<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/9
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>提交完成项目</title>
</head>
<script type="text/javascript">

    window.onload = function () {

        var submitSuccess = '<%=request.getAttribute("submitSuccess")%>';

        var submitError = '<%=request.getAttribute("submitError")%>';
        if(submitSuccess=='submitSuccess'){
            alert("提交成功");
        }
        else if(submitError=='submitError') {
            alert("提交失败，文件较大");
        }
        var submited = '<%=request.getAttribute("submited")%>';
        if(submited=='submited'){
            alert("你已经提交，请耐心等待");
        }
    }
    function sureSubmit() {

        var r=confirm("确认提交")
        if (r==true) {
            /**
             * 把项目状态表的id传到session,,,nonono
             */
            return true;
        }
        else {
            return false;
        }
    }
</script>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">协同育人校企合作平台</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link " href="${pageContext.request.contextPath}/Stu/studentIndex.jsp">首页<span
                    class="sr-only">(current)</span></a>
            <a class="nav-item nav-link"
               href="${pageContext.request.contextPath}/findStuByPageServlet?currentPage=1&rows=10">企业项目</a>
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/ifEmployedListServlet">项目处理</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/haveNoStuResumeServlet">我的简历</a>
        </div>
    </div>
    <div class="dropdown" style="padding-right: 4%">
        <c:if test="${user.ssex == '男' || empty uesr.ssex}">
            <img style="height: 30px" src="Stu/image/boy.jpeg">
        </c:if>
        <c:if test="${user.ssex == '女'}">
            <img style="height: 30px" src="Stu/image/girl.jpg">
        </c:if>
        <button style="color: white" class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${user.sname}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="${pageContext.request.contextPath}/returnSelf_StuInfoServlet?sid=${user.sid}">修改资料</a></li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>
</nav>
<div>
    <div style="background-color: rgb(235, 235, 235); height:600px;width:15%;float:left;position: relative;top:10px;padding-top: 10px">
        <button type="button" data-toggle="collapse" data-target="#demo1"
                style="background-color: rgb(235, 235, 235);width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
            关联项目信息
        </button>
        <div id="demo1" class="collapse in">
            <button onclick="window.location.href = '${pageContext.request.contextPath}/ifEmployedListServlet?ps_state=1'"
                    type="button"
                    style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
                企业同意
            </button>
            <br>
            <button onclick="window.location.href = '${pageContext.request.contextPath}/ifEmployedListServlet?ps_state=0'"
                    type="button"
                    style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
                等待企业
            </button>
            <br>
            <button onclick="window.location.href = '${pageContext.request.contextPath}/ifEmployedListServlet?ps_state=2'"
                    type="button"
                    style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
                企业拒绝
            </button>
            <br>
            <button onclick="window.location.href = '${pageContext.request.contextPath}/ifEmployedListServlet'"
                    type="button"
                    style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
                所有项目
            </button>
            <br>
        </div>
        <button type="button" data-toggle="collapse" data-target="#demo2"
                style="background-color: rgb(235, 235, 235);width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
            项目处理
        </button>
        <div id="demo2" class="collapse in">
            <button onclick="window.location.href = '${pageContext.request.contextPath}/ifEmployedListServlet?ps_state=x'"
                    type="button"
                    style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
                提交项目
            </button>
            <br>
            <button onclick="window.location.href = '${pageContext.request.contextPath}/ifEmployedListServlet?ps_state=3'" type="button" type="button"
                    style="background-color:white;width:100%;font-family:楷体;color:blacke;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
                结束项目
            </button>
        </div>
    </div>
    <div class="" style="float:left;width: 80%;margin-top: 20px;margin-left: 2.5%">
        <table class="table table-striped">
            <legend style="text-align: center;">提交项目</legend>
            <thead>
            <tr>
                <th>编号</th>
                <th>项目名称</th>
                <th>项目发布时间</th>
                <th>企业名称</th>
                <th>企业联系方式</th>
                <th>项目完成描述</th>
                <th>选择文件</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="t" varStatus="s">
                <%--?pid=${t.pid}&sno=${user.sno}&ename=${t.enterpriseAllInfo.ename}--%>
                <form onsubmit="return sureSubmit()" role="form" name="${s.count}" action="${pageContext.request.contextPath}/test_submit_Servlet" method="post" enctype="multipart/form-data">
                <tr>
                    <td>${s.count}</td>
                    <td>${t.pname}</td>
                    <td>${t.publishtime_date}</td>
                    <td>${t.enterpriseAllInfo.ename}</td>
                    <td>${t.enterpriseAllInfo.ephone}</td>
                    <td>
                        <textarea cols="22" rows="2" name="discriWord" id="discriWord" placeholder="项目完成描述" maxlength="200"></textarea>
                    </td>
                    <td>
                        <input name="id" value="${t.id}" hidden>
                        <%--<input name="pid" value="${t.pid}" hidden>--%>
                        <%--<input name="sno" type="text" value="${user.ssno}" hidden>--%>
                        <%--<input name="ename" type="text" value="${t.enterpriseAllInfo.ename}" hidden>--%>
                        <input type="file" name="file">
                    </td>
                    <td>
                        <button type="submit" class="btn btn-primary">
                            上传
                        </button>
                    </td>
                </tr>
                </form>
            </c:forEach>

            </tbody>
        </table>
        <div style="margin: 0px auto;display: table;float: inherit;width: 100%;text-align: center">
            <div class="btn-toolbar">
                <div class="btn-group" role="group">
                    <button class="btn btn-default" type="button">上一页</button>
                </div>
                <div class="btn-group" role="group">
                    <button class="btn btn-default" type="button">下一页</button>
                </div>
            </div>
        </div>
    </div>
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

