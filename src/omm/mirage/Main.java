package omm.mirage;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws Exception{
        Input.getInput();

        int result;

        switch (Input.operation) {
            case "+":
                result = Input.a + Input.b;
                break;
            case "-":
                result = Input.a - Input.b;
                break;
            case "*":
                result = Input.a * Input.b;
                break;
            case "/":
                result = (int)Math.ceil((double)Input.a / (double)Input.b);
                break;
            default:
                throw new InputMismatchException("Калькулятор умеет выполнять " +
                        "операции сложения, вычитания, умножения и деления.");
        }

        if (Input.isRoman)
        {
            if (result < 1)
            {
                throw new Exception("Римские числа могут быть только натуральными.");
            }
            Roman roman = new Roman(result);
            System.out.println(roman.get());
        }
        else
        {
            System.out.println(result);
        }
    }

}
