package main;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball extends Ellipse2D {

    int x,y,xVelocity,yVelocity,radius,panelWidth,panelHeight;

    public Ball(int x,int y,int xVelocity,int yVelocity,int radius, int panelWidth, int panelHeight){
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.radius = radius;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
    }

    public void move(){
        x += xVelocity;
        y += yVelocity;

        if(x < 0 || x > panelWidth - radius) xVelocity = -xVelocity;
        if(y < 0 || y > panelHeight - radius) yVelocity = -yVelocity;

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
}
