package virgoInnovation_LogicalAssignment;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class CurrencyMatching
{
	public static double number,totalnote;
	public static int i,totalnotecount=0,space=20;
	public static ArrayList List=null;
	public static double actual;
	public static void currencyEvaluation(double number,ArrayList receivedArrayList)
	{ 
		System.out.println("Our Available Indian currency notes and paise are==>>");
		for(i=0;i<receivedArrayList.size();i++)
		{
			System.out.print(receivedArrayList.get(i)+"||");	
		}
		System.out.println("\n");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(String.format("%-" + space + "s%-" + space + "s%-" + space + "s","Currency","Count","Total"));
		System.out.println("-----------------------------------------------------------------");
		for(i=0;i<receivedArrayList.size();i++)
		{
			Object object=(Object) receivedArrayList.get(i);
			double value=(double)object;
			if(number>=value)
			{
				totalnote=number/value;
				number=number%value;
				System.out.println(String.format("%-" + space + "s%-" + space + "s%-" + space + "s","Rs "+receivedArrayList.get(i),(int)totalnote,value+"*"+(int)totalnote+"="+value*(int)totalnote));
				actual=actual+value*(int)totalnote;
				totalnotecount=totalnotecount+(int)totalnote;
				
			}
		}
		System.out.println("-----------------------------------------------------------------");
		System.out.println(String.format("%-" + space + "s%-" + space + "s%-" + space + "s","Total",totalnotecount,actual));
		System.out.println("-----------------------------------------------------------------");
		
	}

	public static void main(String[] args)
	{
		System.out.println("Enter Any number for CurrencyMatching which should be in double format");
		Scanner scanner=new Scanner(System.in);
		number=scanner.nextDouble();
		ArrayList <Double>arraylist=new ArrayList<Double>();
		arraylist.add(2000.00);
		arraylist.add(1000.00);
		arraylist.add(500.00);
		arraylist.add(200.00);
		arraylist.add(100.00);
		arraylist.add(50.00);
		arraylist.add(20.00);
		arraylist.add(10.00);
		arraylist.add(5.00);
		arraylist.add(1.00);
		arraylist.add(0.50);
		arraylist.add(0.25);
		currencyEvaluation(number,arraylist);
		
	}

}
