package io.pivotal.pal.tracker.pivotalarchana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PivotalArchanaApplication {


	public static void main(String[] args)
	{
		SpringApplication.run(PivotalArchanaApplication.class, args);
	}

	@Bean
	public JdbcTimeEntryRepository getTimeEntryRepository(DataSource dataSource){
		return new JdbcTimeEntryRepository(dataSource);

	}

}
