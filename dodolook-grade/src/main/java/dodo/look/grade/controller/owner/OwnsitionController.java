package dodo.look.grade.controller.owner;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import dodo.look.grade.pojo.json.AjaxData;
import dodo.look.grade.pojo.json.AjaxVo;
import dodo.look.grade.pojo.ownsition.DepartPost;
import dodo.look.grade.pojo.ownsition.LodepostBean;
import dodo.look.grade.pojo.ownsition.OwnerGroup;

/**
 * 
* @ClassName: OwnsitionController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月11日 上午11:55:58 
*
 */

@RestController
@RequestMapping("/ownsition")
public class OwnsitionController extends AbstractConditionService {

	
	@PostMapping(value="/add",produces = {"application/json;charset=UTF-8"})
	public AjaxVo addOwnsition(@RequestParam("data")String data) {
				
		LodepostBean  lodepost = JSONObject.parseObject(data, LodepostBean.class);
		
		DepartPost departPost = new DepartPost(new Date(),lodepost.getDepartId(),lodepost.getPostId());
		
		Integer groupId = hasExist(departPost);
			
		if(groupId == null) {
			add(departPost);
			groupId = departPost.getGroupId();
		}	
		
		Integer result = ownerGroupMapper.add(new Date(), groupId, lodepost.getList());
		
		AjaxVo vo = new AjaxVo();
		
		if(result>0) {
			vo.setSuccess(true);
		} else {
			vo.setSuccess(false);
		}
		
		return vo;
		
	}
	
	
	@PostMapping(value="/usergroup",produces = {"application/json;charset=UTF-8"})
	public AjaxData<List<OwnerGroup>> getOwnsitionList() {
		
		List<OwnerGroup> list = ownerGroupMapper.selAll();
		
		AjaxData<List<OwnerGroup>> volist = new AjaxData<List<OwnerGroup>>();
		
		volist.setData(list);
		volist.setSuccess(true);
		
		return volist;
	}
	
	
	@PostMapping(value="/delgroup",produces = {"application/json;charset=UTF-8"})
	public AjaxVo delGroup(@RequestParam("groupId")String groupId) {
		
		Integer result = ownerGroupMapper.delGroup(Integer.valueOf(groupId));
			
		AjaxVo vo = new AjaxVo();
		
		if(result>0) {
			vo.setSuccess(true);
		} else {
			vo.setSuccess(false);
		}
		
		return vo;
	}
	
	
	
	@PostMapping(value="/delsingle",produces = {"application/json;charset=UTF-8"})
	public AjaxVo delsingle(@RequestParam("logupId")String logupId,@RequestParam("groupId")String groupId,@RequestParam("loginId")String loginId) {
		
		Integer result  = ownerGroupMapper.delsingle(Integer.valueOf(logupId),Integer.valueOf(groupId),Integer.valueOf(loginId));
		
		AjaxVo vo = new AjaxVo();
		
		if(result>0) {
			vo.setSuccess(true);
		} else {
			vo.setSuccess(false);
		}
		
		return vo;
		
	}
	
	
	
}
