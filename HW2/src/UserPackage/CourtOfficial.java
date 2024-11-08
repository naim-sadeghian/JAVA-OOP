package UserPackage;

public class CourtOfficial extends User {
    String title;

    public String gettitle() { return title; }
    public void settitle(String title) { this.title = title; }

    @Override
    public String toString(){
        return "CourtOfficial\n" + super.toString() + "- title: " + title;
        
    }
    public CourtOfficial(int id, String userName, String title) {
        super(id, userName);
        this.title = title;
    }

    
}