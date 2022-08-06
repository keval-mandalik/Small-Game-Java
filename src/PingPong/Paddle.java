package PingPong;

import java.awt.*;

public interface Paddle {
    public void draw(Graphics g,int player);
    public void move();
    public int getY();
}
