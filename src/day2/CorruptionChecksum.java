package day2;

import java.util.List;

public class CorruptionChecksum {

	public int process (List<String> lines) {
		int checksum = 0;
		for (String line : lines) {
			String[] numberArray = line.split ("\t");
			checksum += findMax (numberArray) - findMin (numberArray);
			
		}
		return checksum;
	}

	private int findMax (String[] numberArray) {
		int max = Integer.MIN_VALUE;
		for (String numberStr : numberArray) {
			int value = Integer.valueOf (numberStr);
			if (value > max) {
				max = value;
			}
		}
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
		return min;
	}

}
