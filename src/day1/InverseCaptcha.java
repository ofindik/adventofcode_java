package day1;

public class InverseCaptcha {

	public int process (String captcha) {
		int result = 0;
		char[] digits = captcha.toCharArray ();
		int firstChar = Character.getNumericValue (digits[0]);
		int nextChar;
		for (int i = 1; i < digits.length;i++) {
			nextChar = Character.getNumericValue (digits[i]);
			if (nextChar == firstChar) {
				result += firstChar;
			}
			firstChar = nextChar;
		}
		nextChar = Character.getNumericValue (digits[0]);
		if (nextChar == firstChar) {
			result += firstChar;
		}

		return result;
	}

}
