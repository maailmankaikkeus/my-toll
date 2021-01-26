package jdev.tracker;

import jdev.dto.PointDTO;
import jdev.tracker.services.GpsService;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GpsServiceTest {

    @Test
    public void sendPoint() throws Exception {
        PointDTO testPoint = new PointDTO("1", "2", "3", 4L);
        String testKmlFile = "src/test/resources/test.kml";
        GpsService gpsService = new GpsService(new KmlParser(testKmlFile));
        int count = 3;
        for (int i=0; i<count; i++)
            gpsService.sendPoint();
        ArrayList<PointDTO> testPointList = gpsService.getStoreService().takeAll();
        assertEquals(count, testPointList.size());
    }

}
