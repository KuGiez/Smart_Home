import java.awt.*;
import javax.swing.*;

public class ZarzadzanieKomputer extends JFrame {
    private Komputer komputer;

    public ZarzadzanieKomputer(Komputer komputer) {
        this.komputer = komputer;
        setTitle("Konfiguracja Komputera: " + komputer.getName());
        setSize(400, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Etykieta z nazwą komputera
        JLabel label = new JLabel("Konfiguracja komputera: " + komputer.getName());
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        add(label);

        // Panel z przyciskami
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10)); // Układ w 4 wierszach
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Przycisk instalacji programu
        JButton instalujButton = new JButton("Instaluj Program");
        instalujButton.addActionListener(e -> instalujProgram());

        // Przycisk włączenia komputera
        JButton wlaczButton = new JButton("Włącz Komputer");
        wlaczButton.addActionListener(e -> komputer.turnOn());

        // Przycisk wyłączenia komputera
        JButton wylaczButton = new JButton("Wyłącz Komputer");
        wylaczButton.addActionListener(e -> komputer.turnOff());

        // Anuluj przycisk do zamknięcia okna
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(e -> dispose());

        // Dodajemy przyciski do panelu
        panel.add(instalujButton);
        panel.add(wlaczButton);
        panel.add(wylaczButton);
        panel.add(cancelButton);

        // Dodajemy panel do głównego okna
        add(panel);
    }

    // Funkcja obsługująca instalację programu
    private void instalujProgram() {
        String program = JOptionPane.showInputDialog(this, "Podaj nazwę programu do zainstalowania:");
        if (program != null && !program.isEmpty()) {
            komputer.instaluj(program);
        } else {
            JOptionPane.showMessageDialog(this, "Nie podano nazwy programu.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
