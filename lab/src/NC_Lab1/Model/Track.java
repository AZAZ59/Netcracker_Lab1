package NC_Lab1.Model;

import java.io.Serializable;

/**
 * Created by azaz on 26/10/15.
 */
public class Track implements Serializable {
    long id_track;
    long length;
    String name;
    Album alb;

    public Track(long id_track, long length, String name, Album alb) {
        this.id_track = id_track;
        this.length = length;
        this.name = name;
        this.alb = alb;
    }

    public long getId_track() {

        return id_track;
    }

    public void setId_track(long id_track) {
        this.id_track = id_track;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlb() {
        return alb;
    }

    public void setAlb(Album alb) {
        this.alb = alb;
    }
}
