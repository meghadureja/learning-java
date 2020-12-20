package edu.practice.java.comparisons;

import java.util.Comparator;

/**
 * Comparator provides a way for you to provide custom comparison logic for types that you have no control over a class
 * (or you want to provide multiple ways to compare objects that you do have control over) then use Comparator.
 * Otherwise you can use Comparable.
 */
public class SortByAgeAscComparator implements Comparator<Developer> {

    @Override
    public int compare(Developer o1, Developer o2) {
        //used for sorting in ascending order of age
        return o1.age - o2.age;
    }
}
