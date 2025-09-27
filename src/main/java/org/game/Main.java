package org.game;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private final Scanner scanner = new Scanner(System.in);
    private Game currentGame = null;

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
                System.out.println("Неверная команда");
            }
        }
    }

    private void handleGame(String line) {
        Pattern p = Pattern.compile("^GAME\\s+(\\d+)\\s*,\\s+(user|comp)\\s+([BbWw])\\s*,\\s+(user|comp)\\s+([BbWw])\\s*$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(line);
        if (!m.matches()) {
            System.out.println("Неверная команда");
            return;
        }

        int n = Integer.parseInt(m.group(1));
        if (n <= 2) System.out.println("Неверная команда");

        String t1 = m.group(2).toLowerCase();
        char c1 = Character.toUpperCase(m.group(3).charAt(0));
        String t2 = m.group(4).toLowerCase();
        char c2 = Character.toUpperCase(m.group(5).charAt(0));

        if (c1 == c2) {
            System.out.println("Неверный ввод");
            return;
        }

        Player p1 = t1.equals("user") ? new UserPlayer(c1) : new ComputerPlayer(c1);
        Player p2 = t2.equals("user") ? new UserPlayer(c2) : new ComputerPlayer(c2);

        currentGame = new Game(n, p1, p2);
        System.out.println("Началась новая игра");
        currentGame.runGame();
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