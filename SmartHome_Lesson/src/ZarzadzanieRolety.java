import javax.swing.*;

public class ZarzadzanieRolety extends JFrame {

    private Rolety rolety;

    public ZarzadzanieRolety(Rolety rolety) {
        this.rolety = rolety;

        setTitle("Konfiguracja Rolet");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Konfiguracja rolet: " + rolety.name);
        add(label);

        // Panel do ustawienia stopnia wysunięcia rolet
        JTextField wysuniecieField = new JTextField(String.valueOf(rolety.getStopienWysuniecia())); // Używamy getter
        wysuniecieField.setMaximumSize(new java.awt.Dimension(200, 30));

        JButton wysunButton = new JButton("Ustaw stopień wysunięcia");
        wysunButton.addActionListener(e -> {
            try {
                double wysuniecie = Double.parseDouble(wysuniecieField.getText());
                if (wysuniecie >= 0 && wysuniecie <= 1) {
                    rolety.wysun(wysuniecie);
                } else {
                    JOptionPane.showMessageDialog(this, "Stopień wysunięcia musi być w zakresie 0.0 - 1.0.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Niepoprawna wartość wysunięcia!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(e -> dispose());

        JPanel panel = new JPanel();
        panel.add(wysuniecieField);
        panel.add(wysunButton);
        panel.add(cancelButton);

        add(panel);
    }
}
