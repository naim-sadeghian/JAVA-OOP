public class PoliteTimedMemo extends TimedMemo {
    protected final String DEFAULT_GREETING ;
    protected final String DEFAULT_CLOSING ;

    public PoliteTimedMemo(String name, String body, String from, String to) {
        super(name, body, from, to);
        this.today = java.time.LocalDate.now( ).toString();
        this.DEFAULT_GREETING = "Dear";
        this.DEFAULT_CLOSING = "Yours truly,";
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //Start with parents string
        sb.append("Date: ").append(today); //Add date on top
        sb.append("Name: ").append(name).append("\n");
        sb.append(DEFAULT_GREETING).append(" ").append(to).append(":\n");
        sb.append(body);
        sb.append(DEFAULT_CLOSING).append("\n");
        sb.append(from).append("\n");
        sb.append("Note# ").append(noteNumber).append("\n");
        sb.append(FOOTER).append("\n");

        return sb.toString();
    }
}
