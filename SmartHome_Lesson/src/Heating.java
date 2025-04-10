import javax.swing.*;

public class Heating extends SmartDevice {
    private double tmpOut; // temperatura na zewnątrz
    private double tmpIn;  // temperatura wewnętrzna
    private int power = 0; // moc grzejnika

    public Heating(String name, double tmpOut, double tmpIn) {
        super(name);
        this.tmpOut = tmpOut;
        this.tmpIn = tmpIn;
        JOptionPane.showMessageDialog(null,name + ": Moc grzejnika przed zmianą: " + power);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        JOptionPane.showMessageDialog(null,name + ": Grzejnik włączony.");
    }

    @Override
    public void turnOff() {
        super.turnOff();
        JOptionPane.showMessageDialog(null,name + ": Grzejnik wyłączony.");
    }

    @Override
    public void showStatus() {
        JOptionPane.showMessageDialog(null,name + " | Stan: " + (isOn ? "Włączony" : "Wyłączony") +
                " | Temperatura wewnętrzna: " + tmpIn + "°C" +
                " | Temperatura zewnętrzna: " + tmpOut + "°C" +
                " | Moc: " + power + "W");
    }

    public void changeHeating() {
        if (isOn) {
            if (tmpIn < 20) {
                power += 2;
                JOptionPane.showMessageDialog(null,name + ": Z powodu niskiej temperatury wewnętrznej, moc grzejnika została zwiększona do: " + power);
            } else {
                JOptionPane.showMessageDialog(null,name + ": Temperatura wewnętrzna jest wystarczająca, moc grzejnika pozostała na poziomie: " + power);
            }
        } else {
            JOptionPane.showMessageDialog(null,name + ": Grzejnik jest wyłączony, zmiana mocy niemożliwa.");
        }
    }

    public void increasePower(int pwr) {
        power += pwr;
        JOptionPane.showMessageDialog(null,name + ": Moc grzejnika została zwiększona do: " + power);
    }

    public void decreasePower(int pwr) {
        if (power - pwr >= 0) {
            power -= pwr;
            JOptionPane.showMessageDialog(null,name + ": Moc grzejnika została zmniejszona do: " + power);
        } else {
            JOptionPane.showMessageDialog(null,name + ": Moc grzejnika nie może być mniejsza niż 0.");
        }
    }
}