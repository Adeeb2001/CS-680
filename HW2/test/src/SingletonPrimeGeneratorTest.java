package edu.umb.cs680.hw02;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SingletonPrimeGeneratorTest {
    private SingletonPrimeGenerator generator;

    @Before
    public void setUp() {
        generator = SingletonPrimeGenerator.getInstance(1, 10);
    }

    @Test
    public void testGetInstanceNotNull() {
        assertNotNull(generator);
    }

    @Test
    public void testGetInstanceReturnsIdenticalInstance() {
        SingletonPrimeGenerator anotherGenerator = SingletonPrimeGenerator.getInstance(1, 10);
        assertSame(generator, anotherGenerator);
    }

    @Test
    public void testGeneratePrimesAndCheckPrimes() {
        generator.generatePrimes();
        assertEquals(4, generator.getPrimes().size());
        assertTrue(generator.getPrimes().contains(2L));
        assertTrue(generator.getPrimes().contains(3L));
        assertTrue(generator.getPrimes().contains(5L));
        assertTrue(generator.getPrimes().contains(7L));
    }

    @Test
    public void testGeneratePrimesWithInvalidRange() {
        generator = SingletonPrimeGenerator.getInstance(10, 1);
        try {
            generator.generatePrimes();
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Exception was thrown as expected
        }
    }
}
