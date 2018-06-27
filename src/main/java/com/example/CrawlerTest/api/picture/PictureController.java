package com.example.CrawlerTest.api.picture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/api/Picture")
@CrossOrigin(origins = "*")
public class PictureController {
    @Value("${crawler.downloadDir}")
    private String downloadDir;

    @RequestMapping("/{picFileName}")
    public String getPicture(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             @PathVariable String picFileName){
        try {
            File downloadDirFile = new File(downloadDir);
            if(downloadDirFile.exists()){
                String PicFilePath = downloadDir + "/" + picFileName;
                File PicFile = new File(PicFilePath);
                if(PicFile.exists()) {
                    httpServletResponse.setContentType("image/png");
                    FileImageInputStream ins = new FileImageInputStream(PicFile);
                    OutputStream os = httpServletResponse.getOutputStream();
                    // img为图片的二进制流
                    int len = 0;
                    final int BUFFER_SIZE = 4096;
                    byte[] img = new byte[BUFFER_SIZE];
                    while ((len = ins.read(img,0,BUFFER_SIZE))!=-1){
                        os.write(img,0,len);
                        os.flush();
                    }

                    os.close();
                }else{
                    return "404";
                }
            }else{
                return "404";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }

}
