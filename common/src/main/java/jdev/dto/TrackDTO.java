package jdev.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Objects;

public class TrackDTO {

    private ArrayList<PointDTO> track;

    public ArrayList<PointDTO> getTrack() {
        return track;
    }
    public void setTrack(ArrayList<PointDTO> track) {
        this.track = track;
    }

    public TrackDTO(ArrayList<PointDTO> track) {
        this.track = track;
    }

    public TrackDTO() {}

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackDTO trackDTO = (TrackDTO) o;
        return Objects.equals(track, trackDTO.track);
    }

    @Override
    public int hashCode() {
        return Objects.hash(track);
    }
}
