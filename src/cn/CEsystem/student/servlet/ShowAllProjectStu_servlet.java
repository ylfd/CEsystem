package cn.CEsystem.student.servlet;

import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.service.Impl.ServiceStudentImpl;
import cn.CEsystem.student.service.ServiceStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAllProjectStu_servlet")
public class ShowAllProjectStu_servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //1.调用UserService完成查询
        ServiceStudent service = new ServiceStudentImpl();
        List<ProjectAllInfo> project = service.findAllProject();
        //#设置不过于长，
        String s;
        for (ProjectAllInfo projectAllInfo : project) {
            s = projectAllInfo.getRequirement();
            if(s.length()>12){
                s = s.substring(0,11)+"...";
//                System.out.println(s);
                projectAllInfo.setRequirement(s);
            }
        }
        //2.将list存入request域
        request.setAttribute("project",project);
        //3.转发到list.jsp
        request.getRequestDispatcher("./Stu/lookProjectPage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
