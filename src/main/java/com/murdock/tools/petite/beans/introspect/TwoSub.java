package com.murdock.tools.petite.beans.introspect;

public class TwoSub extends One {

	@Override
	public int getFtwo() {
		return ftwo;
	}

	public String getFone() {
		return super.getFone();
	}
}
