package com.mbdebian.codingtasks;

import com.mbdebian.codingtasks.models.AppModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessionServiceApplication {

	@Autowired
	private AppModel appModel;

	public static void main(String[] args) {
		SpringApplication.run(AccessionServiceApplication.class, args);
	}
}
