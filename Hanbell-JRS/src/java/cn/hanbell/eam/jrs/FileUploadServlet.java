/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eam.jrs;

import cn.hanbell.eam.ejb.EquipmentAnalyResultBean;
import cn.hanbell.eam.entity.EquipmentAnalyResult;
import cn.hanbell.jrs.SuperRESTForEAM;
import com.lightshell.comm.SuperEJB;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.util.UUID;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author C2090
 */
@Stateless
@Path("jrs/comm")
public class FileUploadServlet extends SuperRESTForEAM<EquipmentAnalyResult> {

    @EJB
    private EquipmentAnalyResultBean equipmentAnalyResultBean;

    protected SuperEJB superEJB;
    //生产环境
    //   private final String filePathTemp = "D:\\glassfish5\\glassfish\\domains\\domain1\\applications\\EAM\\Hanbell-EAM_war\\resources\\app\\res\\";
//F:\C2079\EAM\Hanbell-EAM\web\resources\app\res
    private final String filePathTemp = "F:\\C2079\\EAM\\Hanbell-EAM\\web\\resources\\app\\res\\";

    @Override
    protected SuperEJB getSuperEJB() {
        return equipmentAnalyResultBean;
    }

    public FileUploadServlet() {
        super(EquipmentAnalyResult.class);
    }

    @POST
    @Path("upload/image")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadImage(@Context HttpServletRequest request,
            @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        // 1. 验证权限（与现有接口保持一致）
        if (!isAuthorized(appid, token)) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"code\":401,\"msg\":\"未授权\"}")
                    .build();
        }

        try {
            // 2. 判断是否为 multipart 请求
            if (!ServletFileUpload.isMultipartContent(request)) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"code\":400,\"msg\":\"不是有效的文件上传请求\"}")
                        .build();
            }

            // 3. 创建 FileItem 工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(10 * 1024 * 1024); // 最大 10MB

            // 4. 解析请求
            List<FileItem> items = upload.parseRequest(request);

            // 5. 提取文件流和业务参数
            InputStream fileInputStream = null;
            String originalFilename = null;
            String pid = null;
            String imageBase = null;

            for (FileItem item : items) {
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString("UTF-8");
                    if ("pid".equals(fieldName)) {
                        pid = fieldValue;
                    } else if ("imageBase".equals(fieldName)) {
                        imageBase = fieldValue;
                    }
                } else {
                    fileInputStream = item.getInputStream();
                    originalFilename = item.getName();
                    if (originalFilename != null && originalFilename.contains(File.separator)) {
                        originalFilename = originalFilename.substring(originalFilename.lastIndexOf(File.separator) + 1);
                    }
                }
            }

            // 6. 校验文件
            if (fileInputStream == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"code\":400,\"msg\":\"未找到文件\"}")
                        .build();
            }

            // 7. 提取文件后缀
            String extension = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }

            // 8. 生成文件名（使用 pid_seq_时间戳）
            String newFileName;
            if (pid != null && !pid.isEmpty() && imageBase != null && !imageBase.isEmpty()) {
                long timestamp = System.currentTimeMillis();
                newFileName = pid + "_" + imageBase + "_" + timestamp + extension;
            } else {
                newFileName = UUID.randomUUID().toString() + extension;
            }

            // 9. 保存文件（使用已有的 filePathTemp）
            // 注意：filePathTemp 已在类的成员变量中定义
            File targetDir = new File(filePathTemp);
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            }
            File targetFile = new File(targetDir, newFileName);
            try (FileOutputStream fos = new FileOutputStream(targetFile)) {
                byte[] buffer = new byte[8192];
                int len;
                while ((len = fileInputStream.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            }

            // 10. 构造可访问的 URL
            String contextPath = request.getContextPath();
            String baseUrl = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + contextPath + "/resources/app/res/";
            String fileUrl = baseUrl + newFileName;

            // 11. 返回 JSON
            String jsonResult = String.format(
                    "{\"code\":200,\"msg\":\"上传成功\",\"data\":{\"url\":\"%s\",\"filename\":\"%s\"}}",
                    fileUrl, newFileName
            );
            return Response.ok(jsonResult).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"code\":500,\"msg\":\"上传失败: " + e.getMessage().replace("\"", "\\\"") + "\"}")
                    .build();
        }
    }

}
