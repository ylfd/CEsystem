package cn.CEsystem.enterprise.servlet;

import cn.CEsystem.enterprise.service.ServiceEnterprise;
import cn.CEsystem.enterprise.service.impl.ServiceEnterpriseImpl;
import cn.CEsystem.student.domain.ProjectAllInfo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/publishProjectServlet")
public class PublishProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        ProjectAllInfo projectAllInfo = new ProjectAllInfo();

        try {
            BeanUtils.populate(projectAllInfo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ptime = sdf.format(new Date());
        Date date = null;
        try {
            date  = new Date(sdf.parse(ptime).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        projectAllInfo.setPublishtime(date);

        System.out.println(projectAllInfo.toString());
        ServiceEnterprise service = new ServiceEnterpriseImpl();
        int count = service.publishProject(projectAllInfo);
        if(count>0){
            request.setAttribute("state","success");
            request.setAttribute("map",map);
            //回写操作
            request.getRequestDispatcher("./enterprise/publishProject.jsp").forward(request,response);
        }
        else {
            request.setAttribute("state","error");
            //回写操作
            request.getRequestDispatcher("./enterprise/publishProject.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
