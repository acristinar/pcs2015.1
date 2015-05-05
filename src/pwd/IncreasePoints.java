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

    public static int increaseLevel(String password, int length, int level) {
        setQuantity(password);
        if (getQuantityOfNumber() > 0) {
            level++;
        }
        if (getQuantityOfSmallLetter() > 0) {
            level++;
        }
        if (length > 4 && getQuantityOfCapitalLetter() > 0) {
            level++;
        }
        if (length > 6 && getQuantityOfOtherChar() > 0) {
            level++;
        }
        if (length > 4 && getQuantityOfNumber() > 0 && getQuantityOfSmallLetter() > 0
                || getQuantityOfNumber() > 0 && getQuantityOfCapitalLetter() > 0
                || getQuantityOfNumber() > 0 && getQuantityOfOtherChar() > 0
                || getQuantityOfSmallLetter() > 0 && getQuantityOfCapitalLetter() > 0
                || getQuantityOfSmallLetter() > 0 && getQuantityOfOtherChar() > 0
                || getQuantityOfCapitalLetter() > 0 && getQuantityOfOtherChar() > 0) {
            level++;
        }
        if (length > 6 && getQuantityOfNumber() > 0 && getQuantityOfSmallLetter() > 0 && getQuantityOfCapitalLetter() > 0
                || getQuantityOfNumber() > 0 && getQuantityOfSmallLetter() > 0 && getQuantityOfOtherChar() > 0
                || getQuantityOfNumber() > 0 && getQuantityOfCapitalLetter() > 0 && getQuantityOfOtherChar() > 0
                || getQuantityOfSmallLetter() > 0 && getQuantityOfCapitalLetter() > 0 && getQuantityOfOtherChar() > 0) {
            level++;
        }
        if (length > 8 && getQuantityOfNumber() > 0 && getQuantityOfSmallLetter() > 0
                && getQuantityOfCapitalLetter() > 0 && getQuantityOfOtherChar() > 0) {
            level++;
        }
        if (length > 6 && getQuantityOfNumber() >= 3 && getQuantityOfSmallLetter() >= 3
                || getQuantityOfNumber() >= 3 && getQuantityOfCapitalLetter() >= 3
                || getQuantityOfNumber() >= 3 && getQuantityOfOtherChar() >= 2
                || getQuantityOfSmallLetter() >= 3 && getQuantityOfCapitalLetter() >= 3
                || getQuantityOfSmallLetter() >= 3 && getQuantityOfOtherChar() >= 2
                || getQuantityOfCapitalLetter() >= 3 && getQuantityOfOtherChar() >= 2) {
            level++;
        }
        if (length > 8 && getQuantityOfNumber() >= 2 && getQuantityOfSmallLetter() >= 2 && getQuantityOfCapitalLetter() >= 2
                || getQuantityOfNumber() >= 2 && getQuantityOfSmallLetter() >= 2 && getQuantityOfOtherChar() >= 2
                || getQuantityOfNumber() >= 2 && getQuantityOfCapitalLetter() >= 2 && getQuantityOfOtherChar() >= 2
                || getQuantityOfSmallLetter() >= 2 && getQuantityOfCapitalLetter() >= 2 && getQuantityOfOtherChar() >= 2) {
            level++;
        }
        if (length > 10 && getQuantityOfNumber() >= 2 && getQuantityOfSmallLetter() >= 2
                && getQuantityOfCapitalLetter() >= 2 && getQuantityOfOtherChar() >= 2) {
            level++;
        }
        if (getQuantityOfOtherChar() >= 3) {
            level++;
        }
        if (getQuantityOfOtherChar() >= 6) {
            level++;
        }
        if (length > 12) {
            level++;
        }
        if (length >= 16) {
            level++;
        }
        return level;
    }
}