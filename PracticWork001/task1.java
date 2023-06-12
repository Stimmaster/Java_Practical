//1) Вычислить n-ое треугольного числа (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

package PracticWork001;

public class task1 {
    public static int TriangularNumber(int n) {
        return n * (n + 1) / 2;
    }

    public static int Factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int triangularNumber = TriangularNumber(n);
        int factorial = Factorial(n);
        System.out.println(n + " треугольного числа " + triangularNumber);
        System.out.println("Факториал от " + n + " равен " + factorial);
    }
}