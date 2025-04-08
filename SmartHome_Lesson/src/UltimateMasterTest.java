import javax.swing.*;

public class UltimateMasterTest {
    public static void main(String[] args) {

        // Start zegara
        Clock.startClock();

        SwingUtilities.invokeLater(() -> {
            ZarzadzanieGUI gui = new ZarzadzanieGUI();

            // Dodaj kamery
            gui.addDevice(new Kamera("Kamera wejściowa"));
            gui.addDevice(new Kamera("Kamera korytarz"));
            gui.addDevice(new Kamera("Kamera kuchnia"));

            // Dodaj bramę
            gui.addDevice(new Brama("Brama główna"));

            // Dodaj ogrzewanie
            gui.addDevice(new Heating("Grzejnik łazienkowy", 5.5, 18.0));
            gui.addDevice(new Heating("Grzejnik salonowy", 5.0, 20.0));

            // Dodaj światła
            gui.addDevice(new Light("Lampa w kuchni"));
            gui.addDevice(new Light("Lampa w salonie"));

            // Dodaj alarm
            Alarm alarm = new Alarm((byte)12, (byte)10);
            alarm.wlaczAlarm();
            alarm.start();

            // Dodaj karmnik
            Karmnik karmnik = new Karmnik("Karmnik Ogrodowy", (byte)12, (byte)5);
            karmnik.turnOn();
            gui.addDevice(karmnik);

            // Dodaj rolety
            Rolety rolety = new Rolety("Rolety balkonowe");
            rolety.wysun(0.5);
            gui.addDevice(rolety);

            // Dodaj komputer
            Komputer komputer = new Komputer("PC Domowy");
            komputer.turnOn();
//            komputer.instaluj("Spotify");
            gui.addDevice(komputer);

            // Pokaż GUI
            gui.setVisible(true);
        });
    }
}