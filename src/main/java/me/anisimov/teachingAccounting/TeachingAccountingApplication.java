package me.anisimov.teachingAccounting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import me.anisimov.teachingAccounting.util.DataBaseInitializer;


@SpringBootApplication
public class TeachingAccountingApplication implements CommandLineRunner {

	@Autowired
	private DataBaseInitializer dataBaseInitializer;
	public static void main(String[] args) {
		SpringApplication.run(TeachingAccountingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		dataBaseInitializer.init();

	}

}
