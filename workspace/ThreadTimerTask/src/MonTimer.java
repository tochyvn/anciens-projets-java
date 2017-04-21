import java.util.Timer;

public class MonTimer {
    Timer timer;

    public MonTimer(int seconds) {
        timer = new Timer();
        timer.schedule(new Bombe(),0,seconds*1000 );
	}

    

    public static void main(String args[]) {
        new MonTimer(5);
        System.out.format("Task scheduled.%n");
    }
}