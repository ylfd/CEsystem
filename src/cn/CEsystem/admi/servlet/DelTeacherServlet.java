package cn.CEsystem.admi.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delTeacherServlet")
public class DelTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid = request.getParameter("tid");
//        String currentPage = request.getParameter("currentPage");
        ServiceAdmi service = new ServiceAdmiImpl();
        service.deleteOneTeacher(tid);

        //3.跳转到查询所有Servlet
//        request.getRequestDispatcher("enterpriseInfoListServlet?currentPage="+currentPage).forward(request,response);
        response.sendRedirect(request.getContextPath()+"/teacherInfoListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
