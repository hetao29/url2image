# 说明

根据url生成图片、pdf的服务，服务端可以用docker进行运行，然后通过grpc服务进行调用，生成图片

## 目录说明

1. proto_src目录，proto 的定义文件目录
2. client 目录，golang语言的客户端示例代码
2. client_xxx目录，是各种语言的客户端示例代码
3. proto目录，是自动生成的 proto 的目录，不需要手动修改
4. server/client目录，golang 版本的 server 和 client

## PHP调用示例（其它语言一样）

```php
<?php
define("ROOT",dirname(__FILE__)."/");
define("ROOT_PROTO_LIB",ROOT."../proto/php/");

require_once(ROOT."vendor/autoload.php");


try{
	//call by grpc
	$client = new Liburltoimage\UrltoimageClient("127.0.0.1:10020",[
		'credentials' => Grpc\ChannelCredentials::createInsecure()
	]);
	$request = new Liburltoimage\Request();
	$request->setUrl("https://www.baidu.com/");
	$request->setSize("1280x800");
	$request->setType("jpeg");
	$request->setQuality(100);
	echo date("Y-m-d H:i:s")."\n";
	
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
	
	echo date("Y-m-d H:i:s")."\n";

}catch(Exception $e){
	print_r($e);
}
```
