// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, 
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
//
// Пример меню:
// 1) Добавить контакт
// 2) Вывести всех
// 3) Выход
//
// Иванов 123432
// Иванов 546457
// Иванов 788354
//
// Map<String, ArrayList> ---- {Иванов:[23145, 456745, 56787], Петров:[4325, 45674]}

package PracticWork005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class task {
 
    public static void main(String[] args) {  
        
        Map<String, ArrayList> abonent = new HashMap<>() {// Инициализация списка абонентов
            {
                put("Иванов", new ArrayList<Integer>() {
                    {
                        add(333333);
                        add(444444);
                        add(123456);
                        add(654321);                        
                    }
                });
                put("Петаков", new ArrayList<Integer>() {
                    {
                        add(222222);
                    }
                });
                put("Петросян", new ArrayList<Integer>() {
                    {
                        add(111111);
                        add(121221);
                        add(555555);
                    }
                });
                put("Дартаньян", new ArrayList<Integer>() {
                    {
                        add(777777);
                        add(888888);                        
                    }
                });
            }
        };
        System.out.println();
        System.out.println("Список абонентов: ");
        sortedPrint(abonent);      

        Scanner scanner = new Scanner(System.in, "cp866"); 
        Boolean getOut = false;
        String stack;
        while (!getOut) {
            System.out.println("***************МЕНЮ ТЕЛЕФОННОГО СПРАВОЧНИКА***************");
            System.out.println("1 - ДОБАВИТЬ АБОНЕНТА, 0 - ВЫХОД");
            System.out.println("Введите пункт меню для перехода и нажмите Enter: ");
            stack = scanner.nextLine();
            String name = "";
            String phoneString;
            switch (stack) {
                case "1": {
                    System.out.println("Введите фамилию абонента:");
                    name = scanner.nextLine();
                    if (abonent.containsKey(name)) {
                        System.out.println("В справочнике есть такая фамилия");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Введите номера телефонов через запятую: ");
                        phoneString = scanner.nextLine();
                        String[] arr = phoneString.split(",");
                        ArrayList<Integer> arrInt = new ArrayList<>();
                        for (String item: arr) {
                            arrInt.add(Integer.parseInt(item.trim())) ;
                        }
                        abonent.put(name, arrInt);
                        System.out.println();
                        sortedPrint(abonent);
                        break;
                    }
                }
                case "0": {
                    getOut = true;
                    System.out.println();
                    System.out.println("Всего доброго!!!");
                    System.out.println();
                    break;
                }                                      
            }
        }
    }

    static void sortedPrint(Map<String, ArrayList> map) { // Метод сортировки и печати данных абонентов
        Set<String> keySet = map.keySet();  // Получаем набор ключей abonent
        int maxCount = 0;
        int minCount = 1_000_000;
        
        for (var item : map.entrySet()) {
            if (maxCount < item.getValue().size())
                maxCount = item.getValue().size();
            if (minCount > item.getValue().size())
                minCount = item.getValue().size();            
        }
         
        Stack<String> stack = new Stack<>();   // Формируем стек по возрастанию номеров
        int num = minCount;
        while (num <= maxCount) {
            // System.out.println(map);
            for (var item : map.entrySet()) {
                if (item.getValue().size() == num) {
                    stack.push(item.getKey());
                }  
            }
            num += 1;
        }

        // Распечатываем номера в порядке ключей, находящихся в стеке
        String name;
        for (int i = 0; i < keySet.size(); i++) {
            name = stack.pop();
            for (var item : map.entrySet()) {
                if (name == item.getKey()) {
                    System.out.println();
                    System.out.printf("%8s: ", item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
        System.out.println();
    }

}