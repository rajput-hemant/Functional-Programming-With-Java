package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        greetCustomer(new Customer("Hemant", "+00 1234567890"));
        // Consumer Functional Interface
        greetCustomer.accept(new Customer("Rajput", "+00 1234567890"));
        // BiConsumer Functional Interface
        greetCustomerV2.accept(new Customer("rajput-hemant", "+00 1234567890"), false);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering Phone Number "
                + customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }

    // Consumer Function Interface, takes an arg and return nothing
    static Consumer<Customer> greetCustomer = customer -> System.out
            .println("Hello " + customer.customerName + ", thanks for registering Phone Number "
                    + customer.customerPhoneNumber);
    // BiConsumer Function Interface, takes 2 args and return nothing
    static BiConsumer<Customer, Boolean> greetCustomerV2 = (customer, showPhoneNum) -> System.out
            .println("Hello " + customer.customerName + ", thanks for registering Phone Number "
                    + (showPhoneNum ? customer.customerPhoneNumber : "**********"));
}
