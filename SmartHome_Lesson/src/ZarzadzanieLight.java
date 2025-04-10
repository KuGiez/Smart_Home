import javax.swing.*;

public class ZarzadzanieLight extends JFrame {

    private Light light;

    public ZarzadzanieLight(Light light) {
        this.light = light;

        setTitle("Konfiguracja Światła: " + light.name);
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Konfiguracja światła: " + light.name);
        add(label);

        JButton zapalButton = new JButton("Włącz światło");
        JButton zgasButton = new JButton("Zgaś światło");
        JButton cancelButton = new JButton("Anuluj");

        zapalButton.addActionListener(e -> light.zapal(true));
        zgasButton.addActionListener(e -> light.zapal(false));
        cancelButton.addActionListener(e -> dispose());

        JPanel panel = new JPanel();
        panel.add(zapalButton);
        panel.add(zgasButton);
        panel.add(cancelButton);

        add(panel);
    }
}
