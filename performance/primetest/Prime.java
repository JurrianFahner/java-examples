/**
 * 
 */
// package playground;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * @author jurrian
 *
 */
public class Prime {
	
	//Traditional approach
	private static boolean isPrimeTraditional(int number) {       
	    if(number < 2) return false;
	    for(int i=2; i<number; i++){
	        if(number % i == 0) return false;
	    }
	    return true;
	}
	
	// Declarative approach
	private static boolean isPrime(int number) {
	    IntPredicate isDivisible = index -> number % index == 0;
	     
	    return number > 1
	            && IntStream.range(2, number).noneMatch(isDivisible);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int number = 1000000000;
		long startTime = System.nanoTime();
		System.out.println(isPrimeTraditional(number));
		long round1Time = System.nanoTime();
		System.out.println(isPrime(number));
		long endTime = System.nanoTime();
		
		System.out.println("Time traditional: " + (round1Time - startTime));
		System.out.println("Time declarative: " + (endTime - round1Time));
		System.out.println("" + ((double) (round1Time - startTime)/(endTime - round1Time)) + "times faster");
	}

}
