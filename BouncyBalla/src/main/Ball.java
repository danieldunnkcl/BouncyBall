package main;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball extends Rectangle {

    int x,y,xVelocity,yVelocity,radius,panelWidth,panelHeight,id;
    boolean xCollision = false,yCollision = false;

    public Ball(int x,int y,int xVelocity,int yVelocity,int radius, int panelWidth, int panelHeight,int id){
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.radius = radius;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.id = id;
    }

    public void move(){

        if(x < 0 || x > panelWidth - radius) xVelocity = -xVelocity;
        if(y < 0 || y > panelHeight - radius) yVelocity = -yVelocity;
        if(xCollision) xVelocity = -xVelocity;
        if(yCollision) yVelocity = -yVelocity;

        x += xVelocity;
        y += yVelocity;



        xCollision = false;
        yCollision = false;


    }


    public int getxVelocity() {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return radius;
    }

    @Override
    public double getHeight() {
        return radius;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setFrame(double x, double y, double w, double h) {

    }


    public Rectangle getBounds(){
        return new Rectangle(x,y,radius,radius);
    }

    public void detectCollision(Ball otherBall)
    {

        boolean intersection = this.getBounds().intersects(otherBall.getBounds());
        if(intersection){
            if(this.xVelocity * otherBall.xVelocity < 0){
                xCollision = true;
            }
            if(this.yVelocity * otherBall.yVelocity < 0){
                yCollision = true;
            }
        }
    }

    public boolean equals(Ball rhs){
        return this.id == rhs.id;
    }
}
