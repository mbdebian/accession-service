package com.mbdebian.codingtasks;

import com.mbdebian.codingtasks.models.AppModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessionServiceApplication implements CommandLineRunner {

	@Autowired
	private AppModel appModel;

	@Override
	public void run(String... strings) throws Exception {
		// TODO
	}

	public static void main(String[] args) {
		SpringApplication.run(AccessionServiceApplication.class, args);
	}
}
