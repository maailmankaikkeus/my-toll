package jdev.tracker;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import jdev.dto.TrackDTO;
import jdev.tracker.services.DispatchService;
import jdev.tracker.services.StoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DispatchServiceTest {

    private static final String uri = "http://localhost:8080/upload";

    @Mock
    RestTemplate restTemplate;

    @Mock
    StoreService storeService;

    @InjectMocks
    DispatchService mockedDispatchService;

    @Test
    public void post() throws JsonProcessingException {
        PointDTO testPoint = new PointDTO("1", "2", "3", 4L);
        ArrayList<PointDTO> testPointList = new ArrayList<PointDTO>() {{ add(testPoint); add(testPoint); }};
        TrackDTO td = new TrackDTO(testPointList);
        when(restTemplate.postForObject(eq(uri), anyObject(), anyObject()))
                .thenReturn(td);
        TrackDTO result = mockedDispatchService.post(testPointList);
        assertNotNull(result);
    }

}
