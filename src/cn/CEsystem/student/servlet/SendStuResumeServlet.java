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

@WebServlet("/sendStuResumeServlet")
public class SendStuResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");//项目id
        String name = request.getParameter("name");//项目名
        String company = request.getParameter("company");//企业名字
        HttpSession session = request.getSession();
        StudentAllInfo user = (StudentAllInfo) session.getAttribute("user");
        String sno = user.getSsno();//学生学号

        ServiceStudent service = new ServiceStudentImpl();
        StuResumes stuResumes = service.returnResumeBySno(sno);
        if(stuResumes == null){//判断是否写了简历
            request.setAttribute("sendError","sendError");
            request.setAttribute("sendSuccess","");
            request.getRequestDispatcher("/lookOneProjectServlet?id="+id).forward(request,response);
        }
        else{
            int count = service.sendResumeToE(id,name,company,sno);
            System.out.println("++++++:"+count);

            if(count>= 0){
                request.setAttribute("sendError","");
                request.setAttribute("sendSuccess","sendSuccess");
                request.getRequestDispatcher("/lookOneProjectServlet?id="+id).forward(request,response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
