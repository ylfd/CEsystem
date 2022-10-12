<%--
  Created by IntelliJ IDEA.
  User: ASUS-NB
  Date: 2020/8/12
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>修改学生信息界面</title>
</head>
<script>
    function deleteUser(eid,currentPage){
        //用户安全提示
        if(confirm("您确定要删除吗？")){
            //访问路径
            location.href="${pageContext.request.contextPath}/delEnterpriseServlet?eid="+eid+"&currentPage="+currentPage;
        }
    }
</script>
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
        <div class="blank" style="height: 10px;"></div>
        <span style="text-align: center; display: block;font-family:黑体;font-size: 1.5em;">企业信息详情</span>
        <div class="blank" style="height: 10px;"></div>
        <div class="container">
            <div style="float: left;margin-top: 20px">
                <form class="form-inline" action="${pageContext.request.contextPath}/enterpriseInfoListServlet"
                      method="post">
                    <div class="form-group">
                        <label for="exampleInputName2">公司名称</label>
                        <input type="text" name="ename" value="${condition.ename[0]}" class="form-control"
                               id="exampleInputName2">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputName3">账号</label>
                        <input type="text" name="enumber" value="${condition.enumber[0]}" class="form-control"
                               id="exampleInputName3">
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail2">地址</label>
                        <input type="data" name="eaddress" value="${condition.eaddress[0]}" class="form-control"
                               id="exampleInputEmail2">
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </form>

            </div>
        </div>
        <div class="container" style="width: 100%;">
            <table class="table table-striped">
                <thead>
                <tr align="center">
                    <th>序号</th>
                    <th>企业名称</th>
                    <th>企业账号</th>
                    <th>企业介绍</th>
                    <th>企业地址</th>
                    <th>企业电话</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:forEach items="${pb.list}" var="t" varStatus="s">
                    <tr align="center">
                        <td>${s.count}</td>
                        <th>${t.ename}</th>
                        <th>${t.enumber}</th>
                        <th>
                            <textarea>${t.eintroduce}</textarea>
                        </th>
                        <th>${t.eaddress}</th>
                        <th>${t.ephone}</th>
                        <th>
                            <input type="submit" value="修改" onclick="window.location.href = '${pageContext.request.contextPath}/returnOneEnterpriseInfoServlet?eid=${t.eid}'" style="border:1px solid rgb(154, 240, 154);">
                            <input type="button" value="删除" onclick="window.location.href = 'javascript:deleteUser(${t.eid},${pb.currentPage});'" style="border:1px solid rgb(248, 69, 69);">
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div style="margin-left: 15%;margin-bottom: 10%">
            <nav aria-label="Page navigation">
                <ul class="pagination pagination-lg">
                    <li>
                        <a href="${pageContext.request.contextPath}/enterpriseInfoListServlet?currentPage=${pb.currentPage -1}&rows=10&ename=${condition.ename[0]}&enumber=${condition.enumber[0]}&eaddress=${condition.eaddress[0]}"
                           aria-label="Previous">
                            <span aria-hidden="true">Previous</span>
                        </a>
                    </li>

                    <c:forEach begin="1" end="${pb.totalPage}" var="i">
                        <c:if test="${pb.currentPage == i}">
                            <li class="active">
                                <a style="color: #0f0f0f;" href="${pageContext.request.contextPath}/enterpriseInfoListServlet?currentPage=${i}&rows=10&ename=${condition.ename[0]}&enumber=${condition.enumber[0]}&eaddress=${condition.eaddress[0]}">&nbsp;&nbsp;${i}&nbsp;</a>
                            </li>
                        </c:if>
                        <c:if test="${pb.currentPage != i}">
                            <li>
                                <a href="${pageContext.request.contextPath}/enterpriseInfoListServlet?currentPage=${i}&rows=10&ename=${condition.ename[0]}&enumber=${condition.enumber[0]}&eaddress=${condition.eaddress[0]}">&nbsp;&nbsp;${i}&nbsp;</a>
                            </li>
                        </c:if>
                    </c:forEach>

                    <li>
                        <a href="${pageContext.request.contextPath}/enterpriseInfoListServlet?currentPage=${pb.currentPage +1}&rows=10&ename=${condition.ename[0]}&enumber=${condition.enumber[0]}&eaddress=${condition.eaddress[0]}"
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
<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
     style="position: relative;left:0px;top:20px;width:100%; height:110px;">
    <div style="float: left;width:40%;letter-spacing:3px;height:100%;">
        <a style="color:cadetblue;font-family:黑体;font-size:2em;position:relative;left:130px;top:30px;" href="#">协同育人校企合作平台</a>
    </div>
    <div style="float: left;width:15%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:30px;">网站介绍</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
               href="#">网站功能介绍</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;">网站创作意义</a>
        </ul>
    </div>
    <div style="float: left;width:15%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:30px;">友情链接</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
               href="https://www.cnki.net/" target="_blank">知网</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
               href="https://www.ahnu.edu.cn/" target="_blank">师大官网</a>
        </ul>
    </div>
    <div style="float: left;width:15%;letter-spacing:3px;height:100%;border-left: 0.2px solid white;">
        <ul>
            <a style="color:white;position: relative;left:30px;">快捷页面</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
               href="#">学生登录</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
               href="#">教师登录</a><br>
            <a style="color:silver;position: relative;left:30px;font-size: 0.5em;text-decoration:none;"
               href="#">企业登录</a>
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
