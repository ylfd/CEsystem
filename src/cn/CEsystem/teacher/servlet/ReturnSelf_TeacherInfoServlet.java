package cn.CEsystem.teacher.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.teacher.domain.TeacherAllInfo;
import cn.CEsystem.teacher.service.ServiceTeacher;
import cn.CEsystem.teacher.service.impl.ServiceTeacherImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/returnSelf_TeacherInfoServlet")
public class ReturnSelf_TeacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid = request.getParameter("tid");
        ServiceAdmi service = new ServiceAdmiImpl();
        TeacherAllInfo teacherAllInfo = service.returnTeacherInfoBySid(tid);
        request.setAttribute("t", teacherAllInfo);
        request.getRequestDispatcher("teacher/updateSelf_TeacherInfo.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
