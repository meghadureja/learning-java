package edu.practice.java.comparisons;

import java.util.Comparator;

/**
 * Sort collection by more than one field:
 */
public class SortByNameAndAgeComparator implements Comparator<Developer> {

    @Override
    public int compare(Developer o1, Developer o2) {
        //used for sorting in ascending order of name
        int name = o1.getName().compareTo(o2.getName());
        int age = o1.getAge() - o2.getAge();

        // 2-level comparison using if-else block
        if (name == 0) {
            return ((age == 0) ? name : age);
        } else {
            return name;
        }
    }
}
