package countdown;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Time{
    private static int interval;
    private static Timer timer;

    public void runTimer(int setInterval){
        Scanner sc = new Scanner(System.in);
        int delay = 5000;
        int period = 1000;
        timer = new Timer();
        interval = setInterval;

        System.out.print(interval + " ");
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.print(setInterval() + " ");

            }
        }, delay, period);
    }

    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }
}
