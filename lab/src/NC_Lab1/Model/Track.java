package NC_Lab1.Model;

import NC_Lab1.Util.Exception.AlbumNotFoundException;
import NC_Lab1.Util.IdGenerator;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by azaz on 26/10/15.
 */
public class Track implements Serializable {
    private long trackId;
    private long length;
    private String name;
    private long genreId;
    private Genre genre;

    public Track(long length, String name, Genre genre) throws AlbumNotFoundException {
        this.trackId = IdGenerator.getInstance().GetNextId();
        this.length = length;
        this.name = name;
        this.genre = genre;
        this.genreId = genre.getGenreId();
        genre.getTrackList().add(this.trackId);

        TrackStorage.getStorage().put(this.trackId, this);
    }

    public static Set<Track> getAll() {
        Set<Track> set = new HashSet<>();
        for (Map.Entry<Long, Track> longTrackEntry : TrackStorage.getStorage().entrySet()) {
            set.add(longTrackEntry.getValue());
        }
        return set;

    }

    public long getGenreId() {
        return genreId;
    }
    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public Genre getGenre() {
        return GenreStorage.getStorage().get(genreId);
    }

    public void setGenre(Genre genre) {
        this.genreId = genre.getGenreId();
    }


    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", length=" + length +
                ", name='" + name + '\'' +
                '}';
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
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
