import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ZarzadzanieBrama extends JFrame {

    private JList<String> deviceList;
    private DefaultListModel<String> deviceListModel;
    private List<SmartDevice> devices = new ArrayList<>();

    public ZarzadzanieBrama() {
        setTitle("SmartHome GUI - Brama");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        deviceListModel = new DefaultListModel<>();
        deviceList = new JList<>(deviceListModel);
        JScrollPane scrollPane = new JScrollPane(deviceList);
        add(scrollPane, BorderLayout.CENTER);

        JButton onButton = new JButton("Włącz");
        JButton offButton = new JButton("Wyłącz");
        JButton statusButton = new JButton("Status");
        JButton configureButton = new JButton("Konfiguruj");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(onButton);
        buttonPanel.add(offButton);
        buttonPanel.add(statusButton);
        buttonPanel.add(configureButton); // Dodanie przycisku "Konfiguruj"

        add(buttonPanel, BorderLayout.SOUTH);

        // Przyciski akcji
        onButton.addActionListener(e -> turnOnSelectedDevice());
        offButton.addActionListener(e -> turnOffSelectedDevice());
        statusButton.addActionListener(e -> showStatusSelectedDevice());
        configureButton.addActionListener(e -> configureSelectedDevice());  // Obsługa konfiguracji
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
        deviceListModel.addElement(device.name); // wyświetlana nazwa
    }

    private void turnOnSelectedDevice() {
        int index = deviceList.getSelectedIndex();
        if (index >= 0) {
            SmartDevice device = devices.get(index);
            device.turnOn();
        }
    }

    private void turnOffSelectedDevice() {
        int index = deviceList.getSelectedIndex();
        if (index >= 0) {
            SmartDevice device = devices.get(index);
            device.turnOff();
        }
    }

    private void showStatusSelectedDevice() {
        int index = deviceList.getSelectedIndex();
        if (index >= 0) {
            SmartDevice device = devices.get(index);
            device.showStatus();
        }
    }

    // Metoda, która będzie otwierać okno konfiguracji dla wybranego urządzenia (w tym przypadku bramy)
    private void configureSelectedDevice() {
        int index = deviceList.getSelectedIndex();
        if (index >= 0) {
            SmartDevice device = devices.get(index);
            if (device instanceof Brama) {
                Brama brama = (Brama) device;
                // Okno dialogowe do zmiany hasła i odblokowania bramy
                String[] opcje = {"Odblokuj", "Zmień hasło"};
                int choice = JOptionPane.showOptionDialog(this, "Wybierz akcję", "Konfiguracja Bramy",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcje, opcje[0]);

                if (choice == 0) {
                    // Odblokowanie bramy
                    String pass = JOptionPane.showInputDialog("Podaj hasło:");
                    brama.odblokuj(pass);
                } else if (choice == 1) {
                    // Zmiana hasła
                    String noweHaslo = JOptionPane.showInputDialog("Podaj nowe hasło:");
                    brama.zmienHaslo(noweHaslo);
                }
            } else {
                JOptionPane.showMessageDialog(this, "To urządzenie nie obsługuje konfiguracji.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nie wybrano urządzenia do konfiguracji.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
