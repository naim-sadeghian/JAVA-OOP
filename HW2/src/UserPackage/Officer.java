package UserPackage;

public class Officer extends User {
    String rank;

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    @Override
    public String toString(){
        return "Officer\n" + super.toString() + "- Rank: " + rank;
        
    }
    public Officer(int id, String userName, String rank) {
        super(id, userName);
        this.rank = rank;
    }

    
}
