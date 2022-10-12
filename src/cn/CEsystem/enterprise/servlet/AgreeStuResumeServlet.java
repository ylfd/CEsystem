package cn.CEsystem.enterprise.servlet;

import cn.CEsystem.enterprise.service.ServiceEnterprise;
import cn.CEsystem.enterprise.service.impl.ServiceEnterpriseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/agreeStuResumeServlet")
public class AgreeStuResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String psid = request.getParameter("psid");
        ServiceEnterprise service = new ServiceEnterpriseImpl();

        service.agreeOneStuResume(psid);
        request.getRequestDispatcher("examineStuResumeServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
