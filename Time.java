package countdown;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Time extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6546379787738652515L;
	private static int interval;
    private static Timer timer;
    private static JFrame timerFrame = new JFrame();
    //public static JLabel timePanel = new JLabel("30");



    public void runTimer(int setInterval, JLabel timePanel){

       // timerFrame.setSize(400, 80);
        //timerFrame.setLocation(500, 200);


       // timePanel.setBounds(185, 5, 50, 50);
        //timerFrame.add(timePanel);
        //timerFrame.setLayout(null);
        //timerFrame.setVisible(true);

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

    //public int returnTime() {
      //  return (Integer.parseInt(timePanel.getText()));
    //}

    public void stopTimer() {
        //timePanel.setText("30");
        timer.cancel();

        timerFrame.setVisible(false);
    }
}
