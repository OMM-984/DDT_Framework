package jkde;

import java.util.Scanner;

public class leapyear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year=sc.nextInt();
		if(year%4==0 && year % 100!=0) {
			System.out.println("it is a leap year");
			
		}
		else {
			System.out.println(" it is not a leap year");
		}

	}

}
