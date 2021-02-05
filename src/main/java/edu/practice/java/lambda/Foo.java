package edu.practice.java.lambda;

/**
 * Foo is nothing more than a function that accepts one argument and produces a result
 * Even without @FunctionalInterface, your interface will be treated as functional as long as it has just one abstract method
 * We can easily add default methods to the functional interface
 */
@FunctionalInterface
public interface Foo {

  String method(String string);
  default void defaultMethod() {}
}
