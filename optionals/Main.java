package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "Default Value.");
        // Object value = Optional.ofNullable("Hello").orElseGet(() -> "Default
        // Value.");
        System.out.println(value);

        Object exception = Optional.ofNullable("Hello")
                .orElseThrow(() -> new IllegalStateException("exception"));
        System.out.println(exception);

        Optional.ofNullable("Hello")
                .ifPresent(say -> System.out.println(say + "World"));

        Optional.ofNullable("xyz@mail.com")
                .ifPresentOrElse(email -> System.out.println("Sending Email to -> " + email),
                        () -> System.out.println("Can't Send Email."));
    }
}
