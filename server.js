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
			let width = 1200;
			let height = 800;
			let isMobile = false;
			if (call.request.size) {
				[width, height] = call.request.size.split('x').map(v => parseInt(v, 10));
			}
			//type
			let type="jpeg";
			if (call.request.type) {
				if( call.request.type == "png" || call.request.type =="jpeg" || call.request.type=="jpg" || call.request.type=="pdf"){
					type = call.request.type
				}
			}
			//quality
			let quality=80;
			if (call.request.quality) {
				quality = call.request.quality
			}
			if(quality<0 || quality>100){
				quality = 80;
			}

			let now = new Date();
			let dateStr = now.toISOString();
			let filename = "/tmp/"+now.getTime()+"."+Math.random()+"."+type;
			let page = await global.browser.newPage();
			let params={
				path: `${filename}`,
				type: `${type}`,
				fullPage: true
			};

			if(type=="pdf"){
				//https://pptr.dev/api/puppeteer.page.pdf
				let pdfOptions = {
					format:"A4"
				};

				if(call.request.pdfoptions.format){
					pdfoptions.format = call.request.pdfoptions.format;
				}else{
					pdfOptions.format="A4";
				}

				for(var k in call.request.pdfoptions){
					if(call.request.pdfoptions[k]){
						pdfOptions[k] = call.request.pdfoptions[k];
					}
				}

				pdfOptions.path = filename;

				console.log(
					"onRequest",
					JSON.stringify({
						date: dateStr,
						type,
						request:call.request,
						pdfOptions
					})
				);

				await page.goto(call.request.url, {waitUntil: 'networkidle2'});
				await page.pdf(pdfOptions);
			}else{
				//质量
				if(type!="png"){
					params.quality= quality;
				}
				page.setViewport({
					width,
					height,
					isMobile,
					deviceScaleFactor: 2
				})
				console.log(
					"onRequest",
					JSON.stringify({
						date: dateStr,
						type,
						request:call.request,
					})
				);
				await page.goto(call.request.url, {waitUntil: 'networkidle2'});
				//透明
				//https://stackoverflow.com/questions/55105958/puppeteer-saved-png-is-not-transparent
				if((conf.screenshot && conf.screenshot.transparent) || process.env.TRANSPARENT || call.request.transparent){
					await page.evaluate(() => document.body.style.background = 'transparent');
					params.omitBackground=true;
				}
				//https://pptr.dev/api/puppeteer.page.screenshot
				await page.screenshot(params);
			}
			await page.close();
			let file = {
				name :filename,
				content :fs.readFileSync(filename),
			};
			fs.unlinkSync(filename)
			let end = (new Date()).getTime();
			callback(null,{ code: 0, message: "ok", files:[file]});
			console.log(
				"onResponse",
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

	//prevent node.js process crash
	process.on('unhandledRejection', (reason, promise) => {
		console.log('Unhandled Rejection at:', reason.stack || reason)
	});
	let server = new grpc.Server({'grpc.max_send_message_length': 1024*1024*1024})
	server.addService(impl_proto.liburltoimage.Urltoimage.service, {
		Convert:Convert
	})
	server.bindAsync(conf.ip.server + ':' + conf.port, grpc.ServerCredentials.createInsecure(), (err , port) => {
		if (err != null) {
			return console.error(err);
		}
		console.log(`gRPC listening on ${ port }`);
		server.start()
	});
})();
