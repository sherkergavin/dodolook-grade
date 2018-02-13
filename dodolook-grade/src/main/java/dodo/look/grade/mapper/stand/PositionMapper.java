package dodo.look.grade.mapper.stand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dodo.look.grade.pojo.stand.DeposBean;
import dodo.look.grade.pojo.stand.Position;

/**
 * 
* @ClassName: PositionMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月9日 下午3:31:23 
*
 */
public interface PositionMapper {

	List<Position> selAll();
	
	List<DeposBean> selComAll();
	
	Integer add(@Param("list")List<DeposBean> list);
	
}
