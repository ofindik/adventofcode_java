package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public abstract class BaseTest {

	protected List<String> readFile (String fileName) {
		List<String> lines = Collections.emptyList ();
		try {
			lines = Files.readAllLines (Paths.get (fileName));
		} catch (IOException e) {
			// Ignore exception and return empty list;
		}
		return lines;
	}
}
