public class YearPop {
    int year;
    double pop;

    public YearPop(int year, double pop) {
        this.pop = pop;
        this.year = year;
    }

    public int getYear() {
        return year;
    }
    public double getPop() {
        return pop;
    }

    public static YearPop makeData(String line) {
        String[] values = line.split(",");
        return new YearPop( Integer.parseInt( values[0] ) , Double.parseDouble( values[1] ) );
        
    }
    
}
