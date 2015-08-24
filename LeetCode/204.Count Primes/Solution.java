public class Solution {
  public int countPrimes(int n) {
    ArrayList<Integer> primes = new ArrayList<Integer>();

    for (int i = 2; i < n; i++) {
      boolean isPrime = true;

      for (int prime: primes) {
        if (i % prime == 0) {
          isPrime = false;
          break;
        }
        if (prime > Math.sqrt(i)) {
          break;
        }
      }

      if (isPrime) {
        primes.add(i);
      }
    }

    return primes.size();
  }
}