package hello.upload.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Collection;

@Controller
@RequestMapping("/servlet/v1")
public class ServletUploadController {

    private static final Logger log = LoggerFactory.getLogger(ServletUploadController.class);

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
            return "upload-form";
    }


}
