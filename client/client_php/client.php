<?php
define("ROOT",dirname(__FILE__)."/");
define("ROOT_PROTO_LIB",ROOT."../../proto/php/");

require_once(ROOT."vendor/autoload.php");

//注册自己的类
spl_autoload_register(function($class){
	$root = ROOT_PROTO_LIB.str_replace("\\","/",$class).".php";
	require_once($root);
});

try{
	//call by grpc
	$client = new Liburltoimage\UrltoimageClient("127.0.0.1:10020",[
		'credentials' => Grpc\ChannelCredentials::createInsecure(),
		'grpc.max_receive_message_length' => 1024*1024*1024,
	]);
	$request = new Liburltoimage\Request();
	$request->setUrl("https://blog.mxiqi.com/");
	//{{{
	/*
	$type="png";
	$request->setSize("720x800");
	$request->setType($type);
	$request->setQuality(100);
	 */
	//}}}
	//{{{
	$type="pdf";
	$request->setType($type);
	$pDFOptions = new Liburltoimage\PDFOptions();
	//$pDFOptions->setFormat("A4");
	$pDFOptions->setWidth("1000px");
	$pDFOptions->setHeight("500px");
	$pDFOptions->setDisplayHeaderFooter(true);
	$pDFOptions->setHeaderTemplate('<div style="width:100%;text-align:center;font-size:14px"><span class="title"></span></div>');
	$footer ='<div style="display:block;width:100%;text-align:center;font-size:14px"><span class="pageNumber"></span> / <span class="totalPages"></span></div>';
	$footer.='<div style="display:block;width:100%;text-align:center;font-size:10px"><span class="url"></span></div>';
	$pDFOptions->setFooterTemplate($footer);
	$margin = new Liburltoimage\PDFMargin();
	$margin->setTop(100);
	$margin->setBottom(100);
	$margin->setRight(20);
	$margin->setLeft(20);
	$pDFOptions->setMargin($margin);
	$request->setPdfoptions($pDFOptions);
	//}}}
	echo date("Y-m-d H:i:s")."\n";
	//for($i=0;$i<=100;$i++){
	list($reply,$error) = $client->convert($request)->wait();
	if($reply){
		$files = $reply->getFiles();
		foreach($files as $file){
			$name = ROOT."/../test/".$file->getName();
			$name = "/data/www/www/x.$type";
			file_put_contents($name, $file->getContent());
			echo $name."\n";
		}

	}else{
		echo "Error\n";
		print_r($error);
	}
	//}
	echo date("Y-m-d H:i:s")."\n";

}catch(Exception $e){
	print_r($e);
}
