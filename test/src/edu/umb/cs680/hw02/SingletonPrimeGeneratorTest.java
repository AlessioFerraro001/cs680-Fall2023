package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Arrays;

public class SingletonPrimeGeneratorTest{
	
	@Test
	public void instanceNotNull() {
		SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(1, 10);
		assertNotNull(gen);
	}
	
	@Test
	public void instanceSame() {
		SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance(1, 10);
		SingletonPrimeGenerator gen2 = SingletonPrimeGenerator.getInstance(1, 10);
		assertSame(gen1, gen2);
	}
	
	@Test
	public void iterableCorrect() {
		SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(1, 10);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L};
		LinkedList<Long> primes = gen.getPrimes();
		assertIterableEquals(Arrays.asList(expectedPrimes),
				gen.getPrimes());
	}
	
	@Test
	public void fromNeg10To10() {
		try {
			SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(-10, 10);
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
			SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(100, 1);
			gen.generatePrimes();
			fail("Wrong input values: from=100 to=1");
		}
		catch(Throwable ex){
			assertEquals("Wrong input values: from=100 to=1", ex.getMessage());
		}
	}
}
