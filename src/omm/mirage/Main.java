package omm.mirage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Test test = new Test();

        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        String input = in.nextLine().trim();

        String[] data = input.split(" ");

        Calculation calculation;

        if (data.length == 3) {
            calculation = new Calculation(data);
            System.out.println(calculation.getResult());
        }
        else
        {
            throw new InputMismatchException("Неверный формат ввода.");
        }
    }
}
