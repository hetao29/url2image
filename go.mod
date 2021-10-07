module main

go 1.13

replace proto/mxiqi.com/liburltoimage => ./proto/mxiqi.com/liburltoimage/

replace modules/urltoimage => ./modules/urltoimage/

require (
	github.com/chromedp/cdproto v0.0.0-20200608134039-8a80cdaf865c // indirect
	github.com/chromedp/chromedp v0.5.3 // indirect
	github.com/facebookgo/grace v0.0.0-20180706040059-75cf19382434
	github.com/golang/protobuf v1.4.2 // indirect
	github.com/google/logger v1.0.1
	github.com/gookit/config/v2 v2.0.13
	github.com/grpc-ecosystem/grpc-gateway v1.14.6
	golang.org/x/lint v0.0.0-20200302205851-738671d3881b // indirect
	golang.org/x/tools v0.0.0-20200608163737-5123702d8024 // indirect
	google.golang.org/genproto v0.0.0-20200608115520-7c474a2e3482 // indirect
	google.golang.org/grpc v1.29.1
	gopkg.in/yaml.v2 v2.3.0 // indirect
	modules/urltoimage v0.0.0-00010101000000-000000000000
	proto/mxiqi.com/liburltoimage v0.0.0-00010101000000-000000000000
)
