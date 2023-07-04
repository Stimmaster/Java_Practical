// Практическое задаение №6
// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
//  Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook

// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Класс сделать в отдельном файле

// приветствие
// Выбор параметра
// выбор конкретнее
// вывод подходящих

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task {    
    public static void main(String[] args) {
        Map<String, String> crete_map;                        // список критериев для отбора
        System.out.println();
        NB notebook_1 = new NB("Huawei MateBook D 15 BoD-WFH9", 8, 1024, "Windows 11", "серый");
        NB notebook_2 = new NB("CHUWI Corebook X 14", 8, 512, "Windows 10 Pro", "синий");
        NB notebook_3 = new NB("Asus Laptop 15 X515JA-BQ2588", 16, 256, "Без ОС", "серебристый");
        NB notebook_4 = new NB("ASUS VivoBook X515EA-EJ1413", 8, 512, "Windows 8 Home", "белый");
        NB notebook_5 = new NB("HIPER DZEN MTL1569", 16, 512, "Linux", "черный");
        NB notebook_6 = new NB("ASUS A516JP-EJ461", 8, 1024, "Linux", "серебристый");
        NB notebook_7 = new NB("MSI GP66 Leopard 11UG-699XRU", 16, 512, "Linux", "черный");

        
        ArrayList notebookList = new ArrayList<>();           // список ноутбуков в наличии
        notebookList.add(notebook_1);
        notebookList.add(notebook_2);
        notebookList.add(notebook_3);
        notebookList.add(notebook_4);
        notebookList.add(notebook_5);
        notebookList.add(notebook_6);
        notebookList.add(notebook_7);

        System.out.println("Перечень ноутбуков в наличии: ");
        for (var notebook : notebookList) {
            System.out.println(notebook);
        }
        System.out.println();
        
        crete_map = FindPar();
        FindList(crete_map, notebookList);                      // вызов меню фильтрации параметров
    }

    
    static void FindList(Map<String, String> crete_map, ArrayList<NB> n_list) {    // метод поиска ноутбуков по параметрам 
        ArrayList<NB> finalRes = new ArrayList<>(); 
        System.out.println();
        for (var notebook : n_list) {
            if ((crete_map.containsKey("ram")) && (notebook.getRam() < Integer.parseInt(crete_map.get("ram"))))
            {notebook.setName("");}
            if ((crete_map.containsKey("ssd")) && (notebook.getSsd() < Integer.parseInt(crete_map.get("ssd")))) 
            {notebook.setName("");}
            if ((crete_map.containsKey("os")) && (!notebook.getOs().equals(crete_map.get("os")))) 
            {notebook.setName("");}
            if ((crete_map.containsKey("color")) && (!notebook.getColor().equals(crete_map.get("color"))))
            {notebook.setName("");}
        }
        
        for (var i : n_list) {                                      // заполнение списка результатов поиска
            if (!i.getName().equals("")) {
                finalRes.add(i);
            }            
        }
        if (finalRes.size() > 0) {
            System.out.println("Выбранным характерстикам соответствуют: ");
            for (var item : finalRes) {
                System.out.println(item);
            }
            System.out.println();
        } else {
            System.out.println("Соответствий не найдено");
        }
    }
    
    static Map<String, String> FindPar() {                          //метод списка критериев фильтрации
        String color = "";
        String choice = "";
        String os = "";

        Boolean getOut = false;
        Map<String, String> str = new HashMap<>();                  // список фильтров
        Scanner scan = new Scanner(System.in);
        while (!getOut) {
            System.out.println();
            System.out.println("Введите цифру, соответствующую необходимому критерию: ");
            System.out.println("1 - Оперативная память");
            System.out.println("2 - Объем жесткого диска");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("Enter - вывод полученных результатов");

            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    System.out.println("Введите минимальный объем оперативной памяти в гигабайтах: ");
                    str.put("ram", scan.nextLine());
                    System.out.println("Выбрано: от " + str.get("ram") + " гигабайт оперативной памяти");
                    break;
                }
                case "2": {
                    System.out.println("Введите минимальный объем диска в гигабайтах: ");
                    str.put("ssd", scan.nextLine());
                    System.out.println("Выбрано: диск от " + str.get("ssd") + " гигабайт");
                    System.out.println();
                    break;
                }
                case "3": {
                    System.out.println("Введите название операционной системы ");
                    System.out.println("Доступны следующие ОС:");
                    System.out.println("1 - Windows 11");
                    System.out.println("2 - Windows 10 Pro");
                    System.out.println("3 - Windows 8 Home");
                    System.out.println("4 - Linux");
                    System.out.println("5 - Без ОС");

                    System.out.println("Введите соответствующую цвету цифру: ");
                    choice = scan.nextLine();
                    switch (choice) {
                        case "1": {
                            os = "Windows 11";
                            break;
                        }
                        case "2": {
                            os = "Windows 10 Pro";
                            break;
                        }
                        case "3": {
                            os = "Windows 8 Home";
                            break;
                        }
                        case "4": {
                            os = "Linux";
                            break;
                        }
                        case "5": {
                            os = "Без ОС";
                            break;
                        }

                        default:
                            break;
                    }
                    str.put("os", os);
                    System.out.println("Выбрано: " + str.get("os"));
                    break;
                }
                case "4": {
                    System.out.println("Введите цвет ноутбука. ");
                    System.out.println("Доступны следующие цвета:");
                    System.out.println("1 - белый");
                    System.out.println("2 - черный");
                    System.out.println("3 - серебристый");
                    System.out.println("4 - серый");
                    System.out.println("5 - синий");
                    System.out.println("Введите соответствующую цвету цифру: ");
                    String colorNum = scan.nextLine();
                    switch (colorNum) {
                        case "1": {
                            color = "белый";
                            break;
                        }
                        case "2": {
                            color = "черный";
                            break;
                        }
                        case "3": {
                            color = "серебристый";
                            break;
                        }
                        case "4": {
                            color = "серый";
                            break;
                        }
                        case "5": {
                            color = "синий";
                            break;
                        }
                        default:
                            break;
                    }
                    str.put("color", color);
                    System.out.println("Выбрано: " + str.get("color"));
                    break;
                }
                case "": {
                    getOut = true;
                    break;
                }
                default: {
                    System.out.println("Данные введены неверно, попробуйте еще раз.");
                }
            }
        }
        System.out.println("Выбранные критерии поиска:");
        System.out.println(str);
        return str;
    }
}


