package edu.umb.cs680.hw02;

import java.util.LinkedList;

public class SingletonPrimeGenerator {
    private long from, to;
    private LinkedList<Long> primes;
    private static SingletonPrimeGenerator instance;

    private SingletonPrimeGenerator() {
        // Private constructor to prevent external instantiation
    }

    public static SingletonPrimeGenerator getInstance(long from, long to) {
        if (instance == null) {
            instance = new SingletonPrimeGenerator();
        }
        instance.from = from;
        instance.to = to;
        instance.primes = new LinkedList<>();
        return instance;
    }

    public void generatePrimes() {
        if (from < 2) {
            from = 2;
        }

        for (long number = from; number <= to; number++) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
    }

    private boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (long i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public LinkedList<Long> getPrimes() {
        return primes;
    }
}
