package PingPong;

import java.awt.*;
import java.util.*;
public class AIPaddle implements Paddle{
    double yVel;
    int x,y;
    Ball b;
    Random random = new Random();
    final double GRAVITY = 0.0;
    boolean upAccel,downAccel;
    AIPaddle(int player,Ball b1){
        upAccel = false;
        downAccel = false;
        b = b1;
        y = 210;
        yVel = 0;
        if(player == 1){
            x = 0;
        }
        else if(player == 2){
            x = 680;
        }
    }

    @Override
    public void draw(Graphics g,int player) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,20,80);
    }
    @Override
    public void move() {
        y = b.getY() - 40;
        if(y<=30){
            y = 30;
        }
        else if(y>=420){
            y = 420;
        }
    }

    @Override
    public int getY() {
        return y;
    }
}
