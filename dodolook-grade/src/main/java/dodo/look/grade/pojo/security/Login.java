package dodo.look.grade.pojo.security;
/**
 * 
* @ClassName: Login 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年2月8日 上午11:28:26 
*
 */
public class Login {

	private Integer loginId;
	
	private String loginName;
	
	private String loginPwd;
	
	private String encodePwd;

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

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", loginName=" + loginName + ", loginPwd=" + loginPwd + ", encodePwd="
				+ encodePwd + "]";
	}
	
}
