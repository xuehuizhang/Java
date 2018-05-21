package xuehui.Servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyServlet implements Servlet{
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	    String servletName= arg0.getServletName();
	    System.out.println(servletName);
	    String initValue=arg0.getInitParameter("url");
	    System.out.println(initValue);
	    ServletContext ccontext= arg0.getServletContext();
		System.out.println("我来了....");
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("我开始服务了....");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("我走了....");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
