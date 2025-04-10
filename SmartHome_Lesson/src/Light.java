import javax.swing.*;

public class Light extends SmartDevice {

    public Light(String name) {
        super(name);
    }

    public void zapal(boolean stan) {
        isOn = stan;

        if (isOn) {
            JOptionPane.showMessageDialog(null,name + ": Światło zostało zapalone.");
        } else {
            JOptionPane.showMessageDialog(null,name + ": Światło zostało zgaszone.");
        }
    }

    @Override
    public void showStatus() {
        JOptionPane.showMessageDialog(null,name + " | Stan: " + (isOn ? "Włączone" : "Wyłączone"));
    }
}


