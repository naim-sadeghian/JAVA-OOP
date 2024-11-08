package NotePackage;

import java.util.Comparator;

public class NumberSorter implements Comparator<Note>{
    public int compare(Note n1, Note n2) {
        return n1.getNoteNumber() - n2.getNoteNumber();
    }
}
