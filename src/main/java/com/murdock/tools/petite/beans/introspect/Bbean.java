package com.murdock.tools.petite.beans.introspect;

public class Bbean extends Abean {

	public static final long serialVersionUID = 42L;

	private Long boo;

	Long getBoo() {
		return boo;
	}

	void setBoo(Long boo) {
		this.boo = boo;
	}
}
