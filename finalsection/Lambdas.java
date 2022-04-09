package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        System.out.println(upperCaseName.apply("hemant") + " " + upperCaseName2.apply("rajput"));

        System.out.println(upperCaseName3.apply("rajput-hemant"));
        // System.out.println(upperCaseName3.apply(""));
        
        // Using BiFunction
        System.out.println(upperCaseName4.apply("hemant", "rajput"));
        System.out.println(upperCaseName4.apply("", "rajput"));
        System.out.println(upperCaseName4.apply("hemant", ""));
        System.out.println(upperCaseName4.apply("", ""));
    }

    static Function<String, String> upperCaseName = name -> name.toUpperCase();

    // Using Method Reference
    static Function<String, String> upperCaseName2 = String::toUpperCase;

    static Function<String, String> upperCaseName3 = name -> {
        // logic
        if (name.isBlank())
            throw new IllegalArgumentException("String is Blank!");
        return name.toUpperCase();
    };

    static BiFunction<String, String, String> upperCaseName4 = (firstName, lastName) -> {
        // logic
        if (!firstName.isBlank() && !lastName.isBlank())
            return firstName.concat(" " + lastName).toUpperCase();
        if (!firstName.isBlank())
            return firstName.toUpperCase();
        if (!lastName.isBlank())
            return lastName.toUpperCase();
        return "First And Last Name not provided!";
    };
}
