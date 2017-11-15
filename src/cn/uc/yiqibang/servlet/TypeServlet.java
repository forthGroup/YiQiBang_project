package cn.uc.yiqibang.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yiqibang.dao.TTypeMapper;
import cn.uc.yiqibang.dao.impl.TTypeMapperImpl;
import cn.uc.yiqibang.utils.Result;
import cn.uc.yiqibang.utils.WriteResultToClient;

/**
 * Servlet implementation class TypeServlet
 */
@WebServlet("/TypeServlet")
public class TypeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	TTypeMapper typeDao=new TTypeMapperImpl();
	
	public void adminGetTypeById(HttpServletRequest request,HttpServletResponse response){
		int typeid=Integer.parseInt(request.getParameter("id"));
		Result result = typeDao.getObjectById(typeid);
		WriteResultToClient.writeMethod(result, response);
	}
	
	public void adminGetAllTypes(HttpServletRequest request,HttpServletResponse response){
		Result result = typeDao.getAllObject();
		WriteResultToClient.writeMethod(result, response);
	}
	
	public void getAllTypes(HttpServletRequest request,HttpServletResponse response){
		Result result = typeDao.getAllObject();
		WriteResultToClient.writeMethod(result, response);
	}

}
