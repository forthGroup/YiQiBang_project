package cn.uc.yiqibang.dao;

import cn.uc.yiqibang.bean.TComment;
import cn.uc.yiqibang.utils.Result;

public interface TCommentMapper extends BaseDao<TComment,Result>{
   
	Result deleteByCondition(TComment comm);
	
}