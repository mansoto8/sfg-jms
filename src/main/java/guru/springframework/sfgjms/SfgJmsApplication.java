package guru.springframework.sfgjms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SfgJmsApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SfgJmsApplication.class, args);
	}

}
