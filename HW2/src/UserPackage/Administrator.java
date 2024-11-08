package UserPackage;

public class Administrator extends User {
    String department;

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString(){
        return "Admin\n" + super.toString() + "- Department: " + department;
        
    }
    public Administrator(int id, String userName, String department) {
        super(id, userName);
        this.department = department;
    }

    
}
