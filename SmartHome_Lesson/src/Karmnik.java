import javax.swing.*;

public class Karmnik extends SmartDevice implements Runnable {
    private byte godzina;
    private byte minuty;
    private Thread thread;

    public Karmnik(String name, byte godzina, byte minuty) {
        super(name);

        if (godzina < 0 || godzina >= 24 || minuty < 0 || minuty >= 60) {
            throw new IllegalArgumentException("<Karmnik.system> Nieprawidłowe wartości godziny lub minut");
        }

        this.godzina = godzina;
        this.minuty = minuty;
    }

    @Override
    public void turnOn() {
        super.turnOn();
        JOptionPane.showMessageDialog(null,name + ": Karmnik czeka na właściwą godzinę...");
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void turnOff() {
        super.turnOff();
        if (thread != null) thread.interrupt();
        JOptionPane.showMessageDialog(null,name + ": Karmnik został zatrzymany.");
    }

    @Override
    public void showStatus() {
        JOptionPane.showMessageDialog(null,name + " | Stan: " + (isOn ? "Czeka na karmienie" : "Nieaktywny") +
                " | Zaplanowano na: " + String.format("%02d:%02d", godzina, minuty));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                if ((Clock.getGodzina() == godzina) &&
                        (Math.abs(Clock.getMinuty() - minuty) <= 10)) {

                    JOptionPane.showMessageDialog(null,name + ": 🐦 Karmnik został aktywowany!");
                    break;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null,name + ": ❌ Karmnik przerwany.");
        }
    }




    public byte getGodzina() {
        return godzina;
    }

    public void setGodzina(byte godzina) {
        if (godzina >= 0 && godzina < 24) {
            this.godzina = godzina;
        } else {
            throw new IllegalArgumentException("<Karmnik.system> Nieprawidłowa godzina");
        }
    }

    public byte getMinuty() {
        return minuty;
    }

    public void setMinuty(byte minuty) {
        if (minuty >= 0 && minuty < 60) {
            this.minuty = minuty;
        } else {
            throw new IllegalArgumentException("<Karmnik.system> Nieprawidłowe minuty");
        }
    }

}