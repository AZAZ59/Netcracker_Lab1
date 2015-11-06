package NC_Lab1.Util;

import NC_Lab1.Model.GenreStorage;
import NC_Lab1.Model.TrackStorage;

import java.io.*;

/**
 * Created by azaz on 28/10/15.
 */
public class FileManager implements Serializable {
    private static FileManager ourInstance = new FileManager();
    private GenreStorage genreStorage;
    private TrackStorage trackStorage;
    private FileManager() {
        genreStorage = GenreStorage.getInstance();
        trackStorage = TrackStorage.getInstance();
    }

    public static FileManager getInstance() {
        return ourInstance;
    }

    public static void loadFromFile(String filename) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filename)));
            ourInstance = (FileManager) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveToFile(String filename) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File(filename)));
            oos.writeObject(ourInstance);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected Object readResolve() {
        return getInstance();
    }

}
