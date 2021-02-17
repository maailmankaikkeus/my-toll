package jdev.server.dao.repo;

import jdev.server.dao.TrackPoint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by maailmankaikkeus on 08.02.2021.
 */

public interface TrackPointsRepository extends CrudRepository<TrackPoint, Integer> {

    @Query(
            value = "SELECT * FROM (SELECT * FROM trackpoints WHERE auto_id = ?2) ORDER BY id DESC LIMIT ?1",
            nativeQuery = true
    )
    Collection<TrackPoint> findLastVin(int num, String autoId);

}
