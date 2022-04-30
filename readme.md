1. 运行控制台

```
java -Dserver.port=9000 -Dcsp.sentinel.dashboard.server=localhost:9000 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.4.jar
```
2. 运行程序,添加下面的启动参数

```
-Dcsp.sentinel.dashboard.server=127.0.0.1:9000 -Dproject.name=SentinelDemoApp
```

3. 访问页面：localhost:8080

4. 打开控制台：localhost:9000