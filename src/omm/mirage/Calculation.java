package omm.mirage;

import java.util.InputMismatchException;

public class Calculation {
    private int a;
    private int b;
    private String operation;
    private boolean isRoman = true;

    Calculation(String[] data)
    {
        a = checkRoman(data[0]);
        b = checkRoman(data[2]);
        operation = data[1];

        if (!isRoman) {
            a = new Byte(data[0]);
            b = new Byte(data[2]);
            if (a > 10 || b > 10 || a < 1 || b < 1) {
                throw new NumberFormatException("Калькулятор принимает числа от 1 до 10");
            }
        }
    }

    private int checkRoman(String arg)
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

    public String getResult() throws Exception{
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
            Roman roman = new Roman();
            return roman.getRoman(result);
        }
        else
        {
            return String.valueOf(result);
        }
    }
}
