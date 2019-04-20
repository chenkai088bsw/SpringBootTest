<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>

<body>
    <%--请求参数绑定--%>
    <%--超链接方式--%>
    <a href="param/testParam?username=hehe&password=123">请求参数绑定</a>

    表单方式
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"/><br/>
        密码：<input type="text" name="password"/><br/>
        金额：<input type="text" name="money"/><br/>
        用户姓名：<input type="text" name="user.name"/><br/>
        用户年龄：<input type="text" name="user.age"/><br/>
        <input type="submit" name="提交"/>
    </form>

    <a href="param/testServlet">Servlet原生的API</a>

    <br>
    <%--测试RequestBody注解--%>
    <form action="param/pathVariable" method="post">
        用户姓名：<input type="text" name="username"/><br/>
        用户年龄：<input type="text" name="age"/><br/>
        <input type="submit" name="提交"/>
    </form>

    <%--测试PathVariable注解--%>
    <br>
    <a href="param/testPathVariable/10">testPathVariable</a>

    <%--同时测试获取请求头的值--%>
    <br>
    <a href="param/requestHead">testPathVariable</a>

    <%--测试cookivalue的值--%>
    <br>
    <a href="param/cookieValue">testCookieValue</a>

    <%--测试返回组字符串--%>
    <a href="param/testString">testString</a>

    <%--测试void--%>
    <a href="param/testVoid">testVoid</a>
</body>
</html>