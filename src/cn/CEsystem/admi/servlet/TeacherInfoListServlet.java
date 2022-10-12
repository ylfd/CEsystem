package cn.CEsystem.admi.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.student.domain.PageBean;
import cn.CEsystem.teacher.domain.TeacherAllInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/teacherInfoListServlet")
public class TeacherInfoListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1 获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if(currentPage==null){
            currentPage="1";
        }
        if(rows==null){
            rows="10";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        //2 调用service
        ServiceAdmi service = new ServiceAdmiImpl();
        PageBean<TeacherAllInfo> pb = service.findTeacherByPage(currentPage,rows,condition);

        //3.将PageBean存入request
        request.setAttribute("pb",pb);
//        System.out.println(pb.toString());
        //会写
        request.setAttribute("condition",condition);
        //4.转发到list.jsp
        request.getRequestDispatcher("admi/teacherInfoList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
