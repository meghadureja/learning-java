package edu.practice.java.comparisons;

/**
 * When your class implements Comparable, the compareTo method of the class is defining the "natural" ordering of that object.
 * For example, Strings are generally compared alphabetically. Thus the "a".compareTo("b") would use alphabetical comparisons.
 * If you want to compare Strings on length, you would need to write a custom comparator.
 */
public class Author implements Comparable<Author> {

    protected String firstName;
    protected String lastName;
    protected String bookName;

    Author(String first, String last, String book){
        this.firstName = first;
        this.lastName = last;
        this.bookName = book;
    }

    /**
     * This is where we write the logic to sort
     * automatically by the first name in case that the last name is the same
     * @param o
     * @return
     */
    @Override
    public int compareTo(Author o) {
        //Sorting by last name
        //== 0 -> both are equal,
        //> 0 -> this > greater than o,
        //< 0 -> this < lesser than o,
        int last = this.lastName.compareTo(o.lastName);
        int first = this.firstName.compareTo(o.firstName);
        return last == 0 ? first : last;
//        return 0;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
