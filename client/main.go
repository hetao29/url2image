package main

import (
	"context"
	"fmt"
	"github.com/gookit/config/v2"
	"github.com/gookit/config/v2/json"
	"google.golang.org/grpc"
	"io/ioutil"
	"log"
	"os"
	"path/filepath"
	"proto/libreoffice"
	"time"
)

const (
	defaultName = "world"
)

var cfg *config.Config
var (
	version string
	build   string
)

func main() {
	ex, err := os.Executable()
	if err != nil {
		panic(err)
	}
	fmt.Println("version=", version)
	fmt.Println("build=", build)
	dir := filepath.Dir(ex)
	//load config
	cfg = config.New("default")
	cfg.WithOptions(config.ParseEnv)

	// add Decoder and Encoder
	cfg.AddDriver(json.Driver)

	err = cfg.LoadFiles(dir + "/../etc/config.json")
	if err != nil {
		panic(err)
	}
	log.Printf("config data: \n %#v\n", config.Data())
	proxyRPC := cfg.String("proxy.rpc", "")
	if proxyRPC == "" {
		panic("proxy_rpc is empty")
	}
	// Set up a connection to the server.
	conn, err := grpc.Dial(proxyRPC, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()
	c := libreoffice.NewLibreofficeClient(conn)

	// Contact the server and print out its response.
	//name := "admin"
	//pwd := "123456"
	//if len(os.Args) > 1 {
	//	name = os.Args[1]
	//}
	filename := "test/test.pptx"
	content, err := ioutil.ReadFile(filename)
	ctx, cancel := context.WithTimeout(context.Background(), 100*time.Second)
	defer cancel()
	r, err := c.Convert(ctx, &libreoffice.Request{
		Name:    filename,
		Type:    "pdf",
		Content: content,
	})
	if err != nil {
		log.Fatalf("could not greet: %v", err)
	}
	log.Printf("Greeting: %v", r.GetMessage())
	for i, file := range r.Files {
		ioutil.WriteFile("test/"+file.Name, file.Content, 0644)
		log.Println(i, file.Name, len(file.Content))
	}

}
