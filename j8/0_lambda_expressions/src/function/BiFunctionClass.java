package function;

import java.util.function.BiFunction;

public class BiFunctionClass {

  // TODO import java.util.function.BiFunction; -> transform the input into an output (types can be diff.)

  public static void main(String[] args) {

    // BiFunction<T, U, R> is a functional interface i.e. one abstract method:
    //      R apply(T t, U u)
    // I don't need to create a custom interface
    BiFunction<String, String, Integer> function = (t, u) -> t.length() + u.length();
    System.out.println("BiFunction total length: " + function.apply("hello", "world"));

    BiFunction<String, String, String> function2 = (t, u) -> t.concat(u);
    System.out.println("BiFunction concat: " + function2.apply("hello ", "world"));
  }
}
