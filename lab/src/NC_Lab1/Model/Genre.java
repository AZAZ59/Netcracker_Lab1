package NC_Lab1.Model;

import NC_Lab1.Util.IdGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by azaz on 26/10/15.
 */
public class Genre implements Serializable {
    private long genreId;
    private String name;
    private String description;
    private ArrayList<Long> trackList;

    public Genre(String name, String description) {
        this.genreId = IdGenerator.getInstance().GetNextId();
        this.name = name;
        this.description = description;
        this.trackList = new ArrayList<>();
        GenreStorage.getStorage().put(this.genreId, this);
    }

    public static Set<Genre> getAll() {
        Set<Genre> set = new HashSet<>();
        for (Map.Entry<Long, Genre> longGenreEntry : GenreStorage.getStorage().entrySet()) {
            set.add(longGenreEntry.getValue());
        }
        return set;

    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                "}";
    }

    public long getGenreId() {

        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
