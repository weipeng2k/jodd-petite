package com.murdock.tools.petite.beans.chapter1;

import org.junit.Test;

import jodd.petite.PetiteContainer;
import jodd.petite.WiringMode;
import junit.framework.TestCase;

public class FooTest {

	@Test
	public void test() {
		PetiteContainer pc = new PetiteContainer();
		pc.getConfig().setUseFullTypeNames(true);
		pc.getConfig().setDefaultWiringMode(WiringMode.STRICT);

		pc.registerPetiteBean(Foo.class, null, null, null, false);
		pc.registerPetiteBean(ServiceOne.class, null, null, null, false);
		pc.registerPetiteBean(ServiceTwo.class, "serviceTwo", null, null, false);
		pc.registerPetiteBean(ServiceThree.class, null, null, null, false);

		Foo foo = pc.getBean(Foo.class);
		TestCase.assertEquals(foo, pc.getBean(Foo.class));
		TestCase.assertEquals(foo, pc.getBean(Foo.class));
		TestCase.assertEquals(foo, pc.getBean(Foo.class));
		
		foo.foo();
	}

}
