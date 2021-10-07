const grpc = require('grpc')
const protoLoader = require('@grpc/proto-loader');

var PROTO_PATH = './proto_src/urltoimage/urltoimage.proto'
var conf = require('./conf')

let packageDefinition = protoLoader.loadSync(
            PROTO_PATH
            ,
            {
                            keepCase: true,
                                longs: String,
                                enums: String,
                                defaults: true,
                                oneofs: true
                        }
);

let impl_proto = grpc.loadPackageDefinition(packageDefinition)
console.log(impl_proto);
const client = new impl_proto.liburltoimage.Urltoimage( conf.ip.server + ':' + conf.port, grpc.credentials.createInsecure());

client.convert({
        size:"800x800",
        url:"https://www.baidu.com"
},function(error,res){
            console.log(error);
            console.log(res);
})
