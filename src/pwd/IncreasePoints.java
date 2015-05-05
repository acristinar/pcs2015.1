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
        setQuant(password);
        if (getQuantityOfNumber() > ZERO) {
            level++;
        }
        if (getQuantityOfSmallLetter() > ZERO) {
            level++;
        }
        if (length > SMALL && getQuantityOfCapitalLetter() > ZERO) {
            level++;
        }
        if (length > DEFAULT && getQuantOtherChar() > ZERO) {
            level++;
        }
        if (length > SMALL && getQuantityOfNumber() > ZERO && getQuantityOfSmallLetter() > ZERO
                || getQuantityOfNumber() > ZERO && getQuantityOfCapitalLetter() > ZERO
                || getQuantityOfNumber() > ZERO && getQuantOtherChar() > ZERO
                || getQuantityOfSmallLetter() > ZERO && getQuantityOfCapitalLetter() > ZERO
                || getQuantityOfSmallLetter() > ZERO && getQuantOtherChar() > ZERO
                || getQuantityOfCapitalLetter() > ZERO && getQuantOtherChar() > ZERO) {
            level++;
        }
        if (length > DEFAULT && getQuantityOfNumber() > ZERO && getQuantityOfSmallLetter() > ZERO && getQuantityOfCapitalLetter() > ZERO
                || getQuantityOfNumber() > ZERO && getQuantityOfSmallLetter() > ZERO && getQuantOtherChar() > ZERO
                || getQuantityOfNumber() > ZERO && getQuantityOfCapitalLetter() > ZERO && getQuantOtherChar() > ZERO
                || getQuantityOfSmallLetter() > ZERO && getQuantityOfCapitalLetter() > ZERO && getQuantOtherChar() > ZERO) {
            level++;
        }
        if (length > BIG && getQuantityOfNumber() > ZERO && getQuantityOfSmallLetter() > ZERO
                && getQuantityOfCapitalLetter() > ZERO && getQuantOtherChar() > ZERO) {
            level++;
        }
        if (length > DEFAULT && getQuantityOfNumber() >= SMALL && getQuantityOfSmallLetter() >= SMALL
                || getQuantityOfNumber() >= SMALL && getQuantityOfCapitalLetter() >= SMALL
                || getQuantityOfNumber() >= SMALL && getQuantOtherChar() >= EXTREMELY_SMALL
                || getQuantityOfSmallLetter() >= SMALL && getQuantityOfCapitalLetter() >= SMALL
                || getQuantityOfSmallLetter() >= SMALL && getQuantOtherChar() >= EXTREMELY_SMALL
                || getQuantityOfCapitalLetter() >= SMALL && getQuantOtherChar() >= EXTREMELY_SMALL) {
            level++;
        }
        if (length > BIG && getQuantityOfNumber() >= EXTREMELY_SMALL && getQuantityOfSmallLetter() >= EXTREMELY_SMALL && getQuantityOfCapitalLetter() >= EXTREMELY_SMALL
                || getQuantityOfNumber() >= EXTREMELY_SMALL && getQuantityOfSmallLetter() >= EXTREMELY_SMALL && getQuantOtherChar() >= EXTREMELY_SMALL
                || getQuantityOfNumber() >= EXTREMELY_SMALL && getQuantityOfCapitalLetter() >= EXTREMELY_SMALL && getQuantOtherChar() >= EXTREMELY_SMALL
                || getQuantityOfSmallLetter() >= EXTREMELY_SMALL && getQuantityOfCapitalLetter() >= EXTREMELY_SMALL && getQuantOtherChar() >= EXTREMELY_SMALL) {
            level++;
        }
        if (length > EXTREMELY_BIG && getQuantityOfNumber() >= EXTREMELY_SMALL && getQuantityOfSmallLetter() >= EXTREMELY_SMALL
                && getQuantityOfCapitalLetter() >= EXTREMELY_SMALL && getQuantOtherChar() >= EXTREMELY_SMALL) {
            level++;
        }
        if (getQuantOtherChar() >= SMALL) {
            level++;
        }
        if (getQuantOtherChar() >= DEFAULT) {
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