package dodo.look.grade.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* @ClassName: IndexController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月5日 上午10:16:57 
*
 */
@Controller
public class IndexController {

	
	@RequestMapping("/")
	public String welcomeIndex() {
		
		return "index";
	} 

}
