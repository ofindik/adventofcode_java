package day4;

public class Passphrase {

	public boolean isValid (String passphrase) {
		String[] wordArray = passphrase.split (" ");
		for (int i = 0; i < wordArray.length; i++) {
			for (int j = 0; j < wordArray.length; j++) {
				if ((wordArray[i].equals (wordArray[j])) && (i != j)) {
					return false;
				}

			}
		}

		return true;
	}

}
