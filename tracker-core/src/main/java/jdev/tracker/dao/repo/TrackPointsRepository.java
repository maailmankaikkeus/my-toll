package jdev.tracker.dao.repo;

import jdev.tracker.dao.TrackPoint;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by maailmankaikkeus on 08.02.2021.
 */

public interface TrackPointsRepository extends CrudRepository<TrackPoint, Integer> {
}
