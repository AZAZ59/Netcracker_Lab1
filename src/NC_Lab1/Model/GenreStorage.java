package NC_Lab1.Model;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by azaz on 26/10/15. Updated by ovikeee on 04/11/15.
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
        Pattern pat = Pattern.compile(regexp);  //Шаблон содержит только имя
        for (Map.Entry<Long, Genre> stringGenreEntry : getStorage().entrySet()) { //Foreach для коллекции storage, где хранятся все жанры.  Интерфейс Map.Entry позволяет работать с элементом отображения.
            Matcher m = pat.matcher(stringGenreEntry.getValue().getName()); //Matcher - позволяет сравнивать по шаблону
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

    public static HashSet<Genre> getAllGenre() {
        HashSet<Genre> set = new HashSet<>();
        for (Map.Entry<Long, Genre> longTrackEntry : GenreStorage.getStorage().entrySet()) {
            set.add(longTrackEntry.getValue());
        }
        return set;
    }

    public static void setStorage(HashMap<Long, Genre> storage) {
        GenreStorage.storage = storage;
    }

    public static void addGenre(Genre newGenre) {
        storage.put(newGenre.getId_genre(), newGenre);
        System.out.println("ЖАНР ДОБАВЛЕН");
    }

    public static void addGenre(String nameGenre) {
        Genre genre = new Genre(nameGenre);
        System.out.println("ЖАНР ДОБАВЛЕН");
    }

    public static void removeGenreById(long idGenre) {
        storage.replace(idGenre, getById(idGenre));
    }

    public static void removeGenreByName(String genreName) {
        storage.replace(getByName(genreName).getId_genre(), getByName(genreName));
    }

    //Халтурное удаление
    public static void removeAll() {
        storage = new HashMap<>();
    }

}
