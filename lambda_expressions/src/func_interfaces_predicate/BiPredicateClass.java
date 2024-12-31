package func_interfaces_predicate;

import java.util.function.BiPredicate;

public class BiPredicateClass {

  // TODO import java.util.function.Predicate; -> used to filter/match

  public static void main(String[] args) {

    // BiPredicate<T, U> is a functional interface i.e. one abstract method:
    //      boolean test(T t)
    // I don't need to create a custom interface
    BiPredicate<Integer, String> biPredicate = (t, u) -> t == u.length();

    System.out.println("Evaluate: " + check(5, "My name is Bruna", biPredicate));
  }

  public static <T, U> boolean check(T t, U u, BiPredicate<T, U> lambda) {
    return lambda.test(t, u);
  }
}
