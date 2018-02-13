package dodo.look.grade.pojo.ownsition;

import java.util.Date;

/**
 * 
* @ClassName: DepartPost 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月11日 下午4:07:02 
*
 */
public class DepartPost {

	private Integer groupId;
	
	private Date createTime;
	
	private Integer departId;
	
	private Integer postId;

	public DepartPost() {}
	
	public DepartPost(Date createTime, Integer departId, Integer postId) {
		super();
		this.createTime = createTime;
		this.departId = departId;
		this.postId = postId;
	}
	
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

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

	@Override
	public String toString() {
		return "DepartPost [groupId=" + groupId + ", createTime=" + createTime + ", departId=" + departId + ", postId="
				+ postId + "]";
	}
	
}
