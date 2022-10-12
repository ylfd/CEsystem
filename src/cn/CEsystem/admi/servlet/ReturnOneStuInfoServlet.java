package cn.CEsystem.admi.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.student.domain.StudentAllInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/returnOneStuInfoServlet")
public class ReturnOneStuInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        ServiceAdmi service = new ServiceAdmiImpl();
        StudentAllInfo studentAllInfo = service.returnStuInfoBySid(sid);
        request.setAttribute("stu",studentAllInfo);
        request.getRequestDispatcher("admi/changeOneStuInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
