package com.murdock.tools.petite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.murdock.tools.petite.beans.fulltype.Joo;
import com.murdock.tools.petite.beans.fulltype.Koo;
import com.murdock.tools.petite.beans.pojo.Staff;
import com.murdock.tools.petite.beans.pojo.Worker;

import jodd.petite.PetiteContainer;
import jodd.petite.PetiteReference;
import jodd.petite.WiringMode;

public class FullTypeTest {

	private void registerBean(PetiteContainer petiteContainer, Class<?> beanType) {
		petiteContainer.registerPetiteBean(beanType, null, null, null, false);
	}

	@Test
	public void testFullTypeProperty() {
		// 构建PetiteContainer
		PetiteContainer pc = new PetiteContainer();
		pc.getConfig().setUseFullTypeNames(true);

		registerBean(pc, Koo.class);
		registerBean(pc, Joo.class);

		assertEquals(2, pc.getTotalBeans());

		assertNull(pc.getBean("koo"));
		assertNull(pc.getBean("joo"));

		Koo koo = pc.getBean(Koo.class);
		assertNotNull(koo);
		Joo joo = pc.getBean(Joo.class);
		assertNotNull(joo);

		koo = (Koo) pc.getBean(Koo.class.getName());
		assertNotNull(koo);
		joo = (Joo) pc.getBean(Joo.class.getName());
		assertNotNull(joo);

		assertNotNull(koo.joo);
		assertNotNull(koo.someNoJooName);
		assertEquals(joo, koo.joo);
		assertEquals(joo, koo.someNoJooName);
		assertEquals(joo, pc.getBean(Joo.class));
	}

	@Test
	public void testFullTypeMethodCtor() {
		PetiteContainer pc = new PetiteContainer();
		pc.getConfig().setUseFullTypeNames(true);

		registerBean(pc, Koo.class);
		registerBean(pc, Joo.class);

		Koo koo = (Koo) pc.getBean(Koo.class.getName());
		assertNotNull(koo);
		Joo joo = (Joo) pc.getBean(Joo.class.getName());
		assertNotNull(joo);

		assertNotNull(koo.joo);
		assertNotNull(koo.someNoJooName);
		assertNotNull(koo.mjoo);
		assertNotNull(koo.mjoo2);
		assertNotNull(koo.joojoo);
	}

	@Test
	public void testOptionalAndNotAllReferences() {
		PetiteContainer pc = new PetiteContainer();
		pc.getConfig().setDefaultWiringMode(WiringMode.OPTIONAL);
		pc.getConfig().setUseFullTypeNames(false);
		pc.getConfig().setLookupReferences(PetiteReference.TYPE_SHORT_NAME);

		registerBean(pc, Koo.class);
		registerBean(pc, Joo.class);

		assertEquals(2, pc.getTotalBeans());

		Koo koo = pc.getBean(Koo.class);
		assertNotNull(koo);
		Joo joo = pc.getBean(Joo.class);
		assertNotNull(joo);

		assertNull(koo.someNoJooName);
		assertNotNull(koo.joo);

		koo = (Koo) pc.getBean(Koo.class.getName());
		assertNull(koo);
		joo = (Joo) pc.getBean(Joo.class.getName());
		assertNull(joo);
	}

	@Test
	public void testWorkerStaff() {
		PetiteContainer pc = new PetiteContainer();
		pc.getConfig().setUseFullTypeNames(true);

		registerBean(pc, Worker.class);
		registerBean(pc, Staff.class);

		Worker w = pc.getBean(Worker.class);
		System.out.println(w);
	}
}
