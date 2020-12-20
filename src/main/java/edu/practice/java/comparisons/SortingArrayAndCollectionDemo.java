package edu.practice.java.comparisons;

import java.math.BigDecimal;
import java.util.*;

public class SortingArrayAndCollectionDemo {
    public static void main(String[] args) {
        //Wrapper class implements Comparable interface - String, Integer
        int[] arr = {11,55,22,0,89};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); //[0, 11, 22, 55, 89]
        String[] names = {"Jack", "Abdul", "Kyle"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names)); //[Abdul, Jack, Kyle]
        List<String> fruits = new ArrayList();
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Guava");
        fruits.add("Grapes");
        Collections.sort(fruits);
        System.out.println(fruits); //[Apple, Banana, Grapes, Guava, Orange]

        //Sorting Custom object by implementing Comparable interface
        List<Author> al=new ArrayList<>();
        al.add(new Author("Meghan","markle", "Sky Boys"));
        al.add(new Author("Megha","Dureja", "Tropic of Cancer"));
        al.add(new Author("Megha","Arora", "Brown Girl in the Ring"));
        Collections.sort(al);
        for(Author aur:al){
            System.out.print(aur.firstName+" "+ aur.lastName); //[Megha Arora, Megha Dureja, Meghan markle]
        }

        //Sorting Custom object by implementing Comparator interface
        List<Developer> devs=new ArrayList<>();
        devs.add(new Developer("Megha", new BigDecimal("70000"), 30));
        devs.add(new Developer("Neha", new BigDecimal("50000"), 30));
        devs.add(new Developer("Meghan", new BigDecimal("150000"), 40));

        Collections.sort(devs, new SortByAgeAscComparator());
        for(Developer dev:devs){
            System.out.print(dev.name+" "+ dev.age); //[Megha 30, Neha 30, Meghan 40]
        }

        Collections.sort(devs, new SortByAgeDescComparator());
        for(Developer dev:devs){
            System.out.print(dev.name+" "+ dev.age); //[Meghan 40, Megha 30, Neha 30]
        }
        devs.add(new Developer("Meghan", new BigDecimal("150000"), 30));
        Collections.sort(devs, new SortByNameAndAgeComparator());
        for(Developer dev:devs){
            System.out.print(dev.name+" "+ dev.age); //[Megha 30, Meghan 30, Meghan 40, Neha 30]
        }

        // OR - Classic Comparator example - anonymous
        devs.clear();
        devs.add(new Developer("B", new BigDecimal("70000"), 30));
        devs.add(new Developer("Z", new BigDecimal("50000"), 30));
        devs.add(new Developer("A", new BigDecimal("150000"), 40));

        Comparator<Developer> byName = new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(devs, byName);
        for(Developer dev:devs){
            System.out.print(dev.name); //[A B Z]
        }

        //OR - using Java 8 feature

        //1. the List interface is supports the sort method directly, no need to use Collections.sort anymore.
        devs.sort(new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o2.getAge() - o1.getAge();
            }
        });

        //2. sort using Lambda expression
        //2.1
        devs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());
        //2.2
        //lambda, valid, parameter type is optional
        devs.sort((o1, o2)->o1.getAge()-o2.getAge());
        //2.3
        Comparator<Developer> byNameLambda = (Developer o1, Developer o2)->o1.getName().compareTo(o2.getName());
        devs.sort(byNameLambda);

        //print
        //java 8 only, lambda also, to print the List
        devs.forEach((developer)->System.out.println(developer));

        //TreeSet is a set where the elements are sorted
        Set<Author> set = new TreeSet<>();
        set.add(new Author("Megha","Dureja", "Sky Boys"));
        set.add(new Author("Megha","Arora", "Sky Boys"));
        set.add(new Author("Megha","Megha", "Sky Boys"));
        set.forEach((author)->System.out.println(author));
    }
}
