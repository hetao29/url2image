// Code generated by protoc-gen-go. DO NOT EDIT.
// versions:
// 	protoc-gen-go v1.32.0
// 	protoc        v3.21.12
// source: urltoimage/urltoimage.proto

package liburltoimage

import (
	protoreflect "google.golang.org/protobuf/reflect/protoreflect"
	protoimpl "google.golang.org/protobuf/runtime/protoimpl"
	reflect "reflect"
	sync "sync"
)

const (
	// Verify that this generated code is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(20 - protoimpl.MinVersion)
	// Verify that runtime/protoimpl is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(protoimpl.MaxVersion - 20)
)

// https://pptr.dev/api/puppeteer.page.screenshot
type Request struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	// 文件名,可选
	Url string `protobuf:"bytes,1,opt,name=url,proto3" json:"url,omitempty"`
	// 要转换成的类型,pdf,png/jpg
	Size    string `protobuf:"bytes,2,opt,name=size,proto3" json:"size,omitempty"`
	Type    string `protobuf:"bytes,3,opt,name=type,proto3" json:"type,omitempty"`
	Quality int32  `protobuf:"varint,4,opt,name=quality,proto3" json:"quality,omitempty"`
	// 是否透明
	Transparent           bool        `protobuf:"varint,5,opt,name=transparent,proto3" json:"transparent,omitempty"`
	Pdfoptions            *PDFOptions `protobuf:"bytes,6,opt,name=pdfoptions,proto3" json:"pdfoptions,omitempty"`
	CaptureBeyondViewport bool        `protobuf:"varint,7,opt,name=captureBeyondViewport,proto3" json:"captureBeyondViewport,omitempty"`
}

func (x *Request) Reset() {
	*x = Request{}
	if protoimpl.UnsafeEnabled {
		mi := &file_urltoimage_urltoimage_proto_msgTypes[0]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *Request) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*Request) ProtoMessage() {}

func (x *Request) ProtoReflect() protoreflect.Message {
	mi := &file_urltoimage_urltoimage_proto_msgTypes[0]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use Request.ProtoReflect.Descriptor instead.
func (*Request) Descriptor() ([]byte, []int) {
	return file_urltoimage_urltoimage_proto_rawDescGZIP(), []int{0}
}

func (x *Request) GetUrl() string {
	if x != nil {
		return x.Url
	}
	return ""
}

func (x *Request) GetSize() string {
	if x != nil {
		return x.Size
	}
	return ""
}

func (x *Request) GetType() string {
	if x != nil {
		return x.Type
	}
	return ""
}

func (x *Request) GetQuality() int32 {
	if x != nil {
		return x.Quality
	}
	return 0
}

func (x *Request) GetTransparent() bool {
	if x != nil {
		return x.Transparent
	}
	return false
}

func (x *Request) GetPdfoptions() *PDFOptions {
	if x != nil {
		return x.Pdfoptions
	}
	return nil
}

func (x *Request) GetCaptureBeyondViewport() bool {
	if x != nil {
		return x.CaptureBeyondViewport
	}
	return false
}

// https://pptr.dev/api/puppeteer.pdfoptions
type PDFOptions struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	// 格式A3,A4,A5,Letter,default A4
	Format              string `protobuf:"bytes,1,opt,name=format,proto3" json:"format,omitempty"`
	DisplayHeaderFooter bool   `protobuf:"varint,2,opt,name=displayHeaderFooter,proto3" json:"displayHeaderFooter,omitempty"`
	FooterTemplate      string `protobuf:"bytes,3,opt,name=footerTemplate,proto3" json:"footerTemplate,omitempty"`
	HeaderTemplate      string `protobuf:"bytes,4,opt,name=headerTemplate,proto3" json:"headerTemplate,omitempty"`
	Height              string `protobuf:"bytes,5,opt,name=height,proto3" json:"height,omitempty"`
	Width               string `protobuf:"bytes,6,opt,name=width,proto3" json:"width,omitempty"`
	// 是否横向（默认是竖）
	Landscape bool `protobuf:"varint,7,opt,name=landscape,proto3" json:"landscape,omitempty"`
	// 是否透明
	OmitBackground bool   `protobuf:"varint,8,opt,name=omitBackground,proto3" json:"omitBackground,omitempty"`
	PageRanges     string `protobuf:"bytes,9,opt,name=pageRanges,proto3" json:"pageRanges,omitempty"`
	// 边距
	Margin            *PDFMargin `protobuf:"bytes,10,opt,name=margin,proto3" json:"margin,omitempty"`
	PrintBackground   bool       `protobuf:"varint,11,opt,name=printBackground,proto3" json:"printBackground,omitempty"`
	PreferCSSPageSize bool       `protobuf:"varint,12,opt,name=preferCSSPageSize,proto3" json:"preferCSSPageSize,omitempty"`
}

