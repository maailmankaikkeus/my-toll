package jdev.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.ITestConstants;
import jdev.dto.PointDTO;
import jdev.dto.TrackDTO;
import jdev.server.controllers.TrackerController;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TrackerControllerTest implements ITestConstants {

    @Test
    public void receiveWrappedTrackingListTest () throws JsonProcessingException {
        ArrayList<PointDTO> testPointList = new ArrayList<PointDTO>() {{ add(testPoint); add(testPoint); }};
        TrackDTO td = new TrackDTO(testPointList);
        TrackerController trackerController = new TrackerController();
        TrackDTO result = trackerController.receiveWrappedTrackingList(td);
        assertEquals(new TrackDTO(testPointList).toJson(), result.toJson());
    }

}
