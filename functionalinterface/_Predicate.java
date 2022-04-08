package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        String phoneNum = "+00 1234567890";
        System.out.println("Using Normal Java Methods.");
        System.out.println("Is Valid Phone Number -> " + isPhoneNumberValid("+001234567890"));
        System.out.println("Is Valid Phone Number -> " + isPhoneNumberValid(phoneNum));

        System.out.println("\nUsing Predicate Functional Interface.");
        System.out.println("Is Valid Phone Number -> " + isPhoneNumberValid.test("+001234567890"));
        System.out.println("Is Valid Phone Number -> " + isPhoneNumberValid.test(phoneNum));

        System.out.println("Contains '00' -> " + contains00.test(phoneNum));

        System.out.println("\nCombining Predicate Functions.");
        System.out.println(
                "Is Valid Phone Number and Contains '00' -> " + isPhoneNumberValid.and(contains00).test(phoneNum));
        System.out.println(
                "Is Valid Phone Number or Contains '00' -> " + isPhoneNumberValid.or(contains00).test("+001234567890"));

        System.out.println("\nUsing BiPredicate Functional Interface.");
        System.out.println(
                "Is Valid Phone Number and Contains '00' -> "
                        + isPhoneNumberValidAndContains00.test(phoneNum, contains00.test(phoneNum)));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+") && phoneNumber.length() == 14;
    }

    // Predicate Funcational Interface
    static Predicate<String> isPhoneNumberValid = phoneNumber -> phoneNumber.startsWith("+")
            && phoneNumber.length() == 14;

    static Predicate<String> contains00 = phoneNumber -> phoneNumber.contains("00");

    // BiPredicate Funcational Interface
    static BiPredicate<String, Boolean> isPhoneNumberValidAndContains00 = (phoneNumber,
            contains00) -> phoneNumber.startsWith("+") && phoneNumber.length() == 14;
}
