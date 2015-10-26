package NC_Lab1.Model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by azaz on 26/10/15.
 */
public class GenreStorage implements Serializable {
    private static GenreStorage ourInstance = new GenreStorage();
    private static HashMap<Long, Genre> storage;

    private GenreStorage() {
        setStorage(new HashMap<Long, Genre>());
    }

    public static GenreStorage getInstance() {
        return ourInstance;
    }

    /**
     * @param filename file to load
     */
    public static void storeToFile(String filename) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(filename)));
            oos.writeObject(getStorage());
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param filename file to store
     */
    public static void loadFromFile(String filename) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filename)));
            ourInstance = new GenreStorage();
            setStorage((HashMap<Long, Genre>) ois.readObject());
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param regexp regular expression to find in name of genre
     * @return finded genre or null if regexp not found
     */
    public static Genre getByName(String regexp) {
        Pattern pat = Pattern.compile(regexp);
        for (Map.Entry<Long, Genre> stringGenreEntry : getStorage().entrySet()) {
            Matcher m = pat.matcher(stringGenreEntry.getValue().getName());
            if (m.find()) {
                return stringGenreEntry.getValue();
            }
        }
        return null;
    }

    /**
     * @param id id to find in id of genre
     * @return finded genre or null if id not found
     */
    public static Genre getById(long id) {
        return getStorage().get(id);
    }


    public static HashMap<Long, Genre> getStorage() {
        return storage;
    }

    public static void setStorage(HashMap<Long, Genre> storage) {
        GenreStorage.storage = storage;
    }
}
