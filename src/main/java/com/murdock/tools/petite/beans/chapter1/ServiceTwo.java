package com.murdock.tools.petite.beans.chapter1;

public class ServiceTwo implements Service {

	@Override
	public String service(String parameter) {
		return "ServiceTwo accept param: " + parameter;
	}

}
