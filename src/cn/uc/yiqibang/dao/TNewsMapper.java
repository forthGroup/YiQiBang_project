package cn.uc.yiqibang.dao;

import javax.servlet.http.HttpServletRequest;

import cn.uc.yiqibang.bean.TNews;
import cn.uc.yiqibang.utils.Result;

public interface TNewsMapper extends BaseDao<TNews,Result> {
	
	Result selectByLike(String likeStr);

	Result selectAllByPage(int pageNum);

	Result insertSelective(TNews record);

	Result updateByPrimaryKeySelective(TNews record);

	Result selectNewsByTypeid(int typeid);

	Result insertNewsPic(HttpServletRequest request);
}