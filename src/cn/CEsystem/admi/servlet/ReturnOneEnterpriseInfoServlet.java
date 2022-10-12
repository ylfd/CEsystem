package cn.CEsystem.admi.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/returnOneEnterpriseInfoServlet")
public class ReturnOneEnterpriseInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid = request.getParameter("eid");
        ServiceAdmi service = new ServiceAdmiImpl();
        EnterpriseAllInfo enterpriseAllInfo = service.returnEnterpriseInfoBySid(eid);
//        System.out.println(enterpriseAllInfo.toString());
        request.setAttribute("e",enterpriseAllInfo);
        request.getRequestDispatcher("admi/changeOneEnterpriseInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
