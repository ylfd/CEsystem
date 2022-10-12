package cn.CEsystem.enterprise.servlet;

import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.enterprise.domain.StuResumeList;
import cn.CEsystem.enterprise.service.ServiceEnterprise;
import cn.CEsystem.enterprise.service.impl.ServiceEnterpriseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/evaluateStudentServlet")
public class EvaluateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        EnterpriseAllInfo user = (EnterpriseAllInfo) session.getAttribute("user");
        ServiceEnterprise service = new ServiceEnterpriseImpl();
        List<StuResumeList> list = service.examineStuResume(user.getEname(), "3");
        request.setAttribute("list", list);
        System.out.println(list.toString());
        System.out.println("------------fsad ");

        request.getRequestDispatcher("enterprise/evaluateStudent.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
