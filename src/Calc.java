import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Calc {




    public static String Calc(String input) throws Exception {
        String[] strings = splitStr(input);
        if(Roman.isRomanNumber(strings[0]) && Roman.isRomanNumber(strings[2])){
            return CalcRoman(input);
        } else if(!Roman.isRomanNumber(strings[0]) && !Roman.isRomanNumber(strings[2])){
            return Integer.toString(CalcDecimal(input));
        } else {
            throw new Exception("т.к. используются одновременно разные системы счисления");
        }

    }
    private static String CalcRoman(String input) throws Exception {
        String[] strings = splitStr(input);
        String one = strings[0].toUpperCase();
        String two = strings[2].toUpperCase();
        String sign = Sign(splitStr(input));
        int first = Roman.romanToDecimal(one);
        int second = Roman.romanToDecimal(two);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(first).append(sign).append(second);
        return Roman.decimalToRoman(CalcDecimal(String.valueOf(stringBuilder)));
    }
private static int CalcDecimal(String input) throws Exception {
        int result = 0;
        int one = FirstInt(splitStr(input));
        int two = SecondInt(splitStr(input));
        String sign = Sign(splitStr(input));
    switch (sign) {
        case "+":
            result = one + two;
            break;
        case "-":
            result = one - two;
            break;
        case "*":
            result = one * two;
            break;
        case "/":
            result = one / two;
            break;
    }
    return result;
}
    private static String[] splitStr(String str) throws Exception {
String res = str.replaceAll(" ","");
res.trim();
        String[] parts = res.split("\\s+|(?=\\+|\\-|\\*|\\/)|(?<=\\+|\\-|\\*|\\/)");

        if(parts.length > 3 ){
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (parts.length<3){
            throw new Exception("т.к. строка не является математической операцией");
        }
        return parts;
    }
    private static int FirstInt(String[] strings) throws Exception {
        int one = Integer.parseInt(strings[0]);
        if(one <1 || one > 10){
            throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не боле");
        }
        return one ;
    }
    private static int SecondInt(String[] strings) throws Exception {
        int two = Integer.parseInt(strings[2]);
        if(two <1 || two > 10){
            throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не боле");
        }
        return two ;
    }
    private static String Sign(String[] strings) throws Exception {
        if(strings[1].equals("+") || strings[1].equals("-") || strings[1].equals("*") || strings[1].equals("/")){
            return strings[1];
        } else {
            throw new Exception("т.к. строка не является математической операцией");
        }

    }
}
