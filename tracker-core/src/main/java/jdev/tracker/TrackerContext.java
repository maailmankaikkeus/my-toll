package jdev.tracker;

import jdev.tracker.services.DispatchService;
import jdev.tracker.services.GpsService;
import jdev.tracker.services.StoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;


@Configuration
@EnableScheduling
@PropertySource("classpath:/tracker-core.properties")
public class TrackerContext {

    private final String kmlFileName = "tracker-core/src/main/resources/20150731_Peschanaya.kml";

    @Bean
    public GpsService gpsService() {
        return new GpsService(new KmlParser(kmlFileName), storeService());
    }

    @Bean
    public DispatchService dispatchService() {
        return new DispatchService(storeService(), new RestTemplate());
    }

    @Bean
    public StoreService storeService() {
        return new StoreService();
    }

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("trackerPoolScheduler");
        scheduler.setPoolSize(20);
        return scheduler;
    }

}
