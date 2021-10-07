# 说明

根据url生成图片的服务

```bash
#login
sudo docker login --username=hetal@aliyun.com registry.cn-beijing.aliyuncs.com

#pull image
sudo docker pull registry.cn-beijing.aliyuncs.com/mxiqi/urltoimage:latest

#test
sudo docker run -it --rm registry.cn-beijing.aliyuncs.com/mxiqi/urltoimage:latest /bin/bash
./app.js https://www.yunke.com/ 1024x1024 0 x.png
```

## 目录说明

1. proto_src目录，proto 的定义文件目录
2. client 目录，golang语言的客户端示例代码
2. client_xxx目录，是各种语言的客户端示例代码
3. proto目录，是自动生成的 proto 的目录，不需要手动修改
4. server/client目录，golang 版本的 server 和 client

## Makefile 说明

### 编译
```bash
make build
```

### 运行
```bash
make dockerpull
make dockerrun
```
