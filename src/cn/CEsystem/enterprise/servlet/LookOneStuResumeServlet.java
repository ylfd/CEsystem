package cn.CEsystem.enterprise.servlet;

import cn.CEsystem.enterprise.service.ServiceEnterprise;
import cn.CEsystem.enterprise.service.impl.ServiceEnterpriseImpl;
import cn.CEsystem.student.domain.StuResumes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/lookOneStuResumeServlet")
public class LookOneStuResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");//简历id
        String psid = request.getParameter("psid");//项目状态表id


        ServiceEnterprise service = new ServiceEnterpriseImpl();
        StuResumes stuResumes = service.returnOneStuResume(rid);

        request.setAttribute("psid",psid);
        request.setAttribute("resume",stuResumes);
        request.getRequestDispatcher("enterprise/examineOneResume.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
