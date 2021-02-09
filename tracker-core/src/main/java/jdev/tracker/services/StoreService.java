package jdev.tracker.services;

import jdev.dto.PointDTO;
import jdev.tracker.dao.TrackPoint;
import jdev.tracker.dao.repo.TrackPointsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StoreService {

    private static final Logger log = LoggerFactory.getLogger(StoreService.class);

    private List<TrackPoint> all;

    @Autowired
    TrackPointsRepository trackPointsRepository;

    public void put(PointDTO point) throws InterruptedException {
        TrackPoint trackPoint = create(point);
    }

    public ArrayList<PointDTO> takeAll() {
        read();
        delete();
        return convert(all);
    }

    private TrackPoint create(PointDTO point) {
        TrackPoint trackPoint = new TrackPoint();
        trackPoint.setLatitude(point.getLat());
        trackPoint.setLongitude(point.getLon());
        trackPoint.setAutoId(point.getAutoId());
        trackPoint.setTimeStamp(point.getTime());
        return trackPointsRepository.save(trackPoint);
    }

    private void read() {
        all = (List<TrackPoint>) trackPointsRepository.findAll();

        if (all.size() == 0) {
            log.info("NO RECORDS");
        } else {
            all.forEach(tp -> log.info(tp.toString()));
        }
    }

    private void delete() {
        if (all.size() != 0) {
            trackPointsRepository.delete(all);
        }
    }

    private ArrayList<PointDTO> convert(List<TrackPoint> data) {
        ArrayList<PointDTO> dtoList = new ArrayList<>();
        for (TrackPoint item : data) {
            dtoList.add(new PointDTO(
                    item.getLatitude(),
                    item.getLongitude(),
                    item.getAutoId(),
                    item.getTimeStamp()));
        }
        return dtoList;
    }
}
