<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/2
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>登录界面</title>
    <script type="text/javascript">
        window.onload = function () {
            //显示用户不存在或密码不正确
            var loginError = '<%=request.getAttribute("login_error")%>';
            if (loginError == 'login_error') {
                alert("用户不存在或密码不正确");
                loginError = null;
            }

            var error_stu = '<%=request.getAttribute("error_stu")%>';
            if (error_stu == "error_stu") {
                alert("同学注册的账号或学号已有！")
            }
            var error_enterprise = '<%=request.getAttribute("error_enterprise")%>';
            if (error_enterprise == 'error_enterprise') {
                alert("企业注册的账号或名称已有！")
            }
            //显示用户不存在或密码不正确
            var state = '<%=request.getAttribute("state")%>';
            if (state == 'success') {
                alert("注册成功！请登录");
            }
            else if (state == 'error') {
                alert("注册失败，账号已有，请更换账号注册")
            }
        }

    </script>
</head>
<body style="background-image: url(${pageContext.request.contextPath}/img/logo1.jpg);background-size: 100%">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">协同育人校企合作平台</a>
</nav>
<div style="display:flex;justify-content:center; align-items:center; height: 500px">
    <div style="background-color: rgb(243, 241, 241);border: 1px solid silver;height: 300px;width: 400px;">
        <span style="position: relative;left:40%;font-size: 2em;">登录</span><br>
        <form action="${pageContext.request.contextPath}/loginStudentServlet" method="post">
            <span style="position: relative;left:43%;font-size: 0.5em;">用户名：</span><br>
            <input type="text" value="${requestScope.number}" name="username" placeholder="admin"
                   style="position: relative;width:90%;left: 10px;"><br>
            <span style="position: relative;left:43%;font-size: 0.5em;">密码：</span><br>
            <input type="password" value="${requestScope.password}" name="password" placeholder="password"
                   style="position: relative;width:90%;left: 10px;"><br>
            <span style="position: relative;left:39%;font-size: 0.5em;">登陆者身份：</span><br>
            <select name="who" style="position: relative;width:90%;left: 10px;">
                <option value="student" selected="selected">学生</option>
                <option value="teacher">教师</option>
                <option value="enterprise">企业</option>
                <option value="admi">管理员</option>
            </select><br>


            <input class="btn btn-primary" type="submit" value="登录"
                   style="position: relative;width:100px;height:50px;left: 40px;top:30px;">
            <input class="btn btn-primary" onclick="window.location.href='register.jsp'" value="注册"
                   style="position: relative;width:100px;height:50px;left: 140px;top:30px;">


        </form>
    </div>

</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="position:absolute;bottom:0;width:100%; height:15%">
    <div style="float: left;width:40%;letter-spacing:3px;height:100%;">
        <a style="color:cadetblue;font-family:黑体;font-size:2em;position:relative;left:9%;top:15%;" href="#">协同育人校企合作平台</a>
    </div>
    <div style="float: left;width:20%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:20%">网站介绍</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="#">网站功能介绍</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;">网站创作意义</a>
        </ul>
    </div>
    <div style="float: left;width:20%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:20%">友情链接</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="https://www.cnki.net/" target="_blank">知网</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="https://www.ahnu.edu.cn/" target="_blank">师大官网</a>
        </ul>
    </div>
    <div style="float: left;width:20%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:20%;">快捷页面</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="#">学生登录</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="#">教师登录</a><br>
            <a style="color:silver;position: relative;left:20%;font-size: 0.5em;text-decoration:none;" href="#">企业登录</a>
        </ul>
    </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>