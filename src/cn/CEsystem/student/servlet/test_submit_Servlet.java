package cn.CEsystem.student.servlet;

import cn.CEsystem.student.domain.IfEmployedList;
import cn.CEsystem.student.domain.StudentAllInfo;
import cn.CEsystem.student.service.Impl.ServiceStudentImpl;
import cn.CEsystem.student.service.ServiceStudent;
import cn.CEsystem.student.util.IPTimeStamp;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/test_submit_Servlet")
public class test_submit_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * enctype="multipart/form-data" 解决form问题
         */
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //PageContext是jsp的内置对象，在servlet不能直接使用，需要做一些处理
        JspFactory jspxFactory = null;
        PageContext pageContext = null;
        jspxFactory = JspFactory.getDefaultFactory();
        pageContext = jspxFactory.getPageContext(this,request,response,"",true,8192,true);
        com.jspsmart.upload.File suFile = null;

        int fileSize;
        String fileExt = "";
        int fileCount = 0;
        int maxFileSize = (int) (500*Math.pow(2, 10));//单个文件最大单位K最大上传大小为500M
        String AllowedExtensions=",jpg,jpeg,gif,png,mp4,zip,doc,docx,pdf,rar";//允许上传的文件类型,注意添加文件类型需要在最后加上逗号

        SmartUpload su=new SmartUpload();
        su.initialize(pageContext);
        try {
            su.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        try {
            for (int i=0; i<su.getFiles().getCount();i++) {
                suFile = su.getFiles().getFile(i);
                if (suFile.isMissing())
                    continue;
                fileSize = suFile.getSize()/1024;//字节转换成KB
                if(fileSize==0) fileSize=1;
                if (suFile.getFileExt() == null
                        || "".equals(suFile.getFileExt())) {
                    fileExt = ",,";
                } else {
                    fileExt = "," + suFile.getFileExt().toLowerCase() + ",";
                }
                if (!"".equals(AllowedExtensions)
                        && AllowedExtensions.indexOf(fileExt) == -1) {
                    throw new Exception("您上传的文件[" + suFile.getFileName()
                            + "]的类型为系统禁止上传的文件类型，不能上传！");
                }
                if(maxFileSize<fileSize) throw new Exception("单个上传文件的容量不能超过["+maxFileSize+"KB]即500M"+"超过文件为："+suFile.getFileName());
                fileCount++;
            }
            if (fileCount==0) throw new Exception("请选择上传的文件");

            String fullFileName = null;//保存到服务器上的文件名(带路径)
            for (int i=0; i<su.getFiles().getCount();i++) {
                suFile = su.getFiles().getFile(i);
                fileExt = su.getFiles().getFile(i).getFileExt();
                String filename = su.getFiles().getFile(i).getFileName();
                IPTimeStamp ipTimeStamp = new IPTimeStamp(filename);
                if (suFile.isMissing()) continue;
                fullFileName = ipTimeStamp.getIPTimeStamp()+"."+fileExt;//填写 文件的路径+文件名
//                String path1 = pageContext.getServletContext().getRealPath("/")+"upload"+java.io.File.separator+fullFileName;//填写 文件名
                String path1 = "F:\\DemoFile"+java.io.File.separator+fullFileName;//填写 文件名
                System.out.println(path1);
                suFile.saveAs(path1.toString(),SmartUpload.SAVE_PHYSICAL);// 项目跟路径下upload文件夹下

                String id = su.getRequest().getParameter("id");//id
                String discriWord = su.getRequest().getParameter("discriWord");//id
                System.out.println("---"+id+" "+discriWord);

                //获取当前时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String ptime = sdf.format(new Date());
                Date date = null;
                try {
                    date = new Date(sdf.parse(ptime).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //设置state=3
                ServiceStudent service = new ServiceStudentImpl();
                int count = service.submitProject_changeState(id, discriWord, date,path1,fullFileName);
                if (count > 0) {
                    HttpSession session = request.getSession();
                    StudentAllInfo user =(StudentAllInfo) session.getAttribute("user");
                    List<IfEmployedList> list =  service.ifEmployedList(user.getSsno(),"1");
                    request.setAttribute("list",list);
                    request.setAttribute("submitSuccess","submitSuccess");
                    request.getRequestDispatcher("Stu/submitProjectPage.jsp").forward(request,response);
                }
                else {
                    request.setAttribute("submited","submited");
                    request.getRequestDispatcher("Stu/submitProjectPage.jsp").forward(request,response);
                }
            }
        } catch (SmartUploadException e) {
            System.out.println("错误");
            request.setAttribute("submitError","submitError");
            request.getRequestDispatcher("Stu/submitProjectPage.jsp").forward(request,response);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("错误");
            request.setAttribute("submitError","submitError");
            request.getRequestDispatcher("Stu/submitProjectPage.jsp").forward(request,response);
            e.printStackTrace();
        } finally {

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
