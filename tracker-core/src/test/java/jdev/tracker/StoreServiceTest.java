package jdev.tracker;

import jdev.dto.PointDTO;
import jdev.tracker.services.StoreService;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class StoreServiceTest {

    @Test
    public void putAndTakeAll () throws InterruptedException {
        PointDTO testPoint      = new PointDTO("1", "2", "3", 4L);
        PointDTO testPointFalse = new PointDTO("1", "2", "3", 5L);

        StoreService storeService = new StoreService();
        storeService.put(testPoint);
        storeService.put(testPoint);
        ArrayList<PointDTO> testPointList = storeService.takeAll();

        assertEquals(2, testPointList.size());
        assertEquals(testPoint, testPointList.get(0));
        assertEquals(testPoint, testPointList.get(1));
//        assertEquals(testPointFalse, testPointList.get(1));   // not passed
    }
}
