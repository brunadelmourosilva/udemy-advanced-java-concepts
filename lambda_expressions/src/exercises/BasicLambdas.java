package exercises;

import java.util.function.Consumer;
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

public class BasicLambdas {

  public static void main(String[] args) {

    BasicLambdas basicLambdas = new BasicLambdas();
    basicLambdas.consumer();
    basicLambdas.supplier();
    basicLambdas.predicate();
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

    // todo 3c
  }
}
