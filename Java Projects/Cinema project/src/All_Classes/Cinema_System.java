package All_Classes;

import Gui_pages.Cinemas_Movies_page;

import java.util.ArrayList;

public class Cinema_System {
    private ArrayList<Cinemas> cinemas;
    private ArrayList<Movies> movies;
    private String name;

//__________________________________________________CONSTRUCTOR_________________________________________________________

    public Cinema_System(String name){
        cinemas = new ArrayList<>();
        movies = new ArrayList<>();
        this.name = name;
    }

//____________________________________________________METHODS___________________________________________________________

    public void addCinema(Cinemas c){
        cinemas.add(c);
    }

    public void addMovie(Movies m){
        movies.add(m);
    }

    public void start_program(){
        new Cinemas_Movies_page(movies,cinemas);
    }

}
