package edu.practice.java.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFlatMapDemo {
    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("a", "b", "c", "d");
        System.out.println("before map operation:: " + list1);

        List<String> mapList = list1.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("after map operation:: " + mapList);
        //map() works pretty well in such a simple case, but what if we have something more complex such as a list of lists as an input

        //flatMap() is then used to flatten a Stream of collections to a stream of objects (List of Lists -> List)
        List<List<String>> list2 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"));
        System.out.println("before flattening:: " + list2);

        List<String> flatMapList = list2.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("after flattening:: " + flatMapList);

        //Example 1
        List<String> listOfStrings = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");
        listOfStrings.stream()
                .flatMap(str -> Stream.of(str.charAt(2))) // mapping string with character at position 2.
                .forEach(System.out::println);

        //Example 2
        List<Order> orders = findAll();
        // sum the line items' total amount
        BigDecimal sumOfLineItems = orders.stream()
                .flatMap(order -> order.getLineItems().stream()) //Stream<LineItem>
                .map(lineItem -> lineItem.getTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add); //reduce to sum all
        // sum the order's total amount
        BigDecimal sumOfOrder = orders.stream()
                .map(order -> order.getTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add); //reduce to sum all
        System.out.println(sumOfLineItems);
        System.out.println(sumOfOrder);
        //collect, reduce
        //map, flatmap
        //filter
        //By using map, you transform the object values.
        //The map operation allows us to apply a function, that takes in a parameter of one type, and returns something else.
        //Filter is used for filtering the data, it always returns the boolean value. If it returns true, the item is added to list
        // else it is filtered out (ignored) for eg
        //List<Person> persons = Stream<Person> personsOver18 = persons.stream().filter(p -> p.getAge() > 18)
    }

    // create dummy records
    private static List<Order> findAll() {

        LineItem item1 = new LineItem(1, "apple", 1, new BigDecimal("1.20"), new BigDecimal("1.20"));
        LineItem item2 = new LineItem(2, "orange", 2, new BigDecimal(".50"), new BigDecimal("1.00"));
        Order order1 = new Order(1, "A0000001", Arrays.asList(item1, item2), new BigDecimal("2.20"));

        LineItem item3 = new LineItem(3, "monitor BenQ", 5, new BigDecimal("99.00"), new BigDecimal("495.00"));
        LineItem item4 = new LineItem(4, "monitor LG", 10, new BigDecimal("120.00"), new BigDecimal("1200.00"));
        Order order2 = new Order(2, "A0000002", Arrays.asList(item3, item4), new BigDecimal("1695.00"));

        LineItem item5 = new LineItem(5, "One Plus 8T", 3, new BigDecimal("499.00"), new BigDecimal("1497.00"));
        Order order3 = new Order(3, "A0000003", Arrays.asList(item5), new BigDecimal("1497.00"));

        return Arrays.asList(order1, order2, order3);
    }
}
