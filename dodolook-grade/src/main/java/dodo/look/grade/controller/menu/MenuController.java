package dodo.look.grade.controller.menu;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dodo.look.grade.pojo.json.AjaxData;
import dodo.look.grade.pojo.menu.Menu;

/**
 * 
* @ClassName: MenuController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月5日 上午10:42:18 
*
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends AbstractAuthorityService {

	
	@PostMapping(value="/sel",produces = {"application/json;charset=UTF-8"})
	public AjaxData<List<Menu>> getMenuList(){

		List<Menu> mList = menuMapper.selAll();
		
		List<Menu> result = new ArrayList<Menu>();
				
		List<Menu> copy = new ArrayList<Menu>();
		
		iterTreeList(result, copy, 2, mList);

		AjaxData<List<Menu>> volist = new AjaxData<List<Menu>>();
		
		volist.setData(result);
		volist.setSuccess(true);
		
		return volist;
	}
		
}
