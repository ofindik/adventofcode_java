package day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CorruptionChecksumTest extends BaseTest {

	@Test
	public void checksum_of_one_line_is_delta_of_max_and_min () {
		CorruptionChecksum corruptionChecksum = new CorruptionChecksum ();
		int expected = 8;
		assertEquals (
			expected,
			corruptionChecksum.process (readFile ("/Users/osmanf/adventofcode_java/src/day2/spreadsheet1_1.txt")));
	}

	@Test
	public void checksum_of_multiple_lines_is_sum_of_deltas_of_max_and_min () {
		CorruptionChecksum corruptionChecksum = new CorruptionChecksum ();
		int expected = 18;
		assertEquals (
			expected,
			corruptionChecksum.process (readFile ("/Users/osmanf/adventofcode_java/src/day2/spreadsheet1_2.txt")));
	}

	@Test
	void puzzle_test () {
		CorruptionChecksum corruptionChecksum = new CorruptionChecksum ();
		int expected = 47136;
		assertEquals (
			expected,
			corruptionChecksum.process (readFile ("/Users/osmanf/adventofcode_java/src/day2/spreadsheet1_puzzle.txt")));

	}
}
