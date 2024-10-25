package hello.upload.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@Controller
@RequestMapping("/servlet/v3")
public class ServletUploadController3 {

    private static final Logger log = LoggerFactory.getLogger(ServletUploadController3.class);
    @Value("${file.dir}")
    private String fileDir;

        @GetMapping("/upload")
        public String newFile(){
            return  "upload-form";
        }

        @PostMapping("/upload")
        public String saveFileV1(@RequestParam("itemName") String itemName, @RequestParam("file") MultipartFile file ,HttpServletRequest request) throws ServletException, IOException {
            log.info("request={}",request);
            log.info("itemName={}",itemName);
            log.info("file={}",file);


            if(!file.isEmpty()){
                String fullpath = fileDir + file.getOriginalFilename();
                log.info("파일저장패스 ={}",fullpath);
                file.transferTo(new File(fullpath));
            }


            return "upload-form";
    }


}
