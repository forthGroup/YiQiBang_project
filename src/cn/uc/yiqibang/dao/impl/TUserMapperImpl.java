package cn.uc.yiqibang.dao.impl;

import java.util.List;

import cn.uc.yiqibang.bean.TUser;
import cn.uc.yiqibang.dao.TUserMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.Result;

public class TUserMapperImpl extends BaseDaoImpl<TUser> implements TUserMapper{

	@Override
	public Result insertObject(TUser obj) {
		Result result=new Result();
		String statement=Constants.UserMapper_insert;
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
		String statement=Constants.UserMapper_delete;
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
	public Result update(TUser obj) {
		Result result=new Result();
		String statement=Constants.UserMapper_update;
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
		String statement=Constants.UserMapper_selectAll;
		List<TUser> users=queryAllObj(statement);
		if(users!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(users);
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
		String statement=Constants.UserMapper_selectById;
		TUser user=queryObj(statement, objId);
		if(user!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(user);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

}
