public class Heating {
    double tmpOut;
    double tmpIn;
    int power=0;

    Heating(TemperatureSensorOutside tmpOut, TemperatureSensorInside tmpIn){
        this.tmpIn = tmpIn.tmpInside;
        this.tmpOut = tmpOut.temp;
        System.out.println("Moc grzejnika przed zmianą: "+power);
    }

    void changeHeating(){
        if(tmpIn>20){
            power +=2;
            System.out.println("Z powodu spadku temperatury wewnątrz zwiększono moc ogrzewania do: "+power);
        }
        else{
            System.out.println("Temperatura na zewnątrz nie jest zbyt niska, nie zwiększono mocy ogrzewania");
        }
    }

    void increasePower(int pwr){
        power += pwr;
        System.out.println("Moc grzejnika po zmianie: "+power);
    }

    void decreasePower(int pwr){
        power -= pwr;
        System.out.println("Moc grzejnika po zmianie: "+power);
    }
}
