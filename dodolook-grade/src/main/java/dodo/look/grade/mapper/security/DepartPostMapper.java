package dodo.look.grade.mapper.security;

import org.apache.ibatis.annotations.Param;

import dodo.look.grade.pojo.ownsition.DepartPost;

/**
 * 
* @ClassName: DeptpostMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月11日 下午3:46:05 
*
 */
public interface DepartPostMapper {

	
	public Integer count(@Param("departPost") DepartPost departPost);
	
	public Integer add(@Param("departPost") DepartPost departPost);
	
}
