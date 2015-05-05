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
        EASY, MIDIUM, STRONG, VERY_STRONG, EXTREMELY_STRONG
    }

    public static int checkPasswordStrength(String passwd) {
        if (StringUtils.equalsNull(passwd)) {
            throw new IllegalArgumentException("password is empty");
        }
        int length = passwd.length();
        int level = 0;
        level = IncreasePoints.increaseLevel(passwd, length, level);
        level = DecreasePoints.decreaseLevel(passwd, length, level);
        return level;
    }

    public static String getPasswordLevel(String passwd) {
        int level = checkPasswordStrength(passwd);
        switch (level) {
            case 0:
            case 1:
            case 2:
            case 3:
                return LEVEL.EASY.name();
            case 4:
            case 5:
            case 6:
                return LEVEL.MIDIUM.name();
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
