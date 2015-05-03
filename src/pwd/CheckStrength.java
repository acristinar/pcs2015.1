<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwd;

import java.util.HashMap;
import java.util.Map;


/**
 * Check strength of a password string
 * 
 */
public class CheckStrength {

	public enum LEVEL {
		EASY, MIDIUM, STRONG, VERY_STRONG, EXTREMELY_STRONG
	}

        private static final Map<String, Integer> quantityEachLetter = new HashMap<>();
        
        private static int quantNum;
        private static int quantSmallLetter;
        private static int quantCapitalLetter;
        private static int quantOtherChar;
        
	/**
	 * Simple password dictionary
	 */
	private final static String[] DICTIONARY = { "password", "abc123", "iloveyou", "adobe123", "123123", "sunshine",
			"1314520", "a1b2c3", "123qwe", "aaa111", "qweasd", "admin", "passwd" };

	/**
	 * Check character's type, includes num, capital letter, small letter and other character.
	 * 
	 * @param c
	 * @return
	 */
	public static String checkCharacterType(char c) {
		if (Character.isDigit(c)) {
			return "NUM";
		}
		if (Character.isUpperCase(c)) {
			return "CAPITAL_LETTER";
		}
		if (Character.isLowerCase(c)) {
			return "SMALL_LETTER";
		}
		return "OTHER_CHAR";
	}

	/**
	 * Quantity of password's number by different type
	 * 
	 * @param passwd
	 */
	private static void quantLetter(String passwd) {
            quantityEachLetter.put("NUM", 0);
            quantityEachLetter.put("CAPITAL_LETTER", 0);
            quantityEachLetter.put("SMALL_LETTER", 0);
            quantityEachLetter.put("OTHER_CHAR", 0);
            
            if (null != passwd && passwd.length() > 0) {
		countLetter(passwd);
            }
        }
        
        /**
	 * Count password's number by different type
	 * 
	 * @param passwd
	 */
        private static void countLetter(String passwd) {
            Integer count;
            for (char c : passwd.toCharArray()) {
                String type = checkCharacterType(c);
                count = quantityEachLetter.get(type) + 1;
                quantityEachLetter.put(type, count);
            }
            quantNum = quantityEachLetter.get("NUM");
            quantSmallLetter = quantityEachLetter.get("SMALL_LETTER");
            quantCapitalLetter = quantityEachLetter.get("CAPITAL_LETTER");
            quantOtherChar = quantityEachLetter.get("OTHER_CHAR");
        }

	/**
	 * Check password's strength
	 * 
	 * @param passwd
	 * @return strength level
	 */
	public static int checkPasswordStrength(String passwd) {
		if (StringUtils.equalsNull(passwd)) {
			throw new IllegalArgumentException("password is empty");
		}
		
                int length = passwd.length();
		int level = 0;
                
                quantLetter(passwd);
        	level = increasePoints(length, level);
        	level = decreasePoints(passwd, length, level);

		return level;
	}

