package com.murdock.tools.petite.beans.chapter1;

public class ServiceOne implements Service {

	@Override
	public String service(String parameter) {
		return "ServiceOne accept param: " + parameter;
	}

}
