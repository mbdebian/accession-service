package com.mbdebian.codingtasks;

import com.mbdebian.codingtasks.models.AppModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.AbstractEnvironment;

import java.util.Arrays;

@SpringBootApplication
public class AccessionServiceApplication implements CommandLineRunner {

    @Autowired
    private AppModel appModel;

    @Override
    public void run(String... args) throws Exception {
        // Print result on the standard output
        System.out.println(
                String.join(",", appModel.sortAndAggregate(Arrays.asList(args[0].split(","))))
        );
    }

    public static void main(String[] args) {
        // If we have command line args, we run as command line application, if not, as web service
        if (args.length > 0) {
            new SpringApplicationBuilder(AccessionServiceApplication.class)
                    .web(false)
                    .run(args);
        } else {
            // Show the logging subsystem again when running as web service
            System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "web");
            SpringApplication.run(AccessionServiceApplication.class, args);
        }
    }
}
