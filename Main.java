import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Top five salesmen:");
        Salesman[] salesmen = {
                new Salesman("John", 5000.0f),
                new Salesman("Alice", 6000.0f),
                new Salesman("Bob", 4500.0f),
                new Salesman("Eve", 7000.0f),
                new Salesman("Charlie", 5500.0f),
                new Salesman("David", 4800.0f),
                new Salesman("David's clone", 487800.0f)
        };

        Salesman[] topSalesmen = Salesman.getTopFive(salesmen);
        System.out.println(Arrays.toString(topSalesmen));
    }
}