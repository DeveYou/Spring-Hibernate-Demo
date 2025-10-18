package spring.com.web;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {

    protected WebApplicationContext springContext;

    @Override
    public void init() throws ServletException {
        super.init();
        springContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }
}