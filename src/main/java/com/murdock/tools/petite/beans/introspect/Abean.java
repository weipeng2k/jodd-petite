package com.murdock.tools.petite.beans.introspect;

public class Abean {

	protected Integer	shared;

	private String		fooProp	= "abean_value";

	public void setFooProp(String v) {
		fooProp = v;
	}

	public String getFooProp() {
		return fooProp;
	}

	public boolean isSomething() {
		return true;
	}
}
