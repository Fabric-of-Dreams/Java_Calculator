package omm.mirage;

public class Test {

    Test(){
        test(14, "XIV");
        test(46, "XLVI");
        test(47, "XLVII");
        test(48, "IIL");
        test(87, "LXXXVII");
        test(92, "XCII");
        test(98, "IIC");
    }

    void test(int arab, String romanString)
    {
        Roman roman = new Roman();
        if (roman.getRoman(arab).equals(romanString))
        {
            System.out.println(arab + " test success: " + roman.getRoman(arab));
        }
        else
        {
            System.out.println(arab + " test failed: " + roman.getRoman(arab));
        }
    }
}
