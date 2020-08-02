package omm.mirage;

import java.util.InputMismatchException;

public class Calculation {
    private static boolean isRoman = true;

    public static String calculate(String[] data) throws Exception
    {
        int a = checkRoman(data[0]);
        int b = checkRoman(data[2]);
        String operation = data[1];

        if (!isRoman) {
            a = new Byte(data[0]);
            b = new Byte(data[2]);
            if (a > 10 || b > 10 || a < 1 || b < 1) {
                throw new NumberFormatException("Калькулятор принимает числа от 1 до 10");
            }
        }

        return getResult(a, b, operation);
    }

    private static int checkRoman(String arg)
    {
        switch (arg){
            case ("I"):
                return 1;
            case ("II"):
                return 2;
            case ("III"):
                return 3;
            case ("IV"):
                return 4;
            case ("V"):
                return 5;
            case ("VI"):
                return 6;
            case ("VII"):
                return 7;
            case ("VIII"):
                return 8;
            case ("IX"):
                return 9;
            case ("X"):
                return 10;
            default:
                isRoman = false;
                return 0;
        }
    }

    private static String getResult(int a, int b, String operation) throws Exception{
        int result;

        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = (int)Math.ceil((double)a / (double)b);
                break;
            default:
                throw new InputMismatchException("Калькулятор умеет выполнять " +
                        "операции сложения, вычитания, умножения и деления.");
        }

        if (isRoman)
        {
            if (result < 1)
            {
                throw new Exception("Римские числа могут быть только натуральными.");
            }
            return Roman.arabicToRoman(result);
        }
        else
        {
            return String.valueOf(result);
        }
    }
}
