package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
    private boolean isEmailVaild(String email) {
        return email.contains("@");
    }

    private boolean isPhoneNumberVaild(String phoneNumber) {
        return phoneNumber.startsWith("+00");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Customer customer) {
        return isEmailVaild(customer.getEmail()) &&
                isPhoneNumberVaild(customer.getPhoneNumber()) &&
                isAdult(customer.getDob());
    }
}
