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
import static utills.Validation.findbychassisnum;

public class Showroom {

	public static void main(String[] args) {
		// add,display,exit

		Scanner sc = new Scanner(System.in);
		System.out.println("How many vehicles to be added in ");
		Vehicle[] vehicles = new Vehicle[sc.nextInt()];
		int count = 0;
		boolean exit = false;
		while (!exit) {
			System.out.println(
					"1.add 2.display 3.display all cars of specfic color \n 4.discount on specific vehicle  5purchase vehicle10.exit");
			try {
				switch (sc.nextInt()) {
				// String chasnum, Color colour, double baseprice, Date mfgdate, String company
				case 1:
					if (count < vehicles.length) {
						System.out.println(
								"String chasnum, Color colour, double baseprice, Date mfgdate, String company");
						Vehicle vobj = new Vehicle(validatechasnum(sc.next(), vehicles), validatecolor(sc.next()),
								validateprice(sc.nextDouble()), validatedate(sc.next()), sc.next());
						vehicles[count++] = vobj;
					} else {
						throw new ShowroomHandlinException("Showroom is Full");
					}
					break;
				case 2:
					// System.out.println(Arrays.toString(vehicles));
					for (Vehicle v : vehicles) {
						System.out.println(v);
					}
					break;
				case 3:
					System.out.println(
							"Enter a color to , show the vehicle available according to that color in RG Custom Motors");
					Color customColor = validatecolor(sc.next());
					for (Vehicle v : vehicles)
						if (v != null && v.getColour().equals(customColor)) {
							System.out.println(v.toString());
						}
					break;

				case 4:
					System.out.println("Enter a chassis number");
					String chasnum = sc.next();
					System.out.println("Enter a discount to add");
					double discount = sc.nextDouble();

					Vehicle foundvehicle = findbychassisnum(chasnum, vehicles);
					double originalprice = foundvehicle.getBaseprice();
					foundvehicle.setBaseprice(foundvehicle.getBaseprice() - discount);
					System.out.println("discount will be applied on is:  " + discount + " ,baseprice of vehicle is: "
							+ originalprice);
					System.out.println("After discount price of vehicle : " + foundvehicle.getBaseprice());
					System.out.println("Details of vehicle \n " + foundvehicle.toString());
					break;

				case 5:
					
					//System.out.println(Arrays.toString(vehicles));
					System.out.println("Enter chassis number");
					String purchaseChasno = sc.next();
					Vehicle purchasevehicle = findbychassisnum(purchaseChasno, vehicles);
					if (purchasevehicle.getAdd() == null) {
						System.out.println("Enter Delivery Address: ");
						System.out.println("String addressline1, String addressline2, String city, String pinno");
						purchasevehicle.linkedAddress(sc.next(), sc.next(), sc.next(), sc.next());
						System.out.println(purchasevehicle.toString());
					} else {
						throw new ShowroomHandlinException("vehicle is not available");
					}
					break;
				case 10:
					exit = true;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine(); // taking precaution taking i/p o/p mismatching infinite loop switch case
			}
		}

	}

}
