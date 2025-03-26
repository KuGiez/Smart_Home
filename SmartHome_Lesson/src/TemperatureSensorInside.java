public class TemperatureSensorInside {
    double tmpOut;
    double tmpInside = 20;

    TemperatureSensorInside(TemperatureSensorOutside tmp){
        tmpOut = tmp.temp;
        if(tmpOut>15){
            tmpInside -=2;
            System.out.println("Aktualna temp. wewnątrz spowodowana spadkiem temp. na zewnątrz: "+tmpInside);
        }
    }
}
