package cn.CEsystem.teacher.servlet;

import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.teacher.domain.TeacherAllInfo;
import cn.CEsystem.teacher.service.ServiceTeacher;
import cn.CEsystem.teacher.service.impl.ServiceTeacherImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/teacherRegisterServlet")
public class teacherRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据,封装User对象
        Map<String, String[]> map = request.getParameterMap();

        //3封装对象
        TeacherAllInfo teacherAllInfo = new TeacherAllInfo();
        try {
            BeanUtils.populate(teacherAllInfo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(teacherAllInfo.toString());
        //4,返回结果
        ServiceTeacher service = new ServiceTeacherImpl();
        int count = service.register_teacher(teacherAllInfo);
        //state 状态
        HttpSession session = request.getSession();

        if(count>0){
            request.setAttribute("state","success");
            request.setAttribute("number",teacherAllInfo.getTnumber());
            request.setAttribute("password",teacherAllInfo.getTpassword());
//            //回写操作
//            session.setAttribute("state","success");
//            session.setAttribute("teacherAllInfo",teacherAllInfo);
        }
        else{
            request.setAttribute("state","error");
//            session.setAttribute("state","error");
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
//        response.sendRedirect(request.getContextPath()+"/teacher/teacherRegister.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
