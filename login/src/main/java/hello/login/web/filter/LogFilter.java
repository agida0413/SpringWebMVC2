package hello.login.web.filter;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;


public class LogFilter implements  Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("logfilter dofilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();

        String UUID= java.util.UUID.randomUUID().toString();

        try {
            System.out.println("Req:"+UUID+requestURI);
            filterChain.doFilter(request,servletResponse);
        }
        catch (Exception e){
            throw  e;
        }
        finally {
            System.out.println("RES :"+UUID+requestURI);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("logfiletr init");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
