# 使用官方的 OpenJDK 1.8 镜像作为基础镜像
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app

# 将 Spring Boot jar 文件复制到容器中
COPY order-start/target/order-start-1.0-SNAPSHOT.jar /app/app.jar

# 暴露应用程序运行的端口
EXPOSE 8080

# 运行 Spring Boot 应用程序
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
