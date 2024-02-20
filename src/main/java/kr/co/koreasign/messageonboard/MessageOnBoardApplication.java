package kr.co.koreasign.messageonboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MessageOnBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageOnBoardApplication.class, args);
	}

}
