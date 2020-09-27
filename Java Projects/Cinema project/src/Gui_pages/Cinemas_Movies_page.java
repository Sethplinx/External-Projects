package Gui_pages;

import All_Classes.Cinemas;
import All_Classes.Movies;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Cinemas_Movies_page implements ActionListener {
    private JFrame frame;
    private JTextField lMovie;
    private JButton next;
    private JButton [] bCinemas;
    private DefaultListModel<String> l1;
    private JList<String> list;
    private ArrayList<Movies> movies;
    private ArrayList<Cinemas> cinemas;
    private String movie,cinema;
    private Movies selectedMovie;
    private Cinemas selectedCinema;

//__________________________________________________CONSTRUCTOR_________________________________________________________

    public Cinemas_Movies_page(ArrayList<Movies> movies, ArrayList<Cinemas> cinemas) {
        this.cinemas = cinemas;
        this.movies = movies;

        frame = new JFrame();

        frame.getContentPane().setBackground(Color.GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);

    //__________________________________________________________________________________________________________________
        lMovie = new JTextField("Choose a movie");
        lMovie.setBounds(50,50,150,30);
        lMovie.setEditable(false);
        frame.add(lMovie);

    //__________________________________________________________________________________________________________________
        l1 = new DefaultListModel<>();
        for(int i=0; i < movies.size(); i++)
            l1.addElement(movies.get(i).getMovieName());
        list = new JList<>(l1);
        list.setBounds(50,90, 150,190);
        frame.add(list);

    //__________________________________________________________________________________________________________________
        bCinemas = new JButton[cinemas.size()];
        for(int i=0,xPoss=220,yPoss=50; i < cinemas.size(); i++,xPoss += 130){
            bCinemas[i] = new JButton();
            bCinemas[i].setBounds(xPoss,yPoss,120,120);
            bCinemas[i].setBackground(Color.WHITE);
            bCinemas[i].setText(cinemas.get(i).getName());
            bCinemas[i].addActionListener(this);
            bCinemas[i].setBorder(null);
            frame.add(bCinemas[i]);
        }

    //__________________________________________________________________________________________________________________
        next = new JButton("Continue");
        next.setBounds(750,500, 100,30);
        next.addActionListener(this);
        next.setBorder(null);
        frame.add(next);

    //__________________________________________________________________________________________________________________
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public Movies findMovie(String s){
        for(int i=0; i < movies.size(); i++){
            if(movies.get(i).getMovieName().equals(s))
                return movies.get(i);
        }
        return null;
    }

    public Cinemas findCinema(String s){
        for(int i=0; i < cinemas.size(); i++){
            if(cinemas.get(i).getName().equals(s))
                return cinemas.get(i);
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next) {
            movie = list.getSelectedValue();
            selectedMovie = findMovie(movie);
            next.setToolTipText("Please select a movie and a cinema to continue");
            if(selectedCinema == null && selectedMovie == null || selectedCinema == null || selectedMovie == null )
                System.out.println("here");
            else {
                frame.setVisible(false);
                new tickets_page(selectedMovie,selectedCinema);
            }
        }
        else
            for(int i=0; i < cinemas.size(); i++){
                if(e.getSource() == bCinemas[i]) {
                    cinema = bCinemas[i].getText();
                    selectedCinema = findCinema(cinema);
                }
            }
    }

}
