package consumer;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class BiConsumerClass {

  // TODO import java.util.function.BiConsumer; -> use the parameter but not interested in the return
  // value

  public static void main(String[] args) {

    var map = new HashMap<String, String>();

    // BiConsumer<T> is a functional interface i.e. one abstract method:
    //      void accept(T t, U u)
    // I don't need to create a custom interface
    BiConsumer<String, String> biConsumer = (k, v) -> map.put(k, v);
    biConsumer.accept("Brasil", "Brasília");
    biConsumer.accept("Alemanha", "Berlim");
    System.out.println(map);

    BiConsumer<String, String> biConsumer2 =
        (k, v) -> System.out.println(k + " is the capital of " + v);
    map.forEach(biConsumer2);
  }
}
