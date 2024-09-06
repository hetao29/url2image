ROOT_DIR:=$(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
all:
	@echo "Please specify the cmd!";
test_php:
	php client/client_php/client.php
docker-run:
	sudo docker run -p 8880:80 hetao29/url2image
docker-image:
	docker build -t hetao29/url2image .
docker-push:
	docker push hetao29/url2image:latest
protoc-php:
	find proto_src -name "*.proto" | xargs -I {} sudo docker run --rm -v ${ROOT_DIR}:${ROOT_DIR} -w ${ROOT_DIR} hetao29/docker-protoc:latest protoc \
		--plugin=protoc-gen-grpc=/usr/bin/grpc_php_plugin \
		--grpc_out=proto/php \
		--php_out=proto/php \
		-I proto_src/ -I . \
		"{}"
	find proto_src -name "*.proto" | xargs -I {} sudo docker run --rm -v ${ROOT_DIR}:${ROOT_DIR} -w ${ROOT_DIR} hetao29/docker-protoc:latest protoc \
		--plugin=protoc-gen-grpc=/usr/bin/protoc-gen-php-grpc \
		--grpc_out=proto/php \
		--php_out=proto/php \
		-I proto_src/ -I . \
		"{}"
protoc-go:
	find proto_src -name "*.proto" | xargs -I {} sudo docker run --rm -v ${ROOT_DIR}:${ROOT_DIR} -w ${ROOT_DIR} hetao29/docker-protoc:latest protoc \
		--grpc-gateway_out=logtostderr=true:proto/go \
		--plugin=proto-google-common-protos --go_out=proto/go --go-grpc_out=proto/go\
		-I proto_src/ -I . \
		"{}"
protoc-cpp:
	find proto_src -name "*.proto" | xargs -I {} sudo docker run --rm -v ${ROOT_DIR}:${ROOT_DIR} -w ${ROOT_DIR} hetao29/docker-protoc:latest protoc \
		--plugin=protoc-gen-grpc=/usr/bin/grpc_cpp_plugin \
		--cpp_out=proto/cpp \
		--grpc_out=proto/cpp \
		-I proto_src/ -I . \
		"{}"
protoc-kotlin:
	find proto_src -name "*.proto" | xargs -I {} sudo docker run --rm -v ${ROOT_DIR}:${ROOT_DIR} -w ${ROOT_DIR} hetao29/docker-protoc:latest protoc \
		--plugin=protoc-gen-grpckt=/usr/bin/protoc-gen-grpc-kotlin.sh \
		--java_out=proto/kotlin \
		--grpckt_out=proto/kotlin \
		-I proto_src/ -I . \
		"{}"
protoc-python:
	find proto_src -name "*.proto" | xargs -I {} sudo docker run --rm -v ${ROOT_DIR}:${ROOT_DIR} -w ${ROOT_DIR} hetao29/docker-protoc:latest protoc \
		--plugin=protoc-gen-grpc=/usr/bin/grpc_python_plugin \
		--python_out=proto/python \
		--grpc_out=proto/python \
		-I proto_src/ -I . \
		"{}"
protoc-js:
	find proto_src -name "*.proto" | xargs -I {} sudo docker run --rm -v ${ROOT_DIR}:${ROOT_DIR} -w ${ROOT_DIR} hetao29/docker-protoc:latest protoc \
		--plugin=protoc-gen-grpc=/usr/bin/protoc-gen-js \
		--js_out=proto/js \
		-I proto_src/ -I . \
		"{}"
