package NC_Lab1.Model;

import java.io.Serializable;

/**
 * Created by azaz on 26/10/15.
 */
public class Genre implements Serializable {
    long id_genre;
    String name;
    String description;

    public Genre(long id_genre, String name, String description) {
        this.id_genre = id_genre;
        this.name = name;
        this.description = description;
    }

    public long getId_genre() {

        return id_genre;
    }

    public void setId_genre(long id_genre) {
        this.id_genre = id_genre;
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
