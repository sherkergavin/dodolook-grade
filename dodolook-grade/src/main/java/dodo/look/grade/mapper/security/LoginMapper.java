package dodo.look.grade.mapper.security;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dodo.look.grade.pojo.owner.OwnerInfo;

/**
 * 
* @ClassName: LoginMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月8日 上午11:44:19 
*
 */
public interface LoginMapper {

	
	Integer add(@Param("list")List<OwnerInfo> list);
	
	Integer del(@Param("ownIds") String[] ownIds);
	
	Integer updLoginName(@Param("owner")OwnerInfo ownerInfo);
	
}
