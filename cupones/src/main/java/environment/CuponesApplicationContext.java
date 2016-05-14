package environment;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.javalego.data.jpa.HibernateApplicationContext;

@Configuration
@PropertySource("classpath:application.properties")
public class CuponesApplicationContext extends HibernateApplicationContext {

	public CuponesApplicationContext() {
	}
}
