package dodo.look.grade.controller.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dodo.look.grade.mapper.task.TaskInfoMapper;
import dodo.look.grade.pojo.json.AjaxData;
import dodo.look.grade.pojo.task.TaskInfo;

/**
 * 
* @ClassName: TaskController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月5日 上午9:04:17 
*
 */
@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private  TaskInfoMapper taskInfoMapper;
	
	
	
	@GetMapping(value="/all",produces = {"application/json;charset=UTF-8"})
	public AjaxData<List<TaskInfo>> queryTaskInfoAll() {
		
		
		 List<TaskInfo> list = taskInfoMapper.selAll();
		
		 
		 AjaxData<List<TaskInfo>> json = new AjaxData<List<TaskInfo>>();
		 
		 json.setData(list);
		 json.setSuccess(true); 
		
		 return json;
		
	}
	
	
	
	
	
	
}
