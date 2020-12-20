package edu.practice.java.comparisons;

import java.util.Comparator;

public class SortByNameComparator implements Comparator<Developer> {

    @Override
    public int compare(Developer o1, Developer o2) {
        //used for sorting in ascending order of name
        return o1.name.compareTo(o2.name);
//        return 0;
    }
}
