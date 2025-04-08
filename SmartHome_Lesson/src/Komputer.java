import java.util.Objects;
import java.util.Scanner;

public class Komputer extends SmartDevice {
    private Scanner zapytaj = new Scanner(System.in);

    public Komputer(String name) {
        super(name);
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println(name + ": Komputer został uruchomiony.");
        } else {
            System.out.println(name + ": Komputer już był uruchomiony.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println(name + ": Komputer został wyłączony.");
        } else {
            System.out.println(name + ": Komputer już był wyłączony.");
        }
    }

    @Override
    public void showStatus() {
        System.out.println(name + " | Stan: " + (isOn ? "Włączony" : "Wyłączony"));
    }

    public void instaluj(String program) {
        if (!isOn) {
            System.out.println(name + ": Komputer jest wyłączony. Nie można instalować programów.");
            return;
        }

        System.out.println(name + ": Przeszukuję bazę danych...");
        System.out.println(name + ": Znaleziono " + program + "-install.exe");
        System.out.println("Czy chcesz go zainstalować? T/N");

        String odpowiedz = zapytaj.nextLine();
        if (Objects.equals(odpowiedz.toUpperCase(), "T")) {
            System.out.println(name + ": Instaluję...");
            System.out.println(name + ": Instalacja programu " + program + " powiodła się!");
        } else {
            System.out.println(name + ": Instalacja została anulowana.");
        }
    }
}