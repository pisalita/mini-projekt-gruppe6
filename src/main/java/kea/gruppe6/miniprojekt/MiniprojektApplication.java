package kea.gruppe6.miniprojekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MiniprojektApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MiniprojektApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MiniprojektApplication.class, args);
    }

}
