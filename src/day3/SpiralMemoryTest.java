package day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SpiralMemoryTest {

	@Test
	public void step_count_from_square_1_is_0 () {
		SpiralMemory spiralMemory = new SpiralMemory ();
		int expected = 0;
		assertEquals (expected, spiralMemory.process (1));
	}

	@Test
	public void step_count_from_square_12_is_3 () {
		SpiralMemory spiralMemory = new SpiralMemory ();
		int expected = 3;
		assertEquals (expected, spiralMemory.process (12));
	}

	@Test
	public void step_count_from_square_23_is_2 () {
		SpiralMemory spiralMemory = new SpiralMemory ();
		int expected = 2;
		assertEquals (expected, spiralMemory.process (23));
	}

	@Test
	public void step_count_from_square_1024_is_31 () {
		SpiralMemory spiralMemory = new SpiralMemory ();
		int expected = 31;
		assertEquals (expected, spiralMemory.process (1024));
	}

	@Test
	public void step_count_from_square_368078_is_371 () {
		SpiralMemory spiralMemory = new SpiralMemory ();
		int expected = 371;
		assertEquals (expected, spiralMemory.process (368078));
	}
}
