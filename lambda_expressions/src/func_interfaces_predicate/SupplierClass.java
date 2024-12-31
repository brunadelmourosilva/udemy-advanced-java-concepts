package func_interfaces_predicate;

import java.time.LocalTime;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierClass {

  // TODO import java.util.function.Supplier; -> used to supply values without any input

  public static void main(String[] args) {

    // Supplier<T> is a functional interface i.e. one abstract method:
    //      T get()
    // I don't need to create a custom interface
    Supplier<StringBuilder> stringBuilderSupplier = StringBuilder::new;
    System.out.println("Supplier SB: " + stringBuilderSupplier.get().append("Test"));

    Supplier<LocalTime> localTimeSupplier = LocalTime::now;
    System.out.println(localTimeSupplier.get());

    Supplier<Double> randomSupplier = Math::random;
    System.out.println(randomSupplier.get());
  }
}
