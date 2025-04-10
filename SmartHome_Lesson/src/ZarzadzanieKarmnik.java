import javax.swing.*;

public class ZarzadzanieKarmnik extends JFrame {
    private Karmnik karmnik;

    public ZarzadzanieKarmnik(Karmnik karmnik) {
        this.karmnik = karmnik;
        setTitle("Zarządzanie Karmnikiem");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Dodanie etykiety z nazwą karmnika
        JLabel label = new JLabel("Konfiguracja karmnika: " + karmnik.getName());
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);

        // Pole do ustawiania godziny karmienia
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel godzinaLabel = new JLabel("Godzina:");
        JTextField godzinaField = new JTextField(2);
        godzinaField.setText(String.valueOf(karmnik.getGodzina()));

        JLabel minutaLabel = new JLabel("Minuta:");
        JTextField minutaField = new JTextField(2);
        minutaField.setText(String.valueOf(karmnik.getMinuty()));

        panel.add(godzinaLabel);
        panel.add(godzinaField);
        panel.add(minutaLabel);
        panel.add(minutaField);

        add(panel);

        // Przycisk do zapisania ustawienia godziny
        JButton saveButton = new JButton("Zapisz godzinę karmienia");
        saveButton.setAlignmentX(CENTER_ALIGNMENT);
        saveButton.addActionListener(e -> {
            try {
                int godzina = Integer.parseInt(godzinaField.getText());
                int minuta = Integer.parseInt(minutaField.getText());

                if (godzina < 0 || godzina >= 24 || minuta < 0 || minuta >= 60) {
                    JOptionPane.showMessageDialog(this, "Nieprawidłowa godzina lub minuta!", "Błąd", JOptionPane.ERROR_MESSAGE);
                } else {
                    karmnik.setGodzina((byte) godzina);
                    karmnik.setMinuty((byte) minuta);
                    JOptionPane.showMessageDialog(this, "Godzina karmienia ustawiona na: " + String.format("%02d:%02d", godzina, minuta));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Proszę podać poprawne liczby dla godziny i minut.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(saveButton);
    }
}
