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

    public static int increaseLevel(String passwd, int length, int level) {
        setQuant(passwd);
        if (getQuantNum() > 0) {
            level++;
        }
        if (getQuantSmallLetter() > 0) {
            level++;
        }
        if (length > 4 && getQuantCapitalLetter() > 0) {
            level++;
        }
        if (length > 6 && getQuantOtherChar() > 0) {
            level++;
        }
        if (length > 4 && getQuantNum() > 0 && getQuantSmallLetter() > 0
                || getQuantNum() > 0 && getQuantCapitalLetter() > 0
                || getQuantNum() > 0 && getQuantOtherChar() > 0
                || getQuantSmallLetter() > 0 && getQuantCapitalLetter() > 0
                || getQuantSmallLetter() > 0 && getQuantOtherChar() > 0
                || getQuantCapitalLetter() > 0 && getQuantOtherChar() > 0) {
            level++;
        }
        if (length > 6 && getQuantNum() > 0 && getQuantSmallLetter() > 0 && getQuantCapitalLetter() > 0
                || getQuantNum() > 0 && getQuantSmallLetter() > 0 && getQuantOtherChar() > 0
                || getQuantNum() > 0 && getQuantCapitalLetter() > 0 && getQuantOtherChar() > 0
                || getQuantSmallLetter() > 0 && getQuantCapitalLetter() > 0 && getQuantOtherChar() > 0) {
            level++;
        }
        if (length > 8 && getQuantNum() > 0 && getQuantSmallLetter() > 0
                && getQuantCapitalLetter() > 0 && getQuantOtherChar() > 0) {
            level++;
        }
        if (length > 6 && getQuantNum() >= 3 && getQuantSmallLetter() >= 3
                || getQuantNum() >= 3 && getQuantCapitalLetter() >= 3
                || getQuantNum() >= 3 && getQuantOtherChar() >= 2
                || getQuantSmallLetter() >= 3 && getQuantCapitalLetter() >= 3
                || getQuantSmallLetter() >= 3 && getQuantOtherChar() >= 2
                || getQuantCapitalLetter() >= 3 && getQuantOtherChar() >= 2) {
            level++;
        }
        if (length > 8 && getQuantNum() >= 2 && getQuantSmallLetter() >= 2 && getQuantCapitalLetter() >= 2
                || getQuantNum() >= 2 && getQuantSmallLetter() >= 2 && getQuantOtherChar() >= 2
                || getQuantNum() >= 2 && getQuantCapitalLetter() >= 2 && getQuantOtherChar() >= 2
                || getQuantSmallLetter() >= 2 && getQuantCapitalLetter() >= 2 && getQuantOtherChar() >= 2) {
            level++;
        }
        if (length > 10 && getQuantNum() >= 2 && getQuantSmallLetter() >= 2
                && getQuantCapitalLetter() >= 2 && getQuantOtherChar() >= 2) {
            level++;
        }
        if (getQuantOtherChar() >= 3) {
            level++;
        }
        if (getQuantOtherChar() >= 6) {
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