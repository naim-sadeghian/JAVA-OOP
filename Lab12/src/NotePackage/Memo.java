package NotePackage;

public class Memo extends Note {
    protected String from, to;

    Memo() {
        super();
        this.from = "";
        this.to = "";
    }

    Memo(String name, String body, String from, String to) {
        super(name, body);
        this.from = from;
        this.to = to;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //Start with parents string
        sb.append("From: ").append(from).append("\n");
        sb.append("To: ").append(to).append("\n");
        sb.append( super.toString() ); //Add parents string

        return sb.toString();
    }

    @Override
    public String getTo(){
        return to;
    }

    @Override
    public String getFrom(){
        return from;
    }

}
