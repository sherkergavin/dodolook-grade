package dodo.look.grade.datasource.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
* @ClassName: MyBatisConfig 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年1月30日 下午3:31:58 
*
 */
@Configuration
@MapperScan("dodo.look.grade.mapper.*")
@EnableTransactionManagement
public class MyBatisConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PlatformTransactionManager confTransactionManager() {
		
		return new DataSourceTransactionManager(dataSource);
	}
	
	
	@Bean
	public SqlSessionFactory confSqlSessionFactory() {
		
		SqlSessionFactory sqlSessionFactory = null;
		
		try {
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			
			factoryBean.setDataSource(dataSource);
			
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			
			Resource[] resArr = resolver.getResources("classpath:/mapper/*/*.xml");
			
			factoryBean.setMapperLocations(resArr);
			
			sqlSessionFactory = factoryBean.getObject();
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
	
}
