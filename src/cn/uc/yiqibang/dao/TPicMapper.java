package cn.uc.yiqibang.dao;

import cn.uc.yiqibang.bean.TPic;
import cn.uc.yiqibang.utils.Result;

public interface TPicMapper extends BaseDao<TPic,Result>{
	public Result insertSelective(TPic record);
	
	public Result deleteByCondition(TPic pic);
}