func (x *PDFOptions) Reset() {
	*x = PDFOptions{}
	if protoimpl.UnsafeEnabled {
		mi := &file_urltoimage_urltoimage_proto_msgTypes[1]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *PDFOptions) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*PDFOptions) ProtoMessage() {}

func (x *PDFOptions) ProtoReflect() protoreflect.Message {
	mi := &file_urltoimage_urltoimage_proto_msgTypes[1]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use PDFOptions.ProtoReflect.Descriptor instead.
func (*PDFOptions) Descriptor() ([]byte, []int) {
	return file_urltoimage_urltoimage_proto_rawDescGZIP(), []int{1}
}

func (x *PDFOptions) GetFormat() string {
	if x != nil {
		return x.Format
	}
	return ""
}

func (x *PDFOptions) GetDisplayHeaderFooter() bool {
	if x != nil {
		return x.DisplayHeaderFooter
	}
	return false
}

func (x *PDFOptions) GetFooterTemplate() string {
	if x != nil {
		return x.FooterTemplate
	}
	return ""
}

func (x *PDFOptions) GetHeaderTemplate() string {
	if x != nil {
		return x.HeaderTemplate
	}
	return ""
}

func (x *PDFOptions) GetHeight() string {
	if x != nil {
		return x.Height
	}
	return ""
}

func (x *PDFOptions) GetWidth() string {
	if x != nil {
		return x.Width
	}
	return ""
}

func (x *PDFOptions) GetLandscape() bool {
	if x != nil {
		return x.Landscape
	}
	return false
}

func (x *PDFOptions) GetOmitBackground() bool {
	if x != nil {
		return x.OmitBackground
	}
	return false
}

func (x *PDFOptions) GetPageRanges() string {
	if x != nil {
		return x.PageRanges
	}
	return ""
}

func (x *PDFOptions) GetMargin() *PDFMargin {
	if x != nil {
		return x.Margin
	}
	return nil
}

func (x *PDFOptions) GetPrintBackground() bool {
	if x != nil {
		return x.PrintBackground
	}
	return false
}

func (x *PDFOptions) GetPreferCSSPageSize() bool {
	if x != nil {
		return x.PreferCSSPageSize
	}
	return false
}

type PDFMargin struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Bottom string `protobuf:"bytes,1,opt,name=bottom,proto3" json:"bottom,omitempty"`
	Left   string `protobuf:"bytes,2,opt,name=left,proto3" json:"left,omitempty"`
	Right  string `protobuf:"bytes,3,opt,name=right,proto3" json:"right,omitempty"`
	Top    string `protobuf:"bytes,4,opt,name=top,proto3" json:"top,omitempty"`
}

func (x *PDFMargin) Reset() {
	*x = PDFMargin{}
	if protoimpl.UnsafeEnabled {
		mi := &file_urltoimage_urltoimage_proto_msgTypes[2]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *PDFMargin) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*PDFMargin) ProtoMessage() {}

func (x *PDFMargin) ProtoReflect() protoreflect.Message {
	mi := &file_urltoimage_urltoimage_proto_msgTypes[2]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use PDFMargin.ProtoReflect.Descriptor instead.
func (*PDFMargin) Descriptor() ([]byte, []int) {
	return file_urltoimage_urltoimage_proto_rawDescGZIP(), []int{2}
}

func (x *PDFMargin) GetBottom() string {
	if x != nil {
		return x.Bottom
	}
	return ""
}

func (x *PDFMargin) GetLeft() string {
	if x != nil {
		return x.Left
	}
	return ""
}

func (x *PDFMargin) GetRight() string {
	if x != nil {
		return x.Right
	}
	return ""
}

func (x *PDFMargin) GetTop() string {
	if x != nil {
		return x.Top
	}
	return ""
}

type FileContent struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	// 文件名
	Name string `protobuf:"bytes,1,opt,name=name,proto3" json:"name,omitempty"`
	// 二进制的文件内容
	Content []byte `protobuf:"bytes,2,opt,name=content,proto3" json:"content,omitempty"`
}

