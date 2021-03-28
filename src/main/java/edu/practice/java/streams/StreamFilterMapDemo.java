package edu.practice.java.streams;

import edu.practice.java.model.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * filter() method is an intermediate operation of the Stream interface
 * that allows us to filter elements of a stream that match a given Predicate
 * i.e it always returns the boolean value. If it returns true, the item is added to list else it is filtered out (ignored)
 * filter(<functionalInterface>) or filter(<lambda exp>)
 */
public class StreamFilterMapDemo {

  public static void main(String[] args) {

    Customer john = new Customer("John P.", 15);
    Customer sarah = new Customer("Sarah M.", 200);
    Customer charles = new Customer("Charles B.", 150);
    Customer mary = new Customer("Mary T.", 1);

    List<Customer> customers = Arrays.asList(john, sarah, charles, mary);

    //1. Filtering Collections
    //using lambda exp
    List<Customer> customersWithMoreThan100Points1 = customers
      .stream()
      .filter(c -> c.getPoints() > 100)
      .collect(Collectors.toList());

    //using method reference
    List<Customer> customersWithMoreThan100Points2 = customers
      .stream()
      .filter(Customer::hasOverHundredPoints)
      .collect(Collectors.toList());

    //using predicate(functional interface)
    Predicate<? super Customer> moreThan100 = x -> x.getPoints() > 100;
    List<Customer> customersWithMoreThan100Points3 = customers
      .stream()
      .filter(moreThan100)
      .collect(Collectors.toList());

    //2. Filtering Collections with Multiple Criteria
    List<Customer> charlesWithMoreThan100Points = customers
      .stream()
      .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Charles"))
      .collect(Collectors.toList());

    //3. Filter with predicates that throw an exception - wrapping it with a try-catch block
    List<Customer> customersHasValidPoints = customers
      .stream()
      .filter(c -> {
        try {
          c.hasValidPoints();
        } catch (Exception e) {
          //handle exception
          return true;
        }
        return false;
      })
      .collect(Collectors.toList());

    //before java 8
    List<Customer> result = new ArrayList<>();
    for (Customer c : customers) { // loop -> stream
      if (c.getPoints() > 100 && c.getName().startsWith("Charles")) { // condition -> filter
        result.add(c); // list -> collect
      }
    }

    // .findAny().orElse (null) to return an object conditional
    Customer resCharles1 = customers.stream()
      .filter(c -> "Charles".equals(c.getName()))
      .findAny()
      .orElse(null);

    // .map() to return a String object
    String resCharles2 = customers.stream()
      .filter(c -> "Charles".equals(c.getName()))
      .map(Customer::getName)      //convert stream to String
      .findAny()
      .orElse("");

    // .map() to return a List<String> objects
    List<String> collect = customers.stream()
      .map(Customer::getName)
      .collect(Collectors.toList());
    collect.forEach(System.out::println);

  }
}
