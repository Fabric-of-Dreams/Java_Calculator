package omm.mirage;

public class Roman {
    enum RomanNumeral
    {
        C (100), XC (90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

        private int arab;

        RomanNumeral(int arab)
        {
            this.arab = arab;
        }

        public int getArab()
        {
            return arab;
        }

        public static RomanNumeral[] getArray()
        {
            return RomanNumeral.values();
        }
    }

    public static String arabicToRoman(int arab)
    {
        StringBuilder sb = new StringBuilder();
        RomanNumeral[] romanNumerals = RomanNumeral.getArray();
        for (RomanNumeral romanNumeral : romanNumerals) {
            while (arab >= romanNumeral.getArab())
            {
                sb.append(romanNumeral);
                arab -= romanNumeral.arab;
            }
        }
        return sb.toString();
    }
}
