package ru.sbrf.example.domain;

public class Track {

    private int trackId;
    private String trackName;
    private int duration;

    public Track(){}

    public Track(int trackID, String trackName, int duration) {
        this.trackId = trackID;
        this.trackName = trackName;
        this.duration = duration;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
