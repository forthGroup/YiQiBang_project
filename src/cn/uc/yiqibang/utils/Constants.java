package cn.uc.yiqibang.utils;

/**
 * �ַ����Ĳ���ƴ����
 * @author 12644
 *
 */
public class Constants {

	
	public static final int RETCODE_SUCCESS=0;
	public static final int RETCODE_FAILED=2000;
	
	
	 public static final String root="cn.uc.yiqibang.mapper";
	 
	 public static final String commentMapper=".TCommentMapper";
	 public static final String newsMapper=".TNewsMapper";
	 public static final String AdminMapper=".TAdminMapper";
	 public static final String TypeMapper=".TTypeMapper";
	 public static final String UserMapper=".TUserMapper";
	 public static final String picMapper=".TPicMapper";
	 
	 public static final String selectAllByPage=".selectAllByPage";
	 public static final String insertSelective=".insertSelective";
	 public static final String selectAll=".selectAll";
	 public static final String selectById=".selectByPrimaryKey";
	 public static final String delete=".deleteByPrimaryKey";
	 public static final String update=".updateByPrimaryKey";
	 public static final String insert=".insert";
	 public static final String selectByLike=".selectByLike";
	 public static final String updateByPrimaryKeySelective=".updateByPrimaryKeySelective";
	 public static final String deleteByCondition=".deleteByCondition";
	 public static final String deleteByPrimaryKey=".deleteByPrimaryKey";
	 
	 
	 
	 public static final String commentMapper_selectAll=root+commentMapper+selectAll;
	 public static final String commentMapper_selectById=root+commentMapper+selectById;
	 public static final String commentMapper_delete=root+commentMapper+delete;
	 public static final String commentMapper_update=root+commentMapper+update;
	 public static final String commentMapper_insert=root+commentMapper+insert;
	 public static final String commentMapper_deleteByCondition=root+commentMapper+deleteByCondition;
	 
	 public static final int newsPageCounts=20;
	 public static final String newsMapper_selectAllByPage=root+newsMapper+selectAllByPage;
	 public static final String newsMapper_selectAll=root+newsMapper+selectAll;
	 public static final String newsMapper_selectById=root+newsMapper+selectById;
	 public static final String newsMapper_delete=root+newsMapper+delete;
	 public static final String newsMapper_update=root+newsMapper+update;
	 public static final String newsMapper_insert=root+newsMapper+insert;
	 public static final String newsMapper_selectByLike=root+newsMapper+selectByLike;
	 public static final String newsMapper_insertSelective=root+newsMapper+insertSelective;
	 public static final String newsMapper_updateByPrimaryKeySelective=root+newsMapper+updateByPrimaryKeySelective;
	 public static final String newsMapper_selectByTypeId=root+newsMapper+".selectByTypeId";
	 public static final String newsMapper_deleteByPrimaryKey=root+newsMapper+deleteByPrimaryKey;
	 
	 
	 public static final String AdminMapper_selectAll=root+AdminMapper+selectAll;
	 public static final String AdminMapper_selectById=root+AdminMapper+selectById;
	 public static final String AdminMapper_delete=root+AdminMapper+delete;
	 public static final String AdminMapper_update=root+AdminMapper+update;
	 public static final String AdminMapper_insert=root+AdminMapper+insert;
	 
	 
	 public static final String TypeMapper_selectAll=root+TypeMapper+selectAll;
	 public static final String TypeMapper_selectById=root+TypeMapper+selectById;
	 public static final String TypeMapper_delete=root+TypeMapper+delete;
	 public static final String TypeMapper_update=root+TypeMapper+update;
	 public static final String TypeMapper_insert=root+TypeMapper+insert;
	 
	 
	 public static final String UserMapper_selectAll=root+UserMapper+selectAll;
	 public static final String UserMapper_selectById=root+UserMapper+selectAll;
	 public static final String UserMapper_delete=root+UserMapper+delete;
	 public static final String UserMapper_update=root+UserMapper+update;
	 public static final String UserMapper_insert=root+UserMapper+insert;
	 
	 
	 
	 //Pic
	 public static final String picMapper_deleteByCondition=root+picMapper+deleteByCondition;
	 public static final String picMapper_insertSelective=root+picMapper+insertSelective;
	 
}
