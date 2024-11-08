public class TimedMemo extends Memo {

    protected String today;

    public TimedMemo(String name, String body, String from, String to) {
        super(name, body, from, to);
        this.today = java.time.LocalDate.now( ).toString();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //Start with parents string
        sb.append("Date: ").append(today); //Add date on top
        sb.append( super.toString() ); //Add parents string

        return sb.toString();
    }

}
