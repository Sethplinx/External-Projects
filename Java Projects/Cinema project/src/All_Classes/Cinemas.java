package All_Classes;

public class Cinemas {
    private int rows,columns;
    private String name;

//__________________________________________________CONSTRUCTOR_________________________________________________________

    public Cinemas(String name,int rows, int columns){
        this.columns = columns;
        this.rows = rows;
        this.name = name;
    }

//____________________________________________________GETTERS___________________________________________________________

    public String getName() {
        return name;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }


}
