public class Rolety extends SmartDevice {
    private float stopienWysuniecia = 0.0f; // 0.0 (schowane) – 1.0 (całkowicie wysunięte)

    public Rolety(String name) {
        super(name);
    }

    public void wysun(double wys) {
        if (wys < 0) wys = 0;
        if (wys > 1) wys = 1;

        stopienWysuniecia = (float) Math.round(wys * 1000) / 1000;
        isOn = stopienWysuniecia > 0; 

        System.out.println(name + ": Rolety wysunięte w " + (int)(stopienWysuniecia * 100) + "%.");
    }

    @Override
    public void showStatus() {
        String stan = stopienWysuniecia == 0.0f ? "Całkowicie schowane" :
                stopienWysuniecia == 1.0f ? "Całkowicie wysunięte" :
                        "Wysunięcie: " + (int)(stopienWysuniecia * 100) + "%";

        System.out.println(name + " | Stan: " + stan);
    }
}