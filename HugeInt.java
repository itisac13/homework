import java.util.List;

public class HugeInt {
    private SinglyLinkedList<Character> numberList = new SinglyLinkedList<>();

    // Private constructor used internally
    private HugeInt(String numberStr) {
        if (numberStr.length() == 0)
        {
            this.numberList.append('+');
            this.numberList.append('0');
            return;
        }
        if (numberStr.charAt(0) == '+' || numberStr.charAt(0) == '-')
            this.numberList.append(numberStr.charAt(0));
        else
            this.numberList.append('+');

        for (int i = 0; i < numberStr.length(); i++)
        {
            char digit = numberStr.charAt(i);
            if (!Character.isDigit(digit))
                continue;
            this.numberList.append(digit);
        }

    }

    public String toString()
    {
        return this.numberList.toString();
    }
    private static HugeInt tenComplement(HugeInt num) {
        // Calculate the ten's complement of a number
        HugeInt complement = new HugeInt("");

        for (int i = 0; i < num.numberOfDigits(); i++) {
            char currentDigit = num.digitAt(i);
            int complementDigit = 9 - (currentDigit - '0');
            complement.prependDigit((char) (complementDigit + '0'));
        }

        // Add 1 to complete the ten's complement
        complement = add(complement, new HugeInt("1"));

        return complement;
    }

    // this still needs to be fixed but I'm sure you get what it's supposed to do
    public static HugeInt multiply(HugeInt a, HugeInt b)
    {
        HugeInt output = new HugeInt("0");
        HugeInt counter = new HugeInt("0");
        while (true)
        {
            output = HugeInt.add(output, b);
            counter = HugeInt.add(counter, new HugeInt("1"));
            if (counter.compareTo(a) == 0)
                break;
        }
        return output;
    }
    public static HugeInt add(HugeInt a, HugeInt b)
    {
        while (a.numberOfDigits() > b.numberOfDigits())
            b.prependDigit('0');
        while (b.numberOfDigits() > a.numberOfDigits())
            a.prependDigit('0');

        HugeInt output = new HugeInt("");

        int carry = 0;
        for (int i = a.numberOfDigits() - 1; i >= 0; i--)
        {
            char currentDigitA = a.digitAt(i);
            char currentDigitB = b.digitAt(i);

            int currentDigitAsIntA = currentDigitA - '0';
            int currentDigitAsIntB = currentDigitB - '0';

            int sum = currentDigitAsIntA + currentDigitAsIntB + carry;
            if (sum > 9)
            {
                carry = sum % 10;
                sum = 9;
            }

            char charDigit = (char) (sum + '0');

            output.prependDigit(charDigit);

        }

        // this is because every list begins with the digit 0
        output.numberList.removeLast();


        return output;
    }

    public char sign()
    {
        return this.numberList.elementAt(0);
    }
    public char digitAt(int index)
    {
        return this.numberList.elementAt(index + 1);
    }
    public void addDigit(char c)
    {
        if (Character.isDigit(c))
            this.numberList.append(c);
    }
    public void prependDigit(char c)
    {
        if (Character.isDigit(c))
            this.numberList.insertAfter(1, c);
    }
    public int numberOfDigits()
    {
        return this.numberList.getLength() - 1;
    }

    public int compareTo(HugeInt other)
    {
        while (other.numberOfDigits() > this.numberOfDigits())
            this.prependDigit('0');
        while (this.numberOfDigits() > other.numberOfDigits())
            other.prependDigit('0');

        for (int i = 0; i < this.numberOfDigits(); i++)
        {

            char digitOther = other.digitAt(i);
            char digitSelf = this.digitAt(i);

            int currentDigitAsIntOther = digitOther - '0';
            int currentDigitAsIntSelf = digitSelf - '0';

            if (currentDigitAsIntSelf > currentDigitAsIntOther)
            {
                return 1;
            }
            else if (currentDigitAsIntSelf < currentDigitAsIntOther)
            {
                return -1;
            }

        }
        return 0;
    }

    public static void sort(List<HugeInt> list) {
        int n = list.size();
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < n - 1; i++) {
                HugeInt current = list.get(i);
                HugeInt next = list.get(i + 1);

                if (current.compareTo(next) > 0) {
                    // Swap if the current BigInt is greater than the next BigInt
                    list.set(i, next);
                    list.set(i + 1, current);
                    swapped = true;
                }
            }

            n--;

        } while (swapped);
    }



    public static void main(String[] args) {
        HugeInt n1 = new HugeInt("12");
        HugeInt n2 = new HugeInt("12");

        // System.out.println(n1);
        // System.out.println(HugeInt.multiply(n1, n2));
    }
}
