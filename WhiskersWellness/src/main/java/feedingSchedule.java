import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class feedingSchedule extends Thread {

    public static void main(String[] args) {
        System.out.println("hey");
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // try {
                // Schedule the task to run every 1 second

                String currentTime = new SimpleDateFormat("HH:mm").format(new Date());
                String timeToCompare = "14:07";
                boolean x = currentTime.equals(timeToCompare);
                System.out.println(x);
                if (x) {
                    System.out.println("It's time to feed your cat!");
                }
                //} catch (Exception e) {
                // Throwing an exception
                // System.out.println("Exception is caught");
                //}


            }


        };
        timer.schedule(task, 1000, 1000);

    }
}


