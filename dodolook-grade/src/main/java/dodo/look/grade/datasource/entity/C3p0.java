package dodo.look.grade.datasource.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
* @ClassName: C3p0 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年1月30日 下午3:12:55 
*
 */
@Configuration
public class C3p0 {

	@Value("${c3p0.maxPoolSize}")
	private Integer maxPoolSize;
	
	@Value("${c3p0.minPoolSize}")
	private Integer minPoolSize;
	
	@Value("${c3p0.initialPoolSize}")
	private Integer initialPoolSize;
	
	@Value("${c3p0.checkoutTimeout}")
	private Integer checkoutTimeout;
	
	@Value("${c3p0.maxStatements}")
	private Integer maxStatements;
	
	@Value("${c3p0.idleConnectionTestPeriod}")
	private Integer idleConnectionTestPeriod;
	
	@Value("${c3p0.acquireIncrement}")
	private Integer acquireIncrement;
	
	@Value("${c3p0.maxIdleTime}")
	private Integer maxIdleTime;
	
	@Value("${c3p0.numHelperThreads}")
	private Integer numHelperThreads;

	
	public Integer getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(Integer maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public Integer getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(Integer minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public Integer getInitialPoolSize() {
		return initialPoolSize;
	}

	public void setInitialPoolSize(Integer initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
	}

	public Integer getCheckoutTimeout() {
		return checkoutTimeout;
	}

	public void setCheckoutTimeout(Integer checkoutTimeout) {
		this.checkoutTimeout = checkoutTimeout;
	}

	public Integer getMaxStatements() {
		return maxStatements;
	}

	public void setMaxStatements(Integer maxStatements) {
		this.maxStatements = maxStatements;
	}

	public Integer getIdleConnectionTestPeriod() {
		return idleConnectionTestPeriod;
	}

	public void setIdleConnectionTestPeriod(Integer idleConnectionTestPeriod) {
		this.idleConnectionTestPeriod = idleConnectionTestPeriod;
	}

	public Integer getAcquireIncrement() {
		return acquireIncrement;
	}

	public void setAcquireIncrement(Integer acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}

	public Integer getMaxIdleTime() {
		return maxIdleTime;
	}

	public void setMaxIdleTime(Integer maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}

	public Integer getNumHelperThreads() {
		return numHelperThreads;
	}

	public void setNumHelperThreads(Integer numHelperThreads) {
		this.numHelperThreads = numHelperThreads;
	}

	@Override
	public String toString() {
		return "C3p0 [maxPoolSize=" + maxPoolSize + ", minPoolSize=" + minPoolSize + ", initialPoolSize="
				+ initialPoolSize + ", checkoutTimeout=" + checkoutTimeout + ", maxStatements=" + maxStatements
				+ ", idleConnectionTestPeriod=" + idleConnectionTestPeriod + ", acquireIncrement=" + acquireIncrement
				+ ", maxIdleTime=" + maxIdleTime + ", numHelperThreads=" + numHelperThreads + "]";
	}

}
