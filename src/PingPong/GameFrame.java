package PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements Runnable, KeyListener {
    final int WIDTH = 700,HEIGHT = 500;
    Thread thread;
    HumanPaddle p1 = new HumanPaddle(1);
    //HumanPaddle p2 = new HumanPaddle(2);
    Ball b = new Ball();
   AIPaddle p2 = new AIPaddle(2,b);
    boolean gameStarted = false;
    ImageIcon logo = new ImageIcon("C:\\Users\\Vipul\\Pictures\\download\\pong logo.png");
   public  GameFrame(){
        thread = new Thread(this);
        thread.start();

        this.addKeyListener(this);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Pong Game");
        this.setIconImage(logo.getImage());
        this.setSize(WIDTH,HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    public void paint(Graphics g){
        if(!gameStarted){
            g.setColor(Color.BLACK);
            g.fillRect(0,0,WIDTH,HEIGHT);
            g.setFont(new Font("Simple", Font.BOLD, 50));
            g.setColor(Color.YELLOW);
            g.drawString("Press enter to start", 110, 250);
        }else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            if (b.getX() <= -10 || b.getX() >= 710) {
               /* b.yVel = 0;
                b.xVel = 0;

                g.setColor(Color.BLACK);
                g.fillRect(0, 0, WIDTH, HEIGHT);
                g.setFont(new Font("Ink Free", Font.ITALIC, 50));
                g.setColor(Color.red);
                g.drawString("Game Over", 250, 250);*/
                //GameOver(g);
            this.dispose();
            if(b.getX()<=-10) {
                JOptionPane.showMessageDialog(null, "The Winner is Blue", "Result", JOptionPane.OK_CANCEL_OPTION,logo);
            }
            if(b.getX()>=710) {
                JOptionPane.showMessageDialog(null, "The Winner is Red", "Result", JOptionPane.OK_CANCEL_OPTION,logo);
            }
            }
            g.setColor(Color.YELLOW);
            g.drawLine(350, 0, 350, 500);
            p1.draw(g, 1);
            p2.draw(g, 2);
            b.draw(g);
        }
    }
    public void GameOver(Graphics g) {
        g.setFont(new Font("Consolas", Font.BOLD, 40));
        g.setColor(Color.red);
        g.drawString("Game Over", 250, 250);
        g.setFont(new Font("Consolas", Font.PLAIN, 30));
    }
    public void update(Graphics g){
        paint(g);
    }

    @Override
    public void run() {
        for(;;){
            if(gameStarted) {
                p1.move();
                p2.move();
                b.move();
                b.checkPaddleCollision(p1, p2);
            }
            repaint();
            try{
                Thread.sleep(40);
            }catch(InterruptedException e){}
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            p1.setUpAccel(true);
            //p2.setUpAccel(true);

        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            p1.setDownAccel(true);
            //p2.setDownAccel(true);
        }
        else if(e.getKeyCode()==KeyEvent.VK_ENTER){
            gameStarted = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            p1.setUpAccel(false);
            //p2.setUpAccel(false);

        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            p1.setDownAccel(false);
            //p2.setDownAccel(false);

        }
    }
}
