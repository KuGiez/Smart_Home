import java.util.List;
import javax.swing.*;

public class ZarzadzanieKamera {
    private JList<String> deviceList;
    private DefaultListModel<String> deviceListModel;
    private List<SmartDevice> devices;

    public ZarzadzanieKamera(List<SmartDevice> devices, JList<String> deviceList, DefaultListModel<String> deviceListModel) {
        this.devices = devices;
        this.deviceList = deviceList;
        this.deviceListModel = deviceListModel;
    }

    public void configureSelectedDevice() {
        int index = deviceList.getSelectedIndex();
        if (index >= 0) {
            SmartDevice device = devices.get(index);
            if (device instanceof Kamera) {
                Kamera kamera = (Kamera) device;
                kamera.konfiguruj();  // Wywołanie metody konfigurującej kamerę
            } else {
                JOptionPane.showMessageDialog(null, "To urządzenie nie obsługuje konfiguracji.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nie wybrano urządzenia do konfiguracji.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
