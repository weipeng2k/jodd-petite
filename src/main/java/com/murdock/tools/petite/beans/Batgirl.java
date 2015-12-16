package com.murdock.tools.petite.beans;

import java.io.Serializable;

import jodd.petite.meta.PetiteBean;

@PetiteBean
public class Batgirl implements SuperHero, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5542301952709481789L;

	public String getHeroName() {
		return "Batgirl";
	}
}
