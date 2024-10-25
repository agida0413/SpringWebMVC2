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

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@Controller
@RequestMapping("/servlet/v2")
public class ServletUploadController2 {

    private static final Logger log = LoggerFactory.getLogger(ServletUploadController2.class);
    @Value("${file.dir}")
    private String fileDir;

        @GetMapping("/upload")
        public String newFile(){
            return  "upload-form";
        }

        @PostMapping("/upload")
        public String saveFileV1(HttpServletRequest request) throws ServletException, IOException {
            log.info("request={}",request);

            String itemName= request.getParameter("itemName");
            log.info("itemName={}",itemName);

            Collection<Part> parts = request.getParts();
            log.info("parts={}",parts);

            for (Part part : parts) {
                log.info("====parts====");
                log.info("name={}",part.getName());
                Collection<String> headerName=part.getHeaderNames();
                for (String s : headerName) {
                    log.info("header {}:{}",s,part.getHeader(s));
                }

                log.info("submittedFilename={}",part.getSubmittedFileName());
                log.info("size={}",part.getSize());

                InputStream inputStream=part.getInputStream();
                String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
                log.info("body={}",body);
                if(StringUtils.hasText(part.getSubmittedFileName())){
                    String fullpath = fileDir +"/"+ part.getSubmittedFileName();
                    log.info("파일저장 패스"+fullpath);
                    part.write(fullpath);
                }
            }



            return "upload-form";
    }


}
