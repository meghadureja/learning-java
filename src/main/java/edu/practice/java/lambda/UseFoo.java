package edu.practice.java.lambda;

import java.util.function.Function;

public class UseFoo {

  public String add(String string, Foo foo) {
    return foo.method(string);
  }

  /**
   * you can remove interface Foo completely in above method and change your code to
   * @param string
   * @param fn
   * @return
   */
  public String add(String string, Function<String, String> fn) {
    return fn.apply(string);
  }
}
