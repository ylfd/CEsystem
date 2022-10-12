package cn.CEsystem.enterprise.servlet;

import cn.CEsystem.enterprise.domain.StuResumeList;
import cn.CEsystem.enterprise.service.ServiceEnterprise;
import cn.CEsystem.enterprise.service.impl.ServiceEnterpriseImpl;
import cn.CEsystem.student.domain.StuResumes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lookOneFinishedProjectServlet")
public class LookOneFinishedProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ps_id = request.getParameter("ps_id");

        ServiceEnterprise service = new ServiceEnterpriseImpl();
        StuResumeList stuResumeList = service.returnOneFinsihProjectInfo(ps_id);

        request.setAttribute("fileDownload",stuResumeList);
        request.getRequestDispatcher("enterprise/lookOneFinishedProject.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
