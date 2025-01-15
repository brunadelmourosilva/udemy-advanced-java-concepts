package static_method_references;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class StaticMethodReferences {

  public static void main(String[] args) {

    /**
     * Static method references are considered UNBOUND. A static method is Collections.sort(List)
     */
    Consumer<List<Integer>> sortL = list -> Collections.sort(list);
    Consumer<List<Integer>> sortMR = Collections::sort;

    List<Integer> numbers = Arrays.asList(10, 4, 6, 2, 9);
    sortL.accept(numbers);
    System.out.println(numbers);

    numbers = Arrays.asList(3, 4, 1, 9, 8);
    sortMR.accept(numbers);
    System.out.println(numbers);
  }
}
