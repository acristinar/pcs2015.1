/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwd;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lucianna
 */
public class CountPoints {
    private static int quantityOfNumber;
    private static int quantityOfSmallLetter;
    private static int quantityOfCapitalLetter;
    private static int quantityOfOtherChar;
    private static Map<String, Integer> letter = new HashMap<>();
    
    private final static String[] DICTIONARY = {"password", "abc123", "iloveyou", "adobe123", "123123", "sunshine",
        "1314520", "a1b2c3", "123qwe", "aaa111", "qweasd", "admin", "passwd"};

    public static void setQuantity(String password) {
        letter = StringUtils.quantityOfLetter(password);
        quantityOfNumber = letter.get("NUMBER");
        quantityOfSmallLetter = letter.get("SMALL_LETTER");
        quantityOfCapitalLetter = letter.get("CAPITAL_LETTER");
        quantityOfOtherChar = letter.get("OTHER_CHAR");
    }

    public static int getQuantityOfNumber() {
        return quantityOfNumber;
    }

    public static int getQuantityOfSmallLetter() {
        return quantityOfSmallLetter;
    }

    public static int getQuantityOfCapitalLetter() {
        return quantityOfCapitalLetter;
    }

    public static int getQuantityOfOtherChar() {
        return quantityOfOtherChar;
    }

    public static String[] getDICTIONARY() {
        return DICTIONARY;
    }
}