package utills;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import com.app.Color;
import com.app.Vehicle;

import cutomException.ShowroomHandlinException;
import static com.app.Vehicle.sdf;

public class Validation {

	private static Date beginDate;
	private static Date afterdate;

	static {
		try {
			beginDate = sdf.parse("01-04-2022");
			afterdate = sdf.parse("31-03-2023");
		} catch (Exception e) {
			System.out.println("Error in try block of date : " + e);
		}
	}

	private static final double minprice;
	private static final double maxprice;

	static {
		minprice = 10000;
		maxprice = 100000;
	}

	public static Date validatedate(String date) throws ShowroomHandlinException, ParseException {
		Date dateobj = sdf.parse(date);
		if (dateobj.before(beginDate) || dateobj.after(afterdate))
			throw new ShowroomHandlinException("manufacturing date not in range :01-04-2022 to  31-03-2023");
		return dateobj;
	}

	public static double validateprice(double price) throws ShowroomHandlinException {
		if (price < minprice)
			throw new ShowroomHandlinException("under price not allowed");
		else if (price > maxprice)
			throw new ShowroomHandlinException("over price vehicle not allowed");
		return price;
	}

	public static Color validatecolor(String colour) throws ShowroomHandlinException {
		try {
			return Color.valueOf(colour.toUpperCase());
		} catch (IllegalArgumentException e) {
			System.out.println(Arrays.toString(Color.values()));
			throw new ShowroomHandlinException("Above colors are available  :");
		}

	}

	public static String validatechasnum(String chasnum, Vehicle[] varr) throws ShowroomHandlinException {
		Vehicle vehiclenew = new Vehicle(chasnum);
		for (Vehicle vobj11 : varr)
			if (vobj11 != null)
				if (vobj11.equals(vehiclenew))
					throw new ShowroomHandlinException("Duplicate vehicle");

		return chasnum;

	}
	
	public static Vehicle findbychassisnum(String chasno,Vehicle[] varr) throws ShowroomHandlinException
	{
		Vehicle vobj= new Vehicle(chasno);
		for(Vehicle v: varr)
		{
			if(v!=null && v.equals(vobj))
				return v;
		
		}
		throw new ShowroomHandlinException("this "+chasno+ " chassi number vehicle not available");
	}
	
}








