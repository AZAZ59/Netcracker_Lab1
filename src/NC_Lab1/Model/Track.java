package NC_Lab1.Model;

import NC_Lab1.Util.AlbumNotFoundException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by azaz on 26/10/15.
 * Updated by ovikeee on 04/11/15.
 */
public class Track implements Serializable {

    private long id_track;
    private long length;
    private String name;
    private String album_name;
    private String artist;
    private String genre;

    public Track(String name, String artist, String albumName,long length, String genre) {
        this.id_track = TrackStorage.getStorage().size();
        this.length = length;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.album_name =albumName;
        TrackStorage.getStorage().put(this.id_track, this);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" \t").append(artist).append(" \t").append(album_name).append(" \t").append(length).append(" \t").append(genre);
        return sb.toString();
    }

    public Album getAlbum() {
        return AlbumStorage.getByName(album_name);
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



}
