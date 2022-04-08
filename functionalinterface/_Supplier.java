package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectURL());
        System.out.println(getDBConnectionURL.get());
        System.out.println(getDBConnectionURLList.get());
    }

    static String getDBConnectURL() {
        return "jdbc://localhost:5342/users";
    }

    static Supplier<String> getDBConnectionURL = () -> "jdbc://localhost:5342/users";

    static Supplier<List<String>> getDBConnectionURLList = () -> List.of("jdbc://localhost:5342/users",
            "jdbc://localhost:5342/customers");
}
