abstract class Note {
    protected String name; //note name
    protected String body; 
    protected static int noteCount; // # of notes created
    protected int noteNumber; //ID
    protected static final String FOOTER = "***** Powered by Make-a-Note *****";

    
    public Note() {
        this.name = "";
        this.body = "";
        Note.noteCount += 1;
        this.noteNumber = Note.noteCount;
    }

    public Note(String name, String body) {
        this.name = name;
        this.body = body;
        Note.noteCount += 1;
        this.noteNumber = Note.noteCount;

    }

    public int getNoteNumber() {
        return noteNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Body: ").append(body).append("\n");
        sb.append("Note# ").append(noteNumber).append("\n");
        sb.append(FOOTER).append("\n");

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    
    
}
