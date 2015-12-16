package com.murdock.tools.petite.beans.initmethod;

public class Foo2 {

	public String	data;

	public Bar		bar;

	void init1() {
		result = "1 " + bar + ' ' + data;
	}

	void init2() {
		result += " 2 " + bar + ' ' + data;
	}

	void init3() {
		result += " 3 " + bar + ' ' + data;
	}

	public String result;

}
