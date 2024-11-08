package UserPackage;

public abstract class User {
    int id;
    String userName;

    public int getId() { return id; }
    public String getUserName() { return userName; }
    public void setId(int id) { this.id = id; }
    public void setUserName(String userName) { this.userName = userName; }
    
    @Override
    public String toString() {
        return "- id: " + id + "\n- userName: " + userName + "\n";
    }

    public User(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }
    
    
}
