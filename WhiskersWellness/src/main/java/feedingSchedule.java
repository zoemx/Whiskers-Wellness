import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class feedingSchedule extends Thread {
    private String timeToComparea;
    private String timeToComparep;

    public feedingSchedule(String timeToComparea, String timeToComparep) {
        this.timeToComparea = timeToComparea;
        this.timeToComparep = timeToComparep;
    }

            public void run() {

                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                // try {
                // Schedule the task to run every 1 second

                String currentTime = new SimpleDateFormat("HH:mm").format(new Date());
               // String timeToCompare = "14:17";
                boolean x = currentTime.equals(timeToComparea);
                boolean y = currentTime.equals(timeToComparep);

                if (x || y) {
                    System.out.println("It's time to feed your cat!");
                }
                //} catch (Exception e) {
                // Throwing an exception
                // System.out.println("Exception is caught");
                //}


            }


        };
        timer.schedule(task, 1000, 60000);

    }
}


