import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 1:City, 2:Wilds");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Type how many rows");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.println("Type how many columns");
        int y = Integer.parseInt(scanner.nextLine());
        game Game = new game(number,x, y);
        Game.main();
    }
}