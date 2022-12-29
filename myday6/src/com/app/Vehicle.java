package com.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import static utills.Validation.validatecolor;
public class Vehicle {
private String chasnum;
private Color colour;
private double baseprice;
private Date mfgdate;
private String company;

public static SimpleDateFormat sdf;
static
{
	sdf= new SimpleDateFormat("dd-MM-yyyy");
}


public Vehicle(String chasnum, Color colour, double baseprice, Date mfgdate, String company) {
	super();
	this.chasnum = chasnum;
	this.colour = colour;
	this.baseprice = baseprice;
	this.mfgdate = mfgdate;
	this.company = company;
}

public Vehicle(String chasnum) {//overloaded constructor for validation chassins num of vehicle

	this.chasnum=chasnum;// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Vehicle [chasnum=" + chasnum + ", colour=" + colour + ", "
			+ "baseprice=" + baseprice + ", mfgdate=" + sdf.format(mfgdate)
			+ ", company=" + company + "]";
}

public boolean equals(Object anotherveh) //this will prevent duplication of vehicle
{
	if(anotherveh instanceof Vehicle)
	{
		return this.chasnum.equals(((Vehicle) anotherveh).chasnum);
	}
	else
	{
		return false;
	}
}



}
