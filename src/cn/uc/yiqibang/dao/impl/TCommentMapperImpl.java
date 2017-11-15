package cn.uc.yiqibang.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.uc.yiqibang.bean.TComment;
import cn.uc.yiqibang.dao.TCommentMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;

public class TCommentMapperImpl extends BaseDaoImpl<TComment> implements TCommentMapper{

	@Override
	public Result insertObject(TComment obj) {
		Result result=new Result();
		String statement=Constants.commentMapper_insert;
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
		Result result=new Result();
		String statement=Constants.commentMapper_delete;
		int row=deleteObj(statement, id);
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
	public Result update(TComment obj) {
		Result result=new Result();
		String statement=Constants.commentMapper_update;
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
		String statement=Constants.commentMapper_selectAll;
		List<TComment> comms=queryAllObj(statement);
		if(comms!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(comms);
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
		String statement=Constants.commentMapper_selectById;
		TComment comm=queryObj(statement, objId);
		if(comm!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(comm);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	@Override
	public Result deleteByCondition(TComment comm) {
		Result result=new Result();
		SqlSession session = MyBatisUtils.openSession();
		int row = session.delete(Constants.commentMapper_deleteByCondition,comm);
		session.commit();
		session.close();
		if(row>0){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

	

	

}
