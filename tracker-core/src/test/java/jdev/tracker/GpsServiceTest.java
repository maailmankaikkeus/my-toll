package jdev.tracker;

import jdev.dto.ITestConstants;
import jdev.dto.PointDTO;
import jdev.tracker.services.GpsService;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GpsServiceTest implements ITestConstants {

    @Test
    public void sendPoint() throws Exception {
        GpsService gpsService = new GpsService(new KmlParser(testKmlFile));
        int count = 3;
        for (int i=0; i<count; i++)
            gpsService.sendPoint();
        ArrayList<PointDTO> testPointList = gpsService.getStoreService().takeAll();
        assertEquals(count, testPointList.size());
    }

}
