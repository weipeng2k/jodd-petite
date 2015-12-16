package com.murdock.tools.petite.beans.fulltype;

import jodd.petite.meta.PetiteInject;

public class Koo {

	@PetiteInject
	public Koo(Joo joo) {
		this.joojoo = joo;
	}

	public Joo joojoo;

	@PetiteInject
	public void injectMee(Joo joo, Joo joo2) {
		mjoo = joo;
		mjoo2 = joo2;
	}

	public Joo	mjoo;
	public Joo	mjoo2;

	@PetiteInject
	public Joo	joo;

	@PetiteInject
	public Joo	someNoJooName;

}
