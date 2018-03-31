package day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CorruptionChecksumTest {

	@Test
	public void checksum_of_one_line_is_delta_of_max_and_min () {
		CorruptionChecksum corruptionChecksum = new CorruptionChecksum ();
		int expected = 8;
		assertEquals (
			expected,
			corruptionChecksum.process (readFile ("/Users/osmanf/adventofcode_java/src/day2/spreadsheet.txt")));
	}

	@Test
	public void checksum_of_multiple_lines_is_sum_of_deltas_of_max_and_min () {
		CorruptionChecksum corruptionChecksum = new CorruptionChecksum ();
		int expected = 18;
		assertEquals (
			expected,
			corruptionChecksum.process (readFile ("/Users/osmanf/adventofcode_java/src/day2/spreadsheet2.txt")));
	}

	@Test
	void puzzle_test () {
		CorruptionChecksum corruptionChecksum = new CorruptionChecksum ();
		int expected = 47136;
		assertEquals (
			expected,
			corruptionChecksum.process (readFile ("/Users/osmanf/adventofcode_java/src/day2/spreadsheet_puzzle.txt")));
		
	}
	
	private List<String> readFile (String fileName) {
		List<String> lines = Collections.emptyList ();
		try {
			lines = Files.readAllLines (Paths.get (fileName));
		} catch (IOException e) {
			// Ignore exception and return empty list;
		}
		return lines;
	}
}
