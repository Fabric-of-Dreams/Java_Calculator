package omm.mirage;

import java.util.HashMap;
import java.util.Map;

public class Roman {
    private int[] grades = new int[] { 1, 5, 10, 50, 100 };
    private int[] maxSymbolsOfGrade = new int[] { 3, 1, 3, 1, 1 };
    private Map<Integer, Character> arabToRoman = new HashMap<Integer, Character>();

    public Roman()
    {
        arabToRoman.put(1, 'I');
        arabToRoman.put(5, 'V');
        arabToRoman.put(10, 'X');
        arabToRoman.put(50, 'L');
        arabToRoman.put(100, 'C');
    }

    private int getMaxGradeNumber(int arab)
    {
        for (int i = grades.length - 1; i >= 0; i--) {
            if (arab / grades[i] > 0)
            {
                return i;
            }
        }
        return -1;
    }

    public String getRoman(int arab)
    {
        // Карта, в которой будет записано представление каждого разряда
        Map<Integer, String> romanMap = new HashMap<Integer, String>();

        romanMap.put(1, "");
        romanMap.put(5, "");
        romanMap.put(10, "");
        romanMap.put(50, "");
        romanMap.put(100, "");

        romanMap = tryForward(romanMap, arab, arab, getMaxGradeNumber(arab), 0);

        String forwardResult = romanMap.get(100)+romanMap.get(50)+romanMap.get(10)+romanMap.get(5)+romanMap.get(1);
        String backwardsResult = writeBackwards(arab, getMaxGradeNumber(arab));
        return forwardResult;
    }

    private Map<Integer, String> tryForward(Map<Integer, String> romanMap, int arab, int initialArab,
                                            int gradeNumber, int symbolsAmount)
    {
        if (arab == 0)
        {
            return romanMap;
        }

        arab -= grades[gradeNumber];
        symbolsAmount++;

        if (getMaxGradeNumber(arab) == gradeNumber)
        {
            tryForward(romanMap, arab, initialArab, gradeNumber, symbolsAmount);
            return romanMap;
        }
        else if (symbolsAmount <= maxSymbolsOfGrade[gradeNumber])
        {
            romanMap.put(grades[gradeNumber], writeForward(gradeNumber, symbolsAmount));
            tryForward(romanMap, arab, arab, getMaxGradeNumber(arab), 0);
        }
        else
        {
            romanMap.put(grades[gradeNumber], writeBackwards(initialArab, gradeNumber));
        }
        return romanMap;
    }

    private String writeForward(int gradeNumber, int symbolsAmount)
    {
        String result = "";
        for (int i = 0; i < symbolsAmount; i++) {
            result += arabToRoman.get(grades[gradeNumber]);
        }
        return result;
    }

    private String writeBackwards(int arab, int gradeNumber)
    {
        String result = "";
        int higherGrade = grades[gradeNumber + 1];
        int gradeToDeduct = grades[getMaxGradeNumber(higherGrade - arab)];
        int symbolsAmount = 0;
        int toAddAfterDeduction = arab - higherGrade;

        for (int i = arab; i < higherGrade ; i+=gradeToDeduct) {
            result += arabToRoman.get(gradeToDeduct);
            symbolsAmount++;
            toAddAfterDeduction += gradeToDeduct;
        }

        if (symbolsAmount <= maxSymbolsOfGrade[gradeNumber] - 1)
        {
            result += arabToRoman.get(higherGrade);
            result += getRoman(toAddAfterDeduction);
        }
        else
        {
            result = String.valueOf(arabToRoman.get(grades[gradeNumber]));
            int numberToAdd = arab - (higherGrade - grades[gradeNumber]);
            result += arabToRoman.get(higherGrade);
            result += getRoman(numberToAdd);
        }
        return result;
    }
}
