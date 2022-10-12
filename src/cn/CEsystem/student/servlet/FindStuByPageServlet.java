package cn.CEsystem.student.servlet;

import cn.CEsystem.student.domain.PageBean;
import cn.CEsystem.student.domain.ProjectAllInfo;
import cn.CEsystem.student.service.Impl.ServiceStudentImpl;
import cn.CEsystem.student.service.ServiceStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findStuByPageServlet")
public class FindStuByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1 获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数
        if (currentPage == null) {
            currentPage = "1";
        }
        if (rows == null) {
            rows = "10";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        //2 调用service
        ServiceStudent service = new ServiceStudentImpl();
        PageBean<ProjectAllInfo> pb = service.findProjectByPage(currentPage, rows, condition);
        //#设置不过于长，
        String s;
        for (ProjectAllInfo projectAllInfo : pb.getList()) {
            s = projectAllInfo.getRequirement();
            if (s.length() > 12) {
                s = s.substring(0, 11) + "...";
                projectAllInfo.setRequirement(s);
            }
        }
        //3.将PageBean存入request
        request.setAttribute("pb", pb);
        //会写
        request.setAttribute("condition", condition);
        //#请求对象who
        String who = request.getParameter("who");
        if ("teacher".equals(who)) {
            request.getRequestDispatcher("/teacher/lookAllProject_Teacher.jsp").forward(request, response);
            System.out.println("老师");
        } else {
            //4.转发到list.jsp
            request.getRequestDispatcher("./Stu/lookProjectPage.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
