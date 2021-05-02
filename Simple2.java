package countdown;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static countdown.Game.runNumberRound;

public class Simple2 extends JFrame{
    JFrame f;
    Simple2(){

        JButton b=new JButton("START GAME");
        b.setBounds(100,100,200, 50);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //NumberRoundFrame frame = new NumberRoundFrame();
                //Game game = new Game();
                //frame.setVisible(true);

                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
        });

        add(b);


        JButton exit=new JButton("EXIT");
        exit.setBounds(100, 160, 200, 50);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        add(exit);



        setSize(400,500);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Simple2();
    }
}