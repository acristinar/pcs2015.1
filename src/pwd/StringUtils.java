package pwd;

import java.util.HashMap;
import java.util.Map;

/**
 * {@code StringUtils} contains static methods which operate on a string.
 */
public class StringUtils {

    private static Map<String, Integer> quantityEachLetter = new HashMap<>();
    
    public static String checkCharacterType(char c) {
            if (Character.isDigit(c)) {
                return "NUM";
            }
            if (Character.isUpperCase(c)) {
                return "CAPITAL_LETTER";
            }
            if (Character.isLowerCase(c)) {
                return "SMALL_LETTER";
            }
            return "OTHER_CHAR";
    }

    /**
     * Quantity of password's number by different type
     */
    public static Map quantLetter(String passwd) {
        quantityEachLetter.put("NUM", 0);
        quantityEachLetter.put("CAPITAL_LETTER", 0);
        quantityEachLetter.put("SMALL_LETTER", 0);
        quantityEachLetter.put("OTHER_CHAR", 0);

        if (!equalsNull(passwd)) {
            quantityEachLetter = countLetter(passwd);
        }
        return quantityEachLetter;
    }
        
    /**
     * Count password's number by different type
     */
     private static Map countLetter(String passwd) {
        Integer count;
        for (char c : passwd.toCharArray()) {
            String type = checkCharacterType(c);
            count = quantityEachLetter.get(type) + 1;
            quantityEachLetter.put(type, count);
        }
        return quantityEachLetter;
    }
     
    public static byte[] getDigits(int number) {  
        char[] caracteres = String.valueOf(number).toCharArray();  
        byte[] digits = new byte[caracteres.length];  
        for (int i = 0; i < digits.length; i++) {  
            digits[i] = Byte.parseByte(String.valueOf(caracteres[i]));  
        }  
        return digits;  
    }  

    /**
     * calculate the size of an integer number
     */
    public static int sizeOfInt(int number) {
        int size;
        byte[] digits = getDigits(number);
        size = digits.length;
        return size; 
    }

    /**
     * Judge whether each character of the string equals
     */
    public static boolean isCharEqual(String str) {
            return str.replace(str.charAt(0), ' ').trim().length() == 0;
    }

    /**
     * Determines if the string is a digit
     */
    public static boolean isNumeric(String str) {
            for (int i = str.length(); --i >= 0;) {
                    if (!Character.isDigit(str.charAt(i))) {
                            return false;
                    }
            }
            return true;
    }

    /**
     * Judge whether the string is whitespace, empty ("") or null.
     */
    public static boolean equalsNull(String str) {
            int strLen;
            if (str == null || (strLen = str.length()) == 0 || str.equalsIgnoreCase("null")) {
                    return true;
            }
            for (int i = 0; i < strLen; i++) {
                    if ((Character.isWhitespace(str.charAt(i)) == false)) {
                            return false;
                    }
            }
            return true;
    }

}