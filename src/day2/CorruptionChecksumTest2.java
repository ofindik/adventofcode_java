package day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CorruptionChecksumTest2 extends BaseTest {

	@Test
	public void checksum_of_one_line_is_sum_of_two_evenly_divisible_values () {
		CorruptionChecksum corruptionChecksum = new CorruptionChecksum ();
		int expected = 4;
		assertEquals (
			expected,
			corruptionChecksum.process2 (readFile ("/Users/osmanf/adventofcode_java/src/day2/spreadsheet2_1.txt")));
	}

	@Test
	public void checksum_of_multiple_lines_is_sum_of_each_lines_result () {
		CorruptionChecksum corruptionChecksum = new CorruptionChecksum ();
		int expected = 9;
		assertEquals (
			expected,
			corruptionChecksum.process2 (readFile ("/Users/osmanf/adventofcode_java/src/day2/spreadsheet2_2.txt")));
	}

	@Test
	void puzzle_test () {
		CorruptionChecksum corruptionChecksum = new CorruptionChecksum ();
		int expected = 250;
		assertEquals (
			expected, corruptionChecksum
				.process2 (readFile ("/Users/osmanf/adventofcode_java/src/day2/spreadsheet2_puzzle.txt")));

	}
}
