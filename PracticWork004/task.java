import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// Практическое Задание 4
// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном
// порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка.
// Одно или два числа могут быть отрицательными.

// Даны два Deque, цифры в обратном порядке.
// [3,2,1] - пример Deque
// [5,4,3]- пример второго Deque
// 1) 123 * 345 = 42 435
// Ответ всегда - связный список, в обычном порядке
// [4,2,4,3,5] - пример ответа

public class task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество цифр будет в первом числе: ");
        int alldig1 = sc.nextInt();
        Deque<String> dq1 = new ArrayDeque<>(DqCreate(alldig1));
        System.out.println(dq1/* + " " + dq1.size() */);
        int number1 = IntOut(dq1);

        System.out.print("Введите количество цифр будет во втором числе: ");
        int alldig2 = sc.nextInt();
        Deque<String> dq2 = new ArrayDeque<>(DqCreate(alldig2));
        System.out.println(dq2/* + " " + dq2.size() */);
        int number2 = IntOut(dq2);

        int summ = number1 + number2;
        System.out.printf("Сумма чисел %d и %d равна: %d, number1, number2, summ");
        Deque<Character> dqSumm = new ArrayDeque<>(IntInDeque(summ));
        System.out.println(dqSumm);
        int mult = number1 * number2;
        System.out.printf("Произведение чисел %d и %d равна: %d, number1, number2, mult");
        Deque<Character> dqMult = new ArrayDeque<>(IntInDeque(mult));
        System.out.println(dqMult);
        sc.close();
    }

    public static Deque<Character> IntInDeque(int number) { // Преревод Int в String а затем Deque
        String str = Integer.toString(number);
        Deque<Character> dq = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            dq.add(str.charAt(i));
        }
        return dq;
    }

    public static Integer IntOut(Deque<String> dq) { // Перевод Deque из обратного порядка с помощью StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = dq.size(); i > 0; i--) {
            sb.append(dq.pollLast());
        }
        // System.out.println(sb);
        int num = Integer.parseInt(sb.toString());
        return num;
    }

    public static Deque<String> DqCreate(int num) { // Создание двусвязного списка в обратном направлении
        Deque<String> dq = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        while (num > 0) {
            dq.addFirst(sc.nextLine());
            num--;
        }
        return dq;
    }
}