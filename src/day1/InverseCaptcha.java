package day1;

public class InverseCaptcha {

	public int process (String captcha) {
		int result = 0;
		char[] digits = captcha.toCharArray ();
		int length = digits.length;
		int firstChar = Character.getNumericValue (digits[0]);
		int nextChar;
		for (int i = 1; i <= length; i++) {
			nextChar = Character.getNumericValue (digits[i % length]);
			if (nextChar == firstChar) {
				result += firstChar;
			}
			firstChar = nextChar;
		}

		return result;
	}

	public int process2 (String captcha) {
		int result = 0;
		char[] digits = captcha.toCharArray ();
		int length = digits.length;
		int step = length / 2;
		int firstChar = Character.getNumericValue (digits[0]);
		int nextChar, checkChar;
		for (int i = 1; i <= length; i++) {
			nextChar = Character.getNumericValue (digits[i % length]);
			checkChar = Character.getNumericValue (digits[(i - 1 + step) % length]);
			if (checkChar == firstChar) {
				result += firstChar;
			}
			firstChar = nextChar;
		}

		return result;
	}
}