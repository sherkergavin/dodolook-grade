package dodo.look.grade.controller.owner;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import dodo.look.grade.pojo.json.AjaxData;
import dodo.look.grade.pojo.json.AjaxVo;
import dodo.look.grade.pojo.owner.OwnerInfo;

/**
 * 
* @ClassName: OwnerController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月6日 上午8:58:47 
*
 */
@RestController
@RequestMapping("/owner")
public class OwnerController extends AbstractWeightService {

	
	@PostMapping(value="/sel",produces = {"application/json;charset=UTF-8"})
	public AjaxData<List<OwnerInfo>> getOwnerList(){
		
		List<OwnerInfo> list = ownerInfoMapper.selAll();
		
		AjaxData<List<OwnerInfo>> voList = new AjaxData<List<OwnerInfo>>();
		
		voList.setData(list);
		voList.setSuccess(true);
		return voList;
	}
	
	
	@PostMapping(value="/del",produces = {"application/json;charset=UTF-8"})
	public AjaxVo delOwner(@RequestParam("ownIds")String ownIds) {
		
		Boolean flag = delOwnInfo(ownIds.split(","));
		
		AjaxVo vo = new AjaxVo();
		
		if(flag) {
			vo.setSuccess(true);
		} else {
			vo.setSuccess(false);
		}
		
		return vo;
	} 
	
	@PostMapping(value="/add",produces = {"application/json;charset=UTF-8"})
	public AjaxVo addOwner(@RequestParam("data") String data) {
	
		List<OwnerInfo> list= JSONObject.parseArray(data, OwnerInfo.class);
		
		Boolean flag = processOwnInfo(list);
		
		AjaxVo vo = new AjaxVo();
		
		if(flag) {
			vo.setSuccess(true);
		} else {
			vo.setSuccess(false);
		}
		
		return vo;
	}
	
	@PostMapping(value="/upd",produces = {"application/json;charset=UTF-8"})
	public AjaxVo updOwner(@RequestParam("data") String data) {

		OwnerInfo ownerInfo = JSONObject.parseObject(data, OwnerInfo.class);
		
		Boolean flag = updOwnInfo(ownerInfo);
		
		AjaxVo vo = new AjaxVo();
		
		if(flag) {
			vo.setSuccess(true);
		} else {
			vo.setSuccess(false);
		}
		
		return vo;
	}
	
	
	
	
}
