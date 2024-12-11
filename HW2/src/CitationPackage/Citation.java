package CitationPackage;

public class Citation implements Comparable<Citation>{
    String typeOfOffense; //"Parking", "Speeding", "Jaywalking", and "Inebriated"
    String description;
    int number; //ID
    String date;
    Person person;
    int userID;

    
    public int getUserID() { return userID; }
    public String getTypeOfOffense() { return typeOfOffense; }
    public String getDescription() { return description; }
    public String getDate() { return date; }
    public int getNumber() { return number; }
    public Person getPerson() { return person; }

    public void setDescription(String description) { this.description = description; }
    public void setNumber(int number) { this.number = number; }
    public void setDate(String date) { this.date = date; }
    public void setPerson(Person person) { this.person = person; }
    public void setTypeOfOffense(String typeOfOffense) { this.typeOfOffense = typeOfOffense; }
    public void setUserID(int userID) { this.userID = userID; }

    public String toString(boolean printPerson) {
        StringBuilder sb = new StringBuilder();
        sb.append("Citation #").append(number);
        sb.append("\nType of offense: ").append(typeOfOffense);
        sb.append("\nDescription: ").append(description);
        sb.append("\nDate: ").append(date);
        if (printPerson) sb.append("\n").append(person);
        sb.append("\nUser ID: ").append(userID);
        sb.append("\n\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return toString(false); // Default to not include the person
    }
    
    public Citation(int number, String typeOfOffense, String description, String date, Person person, int userID) {
        this.typeOfOffense = typeOfOffense;
        this.description = description;
        this.number = number;
        this.date = date;
        this.person = person;
        this.userID = userID;
    }

    public Citation() {
        this.person = new Person();
    }

    /**
     * Transforms data to comma separeted string for writing to CSV file
     * @return
     */
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb.append(",").append(typeOfOffense);
        sb.append(",").append(description);
        sb.append(",").append(date);
        sb.append(",").append(person.toCSV());
        sb.append(",").append(userID);
        return sb.toString();
    }

    @Override
    public int compareTo(Citation cit) {
        return this.number - cit.getNumber();
    }
    
}
