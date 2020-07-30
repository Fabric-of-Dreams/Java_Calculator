package omm.mirage;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Roman {
    // Карта, в которой будет записано представление каждого разряда
    private SortedMap<Integer, String> romanMap = new TreeMap<Integer, String>();
    private int[] grades = new int[] { 1, 5, 10, 50, 100 };
    private Map<Integer, Character> arabToRoman = new HashMap<Integer, Character>();

    public Roman(int arab)
    {
        arabToRoman.put(1, 'I');
        arabToRoman.put(5, 'V');
        arabToRoman.put(10, 'X');
        arabToRoman.put(50, 'L');
        arabToRoman.put(100, 'C');
        romanMap.put(1, "");
        romanMap.put(5, "");
        romanMap.put(10, "");
        romanMap.put(50, "");
        romanMap.put(100, "");

        if(!tryForward(arab, getMaxGradeNumber(arab)))
        {
            writeBackwards(arab, getMaxGradeNumber(arab));
        }
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

    private boolean tryForward(int arab, int gradeNumber)
    {
        return tryForward(arab, gradeNumber, 0);
    }

    private boolean tryForward(int arab, int gradeNumber, int symbolsAmount)
    {
        int newArab = arab - grades[gradeNumber];
        symbolsAmount++;

        if (getMaxGradeNumber(newArab) == gradeNumber)
        {
            tryForward(newArab, gradeNumber, symbolsAmount);
        }
        else if (symbolsAmount <= 3)
        {
            romanMap.put(grades[gradeNumber], writeForward(grades[gradeNumber], symbolsAmount));
        }
        else
        {
            return false;
        }
        return true;
    }

    private String writeForward(int grade, int symbolsAmount)
    {
        String result = "";
        for (int i = 0; i < symbolsAmount; i++) {
            result += arabToRoman.get(grade);
        }
        return result;
    }

    private void writeBackwards(int arab, int grade)
    {

    }

    public String get()
    {
        return romanMap.get(1)+romanMap.get(5)+romanMap.get(10)+romanMap.get(50)+
                romanMap.get(100);
    }

//    static void addSymbol(int arab)
//    {
//        while (arab != 0)
//        {
//            if (arab / 100 == 1)
//            {
//                roman += "C";
//                arab -= 100;
//            }
//            else
//            {
//                if (arab / 50 >= 1)
//                {
//                    roman += "L";
//                    arab -= 50;
//                }
//                else
//                {
//                    if (arab / 10 >= 1)
//                    {
//                        roman += "X";
//                        arab -= 10;
//                    }
//                    else
//                    {
//                        if (arab / 5 >= 1)
//                        {
//                            roman += "V";
//                            arab -= 5;
//                        }
//                        else
//                        {
//                            roman += "I";
//                            arab -= 1;
//                        }
//                    }
//                }
//            }
//        }
//
//    }
}
