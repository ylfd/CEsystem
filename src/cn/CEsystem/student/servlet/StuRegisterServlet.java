package cn.CEsystem.student.servlet;

import cn.CEsystem.admi.domain.AdmiAllInfo;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.student.domain.User;
import cn.CEsystem.student.service.Impl.ServiceStudentImpl;
import cn.CEsystem.student.service.ServiceStudent;
import cn.CEsystem.teacher.domain.TeacherAllInfo;
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

@WebServlet("/stuRegisterServlet")
public class StuRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        //2.获取数据,封装User对象
        Map<String, String[]> map = request.getParameterMap();
//        System.out.println(map.toString());
//        System.out.println("---------");
//        map.remove("passwordag");
//        System.out.println(map.size());
//        for (String s : map.keySet()) {
//            System.out.println(s);
//        }
//        for (String[] strings : map.values()) {
//            for (String string : strings) {
//                System.out.println(string);
//            }
//        }

        //3封装对象
        StudentAllInfo studentAllInfo = new StudentAllInfo();
        try {
            BeanUtils.populate(studentAllInfo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(studentAllInfo.toString());
        //4,返回结果
        ServiceStudent service = new ServiceStudentImpl();
        int count = service.register_stu(studentAllInfo);
//        System.out.println(count);
        //state 状态
        if(count>0){
            request.setAttribute("state","success");
            //回写操作
//            request.setAttribute("map",map);
            request.setAttribute("number",studentAllInfo.getSnumber());
            request.setAttribute("password",studentAllInfo.getSpassword());
        }
        else{
            request.setAttribute("error_stu","error_stu");
        }

        request.getRequestDispatcher("index.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
