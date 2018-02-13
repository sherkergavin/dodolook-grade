package dodo.look.grade.mapper.security;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import dodo.look.grade.pojo.ownsition.OwnerGroup;



/**
 * 
* @ClassName: OwnerGroupMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月11日 下午5:09:36 
*
 */
public interface OwnerGroupMapper {

	
	List<OwnerGroup> selAll();
	
	Integer delGroup(@Param("groupId") Integer groupId);

	Integer delsingle(@Param("logupId") Integer logupId,@Param("groupId") Integer groupId,@Param("loginId") Integer loginId);
	
	Integer add(@Param("createTime")Date createTime,
				@Param("groupId") Integer groupId,
				@Param("list")List<Integer> list);
	
}
