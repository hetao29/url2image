#!/usr/bin/env node
const grpc = require('grpc')
const fs = require('fs')
const protoLoader = require('@grpc/proto-loader');
const puppeteer = require('puppeteer');
(async () => {
	global.browser = await puppeteer.launch({
		args: [
			'--no-sandbox',
			'--disable-setuid-sandbox'
		]
	});

	var PROTO_PATH = './proto_src/urltoimage/urltoimage.proto'
	var conf = require('./conf')

	let packageDefinition = protoLoader.loadSync(
		PROTO_PATH,{
			keepCase: true,
			longs: String,
			enums: String,
			defaults: true,
			oneofs: true
		}
	);

	let impl_proto = grpc.loadPackageDefinition(packageDefinition)
	console.log(impl_proto);
	async function Convert(call, callback) {
		try{
			var start = (new Date()).getTime();
			//width & height
			var width = 800;
			var height = 600;
			var isMobile = false;
			if (typeof call.request.size === 'string') {
				var [width, height] = call.request.size.split('x').map(v => parseInt(v, 10));
			}
			//type
			var type="jpeg";
			if (typeof call.request.type === 'string') {
				if( call.request.type == "png" || call.request.type =="jpeg" || call.request.type=="jpg"){
					type = call.request.type
				}
			}
			//quality
			var quality=80;
			if (typeof call.request.quality === 'number') {
				quality = call.request.quality
			} else if (typeof process.argv[6] === 'string') {
				quality = call.request.quality
			}
			if(quality<0 || quality>100){
				quality = 80;
			}

			var now = new Date();
			var dateStr = now.toISOString();
			var filename = "/tmp/"+now.getTime()+"."+Math.random()+"."+type;
			const page = await global.browser.newPage();
			page.setViewport({
				width,
				height,
				isMobile
			})
			var params={
				path: `${filename}`,
				type: `${type}`,
				fullPage: true
			};
			if(type!="png"){
				params.quality= quality;
			}
			//await page.goto(call.request.url, {waitUntil: 'domcontentloaded'});
			await page.goto(call.request.url, {waitUntil: 'networkidle2'});
			await page.screenshot(params);
			await page.close();
			let file = {
				name :filename,
				content :fs.readFileSync(filename),
			};
			fs.unlinkSync(filename)
			var end = (new Date()).getTime();
			callback(null,{ code: 0, message: "ok", files:[file]});
			console.log(
				JSON.stringify({
					date: dateStr,
					duration:(end-start)/1000+"s",
					request:call.request,
					type:type,
					quality:quality,
					filename,
					width,
					height
				})
			);
		}catch(e){
			callback(e,{ code: -1, message: "fail"} );
			console.log(
				JSON.stringify({
					request:call.request,
					exception:e
				})
			);
		}
	};

	var server = new grpc.Server()
	server.addService(impl_proto.liburltoimage.Urltoimage.service, {
		Convert:Convert
	})
	server.bind(conf.ip.server + ':' + conf.port, grpc.ServerCredentials.createInsecure())
	server.start()
})();
