package cn.CEsystem.student.servlet;

import cn.CEsystem.enterprise.domain.StuResumeList;
import cn.CEsystem.student.domain.IfEmployedList;
import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.student.service.Impl.ServiceStudentImpl;
import cn.CEsystem.student.service.ServiceStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ifEmployedListServlet")
public class IfEmployedListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断来由
        String ps_state = request.getParameter("ps_state");

        if("x".equals(ps_state)){//提交页面，转发到别的jsp
            HttpSession session = request.getSession();
            StudentAllInfo user =(StudentAllInfo) session.getAttribute("user");
            ServiceStudent service = new ServiceStudentImpl();
            List<IfEmployedList> list =  service.ifEmployedList(user.getSsno(),"1");
            request.setAttribute("list",list);

            request.getRequestDispatcher("Stu/submitProjectPage.jsp").forward(request,response);
        }
        else{
            HttpSession session = request.getSession();
            StudentAllInfo user =(StudentAllInfo) session.getAttribute("user");
            ServiceStudent service = new ServiceStudentImpl();
            List<IfEmployedList> list =  service.ifEmployedList(user.getSsno(),ps_state);
            request.setAttribute("list",list);
            request.getRequestDispatcher("Stu/IfEmployedPage.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
