# littleproject
Spring Boot + Spring Security + JSON 交互 小项目

项目地址在 https://github.com/wean2016/littleproject

本次用到的框架  

Spring Boot + Spring Security + Spring MVC + Spring + MyBatis  

参考的项目 https://github.com/wean2016/Cerberus

## 项目概况

采用了 Spring Boot 来管理框架

![](http://orqrihppm.bkt.clouddn.com/SpringSecurity%20%E5%AE%9E%E9%99%85%E6%90%9E%E4%B8%80%E6%90%9E%EF%BC%88%E4%BA%8C%EF%BC%89/%E9%A1%B9%E7%9B%AE%E7%BB%93%E6%9E%84.png)

其中，
- config 目录下存放了各个框架的配置
- controller 目录下存放了用来测试的两个控制器
- dao 数据访问层
- domain 存放了 entity
- model 辅助 model
- Security 存放了 本次 Security 用到的类
- service 服务层类
- util 工具
- vo view model ，用来返回给用户

## 项目思路

主要是作为 Spring Security 的练手项目，为了使用 Spring Security 框架来和前端交互，交互形式为 JSON  

所以这个小项目主要是实现了三个功能

- 用户登陆时返回给一个 token 作为凭证
- 用户访问网页时服务器端通过解析 request header 里的 token 判断用户是否有权限访问
- 刷新 token 的有效期

##  实现用户登陆时返回给一个 token 作为凭证

1. 在 Spring Security 的配置类里留下一个地址作为登陆用，访问这个地址可以不检查权限
2. 建立起登陆 handler 方法，这个方法会获取登陆请求中的用户名和密码，并根据用户名和密码在数据库中拿到数据对象包装成的 UserDetail 对象（Spring Security 用来记录账号状态的实体类）
3. 如果密码不对，那么抛出异常，让异常处理器去处理返回的消息
4. 如果密码正确，通过工具类生成 token 并以 json 格式发送回客户端

## 实现用户访问网页时服务器端通过解析 request header 里的 token 判断用户是否有权限访问

1. 编写一个 filter 注册到 Spring Security 中。这个 filter 负责将用户 request 里的 token 解析，并与数据库中的信息比对获得用户有的权限。
2. 注册在 Spring Security 里的原因是 Spring Security 是通过 Sevlet Filter 实现的，而 Spring MVC 是通过 Dispatcher 实现的，原生的 Sevlet Filter 能在 Dispatcher 之前执行，这样才能在 controller 之前完成权限判断
3. 编写的这个 filter 如果拦截到了 token 并且服务器开启了安全验证，那就会开始执行业务。
4. 这个 filter 会将 token 解析，判断 token 是否有效
5. 如果有效，将权限写入本次会话中


## 刷新 token 的有效期

1. 获得 token ，对 token 进行判断，修改 token 的过期时间包装成一个新的 token 返回给用户


## 具体实现。。。看代码吧。。。。

## 运行

运行 mvn spring-boot:run 即可启动程序，也可以打包成 war 包丢进自己的服务器运行

预存的 sql 里保存了 三个账号

普通用户账号 ：用户名 user 密码 password
管理员账号：   用户名 admin 密码 admin

提供了三个测试地址

/login POST  这个地址用于登陆，将 json 格式的用户名密码发送到这个地址即可获得 token ，效果图：

![](http://orqrihppm.bkt.clouddn.com/SpringSecurity%20%E5%AE%9E%E9%99%85%E6%90%9E%E4%B8%80%E6%90%9E%EF%BC%88%E4%BA%8C%EF%BC%89/login.png)

/protected GET 这个地址用户测试是否有权限访问，默认管理员账号可以访问，非管理员账号访问会拒绝，管理员账号登陆效果图：

![](http://orqrihppm.bkt.clouddn.com/SpringSecurity%20%E5%AE%9E%E9%99%85%E6%90%9E%E4%B8%80%E6%90%9E%EF%BC%88%E4%BA%8C%EF%BC%89/manager.png)

/login/refresh GET 这个地址用户测试刷新 token 有效期，刷新成功将获得一个新的 token ，效果图：

![](http://orqrihppm.bkt.clouddn.com/SpringSecurity%20%E5%AE%9E%E9%99%85%E6%90%9E%E4%B8%80%E6%90%9E%EF%BC%88%E4%BA%8C%EF%BC%89/refresh.png)


## 备注

阉割掉了加密密码功能，要开启的话只要写一个如何加密的类并且注册到 Spring Security 中配置起来就可以，可以参考开头的参考项目
