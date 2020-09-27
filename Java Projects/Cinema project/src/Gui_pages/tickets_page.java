package Gui_pages;

import All_Classes.Cinemas;
import All_Classes.Movies;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tickets_page implements ActionListener {
    private JFrame frame;
    private JLabel ticket,ticket_name,price,price_of_ticket,amount,total,total_price;
    private JButton plus,minus,nextPage;
    private JTextField num;
    private int numOfTickets = 0;
    private Movies selectedMovie;
    private Cinemas selectedCinema;

    public tickets_page(Movies m,Cinemas c) {
        selectedMovie = m;
        selectedCinema = c;

        frame = new JFrame();

// _____________________________________________________________________________________________________________________
        ticket = new JLabel("Tickets");
        ticket.setBounds(50,50, 100,30);
        frame.add(ticket);

        ticket_name = new JLabel(selectedCinema.getName());
        ticket_name.setBounds(50,90, 100,30);
        frame.add(ticket_name);

// _____________________________________________________________________________________________________________________
        price = new JLabel("Price");
        price.setBounds(320,50,100,30);
        frame.add(price);

        price_of_ticket = new JLabel(Float.toString(selectedMovie.getPrice()));
        price_of_ticket.setBounds(320,90, 100,30);
        frame.add(price_of_ticket);

// _____________________________________________________________________________________________________________________
        amount = new JLabel("amount");
        amount.setBounds(430,50, 100,30);
        frame.add(amount);

        minus = new JButton("-");
        minus.setBounds(425,100, 13,13);
        minus.addActionListener(this);
        minus.setBorder(null);
        frame.add(minus);

        num = new JTextField();
        num.setBounds(440,100, 20,15);
        num.setEditable(false);
        num.setText("0");
        frame.add(num);

        plus = new JButton("+");
        plus.setBounds(465,100, 13,13);
        plus.addActionListener(this);
        plus.setBorder(null);
        frame.add(plus);

// _____________________________________________________________________________________________________________________
        total = new JLabel("total");
        total.setBounds(580,50, 100,30);
        frame.add(total);

        total_price = new JLabel("0.00");
        total_price.setBounds(580,90, 100,30);
        frame.add(total_price);

// _____________________________________________________________________________________________________________________
        nextPage = new JButton("Continue");
        nextPage.setBounds(550,220, 80,25);
        nextPage.addActionListener(this);
        nextPage.setBorder(null);
        frame.add(nextPage);

// _____________________________________________________________________________________________________________________
        frame.setSize(650,300);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == plus)
            numOfTickets += 1;
        else if(e.getSource() == minus && numOfTickets > 0)
            numOfTickets -= 1;
        else if(e.getSource() == nextPage) {
            frame.setVisible(false);
            new seats_page(selectedCinema.getRows(), selectedCinema.getColumns(), numOfTickets);

        }
        num.setText(Integer.toString(numOfTickets));
        total_price.setText(Float.toString(selectedMovie.getPrice() * numOfTickets));
    }
}
