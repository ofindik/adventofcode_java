package day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PassphraseTest {

	@Test
	public void passphrase_without_duplicate_words_is_valid_1 () {
		Passphrase passphrase = new Passphrase ();
		boolean expected = true;
		assertEquals (expected, passphrase.isValid ("aa bb cc dd ee"));
	}

	@Test
	public void passphrase_with_duplicate_words_is_not_valid () {
		Passphrase passphrase = new Passphrase ();
		boolean expected = false;
		assertEquals (expected, passphrase.isValid ("aa bb cc dd aa"));
	}

	@Test
	public void passphrase_without_duplicate_words_is_valid_2 () {
		Passphrase passphrase = new Passphrase ();
		boolean expected = true;
		assertEquals (expected, passphrase.isValid ("aa bb cc dd aaa"));
	}

	@Test
	public void valid_passphrase_count_for_puzzle_is_455 () {
		Passphrase passphrase = new Passphrase ();
		int expected = 455;
		List<String> lines = readFile ("/Users/osmanf/adventofcode_java/src/day4/puzzle1.txt");
		int count = 0;
		for (String line : lines) {
			if (passphrase.isValid (line)) {
				count++;
			}
		}
		assertEquals (expected, count);
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
