import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private Map<Character, Integer> romanNumerals  = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        Character currentChar;
        int currentCharValue;
        Character nextChar;
        int nextCharValue;
        int result = 0;
        int length = s.length();

        for (int i=0; i<length-1; i++){

            currentChar = s.charAt(i);
            currentCharValue =  romanNumerals.get(currentChar);
            nextChar = s.charAt(i+1);
            nextCharValue = romanNumerals.get(nextChar);

            if (currentCharValue >= nextCharValue)
                result += currentCharValue;

            else
                result -= currentCharValue;
        }

        return result+=romanNumerals.get(s.charAt(length-1));
    }

    public static void main(String[] args){
        RomanToInteger romanToInteger = new RomanToInteger();

        System.out.println(romanToInteger.romanToInt("III"));
        System.out.println(romanToInteger.romanToInt("LVIII"));
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }



}
