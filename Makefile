all:
	@echo "Please specify the cmd!";
build:
	@#正常编译
	@export GOPROXY=https://goproxy.cn && cd server && go build -v -ldflags "-X main.version=1.0.0 -X main.build=`date -u +%Y-%m-%d%H:%M:%S`" -o ../bin/server .
	#@export GOPROXY=https://goproxy.cn && cd client && go build -v -ldflags "-X main.version=1.0.0 -X main.build=`date -u +%Y-%m-%d%H:%M:%S`" -o ../bin/client .
test:
	./bin/client
docker-image:
	docker build -t hetao29/urltoimage .
docker-push:
	docker push hetao29/urltoimage:latest


###下面是和 protobuf 协议相关的操作，除非更新 proto，一般情况不需要安装
initprotoc:
	sudo apt-get install autoconf automake libtool curl protobuf-compiler-grpc golang-grpc-gateway golang-google-genproto-dev golang-google-grpc-dev

initjava:
	#可选!!!
	# 要生成 protobuf 的java 语言才需要安装，执行前，需要先 make initprotoc，不然编译不通过
	#git submodule add https://github.com/grpc/grpc-java.git grpc/grpc-java
	#https://www.jianshu.com/p/7b3bc89d26e5
	git submodule init
	git submodule update grpc/grpc-java
	#https://github.com/grpc/grpc-java/tree/master/compiler
	#REALPREFIX=$(realpath .) && cd grpc/grpc-java/compiler && export CXXFLAGS="-I$$REALPREFIX/grpc/tmp/include/" LDFLAGS="-L$$REALPREFIX/grpc/tmp/lib/" && echo $$REALPREFIX && ../gradlew -DsocksProxyHost=192.168.8.108 -DsocksProxyPort=1080  java_pluginExecutable
	REALPREFIX=$(realpath .) && cd grpc/grpc-java/compiler && export CXXFLAGS="-I$$REALPREFIX/grpc/tmp/include/" LDFLAGS="-L$$REALPREFIX/grpc/tmp/lib/" && echo $$REALPREFIX && ../gradlew java_pluginExecutable

genproto:
	#golang
	find proto_src -name "*.proto" | xargs -I {} protoc \
	       --proto_path=proto_src \
	       --grpc-gateway_out=logtostderr=true:proto \
	       --plugin=protoc-gen-grpc-gateway=/usr/bin/protoc-gen-grpc-gateway \
	       --plugin=protoc-gen-go=/usr/bin/protoc-gen-go \
	       --plugin=proto-google-common-protos --go_out=plugins=grpc:proto \
	       "{}"
gencppproto:
	#c++
	find proto_src -name "*.proto" | xargs -I {} protoc \
	       --proto_path=proto_src \
	       --grpc-gateway_out=logtostderr=true:proto \
	       --plugin=protoc-gen-grpc=/usr/bin/grpc_cpp_plugin \
	       --grpc_out=proto/cpp \
	       --cpp_out=proto/cpp \
	       "{}"
genjavaproto:
	#java
	find proto_src -name "*.proto" | xargs -I {} protoc \
	       --proto_path=grpc/grpc/third_party/googleapis \
	       --proto_path=proto_src \
	       --plugin=proto-google-common-protos \
		   --java_out=proto/java \
		   --grpc-java_out=proto/java \
		   --plugin=protoc-gen-grpc-java=grpc/grpc-java/compiler/build/exe/java_plugin/protoc-gen-grpc-java \
	       "{}"
genphpproto:
	#php
	#https://github.com/grpc/grpc/tree/master/src/php
	#https://pecl.php.net/package/grpc
	find proto_src -name "*.proto" | xargs -I {} protoc \
		--php_out=proto/php \
		--grpc_out=proto/php \
		--proto_path=proto_src \
		--plugin=protoc-gen-grpc=/usr/bin/grpc_php_plugin \
		"{}"

lint:
	#可选!!!
	export GOPROXY=https://goproxy.cn && go get -u golang.org/x/lint/golint
	find . -name "*go" | xargs -I {} golint "{}"
fmt:
	#可选!!!
	find . -name "*go" | xargs -I {} go fmt "{}"
