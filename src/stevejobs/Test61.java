package stevejobs;

import java.util.Scanner;

public class Test61 {

	public static void main(String[] args)
	{
		//Take a number from keyboard except 0
		Scanner sc =new Scanner(System.in);
		System.out.println("enter a word");
		int x=sc.nextInt(); 
		sc.close();
		//check for even
		if(x%2==0) 
		{
			System.out.println(x+"is even");
		}
		else
		{
			System.out.println(x+"is even");
		}

	}

}
