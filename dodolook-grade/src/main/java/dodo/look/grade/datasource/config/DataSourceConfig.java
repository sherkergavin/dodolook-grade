package dodo.look.grade.datasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import dodo.look.grade.datasource.entity.C3p0;
import dodo.look.grade.datasource.entity.MySql;

/**
 * 
* @ClassName: DataSourceConfig 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年1月30日 下午3:12:01 
*
 */

@Configuration
public class DataSourceConfig {

	@Autowired
	private C3p0 c3p0;
	
	@Autowired
	private MySql mySql;
	
	@Bean(destroyMethod="close")
	public ComboPooledDataSource confComboPooledDataSource() {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try {
			dataSource.setJdbcUrl(mySql.getUrl());
			dataSource.setDriverClass(mySql.getDriverClassName());
			dataSource.setUser(mySql.getUsername());
			dataSource.setPassword(mySql.getPassword());
		
			dataSource.setMaxPoolSize(c3p0.getMaxPoolSize());
			dataSource.setMinPoolSize(c3p0.getMinPoolSize());
			dataSource.setInitialPoolSize(c3p0.getInitialPoolSize());
			//DataSource.setCheckoutTimeout(c3p0.getCheckoutTimeout());
			dataSource.setMaxStatements(c3p0.getMaxStatements());
			dataSource.setIdleConnectionTestPeriod(c3p0.getIdleConnectionTestPeriod());
			dataSource.setAcquireIncrement(c3p0.getAcquireIncrement());
			dataSource.setMaxIdleTime(c3p0.getMaxIdleTime());
			dataSource.setNumHelperThreads(c3p0.getNumHelperThreads());
			
		}catch(Exception ex) {
				
				ex.printStackTrace();
				
			}
		
		return dataSource;
	}
	
}
