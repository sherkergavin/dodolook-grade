package dodo.look.grade.mapper.stand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dodo.look.grade.pojo.stand.Department;
import dodo.look.grade.pojo.stand.DeposBean;
/**
 * 
* @ClassName: DepartmentMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月9日 下午3:31:09 
*
 */
public interface DepartmentMapper {
	
	List<Department> selAll();
	
	List<DeposBean> selComAll();
	
	Integer add(@Param("list")List<DeposBean> list);
	
}
