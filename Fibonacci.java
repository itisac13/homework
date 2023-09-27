public class Fibonacci {
    public static int times = 0;
    public static int fibonacci(int n)
    {
        if (n < 0)
        {
            return -1;
        }
        times += 1;
        System.out.println("Called function " + times + " times");

        if (n == 0 || n == 1)
        {
            return 1;
        }
        else
        {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }
}
