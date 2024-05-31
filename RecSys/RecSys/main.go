package main

import (
	"RecSys/http"
	"RecSys/invoker"
)

func main() {
	invoker.Init()

	http.StartHttp()
}
