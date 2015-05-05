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
            return "NUMBER";
        }
        if (Character.isUpperCase(c)) {
            return "CAPITAL_LETTER";
        }
        if (Character.isLowerCase(c)) {
            return "SMALL_LETTER";
        }
        return "OTHER_CHAR";
    }

   public static Map quantityOfLetter(String password) {
        quantityEachLetter.put("NUMBER", 0);
        quantityEachLetter.put("CAPITAL_LETTER", 0);
        quantityEachLetter.put("SMALL_LETTER", 0);
        quantityEachLetter.put("OTHER_CHAR", 0);

        if (!verifyIsNull(password)) {
            quantityEachLetter = countLetter(password);
        }
        return quantityEachLetter;
    }
        
   private static Map countLetter(String password) {
        Integer count;
        for (char c : password.toCharArray()) {
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
    public static int verifySizeNumber(int number) {
        int size;
        byte[] digits = getDigits(number);
        size = digits.length;
        return size; 
    }

    /**
     * Judge whether each character of the string equals
     */
    public static boolean verifyIsChar(String sequence) {
        return sequence.replace(sequence.charAt(0), ' ').trim().length() == 0;
    }

    public static boolean verifyIsNumeric(String sequence) {
        for (int i = sequence.length(); --i >= 0;) {
            if (!Character.isDigit(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Judge whether the string is whitespace, empty ("") or null.
     */
    public static boolean verifyIsNull(String sequence) {
        int sizeSequence;
        if (sequence == null || (sizeSequence = sequence.length()) == 0 || sequence.equalsIgnoreCase("null")) {
            return true;
        }
        for (int i = 0; i < sizeSequence; i++) {
            if ((Character.isWhitespace(sequence.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

}