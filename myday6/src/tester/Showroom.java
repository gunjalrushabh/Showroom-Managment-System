package tester;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import com.app.Color;
import com.app.Vehicle;

import cutomException.ShowroomHandlinException;
import static utills.Validation.validatechasnum;
import static utills.Validation.validatecolor;
import static utills.Validation.validateprice;
import static utills.Validation.validatedate;
public class Showroom {

	public static void main(String[] args) {
		//add,display,exit

		Scanner sc=new Scanner(System.in);
		System.out.println("How many vehicles to be added in ");
		Vehicle []vehicles= new Vehicle[sc.nextInt()];
		int count=0;
		boolean exit = false;
		while(!exit)
		{
			System.out.println("1.add 2.display 10.exit");
			try {
			switch(sc.nextInt())
			{
			//String chasnum, Color colour, double baseprice, Date mfgdate, String company
			case 1:
				if(count<vehicles.length)
				{
					System.out.println("String chasnum, Color colour, double baseprice, Date mfgdate, String company");
				Vehicle vobj=new Vehicle(validatechasnum(sc.next(),vehicles), validatecolor(sc.next()), validateprice(sc.nextDouble()), validatedate(sc.next()), sc.next()) ;
				vehicles[count++]=vobj;
				}
				else {
					throw new ShowroomHandlinException("Showroom is Full");
				}
				break;
			case 2: 
				//System.out.println(Arrays.toString(vehicles));
				for(Vehicle v: vehicles)
				{
					System.out.println(v);
				}
				break;
			//case 1: break;
			case 10:
				exit =true;
				break;
			}
			}
			catch(Exception e) {
				e.printStackTrace();
				sc.nextLine(); //taking precaution taking i/p o/p mismatching infinite loop switch case
			}
		}
		
	}

}
