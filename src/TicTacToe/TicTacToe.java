package TicTacToe;


import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    int bClicked=0;
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel title_panel1 = new JPanel();
    JPanel button_panel = new JPanel();
    JButton[]  button = new JButton[9];
    ImageIcon logo = new ImageIcon("C:\\Users\\Vipul\\Pictures\\download\\logo(2).png");
    JLabel textfield = new JLabel();
    JLabel textfield1 = new JLabel();
    boolean player1_turn;
    public TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(750,750);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setIconImage(logo.getImage());

       

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("MV Boli",Font.BOLD,55));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("");
        textfield.setOpaque(true);

        textfield1.setBackground(new Color(25,25,25));
        textfield1.setForeground(new Color(25,255,250));
        textfield1.setFont(new Font("MV Boli",Font.BOLD,55));
        textfield1.setHorizontalAlignment(JLabel.CENTER);
        textfield1.setText("Tic-Tac-Toe");
        textfield1.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        title_panel1.setLayout(new BorderLayout());
        title_panel1.setBounds(0,100,800,100);

        button_panel.setLayout(new GridLayout(3,3,20,20));
        button_panel.setBackground(new Color(0,0,0));

        for(int i=0;i<9;i++){
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("MV Boli",Font.BOLD,120));
            button[i].setBackground(Color.WHITE);
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }

        title_panel.add(textfield);
        title_panel1.add(textfield1);

        frame.add(title_panel,BorderLayout.SOUTH);
        frame.add(title_panel1,BorderLayout.NORTH);


        frame.add(button_panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++) {
            if (e.getSource() ==button[i]){
            	bClicked++;
                if(player1_turn){
                    if(button[i].getText() == ""){
                        button[i].setForeground(Color.RED);
                        button[i].setFont(new Font("Ink free",Font.BOLD,120));
                        button[i].setText("X");

                        player1_turn = false;
                        textfield.setText("player2 - turn");

                        check();
                    }
                }
                else{
                    if(button[i].getText() == ""){
                        button[i].setForeground(Color.BLUE);
                        button[i].setFont(new Font("Ink free",Font.BOLD,120));
                        button[i].setText("O");
                        player1_turn =true;
                        textfield.setText("player1 - turn");

                            check();

                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){}
        /*try {
            Thread.sleep(2000);
        }catch(InterruptedException e){}
        if(random.nextInt(2) == 0){
            player1_turn = true;
               textfield.setText("player1 - turn");
        }
        else{
            player1_turn = false;
            textfield.setText("player2 - turn");
        }*/
        player1_turn = true;
        textfield.setText("player1 - turn");
    }

    public void check() {

        //check for X
    	 if(bClicked==9) {
        	 textfield.setText("Draw");
        }

            if (button[0].getText() == "X" &&
                    button[1].getText() == "X" &&
                    button[2].getText() == "X") {
                xWin(0, 1, 2);
            }
            if (button[3].getText() == "X" &&
                    button[4].getText() == "X" &&
                    button[5].getText() == "X") {
                xWin(3, 4, 5);
            }
            if (button[6].getText() == "X" &&
                    button[7].getText() == "X" &&
                    button[8].getText() == "X") {
                xWin(6, 7, 8);
            }
            if (button[0].getText() == "X" &&
                    button[3].getText() == "X" &&
                    button[6].getText() == "X") {
                xWin(0, 3, 6);
            }
            if (button[1].getText() == "X" &&
                    button[4].getText() == "X" &&
                    button[7].getText() == "X") {
                xWin(1, 4, 7);
            }
            if (button[2].getText() == "X" &&
                    button[5].getText() == "X" &&
                    button[8].getText() == "X") {
                xWin(2, 5, 8);
            }
            if (button[0].getText() == "X" &&
                    button[4].getText() == "X" &&
                    button[8].getText() == "X") {
                xWin(0, 4, 8);
            }
            if (button[2].getText() == "X" &&
                    button[4].getText() == "X" &&
                    button[6].getText() == "X") {
                xWin(2, 4, 6);
            }
            //check for O
            if (button[0].getText() == "O" &&
                    button[1].getText() == "O" &&
                    button[2].getText() == "O") {
                oWin(0, 1, 2);
            }
            if (button[3].getText() == "O" &&
                    button[4].getText() == "O" &&
                    button[5].getText() == "O") {
                oWin(3, 4, 5);
            }
            if (button[6].getText() == "O" &&
                    button[7].getText() == "O" &&
                    button[8].getText() == "O") {
                oWin(6, 7, 8);
            }
            if (button[0].getText() == "O" &&
                    button[3].getText() == "O" &&
                    button[6].getText() == "O") {
                oWin(0, 3, 6);
            }
            if (button[1].getText() == "O" &&
                    button[4].getText() == "O" &&
                    button[7].getText() == "O") {
                oWin(1, 4, 7);
            }
            if (button[2].getText() == "O" &&
                    button[5].getText() == "O" &&
                    button[8].getText() == "O") {
                oWin(2, 5, 8);
            }
            if (button[0].getText() == "O" &&
                    button[4].getText() == "O" &&
                    button[8].getText() == "O") {
                oWin(0, 4, 8);
            }
            if (button[2].getText() == "O" &&
                    button[4].getText() == "O" &&
                    button[6].getText() == "O") {
                oWin(2, 4, 6);
            }
           
            	
            

    }
    public void xWin(int a,int b,int c){
        button[a].setBackground(Color.RED);
        button[b].setBackground(Color.RED);
        button[c].setBackground(Color.RED);

        for(int i=0;i<9;i++){
            button[i].setEnabled(false);
        }
        textfield.setText("Player 1 wins");
    }
    public void oWin(int a,int b,int c){
        button[a].setBackground(Color.RED);
        button[b].setBackground(Color.RED);
        button[c].setBackground(Color.RED);


        for(int i=0;i<9;i++){
            button[i].setEnabled(false);
        }
        textfield.setText("PLayer 2 wins");
    }
    public void matchDraw(){
        textfield.setText("Draw");
    }

}
