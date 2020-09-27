package Gui_pages;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class seats_page implements ActionListener {
    private final int numOfColumns,numOfRows;
    private int numOfTickets;
    private final JButton[][] seats;
    private final double space;

    public seats_page(int r, int c, int numb) {
        numOfTickets = numb;
        numOfColumns = c;
        numOfRows = r;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        seats = new JButton[numOfRows][numOfColumns];

        space = numOfColumns * 0.2;
        int xPoss = 40, yPoss = 70;

        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                if (j == space || j == space + numOfColumns * 0.6)
                    xPoss += 40;
                seats[i][j] = new JButton();
                seats[i][j].setBounds(xPoss, yPoss, 12, 12);
                seats[i][j].addActionListener(this);
                frame.add(seats[i][j]);
                xPoss += 15;
            }
            xPoss = 40;
            yPoss += 15;
        }

        frame.setSize(650, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void fillSeats(int x, int y){
        int temp = y;

        if(y <= space)                                                              // Left column
            if(space - y <= y) {
                while(temp != space && numOfTickets != 0){
                    seats[x][temp].setBackground(Color.red);
                    temp++;
                    numOfTickets--;
                }
                while(numOfTickets >= 0){
                    if(y < 0) {
                        x++;
                        y=temp-1;
                    }
                    seats[x][y].setBackground(Color.red);
                    numOfTickets--;
                    y--;
                }
            }
            else {
                while(temp >= 0 && numOfTickets != 0){
                    seats[x][temp].setBackground(Color.red);
                    temp--;
                    numOfTickets--;
                }
                while(numOfTickets >= 0){
                    if(y == space) {
                        x++;
                        y=temp+1;
                    }
                    seats[x][y].setBackground(Color.red);
                    numOfTickets--;
                    y++;
                }
            }
        else if(y < 4*space) {                                                      // Middle column
            if(4*space - y <= y) {
                while (temp > space - 1 && numOfTickets != 0) {
                    seats[x][temp].setBackground(Color.red);
                    numOfTickets--;
                    temp--;
                }
                temp = y + 1;
                while(temp < 4*space && numOfTickets > 0){
                    seats[x][temp].setBackground(Color.red);
                    numOfTickets--;
                    temp++;
                }
                temp = y;
                x++;
                while (temp > space - 1 && numOfTickets != 0) {
                    seats[x][temp].setBackground(Color.red);
                    numOfTickets--;
                    temp--;
                }
            }
            else{
                while (temp <= 4*space - 1 && numOfTickets != 0) {
                    seats[x][temp].setBackground(Color.red);
                    numOfTickets--;
                    temp++;
                }
                temp = y - 1;
                while (temp >= space && numOfTickets != 0) {
                    seats[x][temp].setBackground(Color.red);
                    numOfTickets--;
                    temp--;
                }
                temp = y;
                x++;
                while (temp <= 4*space && numOfTickets != 0) {
                    seats[x][temp].setBackground(Color.red);
                    numOfTickets--;
                    temp++;
                }
            }
        }
        else {                                                                      // Right column
            if(y - 4*space < numOfColumns - y) {
                while(temp >= 4*space && numOfTickets != 0){
                    seats[x][temp].setBackground(Color.red);
                    numOfTickets--;
                    temp--;
                }
                while(numOfTickets >= 0){
                    if(y > 5*space - 1) {
                        x++;
                        y = temp + 1;
                    }
                    seats[x][y].setBackground(Color.red);
                    numOfTickets--;
                    y++;
                }
            }
            else{
                while(temp <= 5*space - 1 && numOfTickets != 0){
                    seats[x][temp].setBackground(Color.red);
                    numOfTickets--;
                    temp++;
                }
                temp = y - 1 ;
                while(temp >= 4*space){
                    seats[x][temp].setBackground(Color.red);
                    numOfTickets--;
                    temp--;
                }
                y = temp + 1;
                x++;
                seats[x][y].setBackground(Color.red);
                System.out.println(numOfTickets);
                while(numOfTickets > 0){
                    if(y >= 5*space){
                        x++;
                        y = temp + 1;
                    }
                    seats[x][y].setBackground(Color.red);
                    numOfTickets--;
                    y++;
                }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i,j;
        for (i = 0; i < numOfRows; i++) {
            for (j = 0; j < numOfColumns; j++) {
                if (seats[i][j] == e.getSource()) {
                    if (seats[i][j].getBackground() != Color.RED)
                        fillSeats(i,j);
                    else
                        seats[i][j].setBackground(null);
                }
            }
        }
    }

}
