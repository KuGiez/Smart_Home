public class Kamera extends SmartDevice {
    private String tryb = "Normalny";

    public Kamera(String name) {
        super(name);
    }

    public void zmienTryb(String nowyTryb) {
        this.tryb = nowyTryb;
        System.out.println(name + ": Tryb pracy został zmieniony na: " + this.tryb);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println(name + ": Kamera została włączona.");
    }

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println(name + ": Kamera została wyłączona.");
    }

    @Override
    public void showStatus() {
        System.out.println(name + " | Stan: " + (isOn ? "Włączona" : "Wyłączona") + " | Tryb: " + tryb);
    }
}
