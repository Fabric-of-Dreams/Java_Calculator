package omm.mirage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        String input = in.nextLine().trim();

        String[] data = input.split(" ");

        if (data.length == 3) {
            System.out.println(Calculation.calculate(data));
        }
        else
        {
            throw new InputMismatchException("Неверный формат ввода.");
        }
    }
}
