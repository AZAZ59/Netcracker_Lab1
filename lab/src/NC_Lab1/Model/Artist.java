package NC_Lab1.Model;

import java.io.Serializable;

/**
 * Created by azaz on 26/10/15.
 */
public class Artist implements Serializable {
    long id_artist;
    String name;
    Genre genre;

    public Artist(long id_artist, String name, Genre genre) {
        this.id_artist = id_artist;
        this.name = name;
        this.genre = genre;
    }

    public long getId_artist() {

        return id_artist;
    }

    public void setId_artist(long id_artist) {
        this.id_artist = id_artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
