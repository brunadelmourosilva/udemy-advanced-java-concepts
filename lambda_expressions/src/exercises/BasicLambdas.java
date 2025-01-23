package exercises;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Printable<T> {
  void print(T t);
}

interface Retrievable<T> {
  T retrieve();
}

interface Evaluate<T> {
  Boolean isNegative(T t);
}

interface Functionable<T, R> {
  R applyThis(T t);
}

public class BasicLambdas {

  public static void main(String[] args) {

    BasicLambdas basicLambdas = new BasicLambdas();
    System.out.println("--------------------");
    basicLambdas.consumer();
    System.out.println("--------------------");
    basicLambdas.supplier();
    System.out.println("--------------------");
    basicLambdas.predicate();
    System.out.println("--------------------");
    basicLambdas.function();
    System.out.println("--------------------");
  }

  public void consumer() {
    Printable<String> functionalInterfaceLambda = p -> System.out.println(p); // lambda
    functionalInterfaceLambda.print("Printable lambda");

    Consumer<String> consumerLambda = p -> System.out.println(p); // lambda
    consumerLambda.accept("Consumer lambda");

    Consumer<String> consumerLambdaMR = System.out::println; // method reference
    consumerLambdaMR.accept("Consumer method reference");
  }

  public void supplier() {
    Retrievable<Integer> functionalInterfaceLambda =
        () -> {
          return 77;
        }; // lambda
    System.out.println(functionalInterfaceLambda.retrieve());

    Supplier<Integer> consumerLambda = () -> 77; // lambda
    System.out.println(consumerLambda.get());
  }

  public void predicate() {
    Evaluate<Integer> functionalInterfaceLambda = e -> e < 0;
    System.out.println(functionalInterfaceLambda.isNegative(-1));
    System.out.println(functionalInterfaceLambda.isNegative(1));

    Predicate<Integer> predicateLambda = e -> e < 0;
    System.out.println(predicateLambda.test(-1));
    System.out.println(predicateLambda.test(1));

    Predicate<Integer> predicateLambdaNumbers = c -> c % 2 == 0;
    System.out.println(check(4, predicateLambdaNumbers)); // even
    System.out.println(check(7, predicateLambdaNumbers)); // odd

    Predicate<String> predicateLambdaString = c -> c.startsWith("Mr.");
    System.out.println(check("Mr. Joe Bloggs", predicateLambdaString));
    System.out.println(check("“Ms. Ann Bloggs", predicateLambdaString));

    Predicate<Integer> predicateLambdaAge = c -> c >= 18;
    System.out.println("Is Mike an adult (age 33, 1.8 meters)? " + check(33, predicateLambdaAge));
    System.out.println("Is Ann an adult (age 13, 1.4 meters)? " + check(13, predicateLambdaAge));
  }

  public void function() {
    Functionable<Integer, String> functionalInterfaceLambda =
        f -> "Number is: ".concat(String.valueOf(f));
    System.out.println(functionalInterfaceLambda.applyThis(25));

    Function<Integer, String> functionLambda =
        f -> "Number is (Function interface): ".concat(String.valueOf(f));
    System.out.println(functionLambda.apply(25));
  }

  private <T> boolean check(T t, Predicate<T> lambda) {
    return lambda.test(t);
  }
}
