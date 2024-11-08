public class Customer implements Comparable<Customer>{
    private String firstName, lastName;
    private int rating;
    private double balance;
    private RatingType ratingType;

    public Customer(String firstName, String lastName, int rating, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.balance = balance;
        // Set ratingType here:
        if (rating >= 0 && rating <= 3) {
            this.ratingType = RatingType.LOW;
        } else if (rating >= 4 && rating <= 7) {
            this.ratingType = RatingType.MEDIUM;
        } else if (rating >= 8 && rating <= 10) {
            this.ratingType = RatingType.HIGH;
        } else {
            // throw new IllegalArgumentException("Rating must be between 0 and 10.");
        }

    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getRating() { return rating; }
    public double getBalance() { return balance; }
    // Your getter goes here:

    @Override
    public String toString() {
        return "firstName= " + firstName + " "
                + "lastName= " + lastName + " "
                + "rating= " + rating + " "
                + "balance =" + balance;
                // Add ratingType here:
    }

    @Override
    public int compareTo(Customer customer) {
        // Add comparison here
        return this.rating - customer.getRating();
    }
}
