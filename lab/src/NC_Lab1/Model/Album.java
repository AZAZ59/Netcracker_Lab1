package NC_Lab1.Model;

import java.io.Serializable;

/**
 * Created by azaz on 26/10/15.
 */
public class Album implements Serializable {
    long id_alb;
    String name;
    int year;
    Artist artist;

    public Album(long id_alb, String name, int year, Artist artist) {
        this.id_alb = id_alb;
        this.name = name;
        this.year = year;
        this.artist = artist;
    }

    public long getId_alb() {
        return id_alb;
    }

    public void setId_alb(long id_alb) {
        this.id_alb = id_alb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
