package main;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball extends Ellipse2D {

    int x,y,xVelocity,yVelocity,radius,panelWidth,panelHeight,id;
    boolean collision = false;

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
        x += xVelocity;
        y += yVelocity;

        if(x < 0 || x > panelWidth - radius) xVelocity = -xVelocity;
        if(y < 0 || y > panelHeight - radius) yVelocity = -yVelocity;
        if(collision){
            yVelocity = -yVelocity;
            xVelocity = -xVelocity;
        }

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

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,radius,radius);
    }

    public void setCollision(Ball otherBall){
        collision = this.getBounds().intersects(otherBall.getBounds());
    }

    public boolean equals(Ball rhs){
        return this.id == rhs.id;
    }
}
