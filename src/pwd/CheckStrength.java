/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwd;

/**
 * Check strength of a password string
 *
 */
public class CheckStrength {

    public enum LEVEL {
        EASY, MEDIUM, STRONG, VERY_STRONG, EXTREMELY_STRONG
    }

//    static int level = 0;
    
    public static int checkPasswordStrength(String password) {
        if (StringUtils.verifyIsNull(password)) {
            throw new IllegalArgumentException("password is empty");
        }
        return CountPoints.Points(password);
    }

    public static String getPasswordLevel(int level) {
        switch (level) {
            case 0:
            case 1:
            case 2:
            case 3:
                return LEVEL.EASY.name();
            case 4:
            case 5:
            case 6:
                return LEVEL.MEDIUM.name();
            case 7:
            case 8:
            case 9:
                return LEVEL.STRONG.name();
            case 10:
            case 11:
            case 12:
                return LEVEL.VERY_STRONG.name();
            default:
                return LEVEL.EXTREMELY_STRONG.name();
        }
    }
}
