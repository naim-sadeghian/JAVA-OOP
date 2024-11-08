import java.util.ArrayList;

public class SensorCollection {
    private ArrayList<Sensor> sensors;

    public void add(Sensor s) {
        sensors.add(s);
    }

    public void display() {
        for (Sensor sensor: sensors) {
            System.out.println(sensor);
        }
    }

    public SensorCollection() {
        this.sensors = new ArrayList<>();
    }
}
