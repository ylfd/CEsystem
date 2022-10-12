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

@WebServlet("/loginStudentServlet")
public class LoginStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        //2.获取数据,封装User对象
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //3 确定谁登录
        String who = request.getParameter("who");
        System.out.println(who);
        switch (who){
            case "student" :{
                //5.调用Service查询
                ServiceStudent service = new ServiceStudentImpl();
                StudentAllInfo loginUser = service.login(user);
                //6.判断是否登录成功
                if(loginUser != null){
                    //登录成功
                    //将用户存入session
                    session.setAttribute("user",loginUser);
                    //  System.out.println(loginUser.toString());
                    //跳转页面
                    response.sendRedirect(request.getContextPath()+"/Stu/studentIndex.jsp");
                }else{
                    //登录失败
                    //提示信息
                    request.setAttribute("login_error","login_error");
                    //转发到登录页面
                    request.getRequestDispatcher("/index.jsp").forward(request,response);

                }
                break;
            }
            /**
             * 这里企业登录直接在学生大文件里操作了，不然重复代码较多，只要在学生里的dao 里创建一个自己的查询函数就行
             */
            case "enterprise" :{
                //5.调用Service查询
                ServiceStudent service = new ServiceStudentImpl();//
                EnterpriseAllInfo loginUser = service.login_enterprise(user);
                //6.判断是否登录成功
                if(loginUser != null){
                    //登录成功
                    //将用户存入session
                    session.setAttribute("user",loginUser);
                    //  System.out.println(loginUser.toString());
                    //跳转页面
                    response.sendRedirect(request.getContextPath()+"/enterprise/enterpriseIndex.jsp");
                }else{
                    //登录失败
                    //提示信息
                    request.setAttribute("login_error","login_error");
                    //转发到登录页面
                    request.getRequestDispatcher("/index.jsp").forward(request,response);

                }
                break;
            }
            case "teacher" :{
                //5.调用Service查询
                ServiceStudent service = new ServiceStudentImpl();//
                TeacherAllInfo loginUser = service.login_teacher(user);
                //6.判断是否登录成功
                if(loginUser != null){
                    //登录成功
                    //将用户存入session
                    session.setAttribute("user",loginUser);
                    //  System.out.println(loginUser.toString());
                    //跳转页面
                    response.sendRedirect(request.getContextPath()+"/teacher/teacherIndex.jsp");
                }else{
                    //登录失败
                    //提示信息
                    request.setAttribute("login_error","login_error");
                    //转发到登录页面
                    request.getRequestDispatcher("/index.jsp").forward(request,response);

                }
                break;
            }
            case "admi" :{
                //5.调用Service查询
                ServiceStudent service = new ServiceStudentImpl();//
                AdmiAllInfo loginUser = service.login_admi(user);
                //6.判断是否登录成功
                if(loginUser != null){
                    //登录成功
                    //将用户存入session
                    session.setAttribute("user",loginUser);
                    //  System.out.println(loginUser.toString());
                    //跳转页面
                    response.sendRedirect(request.getContextPath()+"/admi/admiIndex.jsp");
                }else{
                    //登录失败
                    //提示信息
                    request.setAttribute("login_error","login_error");
                    //转发到登录页面
                    request.getRequestDispatcher("/index.jsp").forward(request,response);
                }
                break;
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
