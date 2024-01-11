package br.com.company.CotacaoDolarApplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class CotacaoDolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CotacaoDolarApplication.class, args);
	}
	
}