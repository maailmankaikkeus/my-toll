package jdev.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import jdev.dto.TrackDTO;
import jdev.server.dao.TrackPoint;
import jdev.server.dao.repo.TrackPointsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TrackerController {

    private static final Logger log = LoggerFactory.getLogger(TrackerController.class);

    private Iterable<TrackPoint> all;

    @Autowired
    TrackPointsRepository trackPointsRepository;

    @PostMapping(value = "/upload")
    public TrackDTO receiveWrappedTrackingList(@RequestBody TrackDTO track)
            throws JsonProcessingException {

        for (PointDTO item : track.getTrack()) {
            TrackPoint trackPoint = create(item);
        }

        extractJsonPoints(track.getTrack()).forEach(log::info);
        return track;
    }

    @GetMapping(value = "/download")
    private TrackDTO getLastTrackPoints (@RequestParam(value = "last") String num) throws JsonProcessingException {
        long count = trackPointsRepository.count();
        List<Integer> idsList = new ArrayList<>();
        for (long i = count-Long.parseLong(num)+1; i<=count; i++)
            idsList.add((int)i);
        all = trackPointsRepository.findAll(idsList);
        log.info(all.toString());
        ArrayList<PointDTO> pointList = new ArrayList<PointDTO>() {{
            for (TrackPoint item : all)
                add(new PointDTO(
                        item.getLatitude(),
                        item.getLongitude(),
                        item.getAutoId(),
                        item.getTimeStamp()
                ));
        }};
        return new TrackDTO(pointList);
    }

    private List<String> extractJsonPoints(ArrayList<PointDTO> points) throws JsonProcessingException {
        List<String> pointList = new ArrayList<>();
        for (PointDTO p: points)
            pointList.add(p.toJson());
        return pointList;
    }

    private TrackPoint create(PointDTO point) {
        TrackPoint trackPoint = new TrackPoint();
        trackPoint.setLatitude(point.getLat());
        trackPoint.setLongitude(point.getLon());
        trackPoint.setAutoId(point.getAutoId());
        trackPoint.setTimeStamp(point.getTime());
        return trackPointsRepository.save(trackPoint);
    }
}
