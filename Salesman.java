import java.util.Arrays;
public class Salesman {
    public Salesman(String name, float sales) {
        this.name = name;
        this.sales = sales;
    }

    String name;
    float sales;

    public float getSales() {
        return this.sales;
    }

    public String getName() {
        return this.name;
    }

    public static Salesman[] getTopFive(Salesman[] allSales) {
        Arrays.sort(allSales, (s1, s2) -> Float.compare(s2.getSales(), s1.getSales()));
        // System.out.println(Arrays.toString(allSales));

        int arrayLength = allSales.length;
        if (arrayLength > 5)
        {
            arrayLength = 5;
        }

        Salesman[] topFive = new Salesman[arrayLength];
        for (int i = 0; i < arrayLength; i++)
        {

            topFive[i] = allSales[i];
        }

        return topFive;
    }

    public String toString()
    {
        return this.name + ": " + this.sales;
    }
}
