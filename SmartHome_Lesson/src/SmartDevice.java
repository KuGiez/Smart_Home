public abstract class SmartDevice {
    protected String name;
    protected boolean isOn;

    public SmartDevice(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println(name + ": Urządzenie włączone.");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println(name + ": Urządzenie wyłączone.");
    }

    public abstract void showStatus();

    public boolean isOn() {
        return isOn;
    }
}