thy4项目
几个基本的基于thymeleaf的servlet
不包含和spring的集成
只有导入thymeleaf的相关jar包，其他基本的jar由tomcat/lib提供
在ultimate的alc项目中的使用就是基于这个项目实现的

alc操作流程：
 1在controller中配置java event事件处理方法
 2把处理结果（thymeleaf的上下文），和前往的页面，放在request的attribute中
 3在返回结果时，返回view success type="request" value="thyemeleafTemplate"
 4通过这个请求,进入另外一个接口中，集中处理thymeleaf的模板文件
     这个方法中会把处理完的结果响应回去
     localhost:8080/thy4
     
环境：
 eclipse
 tomcatv6.0 使用elipse自带的
注意：
 启动服务器后，直接运行：
   1localhost:8080  404
   2localhost:8080/thy4 404
   在web.xml配置欢迎页index.jsp  但是index.jsp位于WEB-INF下 ,不允许直接访问
  访问servlet localhost:8080/thy4/thymeleafexample  成功