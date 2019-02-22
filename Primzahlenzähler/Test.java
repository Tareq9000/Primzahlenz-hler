package Primzahlenzähler;

import StoppUhr.Stopwatch;

public class Test {

	static Thread[] thread;
	
	Thread[] t = new Thread[8];
	PrimeFinder[] prf = new PrimeFinder[8];
	Stopwatch sw = new Stopwatch();
	int von = 1;
	long bis = 500 * 100;
	
	public static void main(String[] args) {
		
		Test t = new Test();
		
		System.out.println("PRIMZAHLENZÄHLER\n----------------");
		System.out.println("Suche nach Primzahlen....");
		
		t.testPrimeTime(4, 500);
		
	}

	public Stopwatch testPrimeTime(int threadCount, long end) {
		
		sw.start();
		for (int i = 0; i < t.length; i++) {

			prf[i] = new PrimeFinder(bis/threadCount * i, threadCount * (i + 1));
			t[i] = new Thread(prf[i]);
			
		}
		
		for (int i = 0; i < t.length; i++) {
			t[i].start();
		}

		for (int i = 0; i < t.length; i++) {

				try {t[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
		}
		System.out.println(sw);

		sw.stop();
		return sw;
	}

}
