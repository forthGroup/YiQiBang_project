package cn.uc.yiqibang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uc.yiqibang.dao.TCommentMapper;
import cn.uc.yiqibang.dao.impl.TCommentMapperImpl;
import cn.uc.yiqibang.utils.Result;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	TCommentMapper commDao=new TCommentMapperImpl();
    public void adminGetAllComments(HttpServletRequest request,HttpServletResponse response){
    	Result result = commDao.getAllObject();
    	PrintWriter out=null;
    	try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String jsonResult = JSONObject.fromObject(result).toString();
    	out.println(jsonResult);
    }
    
    
    public void adminInsertComments(HttpServletRequest request,HttpServletResponse response){
    	String content=request.getParameter("content");
    	PrintWriter out=null;
    	try {
			out=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	out.println("����ɹ�:"+content);
    }
    
    //ɾ��һ������
  		public void AdminDeleteComment(HttpServletRequest request,HttpServletResponse response){
  		  //Ҫ�����û��Ĳ������۵�������Ҫ�õ�request���������response��Ӧ����
  		  //����������ȡ���۲���
  			String commId=request.getParameter("commId");//��ȡ��������
  			//System.out.println("ִ��ɾ�����۲�����Ҫɾ��������idΪ��"+commId);
  			PrintWriter out=null;
  			try {
  				out = response.getWriter();
  			} catch (IOException e) {
  				
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  			out.println("ɾ���ɹ�:"+commId);
  		}
    
}
