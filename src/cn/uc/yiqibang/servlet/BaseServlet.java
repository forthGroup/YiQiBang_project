package cn.uc.yiqibang.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if(action==null||"".equals(action)){
		    
			response.getWriter().println("请求参数错误，没有该操作！");
		}else{
			
		    
			try {
				
				Method method = this.getClass().getMethod(action,HttpServletRequest.class,HttpServletResponse.class);
				
				method.invoke(this,request,response);
				
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().println("请求参数错误，没有该操作！");
			} 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
