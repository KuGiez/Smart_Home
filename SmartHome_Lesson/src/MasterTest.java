import javax.swing.*;
import javax.swing.SwingUtilities;


public class MasterTest {
    public static void main(String[] args) {

        //ZEGAR
        Clock.startClock();


        Alarm alarm = new Alarm( (byte) 12, (byte) 10);

        alarm.wlaczAlarm();
        alarm.start();
        alarm.wylaczAlarm();



        //KARMNIK
        Karmnik karmnik = new Karmnik("Karmnik Ogrodowy", (byte)12, (byte)5);
        karmnik.turnOn();  // uruchamia nowy wątek i czeka na czas

        karmnik.showStatus();


        //LIGHT
        Light l1 = new Light("Kuchnia");
        l1.turnOn();
        l1.showStatus();


        //ROLETY
        Rolety r1 = new Rolety("Rolety balkonowe");
        r1.wysun(0.5);
        r1.showStatus();


        //BRAMA
        Brama b1 = new Brama("Brama wjazdowa");

        b1.turnOn();  
        b1.showStatus();  

        b1.odblokuj("adminadmin");  
        b1.showStatus();  

        b1.zmienHaslo("newpassword");  
        b1.showStatus();  

        b1.zablokuj();  
        b1.showStatus();


        //KAMERA
        Kamera kamera = new Kamera("Kamera bezpieczeństwa");

        kamera.turnOn();
        kamera.zmienTryb("Nocny");
        kamera.showStatus();

        kamera.turnOff();
        kamera.showStatus();


        //HEATING
        Heating grzejnik = new Heating("Grzejnik", 5.0, 18.0);

        grzejnik.turnOn();

        grzejnik.changeHeating();
        grzejnik.increasePower(3);
        grzejnik.decreasePower(1);
        
        grzejnik.showStatus();

        grzejnik.turnOff();
        grzejnik.showStatus();


        //KOMPUTER
        Komputer komp = new Komputer("PC Domowy");

        komp.turnOn();
        komp.showStatus();

        komp.instaluj("Spotify");
        komp.turnOff();


        //GUI
        SwingUtilities.invokeLater(() -> {
            ZarzadzanieGUI gui = new ZarzadzanieGUI();

            // Dodaj przykładowe urządzenia
            gui.addDevice(new Kamera("Kamera wejściowa"));
            gui.addDevice(new Brama("Brama główna"));
            gui.addDevice(new Heating("Grzejnik łazienkowy", 5.5, 18.0));
            gui.addDevice(new Light("Lampa w kuchni"));
            


            gui.setVisible(true); // pokaż okno
        });
    }
}