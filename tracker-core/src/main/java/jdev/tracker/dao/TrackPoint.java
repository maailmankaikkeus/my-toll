package jdev.tracker.dao;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

/**
 * Created by maailmankaikkeus on 08.02.2021.
 */
@Entity
@Table(name="trackpoints")
public class TrackPoint {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "LATITUDE")
    String latitude;

    @Column(name = "LONGITUDE")
    String longitude;

    @Column(name = "AUTO_ID")
    String autoId;

    @Column(name = "TIME_STAMP")
    Long timeStamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }


    public String toString() {
        return "Track point{ id=" + id
                + ", lat=" + latitude
                + ", lon=" + longitude
                + ", id=" + autoId
                + ", time=" + timeStamp + " }";
    }
}
