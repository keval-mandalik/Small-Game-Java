package PingPong;


import java.awt.*;

public class HumanPaddle implements Paddle{
    double yVel;
    int x,y;
    Ball b;
    final double GRAVITY = 0.0;
    boolean upAccel,downAccel;
    HumanPaddle(int player){
        upAccel = false;
        downAccel = false;
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
        if(player == 1) {
                g.setColor(Color.red);
                g.fillRect(x, y, 20, 80);
        }
        if(player == 2) {
            g.setColor(Color.blue);
            g.fillRect(x, y, 20, 80);
        }
    }
    @Override
    public void move() {
        if(upAccel){
            yVel -= 4;
        }else if(downAccel){
            yVel += 4;
        }else if(!upAccel && !downAccel){
            yVel *= GRAVITY;
        }
        if(yVel>=5){
            yVel = 5;
        }
        else if(yVel<= -5){
            yVel = -5;
        }
        if(y<=30){
            y = 30;
        }
        else if(y>=420){
            y = 420;
        }
        y += yVel;
    }

    public void setUpAccel(boolean input){
        upAccel = input;
    }
    public void setDownAccel(boolean input){
        downAccel = input;
    }
    @Override
    public int getY() {
        return y;
    }
}
