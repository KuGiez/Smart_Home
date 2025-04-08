import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


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

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(onButton);
        buttonPanel.add(offButton);
        buttonPanel.add(statusButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // przyciski akcji
        onButton.addActionListener(e -> turnOnSelectedDevice());
        offButton.addActionListener(e -> turnOffSelectedDevice());
        statusButton.addActionListener(e -> showStatusSelectedDevice());
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
}