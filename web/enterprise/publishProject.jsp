<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/6
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>填写项目的详细信息</title>
    <script type="text/javascript">
        window.onload = function () {
            //显示用户不存在或密码不正确
            var state = '<%=request.getAttribute("state")%>';
            if(state=='success'){
                alert("${map.name[0]}项目发布成功");
            }
            else if(state=="error"){
                alert("项目发布失败");
            }
        }
        function validate1()
        {
            var Pname = document.getElementById("Pname");
            var stuName = document.getElementById("stuName");
            var password = document.getElementById("password");
            var repassword = document.getElementById("repassword");
            var sno = document.getElementById("sno");


            if (Pname.value == "")
            {
                alert("项目名不能为空！");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
    <a class="navbar-brand" href="#">协同育人校企合作平台</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link " href="${pageContext.request.contextPath}/enterprise/enterpriseIndex.jsp">首页<span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/enterprise/publishProject.jsp">发布项目</a>
            <a class="nav-item nav-link " href="${pageContext.request.contextPath}/examineStuResumeServlet">审核简历</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/lookFinishedServlet">查看完成项目</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/evaluateStudentServlet">评价完成项目</a>
            <%--<button type="button" class="btn btn-primary" style="position: relative;left:190%;">登录</button>--%>
        </div>
    </div>
    <div class="dropdown" style="padding-right: 4%">
        <img style="height: 36px"  src="image/enterpriseImg.jpg">
        <button style="color: white" class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${user.ename}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="${pageContext.request.contextPath}/returnSelf_EnterpriseInfoServlet?eid=${user.eid}">修改资料</a></li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>
</nav>
<h3 style="text-align: center;">请填写发布项目详细信息</h3>
<div style="width: 800px;margin: 0px auto;display: table;">
    <form onsubmit="return validate1();" action="${pageContext.request.contextPath}/publishProjectServlet">
        <div class="form-group">
            <label for="Cname">企业名称</label>
            <input type="text" class="form-control" name="company" id="Cname" value="${user.ename}" readonly>
        </div>
        <div class="form-group">
            <label for="Pname">项目名称</label>
            <input type="text" class="form-control" name="name" id="Pname" value="${map.name[0]}" maxlength="15">
        </div>
        <div class="form-group">
            <label for="Tcr">项目需要技术</label>
            <textarea class="form-control" rows="3" name="requirement" maxlength="200">${map.requirement[0]}</textarea>
        </div>
        <div class="form-group">
            <label for="Content">项目具体内容</label>
            <textarea class="form-control" rows="3" name="content" maxlength="2000">${map.content[0]}</textarea>
        </div>
        <div style="margin: 0px auto;display: table;">
            <button type="submit" class="btn btn-primary">提交发布信息</button>
            <div style="width: 150px;display: inline-block;"></div>
            <button type="reset" class="btn btn-primary">重置发布信息</button>
        </div>
    </form>
</div>
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