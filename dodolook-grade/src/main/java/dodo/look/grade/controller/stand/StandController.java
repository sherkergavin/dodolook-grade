package dodo.look.grade.controller.stand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import dodo.look.grade.mapper.stand.DepartmentMapper;
import dodo.look.grade.mapper.stand.PositionMapper;
import dodo.look.grade.pojo.json.AjaxData;
import dodo.look.grade.pojo.json.AjaxVo;
import dodo.look.grade.pojo.stand.Department;
import dodo.look.grade.pojo.stand.DeposBean;
import dodo.look.grade.pojo.stand.Position;

/**
 * 
* @ClassName: StandController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月9日 下午3:19:18 
*
 */

@RestController
@RequestMapping("/stand")
public class StandController {

	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private PositionMapper positionMapper;
	
	@PostMapping(value="/adddepart",produces = {"application/json;charset=UTF-8"})
	public AjaxVo addDepart(@RequestParam("data") String data) {
		
		List<DeposBean> list= JSONObject.parseArray(data, DeposBean.class);
		
		Integer result = departmentMapper.add(list);

		AjaxVo vo = new AjaxVo();
		
		if(result>0) {
			vo.setSuccess(true);
		} else {
			vo.setSuccess(false);
		}
		
		return vo;
		
	}
	
	
	@PostMapping(value="/addposit",produces = {"application/json;charset=UTF-8"})
	public AjaxVo addPosit(@RequestParam("data") String data) {
		
		List<DeposBean> list= JSONObject.parseArray(data, DeposBean.class);
		
		Integer result = positionMapper.add(list);
		
		AjaxVo vo = new AjaxVo();
		
		if(result>0) {
			vo.setSuccess(true);
		} else {
			vo.setSuccess(false);
		}
		return vo;
	}
	
	@PostMapping(value="/seldepcom",produces = {"application/json;charset=UTF-8"})
	public AjaxData<List<DeposBean>> getDepcomList(){
		
		List<DeposBean> list = departmentMapper.selComAll();
		
		AjaxData<List<DeposBean>> volist = new AjaxData<List<DeposBean>>(); 
		
		volist.setData(list);
		volist.setSuccess(true);
		
		return volist;
	}
	
	
	@PostMapping(value="/selposcom",produces = {"application/json;charset=UTF-8"})
	public AjaxData<List<DeposBean>> getPoscomList(){
		
		List<DeposBean> list = positionMapper.selComAll();
		
		AjaxData<List<DeposBean>> volist = new AjaxData<List<DeposBean>>(); 
		
		volist.setData(list);
		volist.setSuccess(true);
		
		return volist;
	}
	
	
	@PostMapping(value="/seldepart",produces = {"application/json;charset=UTF-8"})
	public AjaxData<List<Department>> getDepartList(){
		
		List<Department> list = departmentMapper.selAll();
		
		AjaxData<List<Department>> volist = new AjaxData<List<Department>>(); 
		
		volist.setData(list);
		volist.setSuccess(true);
		
		return volist;
	}
	
	@PostMapping(value="/selpost",produces = {"application/json;charset=UTF-8"})
	public AjaxData<List<Position>> getPostList(){
		
		List<Position> list = positionMapper.selAll();
		
		AjaxData<List<Position>> volist = new AjaxData<List<Position>>(); 
		
		volist.setData(list);
		volist.setSuccess(true);
		
		return volist;
	}
	
}
