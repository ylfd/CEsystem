package cn.CEsystem.admi.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.student.domain.PageBean;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.service.Impl.ServiceStudentImpl;
import cn.CEsystem.student.service.ServiceStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/enamineProjectPageSerclet")
public class ExamineProjectPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1 获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if(currentPage==null){
            currentPage="1";
        }
        if(rows==null){
            rows="7";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        //2 调用service
        ServiceAdmi service = new ServiceAdmiImpl();
        PageBean<ProjectAllInfo> pb = service.examineProject(currentPage,rows,condition);
        // System.out.println(pb.getList().toString());
        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        //会写
        request.setAttribute("condition",condition);
        //4.转发到list.jsp
        request.getRequestDispatcher("./admi/examineProject.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
