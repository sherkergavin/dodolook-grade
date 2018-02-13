package dodo.look.grade.pojo.ownsition;
/**
 * 
* @ClassName: OwnerPostGroup 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月12日 上午11:35:49 
*
 */
public class OwnerGroup {
	
	private Integer logupId;
	
	private Integer groupId;
	
	private String groupName;
	
	private Integer loginId;
	
	private String loginName;
	
	private String ownerName;
	
	private String workNum;
	
	private Integer departId;
	
	private String departName;
	
	private Integer postId;
	
	private String postName;

	public Integer getLogupId() {
		return logupId;
	}

	public void setLogupId(Integer logupId) {
		this.logupId = logupId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getWorkNum() {
		return workNum;
	}

	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}

	public Integer getDepartId() {
		return departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	@Override
	public String toString() {
		return "OwnerGroup [logupId=" + logupId + ", groupId=" + groupId + ", groupName=" + groupName + ", loginId="
				+ loginId + ", loginName=" + loginName + ", ownerName=" + ownerName + ", workNum=" + workNum
				+ ", departId=" + departId + ", departName=" + departName + ", postId=" + postId + ", postName="
				+ postName + "]";
	}

}
