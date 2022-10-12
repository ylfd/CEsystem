package cn.CEsystem.enterprise.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/returnSelf_EnterpriseInfoServlet")
public class ReturnSelf_EnterpriseInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid = request.getParameter("eid");
        ServiceAdmi service = new ServiceAdmiImpl();
        EnterpriseAllInfo enterpriseAllInfo = service.returnEnterpriseInfoBySid(eid);
//        System.out.println(enterpriseAllInfo.toString());
        request.setAttribute("e",enterpriseAllInfo);
        request.getRequestDispatcher("enterprise/updateSelf_EnterpriseInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
