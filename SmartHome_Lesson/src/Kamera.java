public class Kamera {
    private boolean czy_wlaczona = false;
    private String tryb = "Normalny";

    void wlacz(boolean stan){
        this.czy_wlaczona = stan;
    }
    void stan(){
        if(czy_wlaczona){
            System.out.println("Kamera: włączona");
        }
        else {
            System.out.println("Kamera: wyłączona");
        }
        System.out.println("Tryb kamery: "+this.tryb);
    }
    void zmien_tryb(String nowy_tryb){
        this.tryb = nowy_tryb;
        System.out.println("Tryb pracy kamery został pomyślnie zmieniony na: "+this.tryb);
    }
}
