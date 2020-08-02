package omm.mirage;

public class Test {

    Test(){
        test(14, "XIV");
        test(46, "XLVI");
        test(47, "XLVII");
        test(48, "XLIII");
        test(87, "LXXXVII");
        test(92, "XCII");
        test(98, "XCVIII");
    }

    void test(int arab, String romanString)
    {
        if (Roman.arabicToRoman(arab).equals(romanString))
        {
            System.out.println(arab + " test success: " + Roman.arabicToRoman(arab));
        }
        else
        {
            System.out.println(arab + " test failed: " + Roman.arabicToRoman(arab));
        }
    }
}
