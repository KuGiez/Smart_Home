public class Light {
    boolean czyzapalone = false;

    void zapal(boolean z){
        czyzapalone = z;
        if (czyzapalone){
            System.out.println("Światło zostało zapalone.");
        }
        else {
            System.out.println("Światło zostało zgaszone.");
        }
    }
}
