package PingPong;

import java.awt.*;
import java.util.*;
public class Ball {
    double xVel,yVel;
    int x,y;

    public Ball(){
        int xMin = 100,xMax=600,yMax=450,yMin=50;
        int vxMin = -5,vxMax=5,vyMax=0,vyMin=-5;
        int randx = (int) (Math.random()*(xMax-xMin+1)+xMin);
        int randy = (int) (Math.random()*(yMax-yMin+1)+yMin);
        x = randx;
        y = randy;
        int vrandx = (int) (Math.random()*(vxMax-vxMin+1)+vxMin);
        int vrandy = (int) (Math.random()*(vyMax-vyMin+1)+vyMin);
        if(vrandy==vrandx || vrandy==0 || vrandx==0){
            xVel = -5;
            yVel = 5;
        }else {
            xVel = 5;
            yVel = 5;
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x-10,y-10,20,20);
    }
    public void move(){
        x += xVel;
        y += yVel;
        if(y<35){
            yVel = -yVel;
        }
        if(y>485){
            yVel = -yVel;
        }

    }
    public void checkPaddleCollision(Paddle p1,Paddle p2){
        if(x<=30){
           if(y>=p1.getY() && y<=p1.getY()+80){
               xVel = -xVel;

              xVel ++;
              if(xVel>=5){
                  xVel =5;
              }
              else if(xVel<=-5){
                  xVel =-5;
              }
           }
        }
        else if(x>=670){
            if(y>=p2.getY() && y<=p2.getY()+80){
                xVel = -xVel;
                xVel --;
                if(xVel>=3){
                    xVel =3;
                }
                else if(xVel<=-3){
                    xVel =-3;
                }

            }

        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
