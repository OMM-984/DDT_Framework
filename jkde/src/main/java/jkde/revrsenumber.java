package jkde;

import java.util.Scanner;

public class revrsenumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number");
		int number = sc.nextInt();
		int reversd = 0;
		while(number != 0) {
			int digit = number %10;
			reversd = reversd * 10+ digit;
			number /= 10;
		}
		System.out.println("reversed number "+ reversd);

	}

}
