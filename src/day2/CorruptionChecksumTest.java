package day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

	private List<String> readFile (String fileName) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines (Paths.get (fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace ();
		}
		return lines;
	}
}
