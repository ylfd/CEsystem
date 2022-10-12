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

@WebServlet("/examineStuResumeServlet")
public class ExamineStuResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ps_state = request.getParameter("ps_state");


        HttpSession session = request.getSession();
        EnterpriseAllInfo user =(EnterpriseAllInfo) session.getAttribute("user");
        ServiceEnterprise service = new ServiceEnterpriseImpl();
        List<StuResumeList> list =  service.examineStuResume(user.getEname(),ps_state);
//        System.out.println(list.toString());
//        StuResumeList stuResumeList = service.examineStuResume(user.getEname());

        request.setAttribute("list",list);
        request.getRequestDispatcher("enterprise/examineStuRseumes.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
