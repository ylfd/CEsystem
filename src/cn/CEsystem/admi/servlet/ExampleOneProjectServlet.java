package cn.CEsystem.admi.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.student.domain.ProjectAllInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exampleOneProjectServlet")
public class ExampleOneProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        ServiceAdmi service = new ServiceAdmiImpl();
        ProjectAllInfo projectAllInfo = service.retuenSelectedProject(id);
//        System.out.println(projectAllInfo.toString());
        request.setAttribute("project",projectAllInfo);
        request.getRequestDispatcher("./admi/exampleOneProject.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
