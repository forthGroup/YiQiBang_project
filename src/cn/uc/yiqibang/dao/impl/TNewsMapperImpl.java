package cn.uc.yiqibang.dao.impl;


import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;

import cn.uc.yiqibang.bean.TComment;
import cn.uc.yiqibang.bean.TNews;
import cn.uc.yiqibang.bean.TPic;
import cn.uc.yiqibang.dao.TCommentMapper;
import cn.uc.yiqibang.dao.TNewsMapper;
import cn.uc.yiqibang.dao.TPicMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;

public class TNewsMapperImpl extends BaseDaoImpl<TNews> implements TNewsMapper{
	TPicMapper picDao = new TPicMapperImpl();
	TCommentMapper commDao = new TCommentMapperImpl();
	@Override
	public Result insertObject(TNews obj) {
		Result result=new Result();
		String statement=Constants.newsMapper_insert;
		int row=insertObj(statement, obj);
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(row);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result deleteObject(int id) {
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_FAILED);
		result.setRetMsg(false);

	
		TPic pic = new TPic();
		pic.settNId(id);
		picDao.deleteByCondition(pic);

	
		TComment comm = new TComment();
		comm.settNId(id);
		commDao.deleteByCondition(comm);


		SqlSession session = MyBatisUtils.openSession();
		int row = session.delete(Constants.newsMapper_deleteByPrimaryKey, id);
		session.commit();
		session.close();
		if (row > 0) {
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public Result update(TNews obj) {
		Result result=new Result();
		String statement=Constants.newsMapper_update;
		int row=updateObj(statement, obj);
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(row);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result getAllObject() {
		Result result=new Result();
		String statement=Constants.newsMapper_selectAll;
		List<TNews> news=queryAllObj(statement);
		if(news!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(news);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result getObjectById(int objId) {
		Result result=new Result();
		String statement=Constants.newsMapper_selectById;
		TNews news=queryObj(statement, objId);
		if(news!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(news);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result selectByLike(String likeStr) {
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_FAILED);
		result.setRetMsg(false);
	
		SqlSession session = MyBatisUtils.openSession();
		List<TNews> news = session.selectList(Constants.newsMapper_selectByLike, likeStr);
		session.close();
		if (news!=null) {
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(news);
		}
		return result;
	}

	@Override
	public Result selectAllByPage(int pageNum) {
		Result result = new Result();
		SqlSession session = MyBatisUtils.openSession();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("startIndex",Constants.newsPageCounts*(pageNum-1));
		map.put("pageCounts",Constants.newsPageCounts);
		List<TNews> newsList = session.selectList(Constants.newsMapper_selectAllByPage,map);
		session.close();
		if (newsList != null) {
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(newsList);
		} else {
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result insertSelective(TNews record) {
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_FAILED);
		result.setRetMsg(false);
	
		SqlSession session = MyBatisUtils.openSession();
		int row = session.insert(Constants.newsMapper_insertSelective, record);
		session.commit();
		session.close();
		if (row > 0) {
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public Result updateByPrimaryKeySelective(TNews record) {
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_FAILED);
		result.setRetMsg(false);
	
		SqlSession session = MyBatisUtils.openSession();
		int row = session.insert(Constants.newsMapper_updateByPrimaryKeySelective, record);
		session.commit();
		session.close();
		if (row > 0) {
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}
		return result;
	}

	@Override
	public Result selectNewsByTypeid(int typeid) {
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_FAILED);
		result.setRetMsg(false);
		
		SqlSession session = MyBatisUtils.openSession();
		List<TNews> news = session.selectList(Constants.newsMapper_selectByTypeId, typeid);
		session.close();
		if (news!=null) {
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
			result.setRetData(news);
		}
		return result;
	}

	@Override
	public Result insertNewsPic(HttpServletRequest request) {
		Result result = new Result();
		result.setRetCode(Constants.RETCODE_FAILED);
		result.setRetMsg(false);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File("d:/"));
		factory.setSizeThreshold(100 * 1024 * 1024);

		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(-1);
		upload.setHeaderEncoding("UTF-8");
		upload.setSizeMax(50 * 1024 * 1024);

		try {
			List<FileItem> files = upload.parseRequest(request);
			Iterator<FileItem> itFile = files.iterator();
			while (itFile.hasNext()) {
				FileItem file = itFile.next();
				if (!file.isFormField()) {
					String picName = file.getName();

				
					String suffix = picName.substring(picName.lastIndexOf("."));
					long currTime = System.currentTimeMillis();
					String imgName = currTime + suffix;

					String imgPath = request.getServletContext().getRealPath("new_imgs");
					File filePath = new File(imgPath);
					if (!filePath.exists()) {
						filePath.mkdirs();
					}
					String picPath = imgPath + File.separator + imgName;
					file.write(new File(picPath));

					TPic pic = new TPic();
					pic.setpPath(imgName);
					result = picDao.insertSelective(pic);
					if(result.isRetMsg()){
						result.setRetData(imgName);
					}
					
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
