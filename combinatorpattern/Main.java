package combinatorpattern;

import java.time.LocalDate;
import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Hemant", "hemant@gmail.com", "+001234567890", LocalDate.of(2000, 1, 1));

        // System.out.println(new CustomerValidatorService().isValid(customer));

        // Using Combinator Pattern

        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS)
            throw new IllegalStateException(result.name());
    }
}
