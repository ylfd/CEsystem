<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/6
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>审核企业发布项目</title>
    <!-- 1. 导入CSS的全局样式 -->
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }

        form select {
            appearance: none;
            -moz-appearance: none;
            -webkit-appearance: none;
        }
    </style>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">协同育人校企合作平台</a>
    <div class="dropdown" style="margin-left: 71%;">
        <img style="height: 36px" src="admi/image/admiImg.jpg">
        <button style="color: white" class="btn btn-default dropdown-toggle " type="button" id="dropdownMenu1"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            ${user.aname}
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="#">修改资料</a></li>
            <li><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">注销</a></li>
        </ul>
    </div>
</nav>
<div>
    <div style="background-color: rgb(235, 235, 235); height:600px;width:15%;float:left;position: relative;top:0px;text-align: center">
        <button type="button" data-toggle="collapse" data-target="#demo1" style="background-color: rgb(235, 235, 235); width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
            学生管理
        </button>
        <div id="demo1" class="collapse in" style="text-decoration:none">
            <button onclick="window.location.href = '${pageContext.request.contextPath}/changeStuInfoListServlet'" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">学生详细信息</button><br>
            <%--<button  onclick="window.location.href = '${pageContext.request.contextPath}/Stu/studentRegister.jsp'" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加学生信息</button>--%>
            <a target="_blank" href="${pageContext.request.contextPath}/Stu/studentRegister.jsp" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加学生信息</a>
        </div>
        <button type="button" data-toggle="collapse" data-target="#demo2" style="background-color: rgb(235, 235, 235);width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
            教师管理
        </button>
        <div id="demo2" class="collapse in">
            <button onclick="window.location.href = '${pageContext.request.contextPath}/teacherInfoListServlet'" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">教师详细信息</button><br>
            <%--<button onclick="window.location.href = '${pageContext.request.contextPath}/teacher/teacherRegister.jsp'" type="button" style="background-color:white;width:100%;font-family:楷体;color:blacke;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加教师信息</button>--%>
            <a target="_blank" href="${pageContext.request.contextPath}/teacher/teacherRegister.jsp" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加教师信息</a>
        </div>
        <button type="button" data-toggle="collapse" data-target="#demo3" style="background-color: rgb(235, 235, 235);width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">
            企业管理
        </button>
        <div id="demo3" class="collapse in">
            <%--<button onclick="window.location.href = '企业详细信息查询界面.html'" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">审核企业信息</button><br>--%>
            <button onclick="window.location.href = '${pageContext.request.contextPath}/enamineProjectPageSerclet'" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">审核企业项目</button><br>
            <button onclick="window.location.href = '${pageContext.request.contextPath}/enterpriseInfoListServlet'" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">企业详细信息</button><br>
            <%--<button onclick="window.location.href = '${pageContext.request.contextPath}/enterprise/enterpriseRegister.jsp'" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加企业信息</button>--%>
            <a target="_blank" href="${pageContext.request.contextPath}/enterprise/enterpriseRegister.jsp" type="button" style="background-color:white;width:100%;font-family:楷体;color:black;font-size: 1.5em;border:1px solid rgb(207, 207, 207);">添加企业信息</a>
        </div>
    </div>
    <div style="float:left;width: 85%;">
        <h3 style="text-align: center;">审核企业发布项目信息</h3>
        <div class="container" style="margin-bottom: 10px">
            <div style="float: left;">

                <form class="form-inline" action="${pageContext.request.contextPath}/enamineProjectPageSerclet"
                      method="post">
                    <div class="form-group">
                        <label for="exampleInputName2">项目公司</label>
                        <input type="text" name="company" value="${condition.company[0]}" class="form-control"
                               id="exampleInputName2">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputName3">项目名称</label>
                        <input type="text" name="name" value="${condition.name[0]}" class="form-control"
                               id="exampleInputName3">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail2">发布时间</label>
                        <input type="data" name="publishtime" value="${condition.publishtime[0]}" class="form-control"
                               id="exampleInputEmail2">
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </form>

            </div>
        </div>

        <div class="container" style="margin-top: 20px;">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>发布企业</th>
                    <th>项目名称</th>
                    <th>发布时间</th>
                    <th>项目状态</th>
                    <th>审核操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pb.list}" var="t" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                        <td>${t.company}</td>
                        <td>${t.name}</td>
                        <td>${t.getPublishtime_T()}</td>
                        <td>
                            <c:if test="${t.state == '0'}">
                                <div style="background-color: orange;height: 10px;width: 10px;float: left"></div>
                                <select class="form-control">
                                    <option selected>未审核</option>
                                    <option>通过</option>
                                    <option>不通过</option>
                                </select>
                            </c:if>
                            <c:if test="${t.state == '1'}">
                                <div style="background-color: green;height: 10px;width: 10px;float: left"></div>
                                <select class="form-control">
                                    <option>未审核</option>
                                    <option selected>通过</option>
                                    <option>不通过</option>
                                </select>
                            </c:if>
                            <c:if test="${t.state == '2'}">
                                <div style="background-color: red;height: 10px;width: 10px;float: left"></div>
                                <select class="form-control">
                                    <option>未审核</option>
                                    <option>通过</option>
                                    <option selected>不通过</option>
                                </select>
                            </c:if>

                                <%--<select required class="form-control">--%>
                                <%--<c:if test="${t.state == '0'}">--%>
                                <%--<option selected>未审核<div style="height: 5px;width: 5px;background-color: orange"></div></option>--%>
                                <%--<option>通过</option>--%>
                                <%--<option>不通过</option>--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${t.state == '1'}">--%>
                                <%--<option>未审核</option>--%>
                                <%--<option selected>通过</option>--%>
                                <%--<option>不通过</option>--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${t.state == '2'}">--%>
                                <%--<option>未审核</option>--%>
                                <%--<option>通过</option>--%>
                                <%--<option selected>不通过</option>--%>
                                <%--</c:if>--%>
                                <%--</select>--%>
                        </td>
                        <td>
                            <button type="submit" class="btn btn-primary"
                                    onclick="window.location.href = '${pageContext.request.contextPath}/exampleOneProjectServlet?id=${t.id}'">
                                审核
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="margin-left: 15%;margin-bottom: 10%">
            <nav aria-label="Page navigation">
                <ul class="pagination pagination-lg">
                    <li>
                        <a href="${pageContext.request.contextPath}/enamineProjectPageSerclet?currentPage=${pb.currentPage -1}&rows=7&conpany=${condition.conpany[0]}&name=${condition.name[0]}&publishtime=${condition.publishtime[0]}"
                           aria-label="Previous">
                            <span aria-hidden="true">Previous</span>
                        </a>
                    </li>

                    <c:forEach begin="1" end="${pb.totalPage}" var="i">
                        <c:if test="${pb.currentPage == i}">
                            <li class="active">
                                <a style="color: #0f0f0f;" href="${pageContext.request.contextPath}/enamineProjectPageSerclet?currentPage=${i}&rows=7&conpany=${condition.conpany[0]}&name=${condition.name[0]}&publishtime=${condition.publishtime[0]}">&nbsp;&nbsp;${i}&nbsp;</a>
                            </li>
                        </c:if>
                        <c:if test="${pb.currentPage != i}">
                            <li>
                                <a href="${pageContext.request.contextPath}/enamineProjectPageSerclet?currentPage=${i}&rows=7&conpany=${condition.conpany[0]}&name=${condition.name[0]}&publishtime=${condition.publishtime[0]}">&nbsp;&nbsp;${i}&nbsp;</a>
                            </li>
                        </c:if>
                    </c:forEach>

                    <li>
                        <a href="${pageContext.request.contextPath}/enamineProjectPageSerclet?currentPage=${pb.currentPage +1}&rows=7&conpany=${condition.conpany[0]}&name=${condition.name[0]}&publishtime=${condition.publishtime[0]}"
                           aria-label="Next">
                            <span aria-hidden="true">Next</span>
                        </a>
                    </li>
                    <span style="font-size: 25px;margin-left: 5px;">
                        共${pb.totalCount}条记录，共${pb.totalPage}页
                    </span>
                </ul>
            </nav>
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