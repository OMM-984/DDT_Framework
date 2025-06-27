package jkde;

import java.util.Scanner;

public class demo2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a positive number");
		int n =sc.nextInt();
		int sum = 0;
		for (int i=1;i<=n;i++) {
			sum+=i;
		}
  System.out.println("sum of natural number from 1 to"+ n + "is" + sum);
	}

}
