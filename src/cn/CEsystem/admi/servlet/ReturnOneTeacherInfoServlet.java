package cn.CEsystem.admi.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.teacher.domain.TeacherAllInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/returnOneTeacherInfoServlet")
public class ReturnOneTeacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid = request.getParameter("tid");
        ServiceAdmi service = new ServiceAdmiImpl();
        TeacherAllInfo teacherAllInfo = service.returnTeacherInfoBySid(tid);
//        System.out.println(enterpriseAllInfo.toString());
        request.setAttribute("t", teacherAllInfo);
        request.getRequestDispatcher("admi/changeOneTeacherInfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
