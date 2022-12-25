package tester;

import java.util.Date;
import java.util.Scanner;

import com.app.Color;
import com.app.Vehicle;

import cutomException.ShowroomHandlinException;
import static utills.Validation.validatechasnum;
import static utills.Validation.validatecolor;
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
			switch(sc.nextInt())
			{
			//String chasnum, Color colour, double baseprice, Date mfgdate, String company
			case 1:
				if(count<vehicles.length)
				{
					
				Vehicle vobj=new Vehicle(validatechasnum(sc.next(),vehicles), validatecolor(sc.next()), validateprice(sc.nextDouble()), validatedate(sdf.parse(sc.next())), sc.next()) 
				vehicles[count++]=vobj;
				}
				else {
					throw new ShowroomHandlinException("Showroom is Full")
				}
				break;
			case 2: 
				break;
			//case 1: break;
			case 10:
				exit =true;
				break;
			}
		}
		
	}

}
