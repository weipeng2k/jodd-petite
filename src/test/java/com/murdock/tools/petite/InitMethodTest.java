package com.murdock.tools.petite;

import static jodd.petite.meta.InitMethodInvocationStrategy.POST_CONSTRUCT;
import static jodd.petite.meta.InitMethodInvocationStrategy.POST_DEFINE;
import static jodd.petite.meta.InitMethodInvocationStrategy.POST_INITIALIZE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.murdock.tools.petite.beans.initmethod.Bar;
import com.murdock.tools.petite.beans.initmethod.Foo;
import com.murdock.tools.petite.beans.initmethod.Foo2;

import jodd.petite.PetiteContainer;

public class InitMethodTest {

	private void defineBean(PetiteContainer petiteContainer, String beanName, Class<?> type) {
		petiteContainer.registerPetiteBean(type, beanName, null, null, true);
	}

	@Test
	public void testPostConstructor() {
		PetiteContainer petiteContainer = new PetiteContainer();

		// define two beans
		defineBean(petiteContainer, "bar", Bar.class);
		defineBean(petiteContainer, "foo", Foo.class);

		// wiring
		petiteContainer.registerPetitePropertyInjectionPoint("foo", "bar", "bar");

		// init method
		petiteContainer.registerPetiteInitMethods("foo", POST_CONSTRUCT, "init");

		// param
		petiteContainer.defineParameter("foo.data", "data");

		// get bean
		Foo foo = (Foo) petiteContainer.getBean("foo");

		assertEquals("ctor null null", foo.result);
		assertEquals("bar", foo.bar.toString());
		assertEquals("data", foo.data);
	}

	@Test
	public void testPostDefine() {
		PetiteContainer petiteContainer = new PetiteContainer();

		// define two beans
		defineBean(petiteContainer, "bar", Bar.class);
		defineBean(petiteContainer, "foo", Foo.class);

		// wiring
		petiteContainer.registerPetitePropertyInjectionPoint("foo", "bar", "bar");

		// init method
		petiteContainer.registerPetiteInitMethods("foo", POST_DEFINE, "init");

		// param
		petiteContainer.defineParameter("foo.data", "data");

		// get bean
		Foo foo = (Foo) petiteContainer.getBean("foo");

		assertEquals("ctor bar null", foo.result);
		assertEquals("bar", foo.bar.toString());
		assertEquals("data", foo.data);
	}

	@Test
	public void testPostInitialize() {
		PetiteContainer petiteContainer = new PetiteContainer();

		// define two beans
		defineBean(petiteContainer, "bar", Bar.class);
		defineBean(petiteContainer, "foo", Foo.class);

		// wiring
		petiteContainer.registerPetitePropertyInjectionPoint("foo", "bar", "bar");

		// init method
		petiteContainer.registerPetiteInitMethods("foo", POST_INITIALIZE, "init");

		// param
		petiteContainer.defineParameter("foo.data", "data");

		// get bean
		Foo foo = (Foo) petiteContainer.getBean("foo");

		assertEquals("ctor bar data", foo.result);
		assertEquals("bar", foo.bar.toString());
		assertEquals("data", foo.data);
	}

	@Test
	public void testPostAll() {
		PetiteContainer petiteContainer = new PetiteContainer();

		// define two beans
		defineBean(petiteContainer, "bar", Bar.class);
		defineBean(petiteContainer, "foo", Foo2.class);

		// wiring
		petiteContainer.registerPetitePropertyInjectionPoint("foo", "bar", "bar");

		// init method
		petiteContainer.registerPetiteInitMethods("foo", POST_CONSTRUCT, "init1");
		petiteContainer.registerPetiteInitMethods("foo", POST_DEFINE, "init2");
		petiteContainer.registerPetiteInitMethods("foo", POST_INITIALIZE, "init3");

		// param
		petiteContainer.defineParameter("foo.data", "data");

		// get bean
		Foo2 foo = (Foo2) petiteContainer.getBean("foo");

		assertEquals("1 null null 2 bar null 3 bar data", foo.result);
		assertEquals("bar", foo.bar.toString());
		assertEquals("data", foo.data);
	}

}
