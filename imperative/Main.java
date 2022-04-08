package imperative;

import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Hemant", MALE),
                new Person("Manvendra", MALE),
                new Person("Ritik", MALE),
                new Person("Mugdha", FEMALE),
                new Person("Vaishnavi", FEMALE),
                new Person("Pooja", FEMALE));

        // Imperative Approach
        System.out.println("\nImperative Approach\n");
        List<Person> females = new ArrayList<>();

        // Addding person of Gender FEMALE to the List 'females'
        for (Person person : people)
            if (FEMALE.equals(person.gender))
                females.add(person);

        // Printing the List 'females'
        for (Person female : females)
            System.out.println(female);

        // Declarative Approach
        System.out.println("\nDeclarative Approach\n");

        /*
         * // Filtering and Collecting FEMALE in the List 'females2'
         * List<Person> females2 = people.stream()
         * .filter(person -> FEMALE.equals(person.gender))
         * .collect(Collectors.toList());
         * // Printing the List 'females2'
         * females2.forEach(System.out::println);
         */

        // Filtering and printing FEMALE from List of 'Person'
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(System.out::println);
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