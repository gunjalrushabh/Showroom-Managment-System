package com.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import static utills.Validation.validatecolor;

/**
 * @author RUSHABH GUNJAL
 *
 */
public class Vehicle {
	private String chasnum;
	private Color colour;
	private double baseprice;
	private Date mfgdate;
	private String company;

	private Address add;
	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}

	public Vehicle(String chasnum, Color colour, double baseprice, Date mfgdate, String company) {
		super();
		this.chasnum = chasnum;
		this.colour = colour;
		this.baseprice = baseprice;
		this.mfgdate = mfgdate;
		this.company = company;
	}

	public Vehicle(String chasnum) {// overloaded constructor for validation chassins num of vehicle

		this.chasnum = chasnum;// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if (add == null) {
			String mesg = "Address not assigned please enter Adress";
			System.out.println(mesg);
		} else {
			System.out.println("......Purchased address : " + add.toString());
		}
		
		return "Vehicle [chasnum=" + chasnum + ", colour=" + colour + ", " + "baseprice=" + baseprice + ", mfgdate="
				+ sdf.format(mfgdate) + ", company=" + company + "]";
	}

	public boolean equals(Object anotherveh) // this will prevent duplication of vehicle
	{
		if (anotherveh instanceof Vehicle) {
			return this.chasnum.equals(((Vehicle) anotherveh).chasnum);
		} else {
			return false;
		}
	}

	public Color getColour() {
		return colour;
	}

	public double getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(double baseprice) {
		this.baseprice = baseprice;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}
	
	public Address getAdd() {
		return add;
	}

	

	public void linkedAddress(String addressline1, String addressline2, String city, String pinno)
	{// see here this.add
	this.add=new Address(addressline1, addressline2, city, pinno);
		System.out.println("Delivery Address succefully Added......! Enjoy your ride..");
	}

}
