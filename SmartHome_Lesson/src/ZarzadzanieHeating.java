import java.awt.*;
import javax.swing.*;

public class ZarzadzanieHeating extends JFrame {
    private Heating heating;

    public ZarzadzanieHeating(Heating heating) {
        this.heating = heating;

        setTitle("Konfiguracja Grzejnika: " + heating.getName());
        setSize(400, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Etykieta z nazwą grzejnika
        JLabel label = new JLabel("Konfiguracja grzejnika: " + heating.getName());
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        add(label);

        // Panel z przyciskami
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10)); // Układ w 5 wierszach
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Przycisk włączenia grzejnika
        JButton wlaczButton = new JButton("Włącz Grzejnik");
        wlaczButton.addActionListener(e -> heating.turnOn());

        // Przycisk wyłączenia grzejnika
        JButton wylaczButton = new JButton("Wyłącz Grzejnik");
        wylaczButton.addActionListener(e -> heating.turnOff());

        // Przycisk zmiany mocy grzejnika na podstawie temperatury
        JButton zmianaMocyButton = new JButton("Zmień Moc Grzejnika");
        zmianaMocyButton.addActionListener(e -> heating.changeHeating());

        // Przycisk zwiększania mocy grzejnika
        JButton zwiekszMocButton = new JButton("Zwiększ Moc");
        zwiekszMocButton.addActionListener(e -> {
            String powerInput = JOptionPane.showInputDialog(this, "Podaj ilość W do zwiększenia mocy:");
            if (powerInput != null && !powerInput.isEmpty()) {
                try {
                    int power = Integer.parseInt(powerInput);
                    if (power > 0) {
                        heating.increasePower(power);
                    } else {
                        JOptionPane.showMessageDialog(this, "Moc musi być większa niż 0.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Niepoprawna wartość mocy!", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Przycisk zmniejszania mocy grzejnika
        JButton zmniejszMocButton = new JButton("Zmniejsz Moc");
        zmniejszMocButton.addActionListener(e -> {
            String powerInput = JOptionPane.showInputDialog(this, "Podaj ilość W do zmniejszenia mocy:");
            if (powerInput != null && !powerInput.isEmpty()) {
                try {
                    int power = Integer.parseInt(powerInput);
                    if (power > 0) {
                        heating.decreasePower(power);
                    } else {
                        JOptionPane.showMessageDialog(this, "Moc musi być większa niż 0.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Niepoprawna wartość mocy!", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Anuluj przycisk do zamknięcia okna
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(e -> dispose());

        // Dodajemy przyciski do panelu
        panel.add(wlaczButton);
        panel.add(wylaczButton);
        panel.add(zmianaMocyButton);
        panel.add(zwiekszMocButton);
        panel.add(zmniejszMocButton);
        panel.add(cancelButton);

        // Dodajemy panel do głównego okna
        add(panel);
    }
}