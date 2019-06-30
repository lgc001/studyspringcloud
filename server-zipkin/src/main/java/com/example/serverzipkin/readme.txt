*********此项目没用*********

zipkin-server
在Spring Cloud D版本，zipkin-server通过引入依赖的方式构建工程，自从E版本之后，这一方式改变了，采用官方的jar形式启动，所以需要通过下载官方的jar来启动，也通过以下命令一键启动：

curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar

上面的第一行命令会从zipkin官网下载官方的jar包。 如果是window系统，建议使用gitbash执行上面的命令。

如果用 Docker 的话，使用以下命令：


docker run -d -p 9411:9411 openzipkin/zipkin

通过java -jar zipkin.jar的方式启动之后，在浏览器上访问lcoalhost:9411