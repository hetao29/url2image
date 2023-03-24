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
	$client = new Liburltoimage\UrltoimageClient("127.0.0.1:8880",[
		'credentials' => Grpc\ChannelCredentials::createInsecure(),
		'grpc.max_receive_message_length' => 8*1024*1024,
	]);
	$request = new Liburltoimage\Request();
	$request->setUrl("https://www.baidu.com/");
	$request->setSize("720x800");
	$request->setType("jpeg");
	$request->setQuality(100);
	echo date("Y-m-d H:i:s")."\n";
	//for($i=0;$i<=100;$i++){
	list($reply,$error) = $client->convert($request)->wait();
	if($reply){
		$files = $reply->getFiles();
		foreach($files as $file){
			$name = ROOT."/../test/".$file->getName();
			$name = "/data/www/www/x.png";
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
