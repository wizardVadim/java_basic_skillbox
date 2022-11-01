import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Elevator elevator = new Elevator(-5, 100, 51);

        while (true) {
            System.out.println("Введите номер этажа");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }

    }
}
