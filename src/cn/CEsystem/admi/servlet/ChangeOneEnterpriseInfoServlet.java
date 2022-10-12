package cn.CEsystem.admi.servlet;

import cn.CEsystem.admi.service.ServiceAdmi;
import cn.CEsystem.admi.service.impl.ServiceAdmiImpl;
import cn.CEsystem.enterprise.domain.EnterpriseAllInfo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/changeOneEnterpriseInfoServlet")
public class ChangeOneEnterpriseInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取map
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        EnterpriseAllInfo enterpriseAllInfo = new EnterpriseAllInfo();
        try {
            BeanUtils.populate(enterpriseAllInfo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用Service修改
        ServiceAdmi service = new ServiceAdmiImpl();
        service.updateEnterpriseUser(enterpriseAllInfo);

        //5.跳转到查询所有Servlet
        String eid = enterpriseAllInfo.getEid().toString();
        EnterpriseAllInfo enterpriseAllInfo1 = service.returnEnterpriseInfoBySid(eid);

        request.setAttribute("e",enterpriseAllInfo1);
        request.setAttribute("success","success");
        request.getRequestDispatcher("admi/changeOneEnterpriseInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
