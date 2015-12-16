package com.murdock.tools.petite.generics;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Set;

import org.junit.Test;

/**
 * <pre>
 * GenericArrayType是泛型数组类型
 * 它所包含的成员类型，可能是ParameterizedType或者TypeVariable
 * 
 * 泛型修饰数组的类型为GenericArrayType，调用getGenericComponentType()返回数组前面的内容
 * E[] 返回 E
 * Set<E>[] 返回 Set<E>，ParameterizedType
 * 
 * </pre>
 * 
 * @author weipeng2k 2015年12月12日 下午3:45:22
 */
public class GenericArrayTypeTest {
	class T<E extends Number> {
		E[] earray;
		
		Set<E>[] searray;
	}

	@Test
	public void test() throws Exception {
		Field field = T.class.getDeclaredField("earray");
		Type type = field.getGenericType();
		System.out.println("===========================");
		System.out.println("类型=" + type + ", 类=" + type.getClass());
		GenericArrayType gat = (GenericArrayType) type;
		Type gct = gat.getGenericComponentType();
		System.out.println("成员类型=" + gct + ", 类=" + gct.getClass());
	}
	
	@Test
	public void parameterized() throws Exception {
		Field field = T.class.getDeclaredField("searray");
		Type type = field.getGenericType();
		System.out.println("===========================");
		System.out.println("类型=" + type + ", 类=" + type.getClass());
		GenericArrayType gat = (GenericArrayType) type;
		Type gct = gat.getGenericComponentType();
		System.out.println("成员类型=" + gct + ", 类=" + gct.getClass());
		
	}

}
