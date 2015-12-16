package com.murdock.tools.petite.beans;

import jodd.petite.meta.PetiteBean;

@PetiteBean
public class Superman implements SuperHero {

	public String getHeroName() {
		return "Superman";
	}
}
