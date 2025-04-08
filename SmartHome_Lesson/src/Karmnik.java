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
        System.out.println(name + ": Karmnik czeka na właściwą godzinę...");
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void turnOff() {
        super.turnOff();
        if (thread != null) thread.interrupt();
        System.out.println(name + ": Karmnik został zatrzymany.");
    }

    @Override
    public void showStatus() {
        System.out.println(name + " | Stan: " + (isOn ? "Czeka na karmienie" : "Nieaktywny") +
                " | Zaplanowano na: " + String.format("%02d:%02d", godzina, minuty));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                if ((Clock.getGodzina() == godzina) &&
                        (Math.abs(Clock.getMinuty() - minuty) <= 10)) {

                    System.out.println(name + ": 🐦 Karmnik został aktywowany!");
                    break;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + ": ❌ Karmnik przerwany.");
        }
    }
}