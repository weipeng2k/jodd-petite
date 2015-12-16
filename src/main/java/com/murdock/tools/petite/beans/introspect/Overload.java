package com.murdock.tools.petite.beans.introspect;

public class Overload {

	String company;

	// not a property setter
	public void setCompany(StringBuilder sb) {
		this.company = sb.toString();
	}

	public String getCompany() {
		return company;
	}
}
