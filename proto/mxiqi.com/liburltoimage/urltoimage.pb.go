// Code generated by protoc-gen-go. DO NOT EDIT.
// source: urltoimage/urltoimage.proto

/*
Package liburltoimage is a generated protocol buffer package.

It is generated from these files:
	urltoimage/urltoimage.proto

It has these top-level messages:
	Request
	FileContent
	Response
*/
package liburltoimage

import proto "github.com/golang/protobuf/proto"
import fmt "fmt"
import math "math"

import (
	context "golang.org/x/net/context"
	grpc "google.golang.org/grpc"
)

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

// This is a compile-time assertion to ensure that this generated file
// is compatible with the proto package it is being compiled against.
// A compilation error at this line likely means your copy of the
// proto package needs to be updated.
const _ = proto.ProtoPackageIsVersion2 // please upgrade the proto package

type Request struct {
	// 文件名,可选
	Url string `protobuf:"bytes,1,opt,name=url" json:"url,omitempty"`
	// 要转换成的类型,pdf,png/jpg
	Size    string `protobuf:"bytes,2,opt,name=size" json:"size,omitempty"`
	Type    string `protobuf:"bytes,3,opt,name=type" json:"type,omitempty"`
	Quality int32  `protobuf:"varint,4,opt,name=quality" json:"quality,omitempty"`
}

func (m *Request) Reset()                    { *m = Request{} }
func (m *Request) String() string            { return proto.CompactTextString(m) }
func (*Request) ProtoMessage()               {}
func (*Request) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{0} }

func (m *Request) GetUrl() string {
	if m != nil {
		return m.Url
	}
	return ""
}

func (m *Request) GetSize() string {
	if m != nil {
		return m.Size
	}
	return ""
}

func (m *Request) GetType() string {
	if m != nil {
		return m.Type
	}
	return ""
}

func (m *Request) GetQuality() int32 {
	if m != nil {
		return m.Quality
	}
	return 0
}

type FileContent struct {
	// 文件名
	Name string `protobuf:"bytes,1,opt,name=name" json:"name,omitempty"`
	// 二进制的文件内容
	Content []byte `protobuf:"bytes,2,opt,name=content,proto3" json:"content,omitempty"`
}

func (m *FileContent) Reset()                    { *m = FileContent{} }
func (m *FileContent) String() string            { return proto.CompactTextString(m) }
func (*FileContent) ProtoMessage()               {}
func (*FileContent) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{1} }

func (m *FileContent) GetName() string {
	if m != nil {
		return m.Name
	}
	return ""
}

func (m *FileContent) GetContent() []byte {
	if m != nil {
		return m.Content
	}
	return nil
}

type Response struct {
	Code    int32          `protobuf:"varint,1,opt,name=code" json:"code,omitempty"`
	Message string         `protobuf:"bytes,2,opt,name=message" json:"message,omitempty"`
	Files   []*FileContent `protobuf:"bytes,3,rep,name=files" json:"files,omitempty"`
}

func (m *Response) Reset()                    { *m = Response{} }
func (m *Response) String() string            { return proto.CompactTextString(m) }
func (*Response) ProtoMessage()               {}
func (*Response) Descriptor() ([]byte, []int) { return fileDescriptor0, []int{2} }

func (m *Response) GetCode() int32 {
	if m != nil {
		return m.Code
	}
	return 0
}

func (m *Response) GetMessage() string {
	if m != nil {
		return m.Message
	}
	return ""
}

func (m *Response) GetFiles() []*FileContent {
	if m != nil {
		return m.Files
	}
	return nil
}

