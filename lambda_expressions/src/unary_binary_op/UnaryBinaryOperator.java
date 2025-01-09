package unary_binary_op;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryOperator {

  public static void main(String[] args) {

    // TODO import java.util.function.UnaryOperator; -> transform the input into an output (types must be
    // the same)

    // UnaryOperator<T> extends Function<T, T> is a functional interface i.e. one abstract
    // method: T apply(T t)
    // I don't need to create a custom interface
    UnaryOperator<String> unaryOperator = s -> "My name is ".concat(s);
    System.out.println("Unary Operator: " + unaryOperator.apply("Bruna"));

    // TODO import java.util.function.BinaryOperator; -> transform 2 inputs into an output (types must be
    // the same)

    // BinaryOperator<T> extends BiFunction<T, T, T> is a functional interface i.e. one abstract
    // method: T apply(T t1, T t2)
    // I don't need to create a custom interface
    BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);
    System.out.println("Binary Operator: " + binaryOperator.apply("Bruna ", "Delmouro"));
  }
}
