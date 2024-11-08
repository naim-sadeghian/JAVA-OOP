package NotePackage;

import java.util.ArrayList;
import java.util.Collections;

public class NoteCollection {
    private ArrayList<Note> noteList;

    public NoteCollection() {
        this.noteList = new ArrayList<>();
    }

    public void add(Note note) {
        noteList.add(note);
    }
    
    public ArrayList<Note> getAllNotes() {
        return noteList;
    }

    public Note getNoteByNumber(int num) {
        for (Note note: noteList) {
            if (note.getNoteNumber() == num) {
                return note;
            }
        }
        return null;
    }

    public ArrayList<Note> getNoteByName(String name) {
        ArrayList<Note> newList = new ArrayList<Note>();
        for (Note note: noteList) {
            if ( note.getName().equals(name) ) {
                newList.add(note);
            }
        }
        return newList;
    }

    public void sortByName(){
        Collections.sort(noteList);
    }

    public void sortByNumber(){
        Collections.sort(noteList, new NumberSorter());
    }

    public void sortBySize(){
        Collections.sort(noteList, new SizeSorter());
    }

    /*
     * Types: 
     * 1) Memo
     * 2) Timed
     * 3) Polite
     */
    public static Note createNote(int type, String name, String body, String from, String to) {
        Note ans;
        switch (type) {
            case 1:
                ans = new Memo(name, body, from, to);
                break;
            case 2:
                ans = new TimedMemo(name, body, from, to);
                break;
            case 3:
                PoliteTimedMemo.Builder b = new PoliteTimedMemo.Builder();
                b.setBody(body);
                b.setName(name);
                b.setFrom(from);
                b.setTo(to);
                ans = b.build();
                // ans = new PoliteTimedMemo(name, body, from, to);
                break;
            default:
                NoteDisplayer.displayErrorMessage("Wrong type, creating memo");
                ans = new Memo(name, body, from, to);
                break;
        }
        return ans;
    }
}
