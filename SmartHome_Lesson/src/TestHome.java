// TestHome.java - Klasa, która uruchamia zegar i alarm
public class TestHome {
    static class Clock extends Thread {
        private byte godzina = 0;
        private byte minuty = 0;
        private byte sekundy = 0;
        private Alarm alarm; // Dodajemy obiekt alarmu

        public Clock(Alarm alarm) {
            this.alarm = alarm;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    minuty += 15;

                    if (minuty >= 60) {
                        minuty = 0;
                        godzina++;
                    }

                    if (godzina >= 24) {
                        godzina = 0;
                    }

                    alarm.sprawdzAlarm(godzina, minuty, sekundy);

                    System.out.printf("Czas: %02d:%02d:%02d%n", godzina, minuty, sekundy);

                    Thread.sleep(1000); // 1000 ms = 1 sekunda w prawdziwym czasie

                    sekundy++;
                    if (sekundy >= 60) {
                        sekundy = 0;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Wątek zegara został przerwany");
            }
        }
    }

    public static void main(String[] args) {
        Alarm alarm = new Alarm((byte) 10, (byte) 30, (byte) 0);

        Clock zegar = new Clock(alarm);
        zegar.start();

        alarm.włączAlarm();

        TemperatureSensorOutside tmp = new TemperatureSensorOutside();
        TemperatureSensorInside tmpIn = new TemperatureSensorInside(tmp);
        Heating heat = new Heating(tmp, tmpIn);
        Komputer komputer_stacjonarny = new Komputer();

        heat.increasePower(3);
        heat.increasePower(2);
        heat.decreasePower(2);

        Rolety roleta_salon = new Rolety();
        roleta_salon.wysun(0.5754);

        komputer_stacjonarny.instaluj("firefox");

    }
}


