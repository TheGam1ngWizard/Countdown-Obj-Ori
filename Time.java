package countdown;

import javax.swing.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Time extends JFrame {
    private static int interval;
    private static Timer timer;
    private static JFrame timerFrame = new JFrame();
    public static JLabel timePanel = new JLabel("30");


    public void runTimer(int setInterval){

        timerFrame.setSize(100, 100);
        timerFrame.setLocation(600, 100);


        timePanel.setBounds(10, 10, 50, 50);
        timerFrame.add(timePanel);
        timerFrame.setLayout(null);
        timerFrame.setVisible(true);

        Scanner sc = new Scanner(System.in);
        int delay = 2000;
        int period = 1000;
        timer = new Timer();
        interval = setInterval;

        //System.out.print(interval + " ");
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                timePanel.setText(setInterval() + "");

            }
        }, delay, period);

    }

    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }

    public int returnTime() {
        return (Integer.parseInt(timePanel.getText()));
    }

    public void stopTimer() {
        timePanel.setText("30");
        timer.cancel();
        timerFrame.setVisible(false);
    }
}
