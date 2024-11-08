public class Citation {
    String typeOfOffense; //"Parking", "Speeding", "Jaywalking", and "Inebriated"
    String description;
    int number; //ID
    String date;
    Person person;

    
    public String getTypeOfOffense() {
        return typeOfOffense;
    }
    public void setTypeOfOffense(String typeOfOffense) {
        this.typeOfOffense = typeOfOffense;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public String toString(boolean printPerson) {
        StringBuilder sb = new StringBuilder();
        sb.append("Citation #").append(number);
        sb.append("\nType of offense: ").append(typeOfOffense);
        sb.append("\nDescription: ").append(description);
        sb.append("\nDate: ").append(date);
        if (printPerson) sb.append("\n").append(person);
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return toString(false); // Default to not include the person
    }
    
    public Citation(String typeOfOffense, String description, int number, String date, Person person) {
        this.typeOfOffense = typeOfOffense;
        this.description = description;
        this.number = number;
        this.date = date;
        this.person = person;
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
        return sb.toString();
    }

    
    
}
