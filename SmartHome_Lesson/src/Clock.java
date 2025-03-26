public class Clock extends Thread {
    private static byte godzina = 0;
    private static byte minuty = 0;

    public Clock() {
        godzina = 0;
        minuty = 0;
    }


    public static synchronized byte getGodzina() {
        return godzina;
    }

    public static synchronized byte getMinuty() {
        return minuty;
    }


    @Override
    public void run() {
        try {
            while (true) {
                minuty += 15;

                if (minuty >= 60) {
                    minuty -= 60;
                    godzina++;
                }

                if (godzina >= 24) {
                    godzina -= 24;
                }

//                System.out.printf("Czas: %02d:%02d%n", godzina, minuty);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Wątek zegara został przerwany");
        }
    }
}
