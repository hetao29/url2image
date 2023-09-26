# 说明

根据url生成图片、pdf的服务，服务端可以用docker进行运行，然后通过grpc服务进行调用，生成图片

具体协议参考 https://github.com/hetao29/url2image/blob/main/proto_src/urltoimage/urltoimage.proto

## 目录说明

1. proto_src目录，proto 的定义文件目录
2. client/client_xxx 目录，各语言的客户端示例代码(golang,js,php,java)
3. proto目录，是自动生成的 proto 的目录，不需要手动修改
4. server/client目录，golang 版本的 server 和 client

## 部署(docker-compose.yml)

```yaml
version: "3.7"
services:
  core:
    image: hetao29/url2image:latest
    ports:
        - "10020:80"
    deploy:
      replicas: 2
      update_config:
        parallelism: 1
        delay: 10s
        order: start-first
        failure_action: rollback
      rollback_config:
        parallelism: 1
        delay: 10s
        order: start-first
        failure_action: rollback
      restart_policy:
        condition: on-failure

```

## PHP调用示例（其它语言一样）

1. 安装libs库

```bash
composer require hetao29/url2image
```

2. 可以参考 client/client_php 下的代码

3. 源代码参考
```php
<?php
require_once("vendor/autoload.php");

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
