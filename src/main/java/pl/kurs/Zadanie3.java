package pl.kurs;

public class Zadanie3 {
    public static void main(String[] args) {

        System.out.println(getFibonacciIndex(8));
        System.out.println(getFibonacciIndex(10));

    }

    private static int counterOfFibonacciNumbers = -1;

    public static int getFibonacciIndex(int number) {
        long calculateFibonacciNumber = fibonacciNumber(++counterOfFibonacciNumbers);
        if (calculateFibonacciNumber < number)
            return getFibonacciIndex(number);
        else
            return number == calculateFibonacciNumber ? counterOfFibonacciNumbers : -1;

    }

    public static long fibonacciNumber(int fi) {
        if (fi == 0 || fi == 1)
            return fi;
        else {
            return fibonacciNumber(fi - 1) + fibonacciNumber(fi - 2);
        }
    }
}
