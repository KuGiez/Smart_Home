public class Alarm extends Thread {
    private byte godzinaAlarmu;
    private byte minutaAlarmu;

    private boolean alarmWlaczony = false;

    public Alarm(byte godzina, byte minuta) {
        if (godzina < 0 || godzina >= 24 || minuta < 0 || minuta >= 60) {
            throw new IllegalArgumentException("\n<Alarm.system> Nieprawidłowa godzina lub minuta");
        }
        this.godzinaAlarmu = godzina;
        this.minutaAlarmu = minuta;
    }

    public void włączAlarm() {
        alarmWlaczony = true;
    }

    public void wstrzymajAlarm() {
        alarmWlaczony = false;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (alarmWlaczony) {
                    byte currentGodzina = Clock.getGodzina();
                    byte currentMinuta = Clock.getMinuty();
                    sprawdzAlarm(currentGodzina, currentMinuta);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("\n<Alarm.system> Alarm został przerwany");
        }
    }

    private void sprawdzAlarm(byte godzina, byte minuta) {
        if (godzina == godzinaAlarmu && minuta == minutaAlarmu) {
            uruchomAlarm();
        }
    }

    private void uruchomAlarm() {
        System.out.println("\n<Alarm.system> ALARM! Czas: " + String.format("%02d:%02d", godzinaAlarmu, minutaAlarmu));
    }
}
