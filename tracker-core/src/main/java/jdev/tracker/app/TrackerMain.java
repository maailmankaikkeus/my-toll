package jdev.tracker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//public class TrackerMain {
//
//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(TrackerContext.class);
//    }
//
//}

@SpringBootApplication
@ComponentScan({"jdev/tracker", "jdev/tracker/services"})
public class TrackerMain {

    public static void main(String[] args) {
        SpringApplication.run(TrackerMain.class, args);
    }

}