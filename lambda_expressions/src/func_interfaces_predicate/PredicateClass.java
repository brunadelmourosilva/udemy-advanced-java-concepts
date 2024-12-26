package func_interfaces_predicate;

import java.util.function.Predicate;

public class PredicateClass {

  public static void main(String[] args) {

    // Predicate<T> is a functional interface i.e. one abstract method:
    //      boolean test(T t)
    // I don't need to create a custom interface
    Predicate<Integer> predicate = x -> x > 0;

    System.out.println("Evaluate 5: " + predicate.test(5));
    System.out.println("Evaluate -1: " + predicate.test(-1));

    int x = 4;
    System.out.println("Is " + x + " even? " + check(4, n -> n % 2 == 0)); // true
    x = 7;
    System.out.println("Is " + x + " even? " + check(7, y -> y % 2 == 0)); // false

    String name = "Mr. Joe Bloggs";
    System.out.println(
        "Does "
            + name
            + " start with Mr. ? "
            + check(name, s -> s.startsWith("Mr."))); // true

    name = "Ms. Ann Bloggs";
    System.out.println(
        "Does "
            + name
            + " start with Mr. ? "
            + check(name, s -> s.startsWith("Mr."))); // false

    System.out.println("Is the value blank? " + check("", String::isBlank));
  }

  public static <T> boolean check(T t, Predicate<T> lambda) {
    return lambda.test(t);
  }
}
