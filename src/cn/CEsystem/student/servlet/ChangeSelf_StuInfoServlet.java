package cn.CEsystem.student.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.student.domain.StudentAllInfo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/changeSelf_StuInfoServlet")
public class ChangeSelf_StuInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取map
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        StudentAllInfo studentAllInfo = new StudentAllInfo();
        try {
            BeanUtils.populate(studentAllInfo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用Service修改
        ServiceAdmi service = new ServiceAdmiImpl();
        service.updateStuUser(studentAllInfo);

        //5.跳转到查询所有Servlet
        String sid = studentAllInfo.getSid().toString();
        StudentAllInfo studentAllInfo2 = service.returnStuInfoBySid(sid);
        request.setAttribute("stu",studentAllInfo2);
        request.setAttribute("success","success");
        request.getRequestDispatcher("Stu/updateSelf_StuInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
