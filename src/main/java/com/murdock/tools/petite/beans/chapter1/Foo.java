package com.murdock.tools.petite.beans.chapter1;

import jodd.petite.meta.PetiteBean;
import jodd.petite.meta.PetiteInitMethod;
import jodd.petite.meta.PetiteInject;

/**
 * 这里的注解标示一个
 * 
 * @author weipeng2k 2015年12月16日 下午10:15:06
 */
@PetiteBean
public class Foo {

	private Service	one;
	private Service	three;
	@PetiteInject("serviceTwo")
	Service			two;
	private String	param;

	@PetiteInject
	public Foo(ServiceOne one) {
		this.one = one;
	}

	@PetiteInject
	public void injectService3(ServiceThree three) {
		this.three = three;
	}

	@PetiteInitMethod
	public void init() {
		param = "I am param.";
	}

	public void foo() {
		System.out.println(one.service(param));
		System.out.println(two.service(param));
		System.out.println(three.service(param));
	}
}
