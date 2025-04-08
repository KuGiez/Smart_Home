public class Brama extends SmartDevice {
    private boolean blokada = true;
    private String pass = "adminadmin";

    public Brama(String name) {
        super(name);  // Przekazanie nazwy urządzenia do klasy bazowej
    }
    public void odblokuj(String pass) {
        if (this.pass.equals(pass)) {
            blokada = false;
            System.out.println(name + ": Brama została odblokowana!");
        } else {
            System.out.println(name + ": Niepoprawne hasło - stan pozostanie niezmieniony.");
        }
    }
    public void zablokuj() {
        blokada = true;
        System.out.println(name + ": Brama została zablokowana.");
    }
    public void zmienHaslo(String noweHaslo) {
        this.pass = noweHaslo;
        System.out.println(name + ": Hasło zostało pomyślnie zmienione!");
        System.out.println(name + ": Nowe hasło to: " + this.pass);
    }
    @Override
    public void showStatus() {
        System.out.println(name + ": Brama jest " + (blokada ? "zablokowana" : "odblokowana"));
        System.out.println(name + ": Brama posiada " + this.pass.length() + " znakowe hasło.");
    }
    public boolean isBlokada() {
        return blokada;
    }
}
