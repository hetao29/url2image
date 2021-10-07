package urltoimage

import (
	context "context"
	"google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
	"path/filepath"
	"proto/mxiqi.com/liburltoimage"
	//"bufio"
	"io/ioutil"
	"log"
	"strconv"
	"os"
	"os/exec"
	"time"
)

func init() {
}

// Urltoimage ...
type Urltoimage struct {
	liburltoimage.UrltoimageServer
}

// Register ...
func Register(s *grpc.Server) {
	liburltoimage.RegisterUrltoimageServer(s, &Urltoimage{})
}

// Convert ...
// /data/urltoimage/app.js https://www.yunke.com/ 1024x1024 0 x.png
func (i *Urltoimage) Convert(ctx context.Context, req *liburltoimage.Request) (*liburltoimage.Response, error) {
	//生成临时目录
	if req.Type !="jpeg" || req.Type !="png" {
		req.Type="jpeg";
	}
	tmpfile, err := ioutil.TempFile("/tmp", "urltoimage.*."+req.Type)
	if err != nil {
		return nil, status.Errorf(codes.Internal, "gen tmp file error!")
	}
	defer os.Remove(tmpfile.Name()) // clean up
	//保存文件

	//path, err := exec.LookPath("soffice")
	//if err != nil {
	//	log.Println(err, "soffice is empty")
	//	return false
	//}
	//log.Println("find soffice ", path)
	if req.Size == "" {
		req.Size="1280x800"
	}
	if req.Quality <0  || req.Quality>100 {
		req.Quality=80;
	}
	log.Println("convert gen file", tmpfile.Name())
	ctx, cancel := context.WithTimeout(context.Background(), 100*1000*time.Millisecond)
	defer cancel()
	cmd := exec.CommandContext(ctx, "/data/urltoimage/app.js", req.Url, req.Size, "0", tmpfile.Name(), strconv.Itoa(int(req.Quality)), req.Type)
	stdout, err := cmd.CombinedOutput()
	if err != nil {
		log.Println(string(stdout))
		return nil, status.Errorf(codes.Internal, "gen tmp file error - 2, error is "+string(stdout))
	}
	log.Println(string(stdout))

	response := &liburltoimage.Response{}

	{
		content := liburltoimage.FileContent{}
		log.Println(tmpfile.Name(), i)
		body, err := ioutil.ReadFile(tmpfile.Name())
		if err != nil {
			log.Println(err)
			return nil, status.Errorf(codes.Internal, "gen tmp file error - 3!")
		}

		content.Name = filepath.Base(tmpfile.Name())
		//content.Order = int32(i)
		content.Content = body
		response.Files = append(response.Files, &content)
	}
	return response, nil // status.Errorf(codes.Unimplemented, "Logined ")
}
