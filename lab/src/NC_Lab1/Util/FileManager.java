package NC_Lab1.Util;

import NC_Lab1.Model.AlbumStorage;
import NC_Lab1.Model.ArtistStorage;
import NC_Lab1.Model.GenreStorage;
import NC_Lab1.Model.TrackStorage;

/**
 * Created by azaz on 28/10/15.
 */
public class FileManager {
    private static FileManager ourInstance = new FileManager();

    private FileManager() {
    }

    public static FileManager getInstance() {
        return ourInstance;
    }

    public static void loadFromFile(String filename) {
        GenreStorage.loadFromFile(filename + ".genre");
        ArtistStorage.loadFromFile(filename + ".artist");
        AlbumStorage.loadFromFile(filename + ".album");
        TrackStorage.loadFromFile(filename + ".track");
    }

    public static void saveToFile(String filename) {
        GenreStorage.storeToFile(filename + ".genre");
        ArtistStorage.storeToFile(filename + ".artist");
        AlbumStorage.storeToFile(filename + ".album");
        TrackStorage.storeToFile(filename + ".track");
    }
}
