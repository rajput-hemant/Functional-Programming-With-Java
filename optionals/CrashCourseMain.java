package optionals;

import java.util.Optional;

public class CrashCourseMain {
    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();

        System.out.println(empty);
        System.out.println(empty.isPresent());

        Optional<String> hello = Optional.of("hello");
        // returns boolean, to check if value is present in Optional
        System.out.println(hello.isPresent());
        // returns boolean, to check if Optional is empty
        System.out.println(hello.isEmpty());

        // To initilaize a Optional object with null value.
        Optional<String> helloWorld = Optional.ofNullable(null);
        // Optional<String> helloWorld = Optional.of("Hello");
        String orElse = helloWorld
                .map(String::toUpperCase)
                // .orElse("World");
                .orElseGet(() -> {
                    // logic
                    return "World";
                });

        System.out.println(orElse);

        // ifPresent performs some action if there is some value
        hello.ifPresent(word -> {
            System.out.println(word);
        });
        // ifPresent using Method Reference
        hello.ifPresent(System.out::println);

        // if present do soemthing else do something
        helloWorld.ifPresentOrElse(System.out::println, () -> System.out.println("World"));

        // Person person = new Person("hemant", null);
        // System.out.println(person.getEmail().toUpperCase());

        Person person = new Person("hemant", "hemant@gmail.com");
        String email = person.getEmail()
                .map(String::toUpperCase)
                .orElse("Email not Provided.");
        System.out.println(email);

    }
}

class Person {
    private final String name, email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // public String getEmail() {
    // return email;
    // }

    // public String getName() {
    // return name;
    // }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public Optional<String> getName() {
        return Optional.of(name);
    }

}
