public class Light extends SmartDevice {

    public Light(String name) {
        super(name);
    }

    public void zapal(boolean stan) {
        isOn = stan;

        if (isOn) {
            System.out.println(name + ": Światło zostało zapalone.");
        } else {
            System.out.println(name + ": Światło zostało zgaszone.");
        }
    }

    @Override
    public void showStatus() {
        System.out.println(name + " | Stan: " + (isOn ? "Włączone" : "Wyłączone"));
    }
}


