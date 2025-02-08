package exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    var listPeople = getPeople();

    sortAge(listPeople);
    System.out.println("--------------------");
    sortName(listPeople);
    System.out.println("--------------------");
    sortHeight(listPeople);
  }

  public void consumer() {
    Printable<String> functionalInterfaceLambda = p -> System.out.println(p); // lambda
    functionalInterfaceLambda.print("Printable lambda");

    Consumer<String> consumerLambda = p -> System.out.println(p); // lambda
    consumerLambda.accept("Consumer lambda");

    Consumer<String> consumerLambdaMR = System.out::println; // method reference
    consumerLambdaMR.accept("Consumer method reference");

    PrintableReview<Integer, Integer, Integer, Integer> printableReview =
        (t, u, v, w) -> System.out.println("Review consumer " + t + " " + u + " " + v + " " + w);
    printableReview.print(1, 2, 3, 4);
  }

  public void supplier() {
    Retrievable<Integer> functionalInterfaceLambda =
        () -> {
          return 77;
        }; // lambda
    System.out.println(functionalInterfaceLambda.retrieve());

    Supplier<Integer> consumerLambda = () -> 77; // lambda
    System.out.println(consumerLambda.get());

    SupplierReview<String> supplierReview = () -> "Review supplier - no params";
    System.out.println(supplierReview.supplier());
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

    EvaluateReview<Integer, Integer> evaluateReview = (t, r) -> t > r;
    System.out.println("Is 5 greater than 1? " + evaluateReview.isGreaterThan(5, 1));
    System.out.println("Is 1 greater than 5? " + evaluateReview.isGreaterThan(1, 5));
  }

  public void function() {
    Functionable<Integer, String> functionalInterfaceLambda =
        f -> "Number is: ".concat(String.valueOf(f));
    System.out.println(functionalInterfaceLambda.applyThis(25));

    Function<Integer, String> functionLambda =
        f -> "Number is (Function interface): ".concat(String.valueOf(f));
    System.out.println(functionLambda.apply(25));

    FunctionableReview<String, String> functionableReview =
            t -> "\"Bruna\" starts with ".concat(t) + "? " + "Bruna".startsWith(t);
    System.out.println(functionableReview.apply("B"));
    System.out.println(functionableReview.apply("D"));
  }

  private <T> boolean check(T t, Predicate<T> lambda) {
    return lambda.test(t);
  }

  private static List<Person> getPeople() {
    List<Person> result = new ArrayList<>();
    result.add(new Person("Mike", 33, 1.8));
    result.add(new Person("Mary", 25, 1.4));
    result.add(new Person("Alan", 34, 1.7));
    result.add(new Person("Zoe", 30, 1.5));
    return result;
  }

  private static void sortAge(List<Person> personList) {
    personList.sort(Comparator.comparing(Person::getAge));
    personList.forEach(System.out::println);
  }

  private static void sortName(List<Person> personList) {
    personList.sort(Comparator.comparing(Person::getName));
    personList.forEach(System.out::println);
  }

  private static void sortHeight(List<Person> personList) {
    // personList.sort(Comparator.comparing(Person::getHeight, (s1, s2) -> {return s2.compareTo(s1);}));
    personList.sort(Comparator.comparing(Person::getHeight, Comparator.reverseOrder()));
    personList.forEach(p -> System.out.println(p));
  }
}

interface PrintableReview<T, U, V, W> {
  void print(T t, U u, V v, W w);
}

interface SupplierReview<T> {
  T supplier();
}

interface EvaluateReview<T, R> {
  boolean isGreaterThan(T t, R r);
}

interface FunctionableReview<T, R> {
  R apply(T t);
}
