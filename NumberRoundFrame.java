package countdown;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberRoundFrame extends JFrame{
    JFrame f;
    NumberRoundFrame(){

        JLabel label = new JLabel("Welcome to the Number Round!");
        label.setBounds(100, 50, 350, 30);

        add(label);

        JLabel directions = new JLabel("Choose small numbers or big" + "\n" +
                "numbers to get started.");
        directions.setBounds(50, 80, 350, 20);

        add(directions);

        Font font = new Font("Comic Sans", Font.BOLD, 20);

        JTextArea num1 = new JTextArea("");
        num1.setBounds(50, 110, 300, 30);
        num1.setBackground(Color.darkGray);
        num1.setForeground(Color.white);
        num1.setFont(font);


        JTextArea num2 = new JTextArea();
        num2.setBounds(80, 110, 30, 30);
        num2.setBackground(Color.darkGray);
        num1.setForeground(Color.white);

        JTextArea num3 = new JTextArea();
        num3.setBounds(110, 110, 30, 40);

        JTextArea num4 = new JTextArea();
        num4.setBounds(140, 110, 30, 40);

        JTextArea num5 = new JTextArea();
        num5.setBounds(170, 110, 30, 40);

        add(num1);


        JButton b=new JButton("SMALL NUMBER");
        b.setBounds(25,160,150, 50);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String current = num1.getText();
                num1.setText(current + "1");
            }
        });

        add(b);

        JButton c=new JButton("BIG NUMBER");
        c.setBounds(200,160,150, 50);
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String current = num1.getText();
                num1.setText(current + "200");
            }
        });

        add(c);


        JButton exit=new JButton("EXIT");
        exit.setBounds(90, 220, 200, 50);
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
