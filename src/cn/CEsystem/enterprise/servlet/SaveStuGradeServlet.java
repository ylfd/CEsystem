package cn.CEsystem.enterprise.servlet;

import cn.CEsystem.enterprise.service.ServiceEnterprise;
import cn.CEsystem.enterprise.service.impl.ServiceEnterpriseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveStuGradeServlet")
public class SaveStuGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ps_id = request.getParameter("ps_id");
        String grade= request.getParameter("grade");
        System.out.println(ps_id);
        ServiceEnterprise service = new ServiceEnterpriseImpl();
        int sign = service.saveStudentGrade(ps_id,grade);

        request.getRequestDispatcher("evaluateStudentServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
