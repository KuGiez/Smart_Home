import javax.swing.*;

public class Brama extends SmartDevice {
    private boolean blokada = true;
    private String pass = "adminadmin";

    public Brama(String name) {
        super(name);  // Przekazanie nazwy urządzenia do klasy bazowej
    }
    public void odblokuj(String pass) {
        if (this.pass.equals(pass)) {
            blokada = false;
            JOptionPane.showMessageDialog(null,name + ": Brama została odblokowana!");
        } else {
            JOptionPane.showMessageDialog(null,name + ": Niepoprawne hasło - stan pozostanie niezmieniony.");
        }
    }
    public void zablokuj() {
        blokada = true;
        JOptionPane.showMessageDialog(null,name + ": Brama została zablokowana.");
    }
    public void zmienHaslo(String noweHaslo) {
        this.pass = noweHaslo;
        JOptionPane.showMessageDialog(null,name + ": Hasło zostało pomyślnie zmienione!");
        JOptionPane.showMessageDialog(null,name + ": Nowe hasło to: " + this.pass);
    }
    @Override
    public void showStatus() {
        JOptionPane.showMessageDialog(null,name + ": Brama jest " + (blokada ? "zablokowana" : "odblokowana"));
        JOptionPane.showMessageDialog(null,name + ": Brama posiada " + this.pass.length() + " znakowe hasło.");
    }
    public boolean isBlokada() {
        return blokada;
    }
}
