# 使用官方的 Go 语言镜像作为基础镜像
FROM golang:1.21 as builder

# 设置工作目录
WORKDIR /app

# 将当前目录中的所有文件复制到工作目录
COPY . .

# 编译 Go 程序
RUN go build -o main . && ls -l main

# 使用一个更小的基础镜像来运行程序
FROM debian:stable-slim

# 设置工作目录
WORKDIR /root/

# 将编译好的 Go 程序从 builder 镜像复制到当前镜像
COPY --from=builder /app/main .

# 验证文件是否存在且可执行
RUN ls -l main && chmod +x main

# 暴露应用程序运行的端口
EXPOSE 8080

# 运行 Go 程序
CMD ["./main"]
