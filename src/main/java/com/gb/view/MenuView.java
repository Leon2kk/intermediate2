package com.gb.view;
import java.util.Scanner;
import com.gb.controller.Controller;

public class MenuView {

    private final Controller c = new Controller();

    public MenuView() {
    }

    public void run() {
        Commands comm = Commands.NONE;
        while (true) {
            try {
                System.out.println("ПРИЛОЖЕНИЕ РОЗЫГРЫША ИГРУШЕК!\nЧто вы хотите сделать?\n");
                System.out.println("ADD -- добавить игрушку для розыгрыша\nUPD -- обновить вероятность выпада игрушки");
                System.out.println("RUFF -- разыграть приз для участника\nGET -- выдать приз участнику\nEXIT -- выход");
                String command = prompt("Введите команду: ");
                comm = Commands.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Not found command!");
                continue;
            }
            if (comm == Commands.EXIT) return;
            switch (comm) {
                case ADD:
                    try {
                        String name = String.format(prompt("Наименование игрушки: "));
                        Integer count = Integer.parseInt(prompt("Количество игрушек: "));
                        Integer prob = Integer.parseInt(prompt("Вероятность выигрыша: "));
                        c.createToy(name, count, prob);
                        continue;
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                case UPD:
                    try {
                        Long id = Long.parseLong(prompt("Введите ID игрушки: "));
                        Integer prob = Integer.parseInt(prompt("Измените вероятность выигрыша: "));
                        c.updateToy(id, prob);
                        continue;
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                case RUFF:
                    try {
                        String firstName = prompt("Имя: ");
                        String LastName = prompt("Фамилия: ".toString());
                        String phone = prompt("Телефон: ".toString());
                        c.getRuffle(firstName, LastName, phone);
                        continue;
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                case GET:
                    try {
                        Long id = Long.parseLong(prompt("Введите ID: "));
                        c.getPrize(id);
                        continue;
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
            }
        }
    }

    private String prompt(String message) {
        Scanner sc = new Scanner(System.in, "Cp866");
        System.out.print(message);
        return sc.nextLine().toString();
    }
    
}
