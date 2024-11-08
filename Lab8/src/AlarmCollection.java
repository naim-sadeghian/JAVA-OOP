import java.util.ArrayList;

public class AlarmCollection {
private ArrayList<Alarm> alarms;

    public AlarmCollection() {
        this.alarms = new ArrayList<>();
    }

    public void add(Alarm s) {
        this.alarms.add(s);
    }

    public void display() {
        for (Alarm alarm: this.alarms) {
            System.out.println(alarm);
        }
    }

    
}
