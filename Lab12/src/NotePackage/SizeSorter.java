package NotePackage;

import java.util.Comparator;

public class SizeSorter implements Comparator<Note>{
    public int compare(Note n1, Note n2) {
        return n1.toString().length() - n2.toString().length();
    }
}
