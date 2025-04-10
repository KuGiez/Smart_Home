import javax.swing.*;
public abstract class SmartDevice {
    protected String name;
    protected boolean isOn;

    public SmartDevice(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
        JOptionPane.showMessageDialog(null, "Urządzenie włączone");

    }

    public void turnOff() {
        this.isOn = false;
        JOptionPane.showMessageDialog(null,name + ": Urządzenie wyłączone.");
    }

    public abstract void showStatus();

    public boolean isOn() {
        return isOn;
    }

    public String getName() {
        return name;
    }
}