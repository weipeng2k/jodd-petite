package com.murdock.tools.petite.beans.initmethod;

public class Foo {
	public String	data;

	public Bar		bar;

	void init() {
		result = "ctor " + bar + ' ' + data;
	}

	public String result;
}
