public class Karmnik extends Thread {
    private byte godzina;
    private byte minuty;

    public Karmnik(byte godzina, byte minuty) {
        if (godzina < 0 || godzina >= 24 || minuty < 0 || minuty >= 60) {
            throw new IllegalArgumentException("\n<Karmnik.system> Nieprawidłowe wartości godziny lub minut");
        }
        this.godzina = godzina;
        this.minuty = minuty;
    }

    @Override
    public void run() {
        try {
            while ((Clock.getGodzina() != godzina) || Math.abs(Clock.getMinuty() - minuty) > 10) {
                Thread.sleep(100);
            }
            System.out.println("\n<Karmnik.system> Karmnik włączony");
        } catch (InterruptedException e) {
            System.out.println("\n<Karmnik.system> Przerwano działanie karmnika");
        }
    }
}
