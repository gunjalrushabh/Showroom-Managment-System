package utills;

import java.util.Arrays;

import com.app.Color;
import com.app.Vehicle;

import cutomException.ShowroomHandlinException;

public class Validation {

	

	public static Color validatecolor(String colour) throws ShowroomHandlinException
	{
		try
		{
			return Color.valueOf(colour.toUpperCase());
		}
		catch (IllegalArgumentException e){
			System.out.println("choose correct color ");
			System.out.println(Arrays.toString(Color.values()));
		throw new ShowroomHandlinException("available color are :");
		}
		
	}
	
	

	public static String validatechasnum(String chasnum,Vehicle [] varr) throws ShowroomHandlinException
	{
		Vehicle vobj= new Vehicle(chasnum);
		for(Vehicle v: varr)
		{
			if(v!=null)
			{
				if(v.equals(varr))
					throw new ShowroomHandlinException("Duplicate vehicle");
			}
		}
		return chasnum;
		
		
	}
}
