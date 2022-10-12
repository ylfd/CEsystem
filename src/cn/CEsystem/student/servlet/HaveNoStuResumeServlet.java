package cn.CEsystem.student.servlet;

import cn.CEsystem.student.domain.StuResumes;
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


@WebServlet("/haveNoStuResumeServlet")
public class HaveNoStuResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        StudentAllInfo user = (StudentAllInfo) session.getAttribute("user");
//        String sno = request.getParameter("sno");
        String sno = user.getSsno();
        System.out.println(sno);
        ServiceStudent service = new ServiceStudentImpl();

        StuResumes stuResumes = service.havaNoStuResumes(sno);
        if(stuResumes != null){
            request.setAttribute("haveResume","haveResume");
            request.setAttribute("resume",stuResumes);
            request.getRequestDispatcher("./Stu/writeStuResume.jsp").forward(request,response);
        }
        else{
            request.setAttribute("noResume","noResume");
            request.getRequestDispatcher("./Stu/writeStuResume.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
