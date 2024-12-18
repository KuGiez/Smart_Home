// Klasa Alarm - odpowiada za ustawienie alarmu oraz jego wyzwolenie
class Alarm {
    private byte godzinaAlarmu;
    private byte minutaAlarmu;
    private byte sekundaAlarmu;
    private boolean alarmWlaczony = false;

    public Alarm(byte godzina, byte minuta, byte sekunda) {
        this.godzinaAlarmu = godzina;
        this.minutaAlarmu = minuta;
        this.sekundaAlarmu = sekunda;
    }

    public void włączAlarm() {
        alarmWlaczony = true;
    }

    public void wstrzymajAlarm() {
        alarmWlaczony = false;
    }

    public void sprawdzAlarm(byte godzina, byte minuta, byte sekunda) {
        if (alarmWlaczony && godzina == godzinaAlarmu && minuta == minutaAlarmu && sekunda == sekundaAlarmu) {
            uruchomAlarm();
        }
    }

    private void uruchomAlarm() {
        System.out.println("ALARM! Czas: " + String.format("%02d:%02d:%02d", godzinaAlarmu, minutaAlarmu, sekundaAlarmu));
    }
}