        private static int increasePoints(int length, int level) {
            
            if (quantNum > 0) {
                level++;
            }
            if (quantSmallLetter > 0) {
		level++;
            }
            if (length > 4 && quantCapitalLetter > 0) {
			level++;
		}
            if (length > 6 && quantOtherChar > 0) {
            	level++;
            }

            if (length > 4 && quantNum > 0 && quantSmallLetter > 0
			|| quantNum > 0 && quantCapitalLetter > 0
			|| quantNum > 0 && quantOtherChar > 0
			|| quantSmallLetter > 0 && quantCapitalLetter > 0
			|| quantSmallLetter > 0 && quantOtherChar > 0
			|| quantCapitalLetter > 0 && quantOtherChar > 0) {
		level++;
            }

            if (length > 6 && quantNum > 0 && quantSmallLetter > 0
                        && quantCapitalLetter > 0 || quantNum > 0
			&& quantSmallLetter > 0 && quantOtherChar > 0
			|| quantNum > 0 && quantCapitalLetter > 0
			&& quantOtherChar > 0 || quantSmallLetter > 0
			&& quantCapitalLetter > 0 && quantOtherChar > 0) {
		level++;
            }

            if (length > 8 && quantNum > 0 && quantSmallLetter > 0
                	&& quantCapitalLetter > 0 && quantOtherChar > 0) {
		level++;
            }

            if (length > 6 && quantNum >= 3 && quantSmallLetter >= 3
			|| quantNum >= 3 && quantCapitalLetter >= 3
			|| quantNum >= 3 && quantOtherChar >= 2
			|| quantSmallLetter >= 3 && quantCapitalLetter >= 3
			|| quantSmallLetter >= 3 && quantOtherChar >= 2
			|| quantCapitalLetter >= 3 && quantOtherChar >= 2) {
		level++;
            }

            if (length > 8 && quantNum >= 2 && quantSmallLetter >= 2
			&& quantCapitalLetter >= 2 || quantNum >= 2
			&& quantSmallLetter >= 2 && quantOtherChar >= 2
			|| quantNum >= 2 && quantCapitalLetter >= 2
			&& quantOtherChar >= 2 || quantSmallLetter >= 2
			&& quantCapitalLetter >= 2 && quantOtherChar >= 2) {
		level++;
            }

            if (length > 10 && quantNum >= 2 && quantSmallLetter >= 2
            	&& quantCapitalLetter >= 2 && quantOtherChar >= 2) {
		level++;
            }

            if (quantOtherChar >= 3) {
		level++;
            }
            if (quantOtherChar >= 6) {
		level++;
            }

            if (length > 12) {
		level++;
		if (length >= 16) {
                	level++;
		}
            }
            return level;
        }
        
        private static int decreasePoints(String passwd, int length, int level) {
            
            if ("abcdefghijklmnopqrstuvwxyz".indexOf(passwd) > 0 || "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(passwd) > 0) {
		level--;
            }
            if ("qwertyuiop".indexOf(passwd) > 0 || "asdfghjkl".indexOf(passwd) > 0 || "zxcvbnm".indexOf(passwd) > 0) {
		level--;
            }
            if (StringUtils.isNumeric(passwd) && ("01234567890".indexOf(passwd) > 0 || "09876543210".indexOf(passwd) > 0)) {
		level--;
            }

            if (quantNum == length || quantSmallLetter == length || quantCapitalLetter == length) {
		level--;
            }

            if (length % 2 == 0) { // aaabbb
		String part1 = passwd.substring(0, length / 2);
		String part2 = passwd.substring(length / 2);
		if (part1.equals(part2)) {
                    level--;
		}
		if (StringUtils.isCharEqual(part1) && StringUtils.isCharEqual(part2)) {
                    level--;
		}
            }
            if (length % 3 == 0) { // ababab
            	String part1 = passwd.substring(0, length / 3);
		String part2 = passwd.substring(length / 3, length / 3 * 2);
		String part3 = passwd.substring(length / 3 * 2);
		if (part1.equals(part2) && part2.equals(part3)) {
                	level--;
		}
            }

            if (StringUtils.isNumeric(passwd) && length >= 6) { // 19881010 or 881010
		int year = 0;
		if (length == 8 || length == 6) {
                    year = Integer.parseInt(passwd.substring(0, length - 4));
		}
		int size = StringUtils.sizeOfInt(year);
		int month = Integer.parseInt(passwd.substring(size, size + 2));
		int day = Integer.parseInt(passwd.substring(size + 2, length));
		if (year >= 1950 && year < 2050 && month >= 1 && month <= 12 && day >= 1 && day <= 31) {
                    level--;
		}
            }

            if (null != DICTIONARY && DICTIONARY.length > 0) {// dictionary
		for (int i = 0; i < DICTIONARY.length; i++) {
                    if (passwd.equals(DICTIONARY[i]) || DICTIONARY[i].indexOf(passwd) >= 0) {
			level--;
			break;
                    }
		}
            }

            if (length <= 6) {
                level--;
		if (length <= 4) {
                    level--;
                    if (length <= 3) {
                       	level = 0;
                    }
		}
            }

            if (StringUtils.isCharEqual(passwd)) {
		level = 0;
            }

            if (level < 0) {
		level = 0;
            }
            
            return level;
        }
        
