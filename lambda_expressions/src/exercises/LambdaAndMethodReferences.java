package exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaAndMethodReferences {

  public static void main(String[] args) {
    staticMR();
    System.out.println("--------------------");
    boundMR();
    // todo exercise 3
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
}
