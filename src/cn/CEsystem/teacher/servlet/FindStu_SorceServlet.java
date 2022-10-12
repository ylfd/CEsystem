package cn.CEsystem.teacher.servlet;

import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.enterprise.domain.StuResumeList;
import cn.CEsystem.enterprise.service.ServiceEnterprise;
import cn.CEsystem.enterprise.service.impl.ServiceEnterpriseImpl;
import cn.CEsystem.teacher.domain.TeacherAllInfo;
import cn.CEsystem.teacher.service.ServiceTeacher;
import cn.CEsystem.teacher.service.impl.ServiceTeacherImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/findStu_SorceServlet")
public class FindStu_SorceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        TeacherAllInfo user = (TeacherAllInfo) session.getAttribute("user");
        ServiceTeacher service = new ServiceTeacherImpl();
        List<StuResumeList> list = service.returnStuScorce_Teacher(user.getTnumber(), "3");
        request.setAttribute("list", list);
        request.getRequestDispatcher("teacher/lookStudentSorce_Teacher.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
