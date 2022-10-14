package com.demo.Array;

public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 2, 7, 1, 0 };
		//		print reverse number 0,1,7
		for (int i = arr.length - 1; i > 1; i--) {
			System.out.println("array no " + arr[i]);

		}
		// print array number 
		for(int i=0;i<arr.length;i++)
		{
			System.out.println("Array no is "+ arr[i]);
		}
	}

}
