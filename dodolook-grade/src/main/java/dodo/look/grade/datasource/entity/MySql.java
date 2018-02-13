package dodo.look.grade.datasource.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
* @ClassName: MySql 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年1月30日 下午3:15:15 
*
 */
@Configuration
public class MySql {

	@Value("${mysql.driverClass}")
	private String driverClassName;
	
	@Value("${mysql.url}")
	private String url;
	
	@Value("${mysql.userName}")
	private String username;
	
	@Value("${mysql.passWord}")
	private String password;

	
	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MySql [driverClassName=" + driverClassName + ", url=" + url + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
