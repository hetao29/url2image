all:
	composer update
plugin:
	#git clone -b `$(curl -L https://grpc.io/release)` https://github.com/grpc/grpc
	git clone https://github.com/grpc/grpc
	cd grpc
	git submodule update --init
	make grpc_php_plugin
