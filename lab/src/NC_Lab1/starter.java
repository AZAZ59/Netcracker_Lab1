package NC_Lab1;

import NC_Lab1.Model.Genre;
import NC_Lab1.Model.GenreStorage;
import NC_Lab1.Model.Track;
import NC_Lab1.Util.Exception.IdentifierNotFoundException;
import NC_Lab1.Util.FileManager;

/**
 * Created by azaz on 26/10/15.
 */
public class starter {
    public static void main(String[] args) throws IdentifierNotFoundException {

/*
        View viewshka = View.getInstance();
        viewshka.show_start();
        while (viewshka.show_dialog_start() != 0) {
        }
*/

            Genre g = new Genre("metall", "qweqwe");
            Track track = new Track(100500, "track_1", g);
            new Track(100500, "track_1", g);
            FileManager.saveToFile("123.file");

            System.out.println(GenreStorage.getStorage());
            new Genre("metall111", "qweqwe111");
            new Track(100500, "track_1", g);
            new Track(100500, "track_1", g);
            new Track(100500, "track_1", g);
            System.out.println(GenreStorage.getStorage());

            FileManager.loadFromFile("123.file");
            System.out.println(GenreStorage.getStorage());


    }
}
//1)Будет ли достаточно искать треки только по Id и названию? Или нужно по исполнителям, по альбомам, по продолжительности, по жанру и.тд
//2)Нужно ли делать возможность отдельно добавлять исполнителей и альбомы?
// Если 2)-да, то какая информация кроме названия должна быть у исполнителя, альбома?
//3)Нужно ли искать отдельно альбомы, исполнителей?
//4)Халтурное "удаление" (сами треки не удаляются, просто в TrackStorage поле sorage пересоздается)
//5)Нужно было использовать Observer?

//Нужно снабдить весь код исключениями
//1)Сделать гуишку
//2)Сделать норальный поиск(по жанрам хотяб) Cjplfnm rkfcc Search и там обрабатывать шаблончики.
//3)Сделать многопоточным
//4)Убрать лишние классы Album, Artist
//5)Запилить нормальное сохранение (корректную сериализацию и десериализацию)
//6)Создать генератор Id для треков и жанров
//7)Связать треки и жанры
//8)
