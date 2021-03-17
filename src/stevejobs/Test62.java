package stevejobs;

import java.util.Scanner;

public class Test62 {

	public static void main(String[] args)
	{
		//Take a number from keyboard except 0
		Scanner sc =new Scanner(System.in);
		System.out.println("enter a number");
		int x=sc.nextInt(); 
		sc.close();
		//check for prime
		int flag=0;
		for(int i=2;i<x;i++)
		{
			if(x%i==0) //in java,% indicates remainder
			{
				flag=1;
			}
		}
		if(flag==0)
		{
			System.out.println(x+" is prime");
		}
		else
		{
			System.out.println(x+"is not a prime");
		}

	}

}
