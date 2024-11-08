public class Alarm {
    String message;
    int id;

    public void soundTheAlarm() {
        System.out.println(message);
        System.out.println("Hello? There is an emergency!");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alarm(String message, int id) {
        this.message = message;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Alarm [message=" + message + ", id=" + id + "]";
    }
}
