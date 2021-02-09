package jdev.tracker.app;

import jdev.tracker.dao.TrackPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"jdev.tracker", "jdev.tracker.services"})
@EnableJpaRepositories("jdev.tracker.dao")
@EntityScan(basePackageClasses = TrackPoint.class)
public class TrackerMain {

    public static void main(String[] args) {
        SpringApplication.run(TrackerMain.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}