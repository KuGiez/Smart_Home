import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ZarzadzanieGUI extends JFrame {

    private JList<String> deviceList;
    private DefaultListModel<String> deviceListModel;
    private List<SmartDevice> devices = new ArrayList<>();

    public ZarzadzanieGUI() {
        setTitle("SmartHome GUI");
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
        buttonPanel.add(configureButton);

        add(buttonPanel, BorderLayout.SOUTH);

        onButton.addActionListener(e -> turnOnSelectedDevice());
        offButton.addActionListener(e -> turnOffSelectedDevice());
        statusButton.addActionListener(e -> showStatusSelectedDevice());
        configureButton.addActionListener(e -> configureSelectedDevice());
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
        deviceListModel.addElement(device.name);
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

    private void configureSelectedDevice() {
    int index = deviceList.getSelectedIndex();
        if (index >= 0) {
            SmartDevice device = devices.get(index);

            // Obsługa przypadku Brama
            if (device instanceof Brama brama) {
                String[] options = {"Zmień hasło", "Odblokuj", "Zablokuj", "Anuluj"};
                int choice = JOptionPane.showOptionDialog(this,
                        "Wybierz opcję konfiguracji dla Bramy: " + brama.name,
                        "Konfiguracja Brama",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                switch (choice) {
                    case 0: // Zmień hasło
                        String newPassword = JOptionPane.showInputDialog(this, "Podaj nowe hasło:");
                        if (newPassword != null && !newPassword.isEmpty()) {
                            brama.zmienHaslo(newPassword);
                        }
                        break;
                    case 1: // Odblokuj
                        String pass = JOptionPane.showInputDialog(this, "Podaj hasło do odblokowania:");
                        if (pass != null && !pass.isEmpty()) {
                            brama.odblokuj(pass);
                        }
                        break;
                    case 2: // Zablokuj
                        brama.zablokuj();
                        break;
                    case 3: // Anuluj
                        break;  // Nic nie robimy
                }
            }
            // Obsługa przypadku Kamera
            else if (device instanceof Kamera kamera) {
                String[] options = {"Zmień tryb", "Zmień rozdzielczość", "Włącz/wyłącz tryb nocny", "Zmień FPS", "Anuluj"};
                int choice = JOptionPane.showOptionDialog(this,
                        "Wybierz opcję konfiguracji dla Kamery: " + kamera.name,
                        "Konfiguracja Kamery",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                switch (choice) {
                    case 0: // Zmień tryb
                        String nowyTryb = JOptionPane.showInputDialog(this, "Podaj nowy tryb:");
                        if (nowyTryb != null && !nowyTryb.isEmpty()) {
                            kamera.zmienTryb(nowyTryb);
                        }
                        break;
                    case 1: // Zmień rozdzielczość
                        String nowaRozdzielczosc = JOptionPane.showInputDialog(this, "Podaj nową rozdzielczość (np. 1920x1080):");
                        if (nowaRozdzielczosc != null && !nowaRozdzielczosc.isEmpty()) {
                            kamera.zmienRozdzielczosc(nowaRozdzielczosc);
                        }
                        break;
                    case 2: // Włącz/wyłącz tryb nocny
                        String[] nightModeOptions = {"Włącz tryb nocny", "Wyłącz tryb nocny"};
                        int nightModeChoice = JOptionPane.showOptionDialog(this,
                                "Czy chcesz włączyć tryb nocny?",
                                "Tryb nocny",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, nightModeOptions, nightModeOptions[0]);

                        if (nightModeChoice == 0) {
                            kamera.wlaczTrybNocny();
                        } else {
                            kamera.wylaczTrybNocny();
                        }
                        break;
                    case 3: // Zmień FPS
                        String fpsInput = JOptionPane.showInputDialog(this, "Podaj liczbę klatek na sekundę (FPS):", String.valueOf(kamera.getFps()));
                        if (fpsInput != null && !fpsInput.isEmpty()) {
                            try {
                                int fps = Integer.parseInt(fpsInput);
                                if (fps > 0) {
                                    kamera.setFps(fps);  // Zaktualizuj FPS
                                } else {
                                    JOptionPane.showMessageDialog(this, "FPS musi być większy niż 0.", "Błąd", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(this, "Niepoprawna wartość FPS!", "Błąd", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;
                    case 4: // Anuluj
                        break;  // Nic nie robimy
                }
            }
            // Obsługa przypadku Rolety
            else if (device instanceof Rolety rolety) {
                ZarzadzanieRolety zarzadzanieRolety = new ZarzadzanieRolety(rolety);
                zarzadzanieRolety.setVisible(true);
            }
            // Obsługa przypadku Komputer
            else if (device instanceof Komputer komputer) {
                ZarzadzanieKomputer zarzadzanieKomputer = new ZarzadzanieKomputer(komputer);
                zarzadzanieKomputer.setVisible(true);
            }
            // Obsługa przypadku Grzejnik
            else if (device instanceof Heating heating) {
                ZarzadzanieHeating zarzadzanieHeating = new ZarzadzanieHeating(heating);
                zarzadzanieHeating.setVisible(true);
            }
            // Obsługa przypadku Światło
            else if (device instanceof Light light) {
                ZarzadzanieLight zarzadzanieLight = new ZarzadzanieLight(light);
                zarzadzanieLight.setVisible(true);
            }
            // Obsługa przypadku Karmnik
            else if (device instanceof Karmnik karmnik) {
                ZarzadzanieKarmnik zarzadzanieKarmnik = new ZarzadzanieKarmnik(karmnik);
                zarzadzanieKarmnik.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(this, "To urządzenie nie obsługuje konfiguracji.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
