package net.codejava.Controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class FileController {
    @RequestMapping("/files/{fileName}")
    @ResponseBody
    public void downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse response) {

        if (fileName.indexOf(".doc")>-1) response.setContentType("application/msword");
        if (fileName.indexOf(".docx")>-1) response.setContentType("application/msword");
        if (fileName.indexOf(".xls")>-1) response.setContentType("application/vnd.ms-excel");
        if (fileName.indexOf(".csv")>-1) response.setContentType("application/vnd.ms-excel");
        if (fileName.indexOf(".ppt")>-1) response.setContentType("application/ppt");
        if (fileName.indexOf(".pdf")>-1) response.setContentType("application/pdf");
        if (fileName.indexOf(".zip")>-1) response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=" +fileName);
        response.setHeader("Content-Transfer-Encoding", "binary");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis = new FileInputStream(fileName);
            int len;
            byte[] buf = new byte[1024];
            while((len = fis.read(buf)) > 0) {
                bos.write(buf,0,len);
            }
            bos.close();
            response.flushBuffer();
        }
        catch(IOException e) {
            e.printStackTrace();

        }
    }
}
