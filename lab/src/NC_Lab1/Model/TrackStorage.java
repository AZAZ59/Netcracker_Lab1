package NC_Lab1.Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by azaz on 26/10/15.
 */
public class TrackStorage implements Serializable {
    private static TrackStorage ourInstance = SingletonHelper.instance;
    private HashMap<Long, Track> storage;

    private TrackStorage() {
        storage = new HashMap<>();
    }

    public static TrackStorage getInstance() {
        return SingletonHelper.instance;
    }

    /**
     * @param regexp regular expression to find in name of album
     * @return finded genre or null if regexp not found
     */
    public static Track getByName(String regexp) {
        Pattern pat = Pattern.compile(regexp);
        for (Map.Entry<Long, Track> stringGenreEntry : getStorage().entrySet()) {
            Matcher m = pat.matcher(stringGenreEntry.getValue().getName());
            if (m.find()) {
                return stringGenreEntry.getValue();
            }
        }
        return null;
    }

    /**
     * @param id id to find in id of album
     * @return finded genre or null if id not found
     */
    public static Track getById(long id) {
        return getStorage().get(id);
    }

    public static HashMap<Long, Track> getStorage() {
        return ourInstance.storage;
    }

    public static void setStorage(HashMap<Long, Track> storage) {
        getInstance().storage = storage;
    }

    protected Object readResolve() {
        TrackStorage.setStorage(this.storage);
        return getInstance();
    }

    private static class SingletonHelper {
        private static final TrackStorage instance = new TrackStorage();
    }
}
