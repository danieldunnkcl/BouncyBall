package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class BouncyBallFrame extends JPanel implements ActionListener, MouseListener{

    Timer timer;
    int posX, posY, velX,velY, radius,clicks = 0;

    ArrayList<Ball> balls = new ArrayList<>();

    public BouncyBallFrame(){

        timer = new Timer(5,this);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Ball b : balls){
            for(Ball b2 : balls){
                if(b != b2){
                    b.setCollision(b2);
                }
            }
            g.drawOval((int)b.getX(),(int)b.getY(),(int)b.getWidth(),(int)b.getHeight());
        }
        timer.start();
    }
    public int getWidth(){
        return super.getWidth();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for(Ball b : balls){
            b.move();
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncy Ball");

        frame.setSize(400,500);

        frame.setContentPane(new BouncyBallFrame());


        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        balls.add(new Ball(e.getX(),e.getY(),2,2,50,getWidth(),getHeight(),clicks));
        clicks++;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
