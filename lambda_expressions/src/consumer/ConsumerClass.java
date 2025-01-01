package consumer;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerClass {

  // TODO import java.util.function.Consumer; -> use the parameter but not interested in the return
  // value

  public static void main(String[] args) {

    // Consumer<T> is a functional interface i.e. one abstract method:
    //      void accept(T t)
    // I don't need to create a custom interface
    Consumer<String> consumer = s -> System.out.println(s);
    consumer.accept("To be or not to be, this is the question.");

    List<String> list = List.of("Bruna, Vitória, Marcir, Spike, Lerry");
    list.forEach(consumer);
  }
}
