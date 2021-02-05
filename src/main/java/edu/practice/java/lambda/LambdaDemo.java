package edu.practice.java.lambda;

import edu.practice.java.helper.MockHelper;
import edu.practice.java.service.MockService;

import java.util.function.Function;

/**
 * Lambda - is a function that expects and accepts input parameters and produce output results
 * - is use to instantiate functional interface (single abstract method interfaces) and avoid using bulky anonymous class implementation
 * - () -> { body } OR (argument) -> { body } OR (argument1, argument2, ..) -> { body }
 */
public class LambdaDemo {

  public static void main(String[] args) {

    UseFoo useFoo = new UseFoo();
    Foo foo = parameter -> parameter + " from lambda Foo";
    String result1 = useFoo.add("Message ", foo); //functional interfaces as parameters
    System.out.println(result1);

    //OR
    Function<String, String> fn = parameter -> parameter + " from lambda Fn"; // use interface Function<T,R> instead of above
    String result2 = useFoo.add("Message ", fn);
    System.out.println(result2);

    //OR - use an inner class to instantiate a functional interface
    Foo fooByIC = new Foo() {
      @Override
      public String method(String string) {
        return string + " from Foo";
      }
    };

    // ****** Real life example ******
    // 1. service api call using functional interface
    Foo apiCall = gcgId -> {
      //api call
      MockService service = new MockService();
      return service.mockMethod(gcgId);
    };
    //execute above functional interface
    String result3 = useFoo.add("1234", apiCall);
    System.out.println(result3);

    //2. avoid blocks of code in lambda's body
    Foo foo2 = parameter -> buildString(parameter);
    String result4 = foo2.method("O");
    System.out.println(result4);

    //3. use method references
    Foo foo3 = LambdaDemo::buildString;
    String result5 = foo3.method("X");
    System.out.println(result5);

    //4. use service api method reference
    MockService mockService = new MockService();
    Foo foo4 = mockService::mockMethod;
    String result6 = foo4.method("12345");
    System.out.println(result6);

    //5. use helper method reference
    Foo foo5 = MockHelper::mockMethod;
    String result7 = foo5.method("123456");
    System.out.println(result7);

  }

  /**
   * definition of Foo method() and creating instance
   * @param parameter
   * @return
   */
  private static String buildString(String parameter) {
    String result = "Something " + parameter;
    //many lines of code
    return result;
  }

}
