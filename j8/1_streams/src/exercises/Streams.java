package exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {
  public static void main(String[] args) {

    // exercise 1
    var average = LongStream.of(0, 1, 2, 3, 4, 5).average();
    System.out.println("Average: " + average.orElse(0));

    System.out.println("-------------------------------------------------------------");

    // exercise 2
    var items = List.of(new Item(1, "Screw"), new Item(2, "Nail"), new Item(3, "Bolt"));

    items.stream().sorted(Comparator.comparing(Item::getName)).forEach(System.out::print);

    System.out.println("\n-------------------------------------------------------------");

    // exercise 3
    Stream.of(Arrays.asList("c", "d"), Arrays.asList("a", "b"), Arrays.asList("a", "c"))
            .filter(containsC -> containsC.contains("c"))
            .peek(list -> System.out.println("List before transforming: " + list))
            .flatMap(list -> list.stream())
            .forEach(System.out::println);
  }
}
