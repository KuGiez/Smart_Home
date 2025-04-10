import javax.swing.*;

public class Kamera extends SmartDevice {
    private String tryb = "Normalny";
    private String rozdzielczosc = "1920x1080";
    private boolean trybNocny = false;
    private int fps = 30;

    public Kamera(String name) {
        super(name);
    }

    // Zmieniamy tryb kamery (np. "Normalny", "Nocny")
    public void zmienTryb(String nowyTryb) {
        this.tryb = nowyTryb;
        showMessage(name + ": Tryb pracy został zmieniony na: " + this.tryb);
    }

    // Pomocnicza metoda do pokazania wiadomości
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    // Pomocnicza metoda do pokazania wiadomości z tytułem i typem
    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

    // Pomocnicza metoda do pobierania wartości od użytkownika
    private String getInput(String message, String defaultValue) {
        return JOptionPane.showInputDialog(null, message, defaultValue);
    }

    // Metoda do konfiguracji kamery, umożliwia zmianę rozdzielczości, trybu nocnego i FPS
    public void konfiguruj() {
        String nowaRozdzielczosc = getInput("Podaj rozdzielczość (np. 1920x1080):", rozdzielczosc);
        int trybNocnyOption = showNightModeDialog();
        String fpsInput = getInput("Podaj liczbę klatek na sekundę (FPS):", String.valueOf(fps));

        if (nowaRozdzielczosc != null && !fpsInput.isEmpty()) {
            try {
                this.rozdzielczosc = nowaRozdzielczosc;
                this.trybNocny = trybNocnyOption == 0;
                this.fps = Integer.parseInt(fpsInput);
                showMessage(name + ": Konfiguracja zaktualizowana.");
            } catch (NumberFormatException e) {
                showMessage("Niepoprawna wartość FPS!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Metoda pomocnicza do wyświetlania okna z trybem nocnym
    private int showNightModeDialog() {
        String[] opcje = {"Tak", "Nie"};
        return JOptionPane.showOptionDialog(null, "Tryb nocny?", "Konfiguracja kamery",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcje, opcje[trybNocny ? 0 : 1]);
    }

    // Ustawienie FPS
    public void setFps(int fps) {
        this.fps = fps;
        showMessage(name + ": FPS zostało ustawione na: " + this.fps);
    }

    // Dodatkowe metody do włączania/wyłączania trybu nocnego oraz zmiany rozdzielczości
    public void zmienRozdzielczosc(String nowaRozdzielczosc) {
        this.rozdzielczosc = nowaRozdzielczosc;
        showMessage(name + ": Rozdzielczość została zmieniona na: " + this.rozdzielczosc);
    }

    public void wlaczTrybNocny() {
        this.trybNocny = true;
        showMessage(name + ": Tryb nocny został włączony.");
    }

    public void wylaczTrybNocny() {
        this.trybNocny = false;
        showMessage(name + ": Tryb nocny został wyłączony.");
    }

    @Override
    public void turnOn() {
        super.turnOn();
        showMessage(name + ": Kamera została włączona.");
    }

    @Override
    public void turnOff() {
        super.turnOff();
        showMessage(name + ": Kamera została wyłączona.");
    }

    @Override
    public void showStatus() {
        showMessage(name + " | Stan: " + (isOn ? "Włączona" : "Wyłączona") +
                " | Tryb: " + tryb +
                " | Rozdzielczość: " + rozdzielczosc +
                " | Tryb nocny: " + (trybNocny ? "Tak" : "Nie") +
                " | FPS: " + fps);
    }

    // Gettery dla trybu, rozdzielczości, trybu nocnego i FPS
    public String getTryb() {
        return tryb;
    }

    public String getRozdzielczosc() {
        return rozdzielczosc;
    }

    public boolean isTrybNocny() {
        return trybNocny;
    }

    public int getFps() {
        return fps;
    }
}
