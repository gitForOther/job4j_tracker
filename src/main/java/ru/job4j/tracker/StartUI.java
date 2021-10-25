package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.println("Введите идентификатор заявки: ");
                String id = scanner.nextLine();
                System.out.println("Введите новое наименование заявки: ");
                String newName = scanner.nextLine();
                boolean rsl = tracker.replace(Integer.parseInt(id), new Item(newName));
                if (rsl) {
                    System.out.println("Замена выполнена успешно");
                } else {
                    System.out.println("Не удалось выполнить замену. "
                            + "Возможно, неверно указан ID заявки для замены");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.println("Введите идентификатор заявки: ");
                String id = scanner.nextLine();
                boolean rsl = tracker.delete(Integer.parseInt(id));
                if (rsl) {
                    System.out.println("Заявка успешно удалена");
                } else {
                    System.out.println("Не удалось удалить заявку. "
                            + "Возможно, неверно указан ID заявки.");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                System.out.println("Введите идентификатор заявки: ");
                String id = scanner.nextLine();
                Item itemFind = tracker.findById(Integer.parseInt(id));
                if (itemFind == null) {
                    System.out.println("Не удалось найти заявку. "
                            + "Возможно, неверно указан ID заявки.");
                } else {
                    System.out.println(itemFind);
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.println("Введите наименование заявки: ");
                String name = scanner.nextLine();
                Item[] itemFind = tracker.findByName(name);
                if (itemFind.length == 0) {
                    System.out.println("Не удалось найти заявку. "
                            + "Возможно, неверно указано название заявки.");
                } else {
                    for (Item item : itemFind) {
                        System.out.println(item);
                    }
                }
            } else if (select != 6) {
                System.out.println("Пользователь выбрал: " + select);
            } else {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
