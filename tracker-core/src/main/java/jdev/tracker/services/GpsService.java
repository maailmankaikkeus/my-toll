package jdev.tracker.services;

import jdev.dto.PointDTO;
import jdev.tracker.KmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class GpsService {

    private KmlParser       kmlParser;
    private StoreService    storeService;

    public GpsService(@Autowired KmlParser kmlParser) {
        this.kmlParser      = kmlParser;
        this.storeService   = new StoreService();
    }

    public GpsService(@Autowired KmlParser kmlParser,
                      @Autowired StoreService storeService) {
        this.kmlParser      = kmlParser;
        this.storeService   = storeService;
    }

    @Scheduled(fixedRateString = "${gettingPeriod.prop}")
    public void sendPoint() throws Exception {
        PointDTO nextPoint = kmlParser.getNext();
        if (nextPoint != null)
            storeService.put(nextPoint);
    }

    public StoreService getStoreService() {
        return storeService;
    }
}
