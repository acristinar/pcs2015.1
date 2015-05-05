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
        if (getQuantNum() > EMPTY) {
            level++;
        }
        if (getQuantSmallLetter() > EMPTY) {
            level++;
        }
        if (length > TAM_MEDIO && getQuantCapitalLetter() > EMPTY) {
            level++;
        }
        if (length >  TAM_MEDIO && getQuantOtherChar() > EMPTY) {
            level++;
        }
        if (length >  TAM_MEDIO && getQuantNum() > EMPTY && getQuantSmallLetter() > EMPTY
                || getQuantNum() > EMPTY && getQuantCapitalLetter() > EMPTY
                || getQuantNum() > EMPTY && getQuantOtherChar() > EMPTY
                || getQuantSmallLetter() > EMPTY && getQuantCapitalLetter() > EMPTY
                || getQuantSmallLetter() > EMPTY && getQuantOtherChar() > EMPTY
                || getQuantCapitalLetter() > EMPTY && getQuantOtherChar() > EMPTY) {
            level++;
        }
        if (length >  TAM_MEDIO && getQuantNum() > EMPTY && getQuantSmallLetter() > EMPTY && getQuantCapitalLetter() > EMPTY
                || getQuantNum() > EMPTY && getQuantSmallLetter() > EMPTY && getQuantOtherChar() > EMPTY
                || getQuantNum() > EMPTY && getQuantCapitalLetter() > EMPTY && getQuantOtherChar() > EMPTY
                || getQuantSmallLetter() > EMPTY && getQuantCapitalLetter() > EMPTY && getQuantOtherChar() > EMPTY) {
            level++;
        }
        if (length > 8 && getQuantNum() > EMPTY && getQuantSmallLetter() > EMPTY
                && getQuantCapitalLetter() > EMPTY && getQuantOtherChar() > EMPTY) {
            level++;
        }
        if (length >  TAM_MEDIO && getQuantNum() >=  TAM_PEQUENO && getQuantSmallLetter() >=  TAM_PEQUENO
                || getQuantNum() >=  TAM_PEQUENO && getQuantCapitalLetter() >=  TAM_PEQUENO
                || getQuantNum() >=  TAM_PEQUENO && getQuantOtherChar() >= 2
                || getQuantSmallLetter() >=  TAM_PEQUENO && getQuantCapitalLetter() >=  TAM_PEQUENO
                || getQuantSmallLetter() >=  TAM_PEQUENO && getQuantOtherChar() >= 2
                || getQuantCapitalLetter() >=  TAM_PEQUENO && getQuantOtherChar() >= 2) {
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
        if (getQuantOtherChar() >=  TAM_PEQUENO) {
            level++;
        }
        if (getQuantOtherChar() >=  TAM_MEDIO) {
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