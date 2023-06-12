//3) Реализовать простой калькулятор (+-/*)
package PracticWork001;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число:");
        double num1 = sc.nextDouble();
        System.out.println("Введите второе число:");
        double num2 = sc.nextDouble();
        System.out.println("Выберите оператор (+, -, *, /):");
        char operator = sc.next().charAt(0);

        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                result = num1 / num2;
                break;

            default:
                System.out.println("Ошибка! Неверно выбран оператор.");
                return;
        }

        System.out.println("Результат: " + result);
    }
}
