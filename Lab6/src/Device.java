public class Device {
    String type, location;
    int ind;


    public Device(String type, String location, int ind) {
        this.type = type;
        this.location = location;
        this.ind = ind;
    }
    
    public void actuate() {
        System.out.println( this.toString().toUpperCase() );
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Device{");
        sb.append("type=").append(type);
        sb.append(", location=").append(location);
        sb.append(", ind=").append(ind);
        sb.append('}');
        return sb.toString();
    }

    

}
