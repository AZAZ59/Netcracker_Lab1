package NC_Lab1;

import NC_Lab1.Util.AlbumNotFoundException;
import NC_Lab1.Util.ArtistNotFoundException;
import NC_Lab1.Util.IdentifierNotFoundException;
import NC_Lab1.view.View;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by azaz on 26/10/15.
 */
public class starter {
    public static void main(String[] args) throws IdentifierNotFoundException, ArtistNotFoundException, AlbumNotFoundException {
        
        
        
        
        
        View viewshka = View.getInstance();
        viewshka.show_start();
        while(viewshka.show_dialog_start()!=0){
        }
        
        
//        Genre g = new Genre("metall", "qweqwe");
//        Artist artist = new Artist("ar1", "metall");
//        Album album = new Album("album_1", 2012, "ar1");
//        Track track = new Track(100500, "track_1", "album_1");
//        System.out.println(track.getAlbum().getArtist().getGenre());
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