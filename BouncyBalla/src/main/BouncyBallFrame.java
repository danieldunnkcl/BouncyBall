package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BouncyBallFrame extends JPanel implements ActionListener {

    Timer timer;
    int posX, posY, velX,velY, radius;

    public BouncyBallFrame(){

        timer = new Timer(5,this);
        posX = 1;
        posY = 1;
        velY = 2;
        velX = 2;
        radius = 50;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillOval(posX,posY,radius,radius);
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        posX += velX;
        posY += velY;

        if(posX < 0 || posX > getWidth() - radius) velX = -velX;
        if(posY < 0 || posY > getHeight() - radius) velY = -velY;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncy Ball");

        frame.setSize(400,500);

        frame.setContentPane(new BouncyBallFrame());


        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
