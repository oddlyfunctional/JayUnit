package jayUnit.example;

public class Fibonacci {

    public int compute(int n) {
        if (n < 2) {
            return n;
        } else {
            return compute(n - 1) + compute(n - 2);
        }
    }
}
