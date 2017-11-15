package cn.uc.yiqibang.dao.impl;


import org.apache.ibatis.session.SqlSession;

import cn.uc.yiqibang.bean.TPic;

import cn.uc.yiqibang.dao.TPicMapper;
import cn.uc.yiqibang.utils.Constants;
import cn.uc.yiqibang.utils.MyBatisUtils;
import cn.uc.yiqibang.utils.Result;

public class TPicMapperImpl extends BaseDaoImpl<TPic> implements TPicMapper{

	@Override
	public Result insertObject(TPic obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result deleteObject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(TPic obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getAllObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getObjectById(int objId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result insertSelective(TPic record) {
		Result result=new Result();
		SqlSession session=MyBatisUtils.openSession();
		int row = session.insert(Constants.picMapper_insertSelective,record);
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

	@Override
	public Result deleteByCondition(TPic pic) {
		Result result=new Result();
		SqlSession session = MyBatisUtils.openSession();
		int row = session.delete(Constants.picMapper_deleteByCondition,pic);
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
