package cn.uc.yiqibang.dao.impl;

import java.util.List;

import cn.uc.yiqibang.bean.TType;
import cn.uc.yiqibang.dao.TTypeMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.Result;

public class TTypeMapperImpl extends BaseDaoImpl<TType> implements TTypeMapper{

	@Override
	public Result insertObject(TType obj) {
		Result result=new Result();
		String statement=Constants.TypeMapper_insert;
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
		String statement=Constants.TypeMapper_delete;
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
	public Result update(TType obj) {
		Result result=new Result();
		String statement=Constants.TypeMapper_update;
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
		String statement=Constants.TypeMapper_selectAll;
		List<TType> types=queryAllObj(statement);
		if(types!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(types);
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
		String statement=Constants.TypeMapper_selectById;
		TType type=queryObj(statement, objId);
		if(type!=null){
			result.setRetCode(Constants.RETCODE_SUCCESS);
			result.setRetData(type);
			result.setRetMsg(true);
		}else{
			result.setRetCode(Constants.RETCODE_FAILED);
			result.setRetMsg(false);
		}
		return result;
	}

}
