package NC_Lab1;

import NC_Lab1.Model.Album;
import NC_Lab1.Model.Artist;
import NC_Lab1.Model.Genre;
import NC_Lab1.Model.Track;
import NC_Lab1.Util.IdentifierNotFoundException;

/**
 * Created by azaz on 26/10/15.
 */
public class starter {
    public static void main(String[] args) throws IdentifierNotFoundException {
        Genre g = new Genre("metall", "qweqwe");
        Artist artist = new Artist("ar1", "metall");
        Album album = new Album("album_1", 2012, "ar1");
        Track track = new Track(100500, "track_1", "album_1");

        System.out.println(track.getAlbum().getArtist().getGenre());


    }
}
