###
Description:
Count the number of prime numbers less than a non-negative number, n

References:
How Many Primes Are There? (https://primes.utm.edu/howmany.html)
Sieve of Eratosthenes (http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
###

class Solution(object):
    def countPrimes(self, n):
        if n <= 2:
            return 0
        res = [True] * n
        res[0] = res[1] = False
        for i in xrange(2, n):
            if res[i] == True:
                for j in xrange(i, (n-1)/i+1):
                    res[i*j] = False
        return sum(res)
                
