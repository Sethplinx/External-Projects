package All_Classes;

public class Movies {
    private String movieName;
    private float price;

//__________________________________________________CONSTRUCTOR_________________________________________________________

    public Movies(String name,float price){
        movieName = name;
        this.price = price;
    }

//____________________________________________________GETTERS___________________________________________________________

    public String getMovieName() {
        return movieName;
    }

    public float getPrice() {
        return price;
    }

}
