package day2;

import java.util.List;

public class CorruptionChecksum {

	public int process (List<String> lines) {
		String firstLine = lines.get (0);
		String[] numberArray = firstLine.split (" ");
		return findMax (numberArray) - findMin (numberArray);
	}

	private int findMax (String[] numberArray) {
		int max = Integer.MIN_VALUE;
		for (String numberStr : numberArray) {
			int value = Integer.valueOf (numberStr);
			if (value > max) {
				max = value;
			}
		}
		System.out.println ("max:" + max);
		return max;
	}

	private int findMin (String[] numberArray) {
		int min = Integer.MAX_VALUE;
		for (String numberStr : numberArray) {
			int value = Integer.valueOf (numberStr);
			if (value < min) {
				min = value;
			}
		}
		System.out.println ("min:" + min);
		return min;
	}

}
