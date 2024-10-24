package hello.exception.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.exception.exception.UserException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserHandlerExceptionResolver implements HandlerExceptionResolver {
    private static final Logger log = LoggerFactory.getLogger(UserHandlerExceptionResolver.class);

    private static final ObjectMapper objectMapper=  new ObjectMapper();

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {


       try{
           if(ex instanceof UserException){
               log.info("USEREXCEPTION RESOLVER TO 400");
               String acceptHeader=request.getHeader("accept");
               response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

               if("application/json".equals(acceptHeader)){
                   Map<String,Object> errorResult =new HashMap<>();
                   errorResult.put("ex",ex.getClass());
                   errorResult.put("message",ex.getMessage());

                   response.setContentType("application/json");
                   response.setCharacterEncoding("UTF-8");
                   String result = objectMapper.writeValueAsString(errorResult);
                   response.getWriter().write(result);
                   return new ModelAndView();
               }
               else{
                   return new ModelAndView("error/500");
               }
           }
       }
       catch (IOException e){

       }
       finally {

       }


        return null;
    }
}