func init() {
	proto.RegisterType((*Request)(nil), "liburltoimage.Request")
	proto.RegisterType((*FileContent)(nil), "liburltoimage.FileContent")
	proto.RegisterType((*Response)(nil), "liburltoimage.Response")
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConn

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
const _ = grpc.SupportPackageIsVersion4

// Client API for Urltoimage service

type UrltoimageClient interface {
	// Sends a greeting
	Convert(ctx context.Context, in *Request, opts ...grpc.CallOption) (*Response, error)
}

type urltoimageClient struct {
	cc *grpc.ClientConn
}

func NewUrltoimageClient(cc *grpc.ClientConn) UrltoimageClient {
	return &urltoimageClient{cc}
}

func (c *urltoimageClient) Convert(ctx context.Context, in *Request, opts ...grpc.CallOption) (*Response, error) {
	out := new(Response)
	err := grpc.Invoke(ctx, "/liburltoimage.Urltoimage/Convert", in, out, c.cc, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// Server API for Urltoimage service

type UrltoimageServer interface {
	// Sends a greeting
	Convert(context.Context, *Request) (*Response, error)
}

func RegisterUrltoimageServer(s *grpc.Server, srv UrltoimageServer) {
	s.RegisterService(&_Urltoimage_serviceDesc, srv)
}

func _Urltoimage_Convert_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(Request)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(UrltoimageServer).Convert(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/liburltoimage.Urltoimage/Convert",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(UrltoimageServer).Convert(ctx, req.(*Request))
	}
	return interceptor(ctx, in, info, handler)
}

var _Urltoimage_serviceDesc = grpc.ServiceDesc{
	ServiceName: "liburltoimage.Urltoimage",
	HandlerType: (*UrltoimageServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "Convert",
			Handler:    _Urltoimage_Convert_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "urltoimage/urltoimage.proto",
}

func init() { proto.RegisterFile("urltoimage/urltoimage.proto", fileDescriptor0) }

var fileDescriptor0 = []byte{
	// 265 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0xff, 0x64, 0x91, 0x3f, 0x4f, 0xc3, 0x30,
	0x10, 0xc5, 0x09, 0x69, 0x08, 0x5c, 0x41, 0x42, 0x1e, 0xa8, 0x29, 0x4b, 0x94, 0x29, 0x53, 0x8a,
	0xca, 0x08, 0x13, 0x95, 0x18, 0x18, 0x2d, 0xb1, 0x20, 0x31, 0xa4, 0xe1, 0xa8, 0x8c, 0xfc, 0x27,
	0x89, 0x1d, 0x44, 0xf9, 0xf4, 0xc8, 0x76, 0x43, 0x09, 0x6c, 0xbf, 0x7b, 0xbe, 0xa7, 0xf7, 0x6c,
	0xc3, 0x55, 0xdf, 0x09, 0xab, 0xb9, 0xac, 0x36, 0xb8, 0xd8, 0x63, 0xd9, 0x74, 0xda, 0x6a, 0x72,
	0x26, 0xf8, 0x7a, 0x2f, 0xe6, 0x2f, 0x90, 0x32, 0x6c, 0x7b, 0x34, 0x96, 0x9c, 0x43, 0xdc, 0x77,
	0x82, 0x46, 0x59, 0x54, 0x9c, 0x30, 0x87, 0x84, 0xc0, 0xc4, 0xf0, 0x2f, 0xa4, 0x87, 0x5e, 0xf2,
	0xec, 0x34, 0xbb, 0x6d, 0x90, 0xc6, 0x41, 0x73, 0x4c, 0x28, 0xa4, 0x6d, 0x5f, 0x09, 0x6e, 0xb7,
	0x74, 0x92, 0x45, 0x45, 0xc2, 0x86, 0x31, 0xbf, 0x85, 0xe9, 0x03, 0x17, 0xb8, 0xd2, 0xca, 0xa2,
	0xb2, 0xce, 0xac, 0x2a, 0x89, 0xbb, 0x0c, 0xcf, 0xce, 0x5c, 0x87, 0x63, 0x9f, 0x73, 0xca, 0x86,
	0x31, 0x7f, 0x87, 0x63, 0x86, 0xa6, 0xd1, 0xca, 0xf8, 0xd8, 0x5a, 0xbf, 0x06, 0x67, 0xc2, 0x3c,
	0x3b, 0xa7, 0x44, 0x63, 0xaa, 0xcd, 0xd0, 0x70, 0x18, 0xc9, 0x35, 0x24, 0x6f, 0x5c, 0xa0, 0xa1,
	0x71, 0x16, 0x17, 0xd3, 0xe5, 0xbc, 0x1c, 0x5d, 0xba, 0xfc, 0x55, 0x89, 0x85, 0xc5, 0xe5, 0x23,
	0xc0, 0xd3, 0xcf, 0x02, 0xb9, 0x83, 0x74, 0xa5, 0xd5, 0x07, 0x76, 0x96, 0x5c, 0xfc, 0xf1, 0xee,
	0x5e, 0x6b, 0x3e, 0xfb, 0xa7, 0x87, 0xa6, 0xf9, 0xc1, 0xfd, 0xe5, 0xf3, 0x4c, 0x7e, 0xf2, 0x96,
	0x97, 0xb5, 0x96, 0x8b, 0xd1, 0xd6, 0xfa, 0xc8, 0x7f, 0xc2, 0xcd, 0x77, 0x00, 0x00, 0x00, 0xff,
	0xff, 0x6e, 0xcd, 0x0a, 0x03, 0xa3, 0x01, 0x00, 0x00,
}
