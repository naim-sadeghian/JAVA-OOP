package NotePackage;

public class NoteDisplayer {
    // Basic display
    public static void displayNote(Note note){
        System.out.println(note);
    }

    // new display
    public static void displayNoteFancy(Note note){
        StringBuilder sb = new StringBuilder();
        sb.append("*****************************\n");
        sb.append("* Number: ").append( String.format("%-19s", note.getNoteNumber()) ).append("*\n");
        sb.append("* Name  : ").append( String.format("%-19s", note.getName()) ).append("*\n");
        sb.append("* From  : ").append( String.format("%-19s", note.getFrom()) ).append("*\n");
        sb.append("* To    : ").append( String.format("%-19s", note.getTo()) ).append("*\n");
        sb.append("*****************************\n");


        if ( note instanceof TimedMemo ) {
            sb.append("* Date: ").append( ((TimedMemo) note).getToday() ).append("\n"); //Downcast
        }
        sb.append("*\n");
        sb.append("* Body:\n");
        sb.append( note.getBody() );

        System.out.println( sb.toString() );
    }

    public static void displayErrorMessage(String errorMessage) {
        System.err.println("*************( Error )****************");
        System.err.println(errorMessage);
    }
}
