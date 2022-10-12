//package cn.CEsystem.student.servlet;
//
//import cn.CEsystem.student.service.Impl.ServiceStudentImpl;
//import cn.CEsystem.student.service.ServiceStudent;
//import cn.CEsystem.student.util.IPTimeStamp;
//import com.jspsmart.upload.SmartUpload;
//import com.jspsmart.upload.SmartUploadException;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.jsp.JspFactory;
//import javax.servlet.jsp.PageContext;
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@WebServlet("/submitProjectServlet")
//public class SubmitProjectServlet extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        /**
//         * enctype="multipart/form-data" 解决form问题
//         */
//        request.setCharacterEncoding("GBK");
//        response.setCharacterEncoding("UTF-8");
//        /**
//         * 上传数据及保存文件
//         */
//        SmartUpload smart=new SmartUpload();
//        try {
//            //PageContext是jsp的内置对象，在servlet不能直接使用，需要做一些处理
//            JspFactory jspxFactory = null;
//            PageContext pageContext = null;
//            jspxFactory = JspFactory.getDefaultFactory();
//            pageContext = jspxFactory.getPageContext(this,request,response,"",true,8192,true);
//
//            smart.initialize(pageContext);
//            smart.upload();
//            com.jspsmart.upload.File file = smart.getFiles().getFile(0);
//            /**
//             * 文件名，和路径
//             */
//            String fieldExt = file.getFileExt();
//            String fieldName = file.getFileName();
//            String id = smart.getRequest().getParameter("id");//id
//
//
//
//            System.out.println(fieldExt);
//            System.out.println(fieldName);
//            System.out.println(this.getServletContext().getRealPath("/"));
//
//
//            String ip = request.getRemoteAddr();
//            IPTimeStamp ipTimeStamp = new IPTimeStamp(ip);
//            String fullFileName = null;//保存到服务器上的文件名(带路径
//
//            fullFileName = ipTimeStamp.getIPTimeStamp()+"."+fieldExt;//填写 文件的路径+文件名
//            String path1 = pageContext.getServletContext().getRealPath("/")+"upload"+java.io.File.separator+fullFileName;//填写 文件名
//
//            System.out.println(path1);
//            System.out.println(path1.toString());
//            System.out.println("qqqqqqqqqqqqqqqqqqqq//");
//            System.out.println(SmartUpload.SAVE_PHYSICAL);
//            file.saveAs(path1.toString(),SmartUpload.SAVE_PHYSICAL);// 项目跟路径下upload文件夹下
//
////            smart.getFiles().getFile(0).saveAs(this.getServletContext().getRealPath("/")+"upload"+java.io.File.separator+id);
//
//
////            smart.save(this.getServletContext().getRealPath("/")+"upload"+java.io.File.separator+id);
//
////            System.out.println(this.getServletContext().getRealPath("/")+"upload"+java.io.File.separator+id);
////            smart.save("upload");
//
//
//
//            String discriWord = smart.getRequest().getParameter("discriWord");//id
//            System.out.println("++++++");
//            System.out.println(id);
//            System.out.println(discriWord);
//
//
//            //获取当前时间
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String ptime = sdf.format(new Date());
//            Date date = null;
//            try {
//                date = new Date(sdf.parse(ptime).getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            //设置state=3
//            ServiceStudent service = new ServiceStudentImpl();
//            int count = service.submitProject_changeState(id, discriWord, date);
//            if (count >= 0) {
//                request.setAttribute("submitSuccess", "submitSuccess");
//                request.getRequestDispatcher("ifEmployedListServlet?ps_state=x").forward(request, response);
//            }
//        } catch (Exception e) {
//            System.out.println("错误111");
//            e.printStackTrace();
//        }
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//}
