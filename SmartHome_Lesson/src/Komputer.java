import java.util.Objects;
import java.util.Scanner;
public class Komputer {
    boolean czyuruchomiony = false;
    Scanner zapytaj = new Scanner(System.in);

    void uruchom(boolean u) {
        czyuruchomiony = u;
        if (czyuruchomiony) {
            System.out.println("Komputer został uruchomiony.");
        } else {
            System.out.println("Komputer został zamknięty.");
        }
    }
    void instaluj(String program){
        System.out.println("Przeszukuję bazę danych...");
        System.out.println("Znaleziono " + program + "-install.exe");
        System.out.println("Czy chcesz go zainstalować? T/N");
        String odpowiedz = zapytaj.nextLine();
        System.out.println(odpowiedz);
        if (Objects.equals(odpowiedz, "T") || Objects.equals(odpowiedz, "t")){
            System.out.println("Instaluję...");
            System.out.println("Instalacja programu " + program + " powiodła się!");
        }
        else {
            System.out.println("Anulowanie instalacji...");
            System.out.println("Instalacja została anulowana!");
        }
    }
}