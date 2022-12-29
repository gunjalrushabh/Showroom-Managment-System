package com.app;

public class Address {
private String addressline1;
private String addressline2;
private String city;
private String pinno;

public Address(String addressline1, String addressline2, String city, String pinno) {
	super();
	this.addressline1 = addressline1;
	this.addressline2 = addressline2;
	this.city = city;
	this.pinno = pinno;
}

@Override
public String toString() {
	return "Address [addressline1=" + addressline1 + ", addressline2=" + addressline2 + ", city=" + city + ", pinno="
			+ pinno + "]";
}


}
