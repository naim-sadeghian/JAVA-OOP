package CitationPackage;
import java.util.Comparator;


public class TypeSorter implements Comparator<Citation> {
    @Override
    public int compare(Citation c1, Citation c2) {
        // First compare by movieName
        return c1.getTypeOfOffense().compareTo( c2.getTypeOfOffense() );
        
    }
}
