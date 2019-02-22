package Primzahlenzähler;

import StoppUhr.Stopwatch;

public class PrimeFinder implements Runnable {
	
	private int von;
	private int bis;
	private int primes = 0;
	private boolean prime;

	public PrimeFinder(long von, long bis) {
		this.von = (int) von;
		this.bis = (int) bis;
	}

	@Override
	public void run() {
		
		countPrimes();
		System.out.println("Es gibt " +primes+ " Primzahlen in " +bis+" Zahlen\n");

	}

	public void countPrimes() {
		Stopwatch sw = new Stopwatch();
		sw.start();
		for (int i = von; i <= bis; i++) {
			prime = true;
			if (i % 2 == 0) {
				prime = false;
			} else {
				for (int j = 3; j < i / 3; j++) {
					
					if (i % j == 0) {
						prime = false;
						j = i;
					}
				}
			}
			if (prime) {
				primes++;
			}
		}
		sw.stop();
		System.out.println(sw);
	}

	
}
