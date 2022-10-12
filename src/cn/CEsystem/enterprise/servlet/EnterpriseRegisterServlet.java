package cn.CEsystem.enterprise.servlet;

import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import cn.CEsystem.enterprise.service.ServiceEnterprise;
import cn.CEsystem.enterprise.service.impl.ServiceEnterpriseImpl;
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

@WebServlet("/enterpriseRegisterServlet")
public class EnterpriseRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据,封装User对象
        Map<String, String[]> map = request.getParameterMap();

        //3封装对象
        EnterpriseAllInfo enterpriseAllInfo = new EnterpriseAllInfo();
        try {
            BeanUtils.populate(enterpriseAllInfo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//        System.out.println(enterpriseAllInfo.toString());
        //4,返回结果

        ServiceEnterprise service = new ServiceEnterpriseImpl();
        int count = service.register_enterprise(enterpriseAllInfo);
//        System.out.println(count);
        //state 状态
        if(count>0){
            request.setAttribute("state","success");
            //回写操作
//            request.setAttribute("map",map);
            request.setAttribute("number",enterpriseAllInfo.getEnumber());
            request.setAttribute("password",enterpriseAllInfo.getEpassword());
        }
        else{
            request.setAttribute("error_enterprise","error_enterprise");
        }

        request.getRequestDispatcher("index.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
