package NC_Lab1.Model;

import NC_Lab1.Util.ArtistNotFoundException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by azaz on 26/10/15.
 */
public class Album implements Serializable {
    private long id_alb;
    private String name;
    private int year;
    private Long artist_id;

    public Album(String name, int year, String artistName) throws ArtistNotFoundException {
        this.id_alb = ArtistStorage.getStorage().size();
        this.name = name;
        this.year = year;
        //this.artist_id = artist_id;
        try {
            this.artist_id = ArtistStorage.getByName(artistName).getId_artist();
        } catch (NullPointerException e) {
            throw new ArtistNotFoundException();
        }

        AlbumStorage.getStorage().put(this.id_alb, this);
    }

    public static Set<Album> getAll() {
        Set<Album> set = new HashSet<>();
        for (Map.Entry<Long, Album> longAlbumEntry : AlbumStorage.getStorage().entrySet()) {
            set.add(longAlbumEntry.getValue());
        }
        return set;

    }

    @Override
    public String toString() {
        return "Album{" +
                "id_alb=" + id_alb +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", artist=" + ArtistStorage.getStorage().get(artist_id) +
                '}';
    }

    public Artist getArtist() {
        return ArtistStorage.getById(artist_id);
    }

    public void setArtist(long id) {
        this.artist_id = id;
    }

    public void setArtist(String regexp) {
        this.artist_id = ArtistStorage.getByName(regexp).getId_artist();
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

    public Long getArtistId() {
        return artist_id;
    }

    public void setArtistId(Long artist) {
        this.artist_id = artist;
    }
}
