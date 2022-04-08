package streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Hemant", MALE),
                new Person("Manvendra", MALE),
                new Person("Ritik", MALE),
                new Person("Mugdha", FEMALE),
                new Person("Vaishnavi", FEMALE),
                new Person("Pooja", FEMALE));

        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        boolean containsOnlyFemales = people.stream()
                .allMatch(personPredicate);
        System.out.println("Contains Only Females -> " + containsOnlyFemales);

        boolean containsAtLeastOneFemales = people.stream()
                .anyMatch(personPredicate);
        System.out.println("Contains Any Entry With Females -> " + containsAtLeastOneFemales);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + ", gender=" + gender + '}';
        }
    }

    enum Gender {
        MALE, FEMALE;
    };
}
