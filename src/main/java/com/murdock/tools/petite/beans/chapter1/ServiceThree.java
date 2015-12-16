package com.murdock.tools.petite.beans.chapter1;

public class ServiceThree implements Service {

	@Override
	public String service(String parameter) {
		return "ServiceThree accept param: " + parameter;
	}

}
