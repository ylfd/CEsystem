package cn.CEsystem.admi.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/project_YesNoServlet")
public class Project_YesNoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Y = request.getParameter("Y");
        String N = request.getParameter("N");

        String id = request.getParameter("id");
        ServiceAdmi service = new ServiceAdmiImpl();
        if(Y!=null){
            service.oneProject_YesNo(id);
        }
        else{
            service.disagreeProject(id);
        }
        System.out.println(id);
        response.sendRedirect(request.getContextPath()+"/exampleOneProjectServlet?id="+id);
//        request.getRequestDispatcher(request.getContextPath()+"/exampleOneProjectServlet?id="+id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
