package bound_unbound_method_references;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BoundAndUnboundMR {

  public static void main(String[] args) {

    /**
     * Bound Method References
     *
     * <p>A bound method reference is tied to a specific instance of a class. The method reference
     * includes the object to which the method is bound.
     */
    final String name = "Bruna";

    Supplier<String> supplierL = () -> name.toUpperCase(); // lambda
    Supplier<String> supplierMR = name::toLowerCase; // bound method reference

    System.out.println(supplierL.get());
    System.out.println(supplierMR.get());

    // -----------

    Predicate<String> predicateL = word -> name.startsWith(word); // lambda
    Predicate<String> predicateMR = name::startsWith; // bound method reference

    System.out.println(predicateL.test("B"));
    System.out.println(predicateMR.test("M"));

    /**
     * Unbound Method References
     *
     * <p>An unbound method reference is not tied to any specific instance. Instead, the instance is
     * provided at the time of method invocation.
     */
    Function<String, String> functionL = s -> s.toUpperCase(); // lambda
    Function<String, String> functionMR = String::toUpperCase; // unbound method reference

    // here I'm specifying the word to be upper-cased at the method invocation time.
    System.out.println(functionL.apply("b"));
    System.out.println(functionL.apply("a"));
    System.out.println(functionMR.apply("m"));
    System.out.println(functionMR.apply("s"));
  }
}
