package dodo.look.grade.controller.owner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dodo.look.grade.mapper.security.DepartPostMapper;
import dodo.look.grade.mapper.security.OwnerGroupMapper;
import dodo.look.grade.pojo.ownsition.DepartPost;

/**
 * 
* @ClassName: AbstractConditionService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月11日 下午3:44:42 
*
 */

public abstract class AbstractConditionService {

	@Autowired
	private DepartPostMapper departPostMapper;
	@Autowired
	protected OwnerGroupMapper ownerGroupMapper;
	
	protected Integer hasExist(DepartPost departPost) {
		
		Integer result = departPostMapper.count(departPost);
		
		return result;
		
	}
	
	protected Integer add(DepartPost departPost) {
		
		List<DepartPost> list = new ArrayList<DepartPost>();
		list.add(departPost);
		Integer result = departPostMapper.add(departPost);
		
		return result;
		
	}
	
	
}