	/**
	 * Get password strength level, includes easy, midium, strong, very strong, extremely strong
	 * 
	 * @param passwd
	 * @return
	 */
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

=======
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

	private static final int NUM = 1;
	private static final int SMALL_LETTER = 2;
	private static final int CAPITAL_LETTER = 3;
	private static final int OTHER_CHAR = 4;

	/**
	 * Simple password dictionary
	 */
	private final static String[] DICTIONARY = { "password", "abc123", "iloveyou", "adobe123", "123123", "sunshine",
			"1314520", "a1b2c3", "123qwe", "aaa111", "qweasd", "admin", "passwd" };

	/**
	 * Check character's type, includes num, capital letter, small letter and other character.
	 * 
	 * @param c
	 * @return
	 */
	public static int checkCharacterType(char c) {
		if (Character.isDigit(c)) {
			return NUM;
		}
		if (Character.isUpperCase(c)) {
			return CAPITAL_LETTER;
		}
		if (Character.isLowerCase(c)) {
			return SMALL_LETTER;
		}
		return OTHER_CHAR;
	}
        
        

	/**
	 * Count password's number by different type
	 * 
	 * @param passwd
	 * @param type
	 * @return
	 */
	private static int countLetter(String passwd, int type) {
		int count = 0;
		if (null != passwd && passwd.length() > 0) {
			for (char c : passwd.toCharArray()) {
				if (checkCharacterType(c) == type) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Check password's strength
	 * 
	 * @param passwd
	 * @return strength level
	 */
	public static int checkPasswordStrength(String passwd) {
		if (StringUtils.equalsNull(passwd)) {
			throw new IllegalArgumentException("password is empty");
		}
		int len = passwd.length();
		int level = 0;

		// increase points
		if (countLetter(passwd, NUM) > 0) {
			level++;
		}
		if (countLetter(passwd, SMALL_LETTER) > 0) {
			level++;
		}
		if (len > 4 && countLetter(passwd, CAPITAL_LETTER) > 0) {
			level++;
		}
		if (len > 6 && countLetter(passwd, OTHER_CHAR) > 0) {
			level++;
		}

		if (len > 4 && countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0
				|| countLetter(passwd, NUM) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0
				|| countLetter(passwd, NUM) > 0 && countLetter(passwd, OTHER_CHAR) > 0
				|| countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0
				|| countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0
				|| countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0) {
			level++;
		}

		if (len > 6 && countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0
				&& countLetter(passwd, CAPITAL_LETTER) > 0 || countLetter(passwd, NUM) > 0
				&& countLetter(passwd, SMALL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0
				|| countLetter(passwd, NUM) > 0 && countLetter(passwd, CAPITAL_LETTER) > 0
				&& countLetter(passwd, OTHER_CHAR) > 0 || countLetter(passwd, SMALL_LETTER) > 0
				&& countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0) {
			level++;
		}

		if (len > 8 && countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0
				&& countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0) {
			level++;
		}

		if (len > 6 && countLetter(passwd, NUM) >= 3 && countLetter(passwd, SMALL_LETTER) >= 3
				|| countLetter(passwd, NUM) >= 3 && countLetter(passwd, CAPITAL_LETTER) >= 3
				|| countLetter(passwd, NUM) >= 3 && countLetter(passwd, OTHER_CHAR) >= 2
				|| countLetter(passwd, SMALL_LETTER) >= 3 && countLetter(passwd, CAPITAL_LETTER) >= 3
				|| countLetter(passwd, SMALL_LETTER) >= 3 && countLetter(passwd, OTHER_CHAR) >= 2
				|| countLetter(passwd, CAPITAL_LETTER) >= 3 && countLetter(passwd, OTHER_CHAR) >= 2) {
			level++;
		}

		if (len > 8 && countLetter(passwd, NUM) >= 2 && countLetter(passwd, SMALL_LETTER) >= 2
				&& countLetter(passwd, CAPITAL_LETTER) >= 2 || countLetter(passwd, NUM) >= 2
				&& countLetter(passwd, SMALL_LETTER) >= 2 && countLetter(passwd, OTHER_CHAR) >= 2
				|| countLetter(passwd, NUM) >= 2 && countLetter(passwd, CAPITAL_LETTER) >= 2
				&& countLetter(passwd, OTHER_CHAR) >= 2 || countLetter(passwd, SMALL_LETTER) >= 2
				&& countLetter(passwd, CAPITAL_LETTER) >= 2 && countLetter(passwd, OTHER_CHAR) >= 2) {
			level++;
		}

		if (len > 10 && countLetter(passwd, NUM) >= 2 && countLetter(passwd, SMALL_LETTER) >= 2
				&& countLetter(passwd, CAPITAL_LETTER) >= 2 && countLetter(passwd, OTHER_CHAR) >= 2) {
			level++;
		}

		if (countLetter(passwd, OTHER_CHAR) >= 3) {
			level++;
		}
		if (countLetter(passwd, OTHER_CHAR) >= 6) {
			level++;
		}

		if (len > 12) {
			level++;
			if (len >= 16) {
				level++;
			}
		}

		// decrease points
		if ("abcdefghijklmnopqrstuvwxyz".indexOf(passwd) > 0 || "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(passwd) > 0) {
			level--;
		}
		if ("qwertyuiop".indexOf(passwd) > 0 || "asdfghjkl".indexOf(passwd) > 0 || "zxcvbnm".indexOf(passwd) > 0) {
			level--;
		}
		if (StringUtils.isNumeric(passwd) && ("01234567890".indexOf(passwd) > 0 || "09876543210".indexOf(passwd) > 0)) {
			level--;
		}

		if (countLetter(passwd, NUM) == len || countLetter(passwd, SMALL_LETTER) == len
				|| countLetter(passwd, CAPITAL_LETTER) == len) {
			level--;
		}

		if (len % 2 == 0) { // aaabbb
			String part1 = passwd.substring(0, len / 2);
			String part2 = passwd.substring(len / 2);
			if (part1.equals(part2)) {
				level--;
			}
			if (StringUtils.isCharEqual(part1) && StringUtils.isCharEqual(part2)) {
				level--;
			}
		}
		if (len % 3 == 0) { // ababab
			String part1 = passwd.substring(0, len / 3);
			String part2 = passwd.substring(len / 3, len / 3 * 2);
			String part3 = passwd.substring(len / 3 * 2);
			if (part1.equals(part2) && part2.equals(part3)) {
				level--;
			}
		}

		if (StringUtils.isNumeric(passwd) && len >= 6) { // 19881010 or 881010
			int year = 0;
			if (len == 8 || len == 6) {
				year = Integer.parseInt(passwd.substring(0, len - 4));
			}
			int size = StringUtils.sizeOfInt(year);
			int month = Integer.parseInt(passwd.substring(size, size + 2));
			int day = Integer.parseInt(passwd.substring(size + 2, len));
			if (year >= 1950 && year < 2050 && month >= 1 && month <= 12 && day >= 1 && day <= 31) {
				level--;
			}
		}

		if (null != DICTIONARY && DICTIONARY.length > 0) {// dictionary
			for (int i = 0; i < DICTIONARY.length; i++) {
				if (passwd.equals(DICTIONARY[i]) || DICTIONARY[i].indexOf(passwd) >= 0) {
					level--;
					break;
				}
			}
		}

		if (len <= 6) {
			level--;
			if (len <= 4) {
				level--;
				if (len <= 3) {
					level = 0;
				}
			}
		}

		if (StringUtils.isCharEqual(passwd)) {
			level = 0;
		}

		if (level < 0) {
			level = 0;
		}

		return level;
	}

	/**
	 * Get password strength level, includes easy, midium, strong, very strong, extremely strong
	 * 
	 * @param passwd
	 * @return
	 */
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

>>>>>>> bf82015938567807e17c5a3f0bc85f97c1dd5a2a
}