package NC_Lab1.Model;

import NC_Lab1.Util.GenreNotFoundException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by azaz on 26/10/15.
 */
public class Artist implements Serializable {
    private long id_artist;
    private String name;
    private long genre_id;

    public Artist(String name, String genreName) throws GenreNotFoundException {
        this.id_artist = ArtistStorage.getStorage().size();
        this.name = name;

        try {
            this.genre_id = GenreStorage.getByName(genreName).getId_genre();
        } catch (NullPointerException e) {
            throw new GenreNotFoundException();
        }

        ArtistStorage.getStorage().put(this.id_artist, this);
    }

    public static Set<Artist> getAll() {
        Set<Artist> set = new HashSet<>();
        for (Map.Entry<Long, Artist> longArtistEntry : ArtistStorage.getStorage().entrySet()) {
            set.add(longArtistEntry.getValue());
        }
        return set;

    }
    
    public Genre getGenre() {
        return GenreStorage.getById(genre_id);
    }

    public void setGenre(long id) {
        this.genre_id = id;
    }

    public void setGenre(String regexp) {
        this.genre_id = GenreStorage.getByName(regexp).getId_genre();
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id_artist=" + id_artist +
                ", name='" + name + '\'' +
                ", " + GenreStorage.getById(genre_id) +
                '}';
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

    public long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(long genre_id) {
        this.genre_id = genre_id;
    }


}
