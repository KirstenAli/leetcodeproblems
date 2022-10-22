import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RomanToInteger {

    private Set<Character> subtractionChars  = new HashSet<>() {{
        add('I');
        add('X');
        add('C');
    }};

    private Map<String, Integer> subtractionInstances  = new HashMap<>() {{
        put("IV", 4);
        put("IX", 9);
        put("XL", 40);
        put("XC", 90);
        put("CD", 400);
        put("CM", 900);
    }};

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
        Integer integer =0;

        for (int i=0; i<s.length(); i++){
            var temp = String.valueOf(s.charAt(i));

            if(subtractionChars.contains(temp.charAt(0))){
                if(i!=s.length()-1)
                    temp+= s.charAt(i+1);

                if(subtractionInstances.containsKey(temp)) {
                    integer += subtractionInstances.get(temp);
                    i++;
                }

                else integer+=romanNumerals.get(temp.charAt(0));

            } else {

                integer += romanNumerals.get(temp.charAt(0));
            }
        }

        return integer;
    }

    public static void main(String[] args){
        RomanToInteger romanToInteger = new RomanToInteger();

        System.out.println(romanToInteger.romanToInt("III"));
        System.out.println(romanToInteger.romanToInt("LVIII"));
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }



}
