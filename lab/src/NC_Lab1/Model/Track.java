package NC_Lab1.Model;

import NC_Lab1.Util.AlbumNotFoundException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by azaz on 26/10/15.
 */
public class Track implements Serializable {
    private long id_track;
    private long length;
    private String name;
    private Long album_id;

    public Track(long length, String name, String albumName) throws AlbumNotFoundException {
        this.id_track = TrackStorage.getStorage().size();
        this.length = length;
        this.name = name;
        try {
            this.album_id = AlbumStorage.getByName(albumName).getId_alb();
        } catch (NullPointerException e) {
            throw new AlbumNotFoundException();
        }

        TrackStorage.getStorage().put(this.id_track, this);
    }

    public static Set<Track> getAll() {
        Set<Track> set = new HashSet<>();
        for (Map.Entry<Long, Track> longTrackEntry : TrackStorage.getStorage().entrySet()) {
            set.add(longTrackEntry.getValue());
        }
        return set;

    }

    @Override
    public String toString() {
        return "Track{" +
                "id_track=" + id_track +
                ", length=" + length +
                ", name='" + name + '\'' +
                ", album=" + AlbumStorage.getStorage().get(album_id) +
                '}';
    }

    public Album getAlbum() {
        return AlbumStorage.getById(album_id);
    }

    public void setAlbum(long id) {
        this.album_id = id;
    }

    public void setAlbum(String regexp) {
        this.album_id = AlbumStorage.getByName(regexp).getId_alb();
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

    public Long getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(Long album_id) {
        this.album_id = album_id;
    }
}
