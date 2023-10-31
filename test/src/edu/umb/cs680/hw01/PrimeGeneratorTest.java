package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest{
	@Test
	public void from1To10() {
		PrimeGenerator gen = new PrimeGenerator(1, 10);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L};
		assertArrayEquals(expectedPrimes,
			gen.getPrimes().toArray());
	}
	
	@Test
	public void from25To100() {
		PrimeGenerator gen = new PrimeGenerator(25, 100);
		gen.generatePrimes();
		Long[] expectedPrimes = {29L, 31L, 37L, 41L, 43L, 47L, 
			53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
		assertArrayEquals(expectedPrimes,
			gen.getPrimes().toArray());
	}
	
	@Test
	public void fromNeg10To10() {
		try {
			PrimeGenerator gen = new PrimeGenerator(-10, 10);
			gen.generatePrimes();
			fail("Wrong input values: from=-10 to=10");
		}
		catch(Throwable ex){
			assertEquals("Wrong input values: from=-10 to=10", ex.getMessage());
		}	
	}

	@Test
	public void from100To1() {
		try {
			PrimeGenerator gen = new PrimeGenerator(100, 1);
			gen.generatePrimes();
			fail("Wrong input values: from=100 to=1");
		}
		catch(Throwable ex){
			assertEquals("Wrong input values: from=100 to=1", ex.getMessage());
		}
	}
}