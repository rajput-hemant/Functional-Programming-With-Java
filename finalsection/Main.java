package finalsection;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        hello("Hemant", "Rajput", null);
        hello("Hemant", null, value -> {
            System.out.println("No Last Name Provided for -> " + value);
        });

        hello2("Hemant", "Rajput", () -> System.out.println("No Last Name Provided!"));
        hello2("Hemant", null, () -> System.out.println("No Last Name Provided!"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null)
            System.out.println(lastName);
        else
            callback.accept(firstName);
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null)
            System.out.println(lastName);
        else
            callback.run();
    }
    /*
     * -----JAVASCRIPT-----
     * function hello(firstName, lastName, callBack) {
     * console.log(firstName);
     * if (lastName) {
     * console.log(lastName);
     * } else {
     * callBack();
     * }
     * }
     */
}
