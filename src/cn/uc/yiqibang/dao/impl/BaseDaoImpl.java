package cn.uc.yiqibang.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.uc.yiqibang.utils.MyBatisUtils;

public class BaseDaoImpl<T> {
	
	List<T> queryAllObj(String statement){
		SqlSession session = MyBatisUtils.openSession();
		List<T> t=session.selectList(statement);
		session.close();
		return t;
	}
	
	T queryObj(String statement,int objId){
		SqlSession session = MyBatisUtils.openSession();
		T t=session.selectOne(statement,objId);
		session.close();
		return t;
	}
	
	int insertObj(String statement,T t){
		SqlSession session = MyBatisUtils.openSession();
		int result=session.insert(statement, t);
		session.commit();
		session.close();
		return result;
	}
	
	
	int deleteObj(String statement,int id){
		SqlSession session = MyBatisUtils.openSession();
		int result=session.delete(statement, id);
		session.commit();
		session.close();
		return result;
	}
	
	int updateObj(String statement,T t){
		SqlSession session = MyBatisUtils.openSession();
		int result=session.update(statement, t);
		session.commit();
		session.close();
		return result;
	}
	
}
