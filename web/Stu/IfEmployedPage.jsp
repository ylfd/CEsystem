<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/8
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>学生投递简历</title>
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">

    </script>
</head>
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
    <div style="background-color: rgb(235, 235, 235); height:600px;width:15%;float:left;position: relative;top:0px;">
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
                提交处理
            </button>
            <br>
            <button onclick="window.location.href = '${pageContext.request.contextPath}/ifEmployedListServlet?ps_state=3'"
                    type="button"
                    style="background-color:white;width:100%;font-family:楷体;color:blacke;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
                结束项目
            </button>
        </div>
    </div>
    <div style="float:left;width: 85%;">

        <div class="container" style="margin-top: 20px;">
            <table class="table table-striped">
                <legend style="text-align: center;">项目信息</legend>
                <thead>
                <tr>
                    <th>状态</th>
                    <th>编号</th>
                    <th>项目名称</th>
                    <th>项目发布时间</th>
                    <th>企业名称</th>
                    <th>企业联系方式</th>
                    <th>企业地址</th>
                    <th>项目提交时间</th>
                    <th>下载</th>
                    <%--<th>企业介绍</th>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="t" varStatus="s">
                    <tr>
                        <td>
                            <c:if test="${t.state == '0'}">
                                <div style="background-color: orange;">
                                    等待企业处理中
                                </div>
                            </c:if>
                            <c:if test="${t.state == '1'}">
                                <div style="background-color: #5cb85c;">
                                    企业已同意
                                </div>
                            </c:if>
                            <c:if test="${t.state == '2'}">
                                <div style="background-color: red;">
                                    被拒绝
                                </div>
                            </c:if>
                            <c:if test="${t.state == '3'}">
                                <div style="background-color: gainsboro;">
                                    已结束
                                </div>
                            </c:if>
                        </td>
                        <td>${s.count}</td>
                        <td>${t.pname}</td>
                        <td>${t.publishtime_date}</td>

                        <td>${t.enterpriseAllInfo.ename}</td>
                        <td>${t.enterpriseAllInfo.ephone}</td>
                        <td>${t.enterpriseAllInfo.eaddress}</td>
                        <td>
                            <c:if test="${t.state == '3'}">
                                ${t.submitTime}
                            </c:if>
                        </td>
                        <td colspan="3">
                                <%--file_path=${fileDownload.file_path}&--%>
                            <c:if test="${t.state == '3'}">
                                <a href="${pageContext.request.contextPath}/downLoadFileServlet?file_name=${t.fileSubmit.getFile_name()}">下载</a>
                            </c:if>
                            <a></a>
                        </td>
                            <%--<td>--%>
                            <%--<textarea readonly rows="1" cols="20">${t.enterpriseAllInfo.eintroduce}</textarea>--%>
                            <%--</td>--%>
                    </tr>
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

