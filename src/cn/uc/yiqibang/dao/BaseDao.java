package cn.uc.yiqibang.dao;




public interface BaseDao<T, E> {
	
	E insertObject(T obj);
	
	E deleteObject(int id);
	
	E update(T obj);
	
	E getAllObject();
	
	E getObjectById(int objId);
}
