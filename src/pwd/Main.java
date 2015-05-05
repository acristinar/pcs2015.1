package pwd;

/**
 * Test password level
 * 
 */
public class Main {

	public static void main(String[] args) {
		String password = "2hAj5#mne-ix.86H";
		System.out.println(CheckStrength.getPasswordLevel(password));
	}

}