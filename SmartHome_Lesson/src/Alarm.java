import javax.swing.*;

public class Alarm extends Thread {
    private byte godzinaAlarmu;
    private byte minutaAlarmu;
    private boolean alarmWlaczony = false;

    public Alarm(byte godzina, byte minuta) {
        if (godzina < 0 || godzina >= 24 || minuta < 0 || minuta >= 60) {
            throw new IllegalArgumentException("❌ Nieprawidłowy czas alarmu.");
        }
        this.godzinaAlarmu = godzina;
        this.minutaAlarmu = minuta;
    }

    public void wlaczAlarm() {
        alarmWlaczony = true;
    }

    public void wylaczAlarm() {
        alarmWlaczony = false;
    }

    @Override
    public void run() {
        while (true) {
            if (alarmWlaczony) {
                if (Clock.getGodzina() == godzinaAlarmu && Clock.getMinuty() == minutaAlarmu) {
                    uruchomAlarm();
                    wylaczAlarm(); // żeby nie powtarzał się ciągle
                }
            }

            try {
                Thread.sleep(1000); // co 1 sek sprawdzamy
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null,"🚨 Alarm zatrzymany");
                break;
            }
        }
    }

    private void uruchomAlarm() {
        System.out.printf("🔔 ALARM! Jest %02d:%02d%n", godzinaAlarmu, minutaAlarmu);
    }
}