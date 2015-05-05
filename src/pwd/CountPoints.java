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
    
    protected static final int ZERO = 0;
    protected static final int EXTREMELY_SMALL = 2;
    protected static final int SMALL = 3;
    protected static final int MIDDLE = 4;
    protected static final int DEFAULT = 6;
    protected static final int BIG = 8;
    protected static final int EXTREMELY_BIG = 10;
    
    private static int quantNum;
    private static int quantSmallLetter;
    private static int quantCapitalLetter;
    private static int quantOtherChar;
    private static Map<String, Integer> letter = new HashMap<>();
    
    private final static String[] DICTIONARY = {"password", "abc123", "iloveyou", "adobe123", "123123", "sunshine",
        "1314520", "a1b2c3", "123qwe", "aaa111", "qweasd", "admin", "passwd"};

    public static void setQuant(String password) {
        letter = StringUtils.quantLetter(password);
        quantNum = letter.get("NUM");
        quantSmallLetter = letter.get("SMALL_LETTER");
        quantCapitalLetter = letter.get("CAPITAL_LETTER");
        quantOtherChar = letter.get("OTHER_CHAR");
    }

    public static int getQuantityOfNumber() {
        return quantNum;
    }

    public static int getQuantityOfSmallLetter() {
        return quantSmallLetter;
    }

    public static int getQuantityOfCapitalLetter() {
        return quantCapitalLetter;
    }

    public static int getQuantOtherChar() {
        return quantOtherChar;
    }

    public static String[] getDICTIONARY() {
        return DICTIONARY;
    }
}