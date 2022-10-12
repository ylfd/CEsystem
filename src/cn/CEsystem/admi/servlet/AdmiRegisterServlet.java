package cn.CEsystem.admi.servlet;

import cn.CEsystem.admi.domain.AdmiAllInfo;
import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.enterprise.service.ServiceEnterprise;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/admiRegisterServlet")
public class AdmiRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据,封装User对象
        Map<String, String[]> map = request.getParameterMap();

        //3封装对象
        AdmiAllInfo admiAllInfo = new AdmiAllInfo();
        try {
            BeanUtils.populate(admiAllInfo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(admiAllInfo.toString());
        //4,返回结果
        ServiceAdmi service = new ServiceAdmiImpl();
        int count = service.register_admi(admiAllInfo);
//        System.out.println(count);
        //state 状态
        if(count>0){
            request.setAttribute("state","success");
            //回写操作
//            request.setAttribute("map",map);
            request.setAttribute("number",admiAllInfo.getAnumber());
            request.setAttribute("password",admiAllInfo.getApassword());
        }
        else{
            request.setAttribute("state","error");
        }

        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
