import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;

public class Komputer extends SmartDevice {
    private Scanner zapytaj = new Scanner(System.in);

    public Komputer(String name) {
        super(name);
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            JOptionPane.showMessageDialog(null,name + ": Komputer został uruchomiony.");
        } else {
            JOptionPane.showMessageDialog(null,name + ": Komputer już był uruchomiony.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            JOptionPane.showMessageDialog(null,name + ": Komputer został wyłączony.");
        } else {
            JOptionPane.showMessageDialog(null,name + ": Komputer już był wyłączony.");
        }
    }

    @Override
    public void showStatus() {
        JOptionPane.showMessageDialog(null,name + " | Stan: " + (isOn ? "Włączony" : "Wyłączony"));
    }

    public void instaluj(String program) {
        if (!isOn) {
            JOptionPane.showMessageDialog(null,name + ": Komputer jest wyłączony. Nie można instalować programów.");
            return;
        }

        JOptionPane.showMessageDialog(null,name + ": Przeszukuję bazę danych...");
        JOptionPane.showMessageDialog(null,name + ": Znaleziono " + program + "-install.exe");
        JOptionPane.showMessageDialog(null,"Czy chcesz go zainstalować? T/N");

        String odpowiedz = zapytaj.nextLine();
        if (Objects.equals(odpowiedz.toUpperCase(), "T")) {
            JOptionPane.showMessageDialog(null,name + ": Instaluję...");
            JOptionPane.showMessageDialog(null,name + ": Instalacja programu " + program + " powiodła się!");
        } else {
            JOptionPane.showMessageDialog(null,name + ": Instalacja została anulowana.");
        }
    }
}