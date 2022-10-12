package cn.CEsystem.student.servlet;

import cn.CEsystem.student.domain.StuResumes;
import cn.CEsystem.student.service.Impl.ServiceStudentImpl;
import cn.CEsystem.student.service.ServiceStudent;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/writeStuResumeServler")
public class WriteStuResumeServler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        StuResumes stuResumes = new StuResumes();
        try {
            BeanUtils.populate(stuResumes,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(stuResumes.toString());
        ServiceStudent service = new ServiceStudentImpl();
        int count = service.writeStuResumes(stuResumes);
        if(count>0){
            request.setAttribute("success","success");
            request.setAttribute("resume",stuResumes);
            request.getRequestDispatcher("Stu/writeStuResume.jsp").forward(request,response);
        }
        else{
            request.setAttribute("error","error");
            request.setAttribute("resume",stuResumes);//还存在优化问题，应该返回数据库中一个简历对象，而不是map封装的，但是这里已经返回了count，
            request.getRequestDispatcher("Stu/writeStuResume.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
