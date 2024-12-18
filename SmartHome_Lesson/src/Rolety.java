
public class Rolety {
    float stopienWysuniecia = 0.00f;

    void wysun(double wys){
        if(wys>1){
            wys = 1;
        }
        stopienWysuniecia = (float) Math.round(wys*1000)/1000;
        System.out.println("Rolety wysunięte w " + stopienWysuniecia*100 + "%.");
    }
}