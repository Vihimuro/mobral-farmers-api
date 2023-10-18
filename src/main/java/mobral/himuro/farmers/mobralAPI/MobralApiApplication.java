package mobral.himuro.farmers.mobralAPI;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MobralApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobralApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public JtsModule jtsModule() {
		return new JtsModule();
	}
}
