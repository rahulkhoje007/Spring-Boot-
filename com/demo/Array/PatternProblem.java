package com.demo.Array;
/*    Write a pattern program

*
**
***
****
*****
*******


*/

public class PatternProblem {

	public static void main(String[] args) {
		// Pattern 1 program
		for (int i = 0; i <= 5; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				System.out.print(" * ");
			}
			System.out.println();

		}
		/*
		 
		 pattern 2 program
		 ******
		 *****
		 ****
		 ***
		 **
		 *
		  
		 */
		System.out.println();
		System.out.println();

		for (int i = 0; i <= 5; i++) {
			for (int j = 5; j >= i; j--) 
			{
				System.out.print(" * ");
			}
			System.out.println();

		}
		
		System.out.println();
		System.out.println();
		//  Print all * in Square
		
		for (int i = 0; i <= 5; i++)
		{
			for (int j = 0; j <= 5; j++)
			{
				System.out.print(" * ");
			}
			System.out.println();

		}
		
		System.out.println();
		System.out.println();
		
		for (int i = 0; i <= 5; i++)
		{
			for(int j=2*(5-i); j>=0; j--) {
				System.out.print(" ");
			}
			
			for (int j = 0; j <= i; j++)
			{
				System.out.print(" *");
			}
			
			System.out.println();

		}
		

	}

}
