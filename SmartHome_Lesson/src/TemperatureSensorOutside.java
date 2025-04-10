public class TemperatureSensorOutside {
    double temp;

    TemperatureSensorOutside(){
        int max = 17;
        int min = 5;
        int range = max - min + 1;

        double tmp1 = (double) (Math.random()*range)+min;
        temp = tmp1;

        System.out.printf("Wartość losowa: " + "%.1f%n", tmp1);
        System.out.printf("Aktualna temperatura na zewnątrz: " + "%.1f%n", temp);
    }
}
