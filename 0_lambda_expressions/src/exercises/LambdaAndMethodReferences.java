package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class LambdaAndMethodReferences {

  public static void main(String[] args) {
    staticMR();
    System.out.println("--------------------");
    boundMR();
    System.out.println("--------------------");
    unboundMR();
    System.out.println("--------------------");
    constructorMr();
  }

  public static void staticMR() {
    List<Integer> numbers = Arrays.asList(1, 2, 7, 4, 5);

    Consumer<List<Integer>> consumerLambda = list -> Collections.sort(list);
    System.out.println("Unsorted: " + numbers);
    consumerLambda.accept(numbers);
    System.out.println("Ascending order of numbers (lambda): " + numbers);

    numbers = Arrays.asList(1, 2, 7, 4, 5); // unsorted again

    // Collections.sort(List)
    // Collections.sort(list, Comparator)
    // Java infers what to do from the CONTEXT where we are creating
    // a Consumer and its interface only accepts one parameter *accept(T t)* and
    // then, it invokes the 'sort(List)' as per the lambda syntax above.
    Consumer<List<Integer>> consumerMR = Collections::sort;
    System.out.println("Unsorted: " + numbers);
    consumerMR.accept(numbers);
    System.out.println("Ascending order of numbers (MR): " + numbers);
  }

  public static void boundMR() {
    String name = "Mr. Joe Bloggs";

    Predicate<String> predicateLambda = prefix -> name.startsWith(prefix);
    System.out.println(predicateLambda.test("Mr."));
    System.out.println(predicateLambda.test("Ms."));

    Predicate<String> predicateMR = name::startsWith; // bound method reference
    System.out.println(predicateMR.test("Mr."));
    System.out.println(predicateMR.test("Ms."));
  }

  public static void unboundMR() {
    Predicate<String> predicateLambda = str -> str.isEmpty();
    System.out.println(predicateLambda.test(""));
    System.out.println(predicateLambda.test("xyz"));

    Predicate<String> predicateMR = String::isEmpty; // unbound method reference
    System.out.println(predicateMR.test(""));
    System.out.println(predicateMR.test("xyz"));

    BiPredicate<String, String> biPredicateLambda = (str1, srt2) -> str1.startsWith(srt2);
    System.out.println(biPredicateLambda.test("Mr. Joe Bloggs", "Mr."));
    System.out.println(biPredicateLambda.test("Mr. Joe Bloggs", "Ms."));

    BiPredicate<String, String> biPredicateMR = String::startsWith;
    System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Mr."));
    System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Ms."));
  }

  public static void constructorMr() {
    Supplier<List<String>> supplierLambda = () -> new ArrayList<>();
    List<String> list = supplierLambda.get();
    list.add("Lambda");
    System.out.println(list);

    Supplier<List<String>> supplierMR = ArrayList::new;
    list = supplierMR.get();
    list.add("Method Reference");
    System.out.println(list);

    Function<Integer, List<String>> functionLambda = input -> new ArrayList<>(input);
    list = functionLambda.apply(2);
    list.add("Lambda");
    System.out.println(list);

    Function<Integer, List<String>> functionMR = ArrayList::new;
    list = functionMR.apply(2); // context is important to diff from the supplier impl
    list.add("Lambda");
    System.out.println(list);
  }
}
