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

	public int process2 (List<String> lines) {
		int checksum = 0;
		for (String line : lines) {
			String[] numberArray = line.split ("\t");
			checksum += findDivisionOFEvenlyDivisibleValues (numberArray);
		}
		return checksum;
	}

	private int findDivisionOFEvenlyDivisibleValues (String[] numberArray) {
		int division = 0;
		for (String numberStr1 : numberArray) {
			int value1 = Integer.valueOf (numberStr1);
			for (String numberStr2 : numberArray) {
				int value2 = Integer.valueOf (numberStr2);
				if (value1 != value2) {
					if (value1 % value2 == 0) {
						division = value1 / value2;
					} else if (value2 % value1 == 0) {
						division = value2 / value1;
					}
					if (division > 0) {
						break;
					}
				}
			}
		}
		return division;
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
