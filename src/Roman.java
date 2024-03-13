import java.util.Locale;
import java.util.TreeMap;

public class Roman {

    private static final TreeMap<Character,Integer> ROMAN_NUMS = new TreeMap<>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public static String decimalToRoman(int number) throws Exception {
        if(number < 1){
            throw new Exception("т.к. в римской системе нет отрицательных чисел ");
        }
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + decimalToRoman(number-l);
    }



    public static int romanToDecimal(String roman) {
        int decimal = 0;
        int prevValue = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            char numeral = roman.charAt(i);
            int value = ROMAN_NUMS.get(numeral);
            if (value < prevValue) {
                decimal -= value;
            } else {
                decimal += value;
            }


            prevValue = value;
        }
        return decimal;
    }
    public static boolean isRomanNumber(String str){
        int result = 0;
        char[] chars = str.toUpperCase(Locale.ROOT).toCharArray();
        for (char aChar : chars) {
            if (ROMAN_NUMS.get(aChar) == null) {
                result++;
            }
        }
        if (result > 0){
            return false;
        }
        return true;
    }
}
