package dodo.look.grade.mapper.owner;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dodo.look.grade.pojo.owner.OwnerInfo;

/**
 * 
* @ClassName: OwnerInfoMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年1月30日 下午4:30:00 
*
 */
public interface OwnerInfoMapper {

	 List<OwnerInfo> selAll();
	 
	 Integer del(@Param("ownIds") String[] ownIds);
	 
	 Integer add(@Param("list")List<OwnerInfo> list);
	 
	 Integer upd(@Param("owner")OwnerInfo ownerInfo);
}
