package function;

import java.util.function.Function;

public class FunctionClass {

  // TODO import java.util.function.Function; -> transform the input into an output (types can be diff.)

  public static void main(String[] args) {

    // Function<T, R> is a functional interface i.e. one abstract method:
    //      R apply(T t)
    // I don't need to create a custom interface
    Function<String, Integer> function = s -> s.length();
    System.out.println("The length of the string is: " + function.apply("abc"));
  }
}
