package cn.CEsystem.student.servlet;

import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.student.service.Impl.ServiceStudentImpl;
import cn.CEsystem.student.service.ServiceStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lookOneProjectServlet")
public class LookOneProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        //2.调用Service查询
        ServiceStudent service = new ServiceStudentImpl();
        ProjectAllInfo projectAllInfo = service.lookOneProject(id);
        //3.将user存入request
        request.setAttribute("project", projectAllInfo);

        //#请求对象who
        String who = request.getParameter("who");
        if ("teacher".equals(who)) {
            System.out.println("老师+");
            request.getRequestDispatcher("/teacher/lookOneProject_Teacher.jsp").forward(request, response);
        } else {
            //4.转发到list.jsp
            request.getRequestDispatcher("./Stu/lookOneProject.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
