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

    public static int decreaseLevel(String password, int length, int level) {
        setQuant(password);
        
        level = verifySimpleSequence(password, level);

        if (getQuantityOfNumber() == length || getQuantityOfSmallLetter() == length || getQuantityOfCapitalLetter() == length) {
            level--;
        }
        if (length % EXTREMELY_SMALL == ZERO) { // aaabbb
            level = verifyPairRepeatSequence(length, password, level);
        }
        if (length % SMALL == ZERO) { // ababab
            level = verifyOddRepeatSequence(length, password, level);
        }
        if (StringUtils.verifyIsNumeric(password) && length >= DEFAULT) { // 19881010 or 881010
            level = verifyDate(password, length, level);
        }
        if (null != getDICTIONARY() && getDICTIONARY().length > ZERO) {
            level = wordDictionary(password, level);
        }
        if (length <= DEFAULT) {
            level--;
        }
        if (length <= MIDDLE) {
            level--;
        }
        if (length <= SMALL) {
            level = ZERO;
        }
        if (StringUtils.verifyIsCharEqual(password)) {
            level = ZERO;
        }
        if (level < ZERO) {
            level = ZERO;
        }
        return level;
    }

    private static int wordDictionary(String password, int level) {
        for (int i = 0; i < getDICTIONARY().length; i++) {
            if (password.equals(getDICTIONARY()[i]) || getDICTIONARY()[i].indexOf(password) >= ZERO) {
                level--;
                break;
            }
        }
        return level;
    }

    private static int verifyDate(String password, int length, int level) throws NumberFormatException {
        int year = 0;
        if (length == BIG || length == DEFAULT) {
            year = Integer.parseInt(password.substring(0, length - 4));
        }
        int size = StringUtils.verifySizeNumber(year);
        int month = Integer.parseInt(password.substring(size, size + 2));
        int day = Integer.parseInt(password.substring(size + 2, length));
        if (year >= 1950 && year < 2050 && month >= 1 && month <= 12 && day >= 1 && day <= 31) {
            level--;
        }
        return level;
    }

    private static int verifyOddRepeatSequence(int length, String password, int level) {
        String part1 = password.substring(0, length / 3);
        String part2 = password.substring(length / 3, length / 3 * 2);
        String part3 = password.substring(length / 3 * 2);
        if (part1.equals(part2) && part2.equals(part3)) {
            level--;
        }
        return level;
    }

    private static int verifyPairRepeatSequence(int length, String password, int level) {
        String part1 = password.substring(0, length / 2);
        String part2 = password.substring(length / 2);
        if (part1.equals(part2)) {
            level--;
        }
        if (StringUtils.verifyIsCharEqual(part1) && StringUtils.verifyIsCharEqual(part2)) {
            level--;
        }

        return level;
    }

    private static int verifySimpleSequence(String password, int level) {
        if ("abcdefghijklmnopqrstuvwxyz".indexOf(password) > 0 || "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(password) > 0) {
            level--;
        }
        if ("qwertyuiop".indexOf(password) > 0 || "asdfghjkl".indexOf(password) > 0 || "zxcvbnm".indexOf(password) > 0) {
            level--;
        }
        if (StringUtils.verifyIsNumeric(password) && ("01234567890".indexOf(password) > 0 || "09876543210".indexOf(password) > 0)) {
            level--;
        }
        return level;
    }
}