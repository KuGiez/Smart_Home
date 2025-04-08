public class Heating extends SmartDevice {
    private double tmpOut; // temperatura na zewnątrz
    private double tmpIn;  // temperatura wewnętrzna
    private int power = 0; // moc grzejnika

    public Heating(String name, double tmpOut, double tmpIn) {
        super(name);
        this.tmpOut = tmpOut;
        this.tmpIn = tmpIn;
        System.out.println(name + ": Moc grzejnika przed zmianą: " + power);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println(name + ": Grzejnik włączony.");
    }

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println(name + ": Grzejnik wyłączony.");
    }

    @Override
    public void showStatus() {
        System.out.println(name + " | Stan: " + (isOn ? "Włączony" : "Wyłączony") +
                " | Temperatura wewnętrzna: " + tmpIn + "°C" +
                " | Temperatura zewnętrzna: " + tmpOut + "°C" +
                " | Moc: " + power + "W");
    }

    public void changeHeating() {
        if (isOn) {
            if (tmpIn < 20) {
                power += 2;
                System.out.println(name + ": Z powodu niskiej temperatury wewnętrznej, moc grzejnika została zwiększona do: " + power);
            } else {
                System.out.println(name + ": Temperatura wewnętrzna jest wystarczająca, moc grzejnika pozostała na poziomie: " + power);
            }
        } else {
            System.out.println(name + ": Grzejnik jest wyłączony, zmiana mocy niemożliwa.");
        }
    }

    public void increasePower(int pwr) {
        power += pwr;
        System.out.println(name + ": Moc grzejnika została zwiększona do: " + power);
    }

    public void decreasePower(int pwr) {
        if (power - pwr >= 0) {
            power -= pwr;
            System.out.println(name + ": Moc grzejnika została zmniejszona do: " + power);
        } else {
            System.out.println(name + ": Moc grzejnika nie może być mniejsza niż 0.");
        }
    }
}