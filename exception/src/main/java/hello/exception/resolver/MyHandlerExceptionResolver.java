package hello.exception.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {


    private static final Logger log = LoggerFactory.getLogger(MyHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        if(ex instanceof  IllegalArgumentException){
            log.info("IllegalArgumentException TO 400");
            try {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST,ex.getMessage());
                return  new ModelAndView();
            } catch (IOException e) {
               log.error("exception",e);
            }
        }

        return null;
    }
}
