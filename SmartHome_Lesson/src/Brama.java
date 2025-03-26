public class Brama {
    private boolean blokada = true;
    private String pass = "adminadmin";
    void odblokuj(String pass){
        if(this.pass.equals(pass)){
            blokada = false;
            System.out.println("Brama została odblokowana!");
        }else {
            System.out.println("Niepoprawne hasło - stan pozostanie nie zmieniony");
        }
    }
    void zablokuj(){
        blokada = true;
        System.out.println("Brama została zablokowana");
    }
    void stan(){
        if(this.blokada){
            System.out.println("Brama jest zablokowana");
        }
        else{
            System.out.println("Brama jest odblokowana");
        }
        System.out.println("Brama posiada "+ this.pass.length() +" znakowe hasło.");
    }
    void zmien_haslo(String nowe_haslo){
        this.pass = nowe_haslo;
        System.out.println("Hasło zostało pomyślnie zmienione!");
        System.out.println("Nowe hasło to: "+this.pass);
    }
}
