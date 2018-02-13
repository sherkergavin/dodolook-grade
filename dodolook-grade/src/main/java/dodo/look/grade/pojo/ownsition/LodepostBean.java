package dodo.look.grade.pojo.ownsition;

import java.util.List;

/**
 * 
* @ClassName: LodepostBean 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月11日 下午3:28:16 
*
 */
public class LodepostBean {
	
	private Integer departId;
	
	private Integer postId;
	
	private List<Integer> list;

	public Integer getDepartId() {
		return departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "LodepostBean [departId=" + departId + ", postId=" + postId + ", list=" + list + "]";
	}
	
}
