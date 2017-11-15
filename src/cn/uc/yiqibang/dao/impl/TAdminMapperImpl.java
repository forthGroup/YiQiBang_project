package cn.uc.yiqibang.dao.impl;

import java.util.List;

import cn.uc.yiqibang.bean.TAdmin;
import cn.uc.yiqibang.dao.TAdminMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.Result;

public class TAdminMapperImpl extends BaseDaoImpl<TAdmin> implements TAdminMapper{

	@Override
	public Result insertObject(TAdmin obj) {
		Result result=new Result();
		String statement=Constants.AdminMapper_insert;
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
		String statement=Constants.AdminMapper_delete;
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
	public Result update(TAdmin obj) {
		Result result=new Result();
		String statement=Constants.AdminMapper_update;
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
		String statement=Constants.AdminMapper_selectAll;
		List<TAdmin> admins=queryAllObj(statement);
		if(admins!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(admins);
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
		String statement=Constants.AdminMapper_selectById;
		TAdmin admin=queryObj(statement, objId);
		if(admin!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(admin);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

}
