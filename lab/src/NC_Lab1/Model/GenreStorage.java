package NC_Lab1.Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by azaz on 26/10/15.
 */
public class GenreStorage implements Serializable {
    private static GenreStorage ourInstance = SingletonHelper.instance;
    private HashMap<Long, Genre> storage;

    private GenreStorage() {
        storage = new HashMap<Long, Genre>();
    }

    public static GenreStorage getInstance() {
        return SingletonHelper.instance;
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
        return getInstance().storage;
    }

    public static void setStorage(HashMap<Long, Genre> storage) {
        getInstance().storage = storage;
    }

    protected Object readResolve() {
        GenreStorage.setStorage(this.storage);
        return ourInstance;
    }

    private static class SingletonHelper {
        private static final GenreStorage instance = new GenreStorage();
    }

}
