package func_interfaces_predicate;

interface MyFunctionalInterface<T> {
  boolean isPositive(T t); // similar to Predicate in the java API
}

interface MyFunctionalInterfaceNoParam {
  String print();
}

public class FunctionalInterface {
  public static void main(String[] args) {

    // doing without lambda, declaring by anonymous class
    MyFunctionalInterface<Integer> lambdaOldDeclaration =
        new MyFunctionalInterface<Integer>() {

          @Override
          public boolean isPositive(Integer integer) {
            return integer > 0;
          }
        };
    System.out.println("Evaluate 2: " + lambdaOldDeclaration.isPositive(2));
    System.out.println("Evaluate -6: " + lambdaOldDeclaration.isPositive(-6));

    // ---------------------------------------------------------------------

    // doing with lambda
    MyFunctionalInterface<Integer> lambda = n -> n > 0;

    // MyFunctionalInterface<T> is a functional interface i.e. one abstract method:
    // boolean isPositive(T t); // similar to java.util.function.Predicate
    System.out.println("Evaluate 5: " + lambda.isPositive(5));
    System.out.println("Evaluate -9: " + lambda.isPositive(-9));

    MyFunctionalInterfaceNoParam functionalInterface = () -> "I'm a lambda called with no params";
    System.out.println(functionalInterface.print());
  }
}
