package com.murdock.tools.petite.beans;

import jodd.petite.meta.PetiteBean;

@PetiteBean
public class Batman implements SuperHero {

	public String getHeroName() {
		return "Batman";
	}
}
