package hello.login.web.filter;

import hello.login.web.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {

    private static final String[] whiteList ={"/","/member/add","/login","/css/*"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String requestURI= request.getRequestURI();

        HttpServletResponse response = (HttpServletResponse) servletResponse;

            try {
                System.out.println(requestURI);
                if(isLoginCheckPath(requestURI)){
                    System.out.println("인증체크 로직실행");

                    HttpSession session = request.getSession(false);

                    if(session==null || session.getAttribute(SessionConst.LOGIN_MEMBER)==null){
                        System.out.println("미인증 사용자");

                        response.sendRedirect("/login?redirectURL="+requestURI);

                        return;
                    }


                }
                filterChain.doFilter(servletRequest,servletResponse);
            } catch (Exception e) {
                throw e;
            }
            finally {

            }


    }

    private boolean isLoginCheckPath(String requestURI){
        return !PatternMatchUtils.simpleMatch(whiteList,requestURI);
    }
}
