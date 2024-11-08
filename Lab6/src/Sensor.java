public class Sensor {
    double minimum, maximum, currentValue, interval;
    String location, type;
    int string;

    public boolean trip() {
        return (currentValue < minimum) || (currentValue > maximum);
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public double getMaximum() {
        return maximum;
    }

    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }

    public Sensor(double minimum, double maximum, double currentValue, double interval, String location, String type,
            int string) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.currentValue = currentValue;
        this.interval = interval;
        this.location = location;
        this.type = type;
        this.string = string;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public double getInterval() {
        return interval;
    }

    public void setInterval(double interval) {
        this.interval = interval;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getString() {
        return string;
    }

    public void setString(int string) {
        this.string = string;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sensor{");
        sb.append("minimum=").append(minimum);
        sb.append(", maximum=").append(maximum);
        sb.append(", currentValue=").append(currentValue);
        sb.append(", interval=").append(interval);
        sb.append(", location=").append(location);
        sb.append(", type=").append(type);
        sb.append(", string=").append(string);
        sb.append('}');
        return sb.toString();
    }
}
