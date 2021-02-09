package jdev.server.app;

import jdev.server.dao.TrackPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"jdev.server.controllers"})
@EnableJpaRepositories("jdev.server.dao")
@EntityScan(basePackageClasses = TrackPoint.class)
public class ServerMain {

    public static void main(String[] args) {
        SpringApplication.run(ServerMain.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
