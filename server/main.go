package main

import (
	//"context"
	//"github.com/grpc-ecosystem/grpc-gateway/runtime"
	"google.golang.org/grpc"
	//"github.com/google/logger"
	"log"
	"modules/urltoimage"
	"path/filepath"
	//"net"
	"fmt"
	"github.com/gookit/config/v2"
	"github.com/gookit/config/v2/json"
	"os"
	//"net/http"
)
import "github.com/facebookgo/grace/gracenet"

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
	cfg = config.New("default")
	//load config
	cfg.WithOptions(config.ParseEnv)

	// add Decoder and Encoder
	cfg.AddDriver(json.Driver)

	err = cfg.LoadFiles(dir + "/../etc/config.json")
	if err != nil {
		panic(err)
	}
	log.SetOutput(os.Stdout)
	logfile := cfg.String("log.file", "")
	if logfile != "" {

		lf, err := os.OpenFile(cfg.String("log.file"), os.O_CREATE|os.O_WRONLY|os.O_APPEND, 0660)
		if err == nil {
			log.SetOutput(lf)
			log.Println("Failed to open log file and write log to stdout: %v", err)
		}

	}
	log.SetPrefix("[OFFICE]")
	log.SetFlags(log.Ldate | log.Ltime | log.Llongfile)

	log.Printf("config data: \n %#v\n", cfg.Data())
	listenRPC := cfg.String("listen.rpc", "")
	if listenRPC == "" {
		panic("rpc port is empty")
	}

	//register grpc
	s := grpc.NewServer()

	urltoimage.Register(s)
	net := gracenet.Net{}
	lis, err := net.Listen("tcp", listenRPC)
	if err != nil {
		log.Panicf("failed to listen: %v", err)
	}
	if err := s.Serve(lis); err != nil {
		log.Panicf("failed to serve: %v", err)
	}

}
