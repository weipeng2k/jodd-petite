package com.murdock.tools.petite.generics;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import org.junit.Test;

/**
 * <pre>
 * GType，也就是Class类型的泛型反射获取泛型类型
 * 
 * 通过 getTypeParameters()获取TypeVariable，因为在类型上的泛型参数类型都是如下
 * 
 * Type<X, Y, Z extends Number>，这些只能出现TypeVariable
 * 
 * </pre>
 * 
 * @author weipeng2k 2015年12月14日 下午9:36:07
 */
public class ClassGenericTest {

	@Test
	public void test() {
		for (Type type : GType.class.getGenericInterfaces()) {
			System.out.println("GenericInterface类型=" + type + ", 类=" + type.getClass());
		}
		Type type = GType.class.getGenericSuperclass();
		System.out.println("GenericSuperclass类型=" + type + ", 类=" + type.getClass());
		
		for (TypeVariable<Class<GType>> typeVariable : GType.class.getTypeParameters()) {
			System.out.println("TypeVariable类型=" + typeVariable + ", 类=" + typeVariable.getClass());
		}
	}

}
