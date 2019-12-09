package io.pivotal.pal.tracker.pivotalarchana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PivotalArchanaApplication {


	public static void main(String[] args)
	{
		SpringApplication.run(PivotalArchanaApplication.class, args);
	}

	@Bean
	public InMemoryTimeEntryRepository getTimeEntryRepository(){
		return new InMemoryTimeEntryRepository();

	}

}
