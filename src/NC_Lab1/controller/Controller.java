package NC_Lab1.controller;

import NC_Lab1.Model.AlbumStorage;
import NC_Lab1.Model.ArtistStorage;
import NC_Lab1.Model.Genre;
import NC_Lab1.Model.GenreStorage;
import NC_Lab1.Model.Track;
import NC_Lab1.Model.TrackStorage;
import NC_Lab1.Util.AlbumNotFoundException;
import NC_Lab1.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Created by ovikeee on 01.11.2015
 */
public class Controller {

    private static Controller controller = new Controller();
    private static View view;

    private Controller() {
        view =  View.getInstance();
        if(view==null){
            System.out.println("NULL!!!");
        }
    }

    public static Controller getInstance() {
        return controller;
    }

    public void add(int i, String str) {
        switch (i) {
            case 1:
                StringTokenizer strTok = new StringTokenizer(str);
                TrackStorage.addTrack(strTok.nextToken(), strTok.nextToken(), strTok.nextToken(), Long.parseLong(strTok.nextToken()), strTok.nextToken());
                break;
            /*передача инфы в модель и возврат сообщения о завершении операции - ответ не реализован*/
            case 2: //Жанр
                GenreStorage.addGenre(str);
                break;
            case 3: /*треки из файла: сериализованный TrackStorage*/

                TrackStorage.loadFromFile(str);
                break;
            case 4: /*жанры из файла: сериализованный GenreStorage*/

                GenreStorage.loadFromFile(str);
                break;
        }
    }

    public void remove(int i, String str) {
        switch (i) {
            case 1:/*удалнеие трека по номеру*///не реализовано

                int num = Integer.parseInt(str);
                TrackStorage.removeTrackById(num);
                break;
            case 2:/*удалнеие трека по названию*///не реализовано

                TrackStorage.removeTrackByName(str);
                break;
            case 3:/*удалнеие жанра по названию*///не реализовано

                break;
            case 4:/*удалнеие всех tracks*///халтура

                if (str.equals("Y") || str.equals("y")) {
                    TrackStorage.removeAll();
                    break;
                } else {
                    view.message("Операция не выполнена!", false);
                }
                break;
            case 5:
                if (str.equals("Y") || str.equals("y")) {
                    GenreStorage.removeAll();
                    break;
                } else {
                    view.message("Операция не выполнена!", false);
                    /*опеация не выполнена*/
                }
        }
    }

    public void find_track(int i, String str) {
        switch (i) {
            case 1: /*поиск по номеру трека*/
                View.getInstance().query_results_track(TrackStorage.getById(i).toString());
                view.query_results_track(TrackStorage.getById(i).toString());
                break;
            case 2:/*поиск по названию трека*/
                View.getInstance().query_results_track(TrackStorage.getByName(str).toString());
               // view.query_results_track(TrackStorage.getByName(str).toString());
                break;
            case 3:/*поиск по исполнителям*/

                throw new UnsupportedOperationException("Пока не реализовали поиск по исполнителям");
            /*не реализовано*///ArtistStorage.getByName(str);

            case 4:/*поиск по альбомам*/

                throw new UnsupportedOperationException("Пока не реализовали поиск по альбомам");
            /*не реализовано*///AlbumStorage.getByName(str);
            case 5:/*поиск по жанрам*/

                throw new UnsupportedOperationException("Пока не реализовали поиск по жанрам");
            /*не реализовано*///GenreStorage.getByName(str);
            case 6: /*поиск всех треков*/
                ArrayList<String> strings = new ArrayList<>();
                Iterator<Track> itr = TrackStorage.getAllTracks().iterator();
                while (itr.hasNext()) {
                    strings.add(itr.next().toString());
                }
                View.getInstance().query_results_tracks(strings);
                //Почему тут ругается???view.query_results_tracks();
                break;
        }
    }

    public void find_album(int i, String str) {
        switch (i) {
            case 1: /*поиск по номеру*/

                view.message(AlbumStorage.getById(i).getName(), false);
            case 2:/*поиск по названию трека*/

                view.message(AlbumStorage.getByName(str).getName(), false);
        }

    }

    public void find_genre(int i, String str) {
        switch (i) {
            case 1: /*поиск по номеру*/

                View.getInstance().message(GenreStorage.getById(i).getName(), false);
                break;
            case 2:/*поиск по названию трека*/

                View.getInstance().message(GenreStorage.getByName(str).getName(), false);
                break;
            case 3: 
                ArrayList<String> strings = new ArrayList<>();
                Iterator<Genre> itr = GenreStorage.getAllGenre().iterator();
                while (itr.hasNext()) {
                    strings.add(itr.next().toString());
                }
                View.getInstance().query_results_genres(strings);
                //Почему тут ругается???view.query_results_tracks();
                break;
        }
    }

    public void save(int i, String str) {
        switch (i) {
            case 1:
                TrackStorage.storeToFile(str);
                break;
            case 2:
                GenreStorage.storeToFile(str);
                break;
        }
    }
}
//Ошибки, пока не обрабатываются.
