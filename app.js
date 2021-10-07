#!/usr/bin/env node
// https://github.com/puppeteer/puppeteer/blob/v1.10.0/docs/api.md#pagescreenshotoptions
function sleep(ms) {
    ms = (ms) ? ms : 0;
    return new Promise(resolve => {setTimeout(resolve, ms);});
}

process.on('uncaughtException', (error) => {
    console.error(error);
    process.exit(1);
});

process.on('unhandledRejection', (reason, p) => {
    console.error(reason, p);
    process.exit(1);
});

const puppeteer = require('puppeteer');

// console.log(process.argv);

if (!process.argv[2]) {
    console.error('ERROR: no url arg\n');
    process.exit(1);
}

var url = process.argv[2];

var now = new Date();

var dateStr = now.toISOString();

var width = 800;
var height = 600;


if (typeof process.argv[3] === 'string') {
    var [width, height] = process.argv[3].split('x').map(v => parseInt(v, 10));
}

var delay = 0;

if (typeof process.argv[4] === 'string') {
    delay = parseInt(process.argv[4], 10);
}

var filename = `/tmp/full_screenshot_${width}_${height}.png`;

if (typeof process.argv[5] === 'string') {
    filename = process.argv[5]
}

var quality = 80;

if (typeof process.argv[6] === 'number') {
    quality = process.argv[6]
} else if (typeof process.argv[6] === 'string') {
    quality = parseInt(process.argv[6])
}

var type = `jpeg`;

if (typeof process.argv[7] === 'string') {
    type = process.argv[7]
}

var isMobile = false;


(async() => {

    const browser = await puppeteer.launch({
        args: [
        '--no-sandbox',
        '--disable-setuid-sandbox'
        ]
    });

    const page = await browser.newPage();

    page.setViewport({
        width,
        height,
        isMobile
    });

    await page.goto(url, {waitUntil: 'networkidle2'});

    await sleep(delay);

    await page.screenshot({
		path: `${filename}`,
		type: `${type}`,
		quality: quality,
		fullPage: true
	});

    browser.close();

    console.log(
        JSON.stringify({
            date: dateStr,
            timestamp: Math.floor(now.getTime() / 1000),
			type:type,
			quality:quality,
            filename,
            width,
            height
        })
    );

})();
