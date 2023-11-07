package edu.umb.cs680.hw01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.LinkedList;

public class PrimeGeneratorTest {

    @Test
    public void testGeneratePrimesInRange() {
        PrimeGenerator gen = new PrimeGenerator(1, 10);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();

        // Check that the list of primes is as expected for the range (1, 10)
        assertEquals(4, primes.size());
        assertTrue(primes.contains(2L));
        assertTrue(primes.contains(3L));
        assertTrue(primes.contains(5L));
        assertTrue(primes.contains(7L));
    }

    @Test
    public void testGeneratePrimesNegativeRange() {
        PrimeGenerator gen = new PrimeGenerator(-10, -1);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();

        // There should be no prime numbers in the range (-10, -1)
        assertEquals(0, primes.size());
    }
}
