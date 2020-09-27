import All_Classes.Cinema_System;
import All_Classes.Cinemas;
import All_Classes.Movies;

public class main_class {
    public static void main(String[] args) {
        Cinema_System village = new Cinema_System("Village");

        village.addMovie(new Movies("Movie 1", 3.5f));
        village.addMovie(new Movies("Movie 2",4.75f));
        village.addMovie(new Movies("Movie 3",5));
        village.addMovie(new Movies("Movie 4",5.65f));
        village.addMovie(new Movies("Movie 5",6));

        village.addCinema(new Cinemas("Cinema 1",10,20));
        village.addCinema(new Cinemas("Cinema 2",12,20));
        village.addCinema(new Cinemas("Cinema 3",15,25));
        village.addCinema(new Cinemas("Cinema 4",20,30));
        village.addCinema(new Cinemas("Cinema 5",25,35));

        village.start_program();
    }
}
