package NC_Lab1;

import NC_Lab1.Model.Genre;
import NC_Lab1.Model.GenreStorage;

/**
 * Created by azaz on 26/10/15.
 */
public class starter {
    public static void main(String[] args) {
        Genre g = new Genre("test_1", "qwe");
        Genre g1 = new Genre("metall", "qweqwe");

        GenreStorage.storeToFile("GS.lab");

        new Genre("test_122", "qwe");
        new Genre("metall222", "qweqwe");

        System.out.println(GenreStorage.getInstance().getStorage());
        System.out.println("=================");
        GenreStorage.loadFromFile("GS.lab");

        System.out.println(GenreStorage.getStorage());

        System.out.println(GenreStorage.getByName("metall"));

    }
}
