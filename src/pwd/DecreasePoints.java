/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwd;

/**
 *
 * @author Lucianna
 */
public class DecreasePoints extends CountPoints{

    private static int decreaseLevel;
    
    public static int decreaseLevel(String password, int level) {
        
        int length = password.length();
        decreaseLevel = level;
        
        simpleSequence(password);
        passwordSize(length);
        pairRepeatSequence(length, password);
        oddRepeatSequence(length, password);
        date(password, length);
        wordDictionary(password);
        setLevelZero(length, password);
        
        return level = decreaseLevel;
    }

    private static void passwordSize(int length) {
        if (getQuantityOfNumber() == length || getQuantityOfSmallLetter() == length || getQuantityOfCapitalLetter() == length) {
            decreaseLevel--;
        }
        if (length <= DEFAULT && length > MEDIUM) {
            decreaseLevel--;
        }
        if (length <= MEDIUM) {
            decreaseLevel = decreaseLevel-2;
        }
    }

    private static void setLevelZero(int length, String password) {
        if (length <= SMALL || StringUtils.verifyIsCharEqual(password) || decreaseLevel < ZERO) {
            decreaseLevel = ZERO;
        }
    }

    private static void wordDictionary(String password) {
        try {
            for (String dictionary : getDICTIONARY()) {
                if (password.equals(dictionary) || dictionary.indexOf(password) >= ZERO) {
                    decreaseLevel--;
                    break;
                }
            }
        } catch (NullPointerException e) {
            decreaseLevel = decreaseLevel;
        }
    }

    private static void date(String password, int length) throws NumberFormatException {
        if (StringUtils.verifyIsNumeric(password) && length >= DEFAULT) { // 19881010 or 881010
            int year = 0;
            if (length == BIG || length == DEFAULT) {
                year = Integer.parseInt(password.substring(0, length - 4));
            }
            int size = StringUtils.verifySizeNumber(year);
            int month = Integer.parseInt(password.substring(size, size + 2));
            int day = Integer.parseInt(password.substring(size + 2, length));
            if (year >= 1950 && year < 2050 && month >= 1 && month <= 12 && day >= 1 && day <= 31) {
                decreaseLevel--;
            }
        }
    }

    private static void oddRepeatSequence(int length, String password) {
        if (length % SMALL == ZERO) { // ababab
            String part1 = password.substring(0, length / 3);
            String part2 = password.substring(length / 3, length / 3 * 2);
            String part3 = password.substring(length / 3 * 2);
            if (part1.equals(part2) && part2.equals(part3)) {
                decreaseLevel--;
            }
        }
    }

    private static void pairRepeatSequence(int length, String password) {
        if (length % EXTREMELY_SMALL == ZERO) { 
            String part1 = password.substring(0, length / 2);
            String part2 = password.substring(length / 2);
            if (part1.equals(part2)) {
                decreaseLevel--;
            }
            if (StringUtils.verifyIsCharEqual(part1) && StringUtils.verifyIsCharEqual(part2)) {
                decreaseLevel--;
            }
        }
    }

    private static void simpleSequence(String password) {
        if ("abcdefghijklmnopqrstuvwxyz".indexOf(password) > 0 || "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(password) > 0) {
            decreaseLevel--;
        }
        if ("qwertyuiop".indexOf(password) > 0 || "asdfghjkl".indexOf(password) > 0 || "zxcvbnm".indexOf(password) > 0) {
            decreaseLevel--;
        }
        if (StringUtils.verifyIsNumeric(password) && ("01234567890".indexOf(password) > 0 || "09876543210".indexOf(password) > 0)) {
            decreaseLevel--;
        }
    }
}