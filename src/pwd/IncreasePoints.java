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
public class IncreasePoints extends CountPoints {
    
    private static int increaseLevel;

    public static int increaseLevel(String password, int level) {
        setQuant(password);
        
        int length = password.length();
        increaseLevel = level;
        
        oneTypeOfCharacter();
        twoTypeOfCharacters(length);
        threeTypeOfCharacters(length);
        fourTypeOfCharacters(length);
        passwordSize(length);
        
        return level = increaseLevel;
    }

    private static void fourTypeOfCharacters(int length) { 
        int size[] = {1, EXTREMELY_SMALL, BIG, EXTREMELY_BIG};
        for(int i = 0; i < size.length/2; i++){
            if (length > size[i+2] && getQuantityOfNumber() >= size[i] && getQuantityOfSmallLetter() >= size[i]
                && getQuantityOfCapitalLetter() >= size[i] && getQuantityOtherChar() >= size[i]) {
                increaseLevel++;
            }
        }
    }

    private static void threeTypeOfCharacters(int length) {
        int value1[] = {1, DEFAULT};
        if (valueAndQuantity3(length, value1)) {
            increaseLevel++;
        }
        int value2[] = {EXTREMELY_SMALL, BIG};
        if (valueAndQuantity3(length, value2)) {
            increaseLevel++;
        }
    }

    private static boolean valueAndQuantity3(int length, int[] value) { 
        if (length > value[value.length-1] && getQuantityOfNumber() >= value[0] && getQuantityOfSmallLetter() >= value[0] && getQuantityOfCapitalLetter() >= value[0]) {
            return true;
        }
        if (getQuantityOfSmallLetter() >= value[0] && getQuantityOfCapitalLetter() >= value[0] && getQuantityOtherChar() >= value[0]) {
            return true;
        }
        int characters[] = {getQuantityOfNumber(), getQuantityOfSmallLetter(), getQuantityOfCapitalLetter()};
        for (int i = 0; i < characters.length-1; i++) {
            if (characters[0] >= value[0] && characters[i+1] >= value[0] && getQuantityOtherChar() >= value[0]) {
                return true;
            }
        }
        return false;
    }

    private static void twoTypeOfCharacters(int length) {
        int value1[] = {1, 1, SMALL};
        if (valueAndQuantity2(length, value1)) {
            increaseLevel++;
        }
        int value2[] = {EXTREMELY_SMALL, SMALL, DEFAULT};
        if (valueAndQuantity2(length, value2)) {
            increaseLevel++;
        }
    }
    
    private static boolean valueAndQuantity2(int length, int[] value) { // retirando if's aninhados
        if (length > value[value.length-1] && getQuantityOfNumber() >= value[1] && getQuantityOfSmallLetter() >= value[1]) {
            return true;
        }
        if (getQuantityOfCapitalLetter() >= value[1] && getQuantityOtherChar() >= value[0]) {
            return true;
        }
        int characters[] = {getQuantityOfNumber(), getQuantityOfSmallLetter()};
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] >= value[1] && getQuantityOfCapitalLetter() >= value[1]) {
                return true;
            }
            if (characters[i] >= value[1] && getQuantityOtherChar() >= value[0]) {
                return true;
            }
        }
        return false;
    }

    private static void passwordSize(int length) { 
        int characters[] = {getQuantityOfCapitalLetter(), getQuantityOtherChar()};
        int size[] = {SMALL, DEFAULT};
        for(int i = 0; i < characters.length; i++){
            if (length > size[i] && characters[i] > ZERO) {
                increaseLevel++;
            }
        }
        if (length > 12 && length < 16) {
            increaseLevel++;
        }
        if (length >= 16) {
            increaseLevel = increaseLevel+2;
        }
    }

    private static void oneTypeOfCharacter() { 
        int characters[] = {getQuantityOfNumber(), getQuantityOfSmallLetter()};
        int quantity[] = {SMALL, DEFAULT};
        for (int j = 0; j < quantity.length; j++) {
            if (getQuantityOtherChar() >= quantity[j]){
                increaseLevel++;
            }
            if (characters[j] > ZERO){
                increaseLevel++;
            } 
        }
    }
}