package dodo.look.grade.pojo.owner;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: OwnerInfo 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年1月30日 下午4:05:17 
*
 */
public class OwnerInfo {

	//主键
	private Integer ownerId;
	//创建时间
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	//人员名
	private String ownerName;
	//登录ID
	private Integer loginId;
	//登录名
	private String loginName;
	//工号
	private String workNum;
	//密码
	private String loginPwd;
	//密码(编码)
	private String encodePwd;
	//加权
	private Integer salt;
	
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
	public String getWorkNum() {
		return workNum;
	}
	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getEncodePwd() {
		return encodePwd;
	}
	public void setEncodePwd(String encodePwd) {
		this.encodePwd = encodePwd;
	}
	public Integer getSalt() {
		return salt;
	}
	public void setSalt(Integer salt) {
		this.salt = salt;
	}
	
	@Override
	public String toString() {
		return "OwnerInfo [ownerId=" + ownerId + ", createTime=" + createTime + ", ownerName=" + ownerName
				+ ", loginId=" + loginId + ", loginName=" + loginName + ", workNum=" + workNum + ", loginPwd="
				+ loginPwd + ", encodePwd=" + encodePwd + ", salt=" + salt + "]";
	}
	
}
