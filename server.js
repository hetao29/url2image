#!/usr/bin/env node
const grpc = require('@grpc/grpc-js')
const fs = require('fs')
const protoLoader = require('@grpc/proto-loader');
const puppeteer = require('puppeteer');
(async () => {
	global.browser = await puppeteer.launch({
		args: [
			'--no-sandbox',
			'--disable-setuid-sandbox',
			'--device-scale-factor=2'
		]
	});

	let PROTO_PATH = './proto_src/urltoimage/urltoimage.proto'
	let conf = require('./conf')

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
			let start = (new Date()).getTime();
			//width & height
			let width = 800;
			let height = 600;
			let isMobile = false;
			if (typeof call.request.size === 'string') {
				[width, height] = call.request.size.split('x').map(v => parseInt(v, 10));
			}
			//type
			let type="jpeg";
			if (typeof call.request.type === 'string') {
				if( call.request.type == "png" || call.request.type =="jpeg" || call.request.type=="jpg"){
					type = call.request.type
				}
			}
			//quality
			let quality=80;
			if (typeof call.request.quality === 'number') {
				quality = call.request.quality
			} else if (typeof process.argv[6] === 'string') {
				quality = call.request.quality
			}
			if(quality<0 || quality>100){
				quality = 80;
			}

			let now = new Date();
			let dateStr = now.toISOString();
			let filename = "/tmp/"+now.getTime()+"."+Math.random()+"."+type;
			let page = await global.browser.newPage();
			page.setViewport({
				width,
				height,
				isMobile,
				deviceScaleFactor: 2
			})
			let params={
				path: `${filename}`,
				type: `${type}`,
				fullPage: true
			};
			if(type!="png"){
				params.quality= quality;
			}
			//await page.goto(call.request.url, {waitUntil: 'domcontentloaded'});
			await page.goto(call.request.url, {waitUntil: 'networkidle2'});

			//https://stackoverflow.com/questions/55105958/puppeteer-saved-png-is-not-transparent
			if((conf.screenshot && conf.screenshot.transparent) || process.env.TRANSPARENT){
				await page.evaluate(() => document.body.style.background = 'transparent');
				params.omitBackground=true;
			}


			await page.screenshot(params);
			await page.close();
			let file = {
				name :filename,
				content :fs.readFileSync(filename),
			};
			fs.unlinkSync(filename)
			let end = (new Date()).getTime();
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
					height,
					params
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

	let server = new grpc.Server({'grpc.max_send_message_length': 1024*1024*1024})
	server.addService(impl_proto.liburltoimage.Urltoimage.service, {
		Convert:Convert
	})
	server.bindAsync(conf.ip.server + ':' + conf.port, grpc.ServerCredentials.createInsecure(), ()=>{
		server.start()
	})
})();
