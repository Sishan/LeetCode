/*
Description:
Count the number of prime numbers less than a non-negative number, n

References:
How Many Primes Are There? (https://primes.utm.edu/howmany.html)
Sieve of Eratosthenes (http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
*/

public class Solution {
    public int countPrimes(int n) {
    	if (n < 3) return 0;
    	boolean [] primes = new boolean[n];  // defult is False
    	int count = 0;
    	for (int i = 2; i < n; i++){
    		if (!primes[i]){
    			count++;
    			for (int j = 2 * i; j < n; j = j + i){
    				primes[j] = true;
    			}
    		}
    	}
    	return count;
    }
}
