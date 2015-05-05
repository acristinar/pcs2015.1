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

        if (getQuantNum() == length || getQuantSmallLetter() == length || getQuantCapitalLetter() == length) {
            level--;
        }
        if (length % 2 == EMPTY) { // aaabbb
            level = verifyPairRepeatSequence(length, password, level);
        }
        if (length % TAM_PEQUENO == EMPTY) { // ababab
            level = verifyOddRepeatSequence(length, password, level);
        }
        if (StringUtils.verifyIsNumeric(password) && length >= TAM_PADRAO) { // 19881010 or 881010
            level = verifyDate(password, length, level);
        }
        if (null != getDICTIONARY() && getDICTIONARY().length > EMPTY) {
            level = wordDictionary(password, level);
        }
        if (length <= TAM_PADRAO) {
            level--;
        }
        if (length <= 4) {
            level--;
        }
        if (length <= TAM_PEQUENO) {
            level = EMPTY;
        }
        if (StringUtils.verifyIsChar(password)) {
            level = EMPTY;
        }
        if (level < EMPTY) {
            level = EMPTY;
        }
        return level;
    }

    /**
     * Compare password with words from the dictionary
     */
    private static int wordDictionary(String password, int level) {
        for (int i = 0; i < getDICTIONARY().length; i++) {
            if (password.equals(getDICTIONARY()[i]) || getDICTIONARY()[i].indexOf(password) >= EMPTY) {
                level--;
                break;
            }
        }
        return level;
    }

    /**
     * Judge whether the password is a verifyDate
     */
    private static int verifyDate(String password, int length, int level) throws NumberFormatException {
        int year = 0;
        if (length == 8 || length == TAM_PADRAO) {
            year = Integer.parseInt(password.substring(0, length - 4));
        }
        int size = StringUtils.verifySizeNumber(year);
        int month = Integer.parseInt(password.substring(size, size + 2));
        int day = Integer.parseInt(password.substring(size + 2, length));
        if (year >= 1950 && year < 2050 && month >= 1 && month <= 12 && day >= 1 && day <= TAM_PEQUENO) {
            level--;
        }
        return level;
    }

    /**
     * Judge whether the password is an odd repeat sequence
     */
    private static int verifyOddRepeatSequence(int length, String password, int level) {
        String part1 = password.substring(0, length / 3);
        String part2 = password.substring(length / 3, length / 3 * 2);
        String part3 = password.substring(length / 3 * 2);
        if (part1.equals(part2) && part2.equals(part3)) {
            level--;
        }
        return level;
    }

    /**
     * Judge whether the password is a pair repeat sequence
     */
    private static int verifyPairRepeatSequence(int length, String password, int level) {
        String part1 = password.substring(0, length / 2);
        String part2 = password.substring(length / 2);
        if (part1.equals(part2)) {
            level--;
        }
        if (StringUtils.verifyIsChar(part1) && StringUtils.verifyIsChar(part2)) {
            level--;
        }

        return level;
    }

    /**
     * Judge whether the password is a common sequence
     */
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