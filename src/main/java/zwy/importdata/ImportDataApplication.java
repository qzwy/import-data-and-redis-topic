package zwy.importdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("zwy.importdata")
public class ImportDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImportDataApplication.class, args);
	}

}
