package UserPackage;

public class UserFactory {
    public static User createUser(int id, String userType, String name, String other) {
        User ans = null;
        switch (userType) {
            case "Administrator":
                ans = new Administrator(id, name, other);
                break;
            case "Officer":
                ans = new Officer(id, name, other);
                break;
            case "CourtOfficial":
                ans = new CourtOfficial(id, name, other);
                break;
            default:
                throw new AssertionError();
        }
        return ans;
    }
    
}
