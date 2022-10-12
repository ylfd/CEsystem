package cn.CEsystem.teacher.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.teacher.domain.TeacherAllInfo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/changeSelf_TeacherInfoServlet")
public class ChangeSelf_TeacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取map
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        TeacherAllInfo teacherAllInfo = new TeacherAllInfo();
        try {
            BeanUtils.populate(teacherAllInfo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用Service修改
        ServiceAdmi service = new ServiceAdmiImpl();
        service.updateTeacherUser(teacherAllInfo);

        //5.跳转到查询所有Servlet
        String tid = teacherAllInfo.getTid().toString();
        TeacherAllInfo teacherAllInfo1 = service.returnTeacherInfoBySid(tid);

//        System.out.println(enterpriseAllInfo.toString());
        request.setAttribute("success","success");
        request.setAttribute("t", teacherAllInfo1);
        request.getRequestDispatcher("teacher/updateSelf_TeacherInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
