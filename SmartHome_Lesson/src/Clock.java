import java.util.Timer;
import java.util.TimerTask;

public class Clock {
    private static byte godzina = 12;
    private static byte minuta = 0;

    public static byte getGodzina() {
        return godzina;
    }

    public static byte getMinuty() {
        return minuta;
    }

    public static void startClock() {
        Timer timer = new Timer(true); // działa w tle
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                minuta++;
                if (minuta >= 60) {
                    minuta = 0;
                    godzina++;
                    if (godzina >= 24) godzina = 0;
                }
                // Możesz odkomentować:
                // System.out.printf("⏰ %02d:%02d\n", godzina, minuta);
            }
        }, 0, 1000); // co sekundę = 1 minuta zegarowa
    }
}