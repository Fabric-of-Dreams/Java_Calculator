package omm.mirage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static int a;
    public static int b;
    public static String operation;
    public static boolean isRoman = true;

    static void getInput() throws NumberFormatException, InputMismatchException{
        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        String input = in.nextLine().trim();

        String[] data = input.split(" ");

        if (data.length != 3) {
            throw new InputMismatchException("Неверный формат ввода.");
        }

        setAB(data[0], data[2]);
        operation = data[1];
    }

    static void setAB(String arg1, String arg2)
    {
        a = checkRoman(arg1);
        b = checkRoman(arg2);

        if (!isRoman) {
            a = new Byte(arg1);
            b = new Byte(arg2);
            if (a > 10 || b > 10 || a < 1 || b < 1) {
                throw new NumberFormatException("Калькулятор принимает числа от 1 до 10");
            }
        }
    }

    static byte checkRoman(String arg)
    {
        switch (arg){
            case ("I"):
                return 1;
            case ("II"):
                return 2;
            case ("III"):
                return 3;
            case("IV"):
                return 4;
            case("V"):
                return 5;
            case("VI"):
                return 6;
            case("VII"):
                return 7;
            case("VIII"):
                return 8;
            case("IX"):
                return 9;
            case("X"):
                return 10;
            default:
                isRoman = false;
        }
        return 0;
    }
}
