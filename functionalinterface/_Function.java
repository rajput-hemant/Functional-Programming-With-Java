package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementBy1Function(1);
        System.out.println(increment);
        // Function takes 1 arguments and produces 1 result.
        System.out.println(incrementBy1Function.apply(1));

        System.out.println(multiplyBy10Function.apply(increment));

        System.out.println(addByOneAndThenMultiplyBy10.apply(4));

        System.out.println(incrementBy1AndMultiply(4, 10));
        // BiFunction takes 2 arguments and produces 1 result.
        System.out.println(incrementBy1AndMultiply.apply(4, 10));
    }

    static int incrementBy1Function(int number) {
        return number + 1;
    }

    // Function<Input Type, Return Type> functionName = var -> operationOnVar;
    static Function<Integer, Integer> incrementBy1Function = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    // Combining two function using addThen
    static Function<Integer, Integer> addByOneAndThenMultiplyBy10 = incrementBy1Function.andThen(multiplyBy10Function);

    static int incrementBy1AndMultiply(int num, int numToMultiplyWith) {
        return (num + 1) * numToMultiplyWith;
    }

    // BiFunction<Input Type, Input Type, Return Type> functionName =
    // (var1, var2) -> operationOnVars
    static BiFunction<Integer, Integer, Integer> incrementBy1AndMultiply = (numToIncrement,
            numToMultiplyWith) -> (numToIncrement + 1) * numToMultiplyWith;
}
