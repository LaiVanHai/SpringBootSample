package jp.co.netprotections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @Configurationと@EnableAutoConfigurationと@ComponentScan一緒意味 
public class SpringBootSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, args);
		// Springコンテナーを作成する
	}

}
