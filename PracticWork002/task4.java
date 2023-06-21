import java.util.Scanner;
import java.util.logging.Logger;

public class task4 {
    private static final Logger log = Logger.getLogger(task4.class.getName());

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double num1, num2, result;
            char operator;

            log.info("Введите первое число:");
            num1 = scanner.nextDouble();
            log.info("Введите второе число:");
            num2 = scanner.nextDouble();
            log.info("Введите оператор (+, -, *, /):");
            operator = scanner.next().charAt(0);

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
                    log.warning("Недопустимый оператор.");
                    return;
            }
            log.info(String.format("%.2f %c %.2f = %.2f", num1, operator, num2, result));
        }
    }
}
