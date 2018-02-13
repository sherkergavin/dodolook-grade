package dodo.look.grade;

import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
/**
 * 
* @ClassName: DodolookGradeApplication 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GWJ
* @date 2018年1月30日 下午3:08:36 
*
 */


@SpringBootApplication
public class DodolookGradeApplication {


	@Bean
	public HttpMessageConverters confHttpMessageConverters(){
		
		StringHttpMessageConverter stringConverter = new  StringHttpMessageConverter(Charset.forName("UTF-8"));
		
		FastJsonHttpMessageConverter jsonConverter = new FastJsonHttpMessageConverter(); 
		
		FastJsonConfig jsonConf = new FastJsonConfig();
		jsonConf.setSerializerFeatures(SerializerFeature.PrettyFormat);
		jsonConverter.setFastJsonConfig(jsonConf);

		return new HttpMessageConverters(stringConverter,jsonConverter);			
	}
	
	@Bean
	public Md5PasswordEncoder getMd5PasswordEncoder() {
		
		return new Md5PasswordEncoder();
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(DodolookGradeApplication.class, args);
	}
}
