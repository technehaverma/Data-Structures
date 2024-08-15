package com.practice.problems.arrays;

public class VerifyPrime {
	public int isPrime(int A) {
		int  j  = 0;
		if (A < 2) {
			return j;
		}
		if(A==2)
			return 1;
		for ( int i = 2; i < A / 2; i++) {
			if(A%i==0) {
				j=0;
				
				break;
			}
			else j = 1;
			
		}
		//System.out.println(i);
		return j;
	}
	public static void main(String[] args) {
		VerifyPrime prime  = new VerifyPrime();
		int  i = prime.isPrime(84923);
		System.out.println(i);
	}

}