func (x *FileContent) Reset() {
	*x = FileContent{}
	if protoimpl.UnsafeEnabled {
		mi := &file_urltoimage_urltoimage_proto_msgTypes[3]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *FileContent) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*FileContent) ProtoMessage() {}

func (x *FileContent) ProtoReflect() protoreflect.Message {
	mi := &file_urltoimage_urltoimage_proto_msgTypes[3]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use FileContent.ProtoReflect.Descriptor instead.
func (*FileContent) Descriptor() ([]byte, []int) {
	return file_urltoimage_urltoimage_proto_rawDescGZIP(), []int{3}
}

func (x *FileContent) GetName() string {
	if x != nil {
		return x.Name
	}
	return ""
}

func (x *FileContent) GetContent() []byte {
	if x != nil {
		return x.Content
	}
	return nil
}

type Response struct {
	state         protoimpl.MessageState
	sizeCache     protoimpl.SizeCache
	unknownFields protoimpl.UnknownFields

	Code    int32          `protobuf:"varint,1,opt,name=code,proto3" json:"code,omitempty"`
	Message string         `protobuf:"bytes,2,opt,name=message,proto3" json:"message,omitempty"`
	Files   []*FileContent `protobuf:"bytes,3,rep,name=files,proto3" json:"files,omitempty"`
}

func (x *Response) Reset() {
	*x = Response{}
	if protoimpl.UnsafeEnabled {
		mi := &file_urltoimage_urltoimage_proto_msgTypes[4]
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		ms.StoreMessageInfo(mi)
	}
}

func (x *Response) String() string {
	return protoimpl.X.MessageStringOf(x)
}

func (*Response) ProtoMessage() {}

func (x *Response) ProtoReflect() protoreflect.Message {
	mi := &file_urltoimage_urltoimage_proto_msgTypes[4]
	if protoimpl.UnsafeEnabled && x != nil {
		ms := protoimpl.X.MessageStateOf(protoimpl.Pointer(x))
		if ms.LoadMessageInfo() == nil {
			ms.StoreMessageInfo(mi)
		}
		return ms
	}
	return mi.MessageOf(x)
}

// Deprecated: Use Response.ProtoReflect.Descriptor instead.
func (*Response) Descriptor() ([]byte, []int) {
	return file_urltoimage_urltoimage_proto_rawDescGZIP(), []int{4}
}

func (x *Response) GetCode() int32 {
	if x != nil {
		return x.Code
	}
	return 0
}

func (x *Response) GetMessage() string {
	if x != nil {
		return x.Message
	}
	return ""
}

func (x *Response) GetFiles() []*FileContent {
	if x != nil {
		return x.Files
	}
	return nil
}

var File_urltoimage_urltoimage_proto protoreflect.FileDescriptor

var file_urltoimage_urltoimage_proto_rawDesc = []byte{
	0x0a, 0x1b, 0x75, 0x72, 0x6c, 0x74, 0x6f, 0x69, 0x6d, 0x61, 0x67, 0x65, 0x2f, 0x75, 0x72, 0x6c,
	0x74, 0x6f, 0x69, 0x6d, 0x61, 0x67, 0x65, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x12, 0x0d, 0x6c,
	0x69, 0x62, 0x75, 0x72, 0x6c, 0x74, 0x6f, 0x69, 0x6d, 0x61, 0x67, 0x65, 0x22, 0xf0, 0x01, 0x0a,
	0x07, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73, 0x74, 0x12, 0x10, 0x0a, 0x03, 0x75, 0x72, 0x6c, 0x18,
	0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x03, 0x75, 0x72, 0x6c, 0x12, 0x12, 0x0a, 0x04, 0x73, 0x69,
	0x7a, 0x65, 0x18, 0x02, 0x20, 0x01, 0x28, 0x09, 0x52, 0x04, 0x73, 0x69, 0x7a, 0x65, 0x12, 0x12,
	0x0a, 0x04, 0x74, 0x79, 0x70, 0x65, 0x18, 0x03, 0x20, 0x01, 0x28, 0x09, 0x52, 0x04, 0x74, 0x79,
	0x70, 0x65, 0x12, 0x18, 0x0a, 0x07, 0x71, 0x75, 0x61, 0x6c, 0x69, 0x74, 0x79, 0x18, 0x04, 0x20,
	0x01, 0x28, 0x05, 0x52, 0x07, 0x71, 0x75, 0x61, 0x6c, 0x69, 0x74, 0x79, 0x12, 0x20, 0x0a, 0x0b,
	0x74, 0x72, 0x61, 0x6e, 0x73, 0x70, 0x61, 0x72, 0x65, 0x6e, 0x74, 0x18, 0x05, 0x20, 0x01, 0x28,
	0x08, 0x52, 0x0b, 0x74, 0x72, 0x61, 0x6e, 0x73, 0x70, 0x61, 0x72, 0x65, 0x6e, 0x74, 0x12, 0x39,
	0x0a, 0x0a, 0x70, 0x64, 0x66, 0x6f, 0x70, 0x74, 0x69, 0x6f, 0x6e, 0x73, 0x18, 0x06, 0x20, 0x01,
	0x28, 0x0b, 0x32, 0x19, 0x2e, 0x6c, 0x69, 0x62, 0x75, 0x72, 0x6c, 0x74, 0x6f, 0x69, 0x6d, 0x61,
	0x67, 0x65, 0x2e, 0x50, 0x44, 0x46, 0x4f, 0x70, 0x74, 0x69, 0x6f, 0x6e, 0x73, 0x52, 0x0a, 0x70,
	0x64, 0x66, 0x6f, 0x70, 0x74, 0x69, 0x6f, 0x6e, 0x73, 0x12, 0x34, 0x0a, 0x15, 0x63, 0x61, 0x70,
	0x74, 0x75, 0x72, 0x65, 0x42, 0x65, 0x79, 0x6f, 0x6e, 0x64, 0x56, 0x69, 0x65, 0x77, 0x70, 0x6f,
	0x72, 0x74, 0x18, 0x07, 0x20, 0x01, 0x28, 0x08, 0x52, 0x15, 0x63, 0x61, 0x70, 0x74, 0x75, 0x72,
	0x65, 0x42, 0x65, 0x79, 0x6f, 0x6e, 0x64, 0x56, 0x69, 0x65, 0x77, 0x70, 0x6f, 0x72, 0x74, 0x22,
	0xc4, 0x03, 0x0a, 0x0a, 0x50, 0x44, 0x46, 0x4f, 0x70, 0x74, 0x69, 0x6f, 0x6e, 0x73, 0x12, 0x16,
	0x0a, 0x06, 0x66, 0x6f, 0x72, 0x6d, 0x61, 0x74, 0x18, 0x01, 0x20, 0x01, 0x28, 0x09, 0x52, 0x06,
	0x66, 0x6f, 0x72, 0x6d, 0x61, 0x74, 0x12, 0x30, 0x0a, 0x13, 0x64, 0x69, 0x73, 0x70, 0x6c, 0x61,
	0x79, 0x48, 0x65, 0x61, 0x64, 0x65, 0x72, 0x46, 0x6f, 0x6f, 0x74, 0x65, 0x72, 0x18, 0x02, 0x20,
	0x01, 0x28, 0x08, 0x52, 0x13, 0x64, 0x69, 0x73, 0x70, 0x6c, 0x61, 0x79, 0x48, 0x65, 0x61, 0x64,
	0x65, 0x72, 0x46, 0x6f, 0x6f, 0x74, 0x65, 0x72, 0x12, 0x26, 0x0a, 0x0e, 0x66, 0x6f, 0x6f, 0x74,
	0x65, 0x72, 0x54, 0x65, 0x6d, 0x70, 0x6c, 0x61, 0x74, 0x65, 0x18, 0x03, 0x20, 0x01, 0x28, 0x09,
	0x52, 0x0e, 0x66, 0x6f, 0x6f, 0x74, 0x65, 0x72, 0x54, 0x65, 0x6d, 0x70, 0x6c, 0x61, 0x74, 0x65,
	0x12, 0x26, 0x0a, 0x0e, 0x68, 0x65, 0x61, 0x64, 0x65, 0x72, 0x54, 0x65, 0x6d, 0x70, 0x6c, 0x61,
	0x74, 0x65, 0x18, 0x04, 0x20, 0x01, 0x28, 0x09, 0x52, 0x0e, 0x68, 0x65, 0x61, 0x64, 0x65, 0x72,
	0x54, 0x65, 0x6d, 0x70, 0x6c, 0x61, 0x74, 0x65, 0x12, 0x16, 0x0a, 0x06, 0x68, 0x65, 0x69, 0x67,
	0x68, 0x74, 0x18, 0x05, 0x20, 0x01, 0x28, 0x09, 0x52, 0x06, 0x68, 0x65, 0x69, 0x67, 0x68, 0x74,
	0x12, 0x14, 0x0a, 0x05, 0x77, 0x69, 0x64, 0x74, 0x68, 0x18, 0x06, 0x20, 0x01, 0x28, 0x09, 0x52,
	0x05, 0x77, 0x69, 0x64, 0x74, 0x68, 0x12, 0x1c, 0x0a, 0x09, 0x6c, 0x61, 0x6e, 0x64, 0x73, 0x63,
	0x61, 0x70, 0x65, 0x18, 0x07, 0x20, 0x01, 0x28, 0x08, 0x52, 0x09, 0x6c, 0x61, 0x6e, 0x64, 0x73,
	0x63, 0x61, 0x70, 0x65, 0x12, 0x26, 0x0a, 0x0e, 0x6f, 0x6d, 0x69, 0x74, 0x42, 0x61, 0x63, 0x6b,
	0x67, 0x72, 0x6f, 0x75, 0x6e, 0x64, 0x18, 0x08, 0x20, 0x01, 0x28, 0x08, 0x52, 0x0e, 0x6f, 0x6d,
	0x69, 0x74, 0x42, 0x61, 0x63, 0x6b, 0x67, 0x72, 0x6f, 0x75, 0x6e, 0x64, 0x12, 0x1e, 0x0a, 0x0a,
	0x70, 0x61, 0x67, 0x65, 0x52, 0x61, 0x6e, 0x67, 0x65, 0x73, 0x18, 0x09, 0x20, 0x01, 0x28, 0x09,
	0x52, 0x0a, 0x70, 0x61, 0x67, 0x65, 0x52, 0x61, 0x6e, 0x67, 0x65, 0x73, 0x12, 0x30, 0x0a, 0x06,
	0x6d, 0x61, 0x72, 0x67, 0x69, 0x6e, 0x18, 0x0a, 0x20, 0x01, 0x28, 0x0b, 0x32, 0x18, 0x2e, 0x6c,
	0x69, 0x62, 0x75, 0x72, 0x6c, 0x74, 0x6f, 0x69, 0x6d, 0x61, 0x67, 0x65, 0x2e, 0x50, 0x44, 0x46,
	0x4d, 0x61, 0x72, 0x67, 0x69, 0x6e, 0x52, 0x06, 0x6d, 0x61, 0x72, 0x67, 0x69, 0x6e, 0x12, 0x28,
	0x0a, 0x0f, 0x70, 0x72, 0x69, 0x6e, 0x74, 0x42, 0x61, 0x63, 0x6b, 0x67, 0x72, 0x6f, 0x75, 0x6e,
	0x64, 0x18, 0x0b, 0x20, 0x01, 0x28, 0x08, 0x52, 0x0f, 0x70, 0x72, 0x69, 0x6e, 0x74, 0x42, 0x61,
	0x63, 0x6b, 0x67, 0x72, 0x6f, 0x75, 0x6e, 0x64, 0x12, 0x2c, 0x0a, 0x11, 0x70, 0x72, 0x65, 0x66,
	0x65, 0x72, 0x43, 0x53, 0x53, 0x50, 0x61, 0x67, 0x65, 0x53, 0x69, 0x7a, 0x65, 0x18, 0x0c, 0x20,
	0x01, 0x28, 0x08, 0x52, 0x11, 0x70, 0x72, 0x65, 0x66, 0x65, 0x72, 0x43, 0x53, 0x53, 0x50, 0x61,
	0x67, 0x65, 0x53, 0x69, 0x7a, 0x65, 0x22, 0x5f, 0x0a, 0x09, 0x50, 0x44, 0x46, 0x4d, 0x61, 0x72,
	0x67, 0x69, 0x6e, 0x12, 0x16, 0x0a, 0x06, 0x62, 0x6f, 0x74, 0x74, 0x6f, 0x6d, 0x18, 0x01, 0x20,
	0x01, 0x28, 0x09, 0x52, 0x06, 0x62, 0x6f, 0x74, 0x74, 0x6f, 0x6d, 0x12, 0x12, 0x0a, 0x04, 0x6c,
	0x65, 0x66, 0x74, 0x18, 0x02, 0x20, 0x01, 0x28, 0x09, 0x52, 0x04, 0x6c, 0x65, 0x66, 0x74, 0x12,
	0x14, 0x0a, 0x05, 0x72, 0x69, 0x67, 0x68, 0x74, 0x18, 0x03, 0x20, 0x01, 0x28, 0x09, 0x52, 0x05,
	0x72, 0x69, 0x67, 0x68, 0x74, 0x12, 0x10, 0x0a, 0x03, 0x74, 0x6f, 0x70, 0x18, 0x04, 0x20, 0x01,
	0x28, 0x09, 0x52, 0x03, 0x74, 0x6f, 0x70, 0x22, 0x3b, 0x0a, 0x0b, 0x46, 0x69, 0x6c, 0x65, 0x43,
	0x6f, 0x6e, 0x74, 0x65, 0x6e, 0x74, 0x12, 0x12, 0x0a, 0x04, 0x6e, 0x61, 0x6d, 0x65, 0x18, 0x01,
	0x20, 0x01, 0x28, 0x09, 0x52, 0x04, 0x6e, 0x61, 0x6d, 0x65, 0x12, 0x18, 0x0a, 0x07, 0x63, 0x6f,
	0x6e, 0x74, 0x65, 0x6e, 0x74, 0x18, 0x02, 0x20, 0x01, 0x28, 0x0c, 0x52, 0x07, 0x63, 0x6f, 0x6e,
	0x74, 0x65, 0x6e, 0x74, 0x22, 0x6a, 0x0a, 0x08, 0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65,
	0x12, 0x12, 0x0a, 0x04, 0x63, 0x6f, 0x64, 0x65, 0x18, 0x01, 0x20, 0x01, 0x28, 0x05, 0x52, 0x04,
	0x63, 0x6f, 0x64, 0x65, 0x12, 0x18, 0x0a, 0x07, 0x6d, 0x65, 0x73, 0x73, 0x61, 0x67, 0x65, 0x18,
	0x02, 0x20, 0x01, 0x28, 0x09, 0x52, 0x07, 0x6d, 0x65, 0x73, 0x73, 0x61, 0x67, 0x65, 0x12, 0x30,
	0x0a, 0x05, 0x66, 0x69, 0x6c, 0x65, 0x73, 0x18, 0x03, 0x20, 0x03, 0x28, 0x0b, 0x32, 0x1a, 0x2e,
	0x6c, 0x69, 0x62, 0x75, 0x72, 0x6c, 0x74, 0x6f, 0x69, 0x6d, 0x61, 0x67, 0x65, 0x2e, 0x46, 0x69,
	0x6c, 0x65, 0x43, 0x6f, 0x6e, 0x74, 0x65, 0x6e, 0x74, 0x52, 0x05, 0x66, 0x69, 0x6c, 0x65, 0x73,
	0x32, 0x4a, 0x0a, 0x0a, 0x55, 0x72, 0x6c, 0x74, 0x6f, 0x69, 0x6d, 0x61, 0x67, 0x65, 0x12, 0x3c,
	0x0a, 0x07, 0x43, 0x6f, 0x6e, 0x76, 0x65, 0x72, 0x74, 0x12, 0x16, 0x2e, 0x6c, 0x69, 0x62, 0x75,
	0x72, 0x6c, 0x74, 0x6f, 0x69, 0x6d, 0x61, 0x67, 0x65, 0x2e, 0x52, 0x65, 0x71, 0x75, 0x65, 0x73,
	0x74, 0x1a, 0x17, 0x2e, 0x6c, 0x69, 0x62, 0x75, 0x72, 0x6c, 0x74, 0x6f, 0x69, 0x6d, 0x61, 0x67,
	0x65, 0x2e, 0x52, 0x65, 0x73, 0x70, 0x6f, 0x6e, 0x73, 0x65, 0x22, 0x00, 0x42, 0x19, 0x5a, 0x17,
	0x6d, 0x78, 0x69, 0x71, 0x69, 0x2e, 0x63, 0x6f, 0x6d, 0x2f, 0x6c, 0x69, 0x62, 0x75, 0x72, 0x6c,
	0x74, 0x6f, 0x69, 0x6d, 0x61, 0x67, 0x65, 0x62, 0x06, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x33,
}

var (
	file_urltoimage_urltoimage_proto_rawDescOnce sync.Once
	file_urltoimage_urltoimage_proto_rawDescData = file_urltoimage_urltoimage_proto_rawDesc
)

func file_urltoimage_urltoimage_proto_rawDescGZIP() []byte {
	file_urltoimage_urltoimage_proto_rawDescOnce.Do(func() {
		file_urltoimage_urltoimage_proto_rawDescData = protoimpl.X.CompressGZIP(file_urltoimage_urltoimage_proto_rawDescData)
	})
	return file_urltoimage_urltoimage_proto_rawDescData
}

var file_urltoimage_urltoimage_proto_msgTypes = make([]protoimpl.MessageInfo, 5)
var file_urltoimage_urltoimage_proto_goTypes = []interface{}{
	(*Request)(nil),     // 0: liburltoimage.Request
	(*PDFOptions)(nil),  // 1: liburltoimage.PDFOptions
	(*PDFMargin)(nil),   // 2: liburltoimage.PDFMargin
	(*FileContent)(nil), // 3: liburltoimage.FileContent
	(*Response)(nil),    // 4: liburltoimage.Response
}
var file_urltoimage_urltoimage_proto_depIdxs = []int32{
	1, // 0: liburltoimage.Request.pdfoptions:type_name -> liburltoimage.PDFOptions
	2, // 1: liburltoimage.PDFOptions.margin:type_name -> liburltoimage.PDFMargin
	3, // 2: liburltoimage.Response.files:type_name -> liburltoimage.FileContent
	0, // 3: liburltoimage.Urltoimage.Convert:input_type -> liburltoimage.Request
	4, // 4: liburltoimage.Urltoimage.Convert:output_type -> liburltoimage.Response
	4, // [4:5] is the sub-list for method output_type
	3, // [3:4] is the sub-list for method input_type
	3, // [3:3] is the sub-list for extension type_name
	3, // [3:3] is the sub-list for extension extendee
	0, // [0:3] is the sub-list for field type_name
}

func init() { file_urltoimage_urltoimage_proto_init() }
func file_urltoimage_urltoimage_proto_init() {
	if File_urltoimage_urltoimage_proto != nil {
		return
	}
	if !protoimpl.UnsafeEnabled {
		file_urltoimage_urltoimage_proto_msgTypes[0].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*Request); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_urltoimage_urltoimage_proto_msgTypes[1].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*PDFOptions); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_urltoimage_urltoimage_proto_msgTypes[2].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*PDFMargin); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_urltoimage_urltoimage_proto_msgTypes[3].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*FileContent); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
		file_urltoimage_urltoimage_proto_msgTypes[4].Exporter = func(v interface{}, i int) interface{} {
			switch v := v.(*Response); i {
			case 0:
				return &v.state
			case 1:
				return &v.sizeCache
			case 2:
				return &v.unknownFields
			default:
				return nil
			}
		}
	}
	type x struct{}
	out := protoimpl.TypeBuilder{
		File: protoimpl.DescBuilder{
			GoPackagePath: reflect.TypeOf(x{}).PkgPath(),
			RawDescriptor: file_urltoimage_urltoimage_proto_rawDesc,
			NumEnums:      0,
			NumMessages:   5,
			NumExtensions: 0,
			NumServices:   1,
		},
		GoTypes:           file_urltoimage_urltoimage_proto_goTypes,
		DependencyIndexes: file_urltoimage_urltoimage_proto_depIdxs,
		MessageInfos:      file_urltoimage_urltoimage_proto_msgTypes,
	}.Build()
	File_urltoimage_urltoimage_proto = out.File
	file_urltoimage_urltoimage_proto_rawDesc = nil
	file_urltoimage_urltoimage_proto_goTypes = nil
	file_urltoimage_urltoimage_proto_depIdxs = nil
}