package day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SpiralMemoryTest2 {

	@Test
	public void first_value_larger_than_368078_is_369601 () {
		SpiralMemory spiralMemory = new SpiralMemory ();
		int expected = 369601;
		assertEquals (expected, spiralMemory.process2 (368078));
	}
}
