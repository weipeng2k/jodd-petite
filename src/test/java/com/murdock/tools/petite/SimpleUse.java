package com.murdock.tools.petite;

import org.junit.Test;

import jodd.petite.PetiteContainer;

public class SimpleUse {

	@Test
	public void test() {
		PetiteContainer pc = new PetiteContainer();
		pc.getConfig().setUseFullTypeNames(true);
	}

}
