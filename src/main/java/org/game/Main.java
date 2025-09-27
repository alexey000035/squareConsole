package org.game;

import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        while (true) {
            if(!scanner.hasNextLine()) break;

            String line = scanner.nextLine().trim();
            if(line.isEmpty()) continue;

            String cmdUpper = line.split("\\s+")[0].toUpperCase();
            try {
                switch (cmdUpper) {
                    case "GAME" -> handleGame(line);
                    case "MOVE" -> handleMove(line);
                    case "HELP" -> printHelp();
                    case "EXIT" -> {return;}
                    default -> System.out.println("Неверная команда");
                }
            } catch (Exception e) {
                System.out.println("Incorrect command");
            }
        }
    }

    private void handleGame(String line) {

    }

    private void handleMove(String line) {

    }

    private void printHelp() {
        System.out.println("Команды:");
        System.out.println(" GAME N, TYPE1 C1, TYPE2 C2");
        System.out.println(" MOVE X Y");
        System.out.println(" HELP");
        System.out.println(" EXIT");
    }
}