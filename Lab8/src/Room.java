

public class Room {
    private double length, width;
    private String name;
    private int id;
    private SensorCollection sensors;
    private  AlarmCollection alarms;
    private Device device;

    public Room() {
        this.length = 0.0;
        this.width = 0.0;
        this.name = "";
        this.id = 0;
        this.sensors = new SensorCollection();
        this.alarms = new AlarmCollection();

    }

    public Room(double length, double width, String name, int id) {
        this.length = length;
        this.width = width;
        this.name = name;
        this.id = id;
        this.sensors = new SensorCollection();
        this.alarms = new AlarmCollection();
    }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public void addSensor(Sensor s) {
        sensors.add(s);
    }

    public void addAlarm(Alarm a) {
        alarms.add(a);
    }

    public void addDevice(Device d) {
        this.device = d;
    }

    @Override
    public String toString() {
        return "Room{" +
                "length=" + length +
                ", width=" + width +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public void display() {
        System.out.println(this);
        System.out.println(this.device);
        sensors.display();
        alarms.display();
    }

    public double getArea( ) {
        return length*width;
    }
}
