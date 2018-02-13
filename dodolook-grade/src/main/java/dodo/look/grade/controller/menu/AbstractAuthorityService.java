package dodo.look.grade.controller.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dodo.look.grade.mapper.menu.MenuMapper;
import dodo.look.grade.pojo.menu.Menu;

/**
 * 
* @ClassName: AbstractAuthorityService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月5日 下午1:41:02 
*
 */

public abstract class AbstractAuthorityService {
	
	@Autowired
	protected MenuMapper  menuMapper;
	

	protected void iterTreeList(List<Menu>result,List<Menu>copy,int lev,List<Menu> resource){
		  boolean j = true;
	        int i = 0;
	        while(j){
	            if(lev == resource.get(i).getLevel()){       	
	            	result.add(resource.get(i));
	            	resource.remove(i);
	                i--;
	            }
	            if(i==resource.size()-1){
	                if(copy.size()==0){
	                    for(Menu dto:result){
	                    	copy.add(dto);
	                    }
	                    result.clear();
	                    lev--;
	                    iterTreeList(result,copy,lev,resource);
	                }else{
	                	iterAddChild(result,copy);
	                }
	            }
	            i++;
	            if(i>=resource.size()){i = 0;}
	            if(resource.size() == 0) j = false;
	        }
	}
	
	
	private void iterAddChild(List<Menu>result,List<Menu>copy){
        boolean x = true;
        int n = 0;
        while(x){
        	Menu tmpM = copy.get(n);
            int tmpUpId  = tmpM.getParentId();
            boolean flag = false;
            for(Menu dto:result){
                if(tmpUpId == dto.getId()){
                    if(dto.getChildren() == null){
                    	dto.setChildren(new ArrayList<Menu>());
                    }
                    dto.getChildren().add(tmpM);
                    copy.remove(n);
                    n--;
                    if(flag == false){
                        dto.setExpanded(true);
                        flag = true;
                    }
                    break;
                }
            }
            n++;
            if(copy.size() == 0) x = false;
        }
	}
	
	
	
}
