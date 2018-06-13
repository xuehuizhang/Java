package org.coding.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import org.coding.domain.UserInfo;
import org.coding.service.UserInfoService;
/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user/reg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String reupwd=request.getParameter("reupwd");
	    UserInfo u=new UserInfo();
	    Map<String,String[]> map=request.getParameterMap();
	    try {
			BeanUtils.populate(u,map);
			if(u.getUpwd().equals(reupwd)) {
				u.setUid(UUID.randomUUID().toString());
				UserInfoService uService=new UserInfoService();
				
				boolean flag=uService.regUser(u);
				response.sendRedirect(request.getContextPath()+"/user/login.jsp");
			}
			request.setAttribute("errorMsg", "×¢²áÊ§°Ü");
			request.getRequestDispatcher("/user/reg.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
