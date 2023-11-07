package edu.umb.cs680.hw01;

import java.util.LinkedList;

public class PrimeGenerator {
    protected long from, to;
    protected LinkedList<Long> primes;

    public PrimeGenerator(long from, long to) {
        this.from = from;
        this.to = to;
        this.primes = new LinkedList<>();
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

    public static void main(String[] args) {
        PrimeGenerator gen = new PrimeGenerator(1, 10);
        gen.generatePrimes();
        LinkedList<Long> primesList = gen.getPrimes();

        System.out.println("Prime numbers between " + gen.from + " and " + gen.to + ": " + primesList);
    }
}