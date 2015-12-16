package com.murdock.tools.petite.generics;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.junit.Test;

/**
 * <pre>
 * 对于一个方法
 * 
 * <E extends Throwable> method(List<E> eList, String s) throws E
 * 存在方法参数泛型
 * 存在返回值泛型
 * 存在抛出异常泛型
 * 
 * m.getGenericParameterTypes()返回参数的泛型列表。
 * List 是一个Class
 * List<String> 这个就是一个ParameterizedType，对于这个类型就是有 <> 修饰的类型
 * List<? extends Number> 这个是一个WildCardType
 * List<E[]> 这个是一个GenericArrayType
 * E这个是一个TypeVariable
 * 如果方法中的参数类型是泛型，则根据上面的返回对应的类型
 * 
 * ParameterizedType中的
 * Type[] getActualTypeArguments()返回的是泛型参数类型的参数类型
 * TTT<E, X, Y>，调用getActualTypeArguments()后返回Type[]，可以预见均为TypeVariable
 * 
 * Type getRawType()返回的声明非参数类型
 * List<E>，调用getRawType()，返回的是java.util.List
 * 
 * Type getOwnerType()返回的所有者类型，一般是内部类，包括静态内部类
 * 
 * ParameterizedType是对 类型<参数类型1，参数类型2> 的一种定义，当通过getActualTypeArguments()方法调用，返回的
 * 是类型数组[] {参数类型1， 参数类型2}，也可以通过getRawType()获取声明的类型，如果这个类型的OwnerType也可以通过getOwnerType()获取，一般是内部类定义所在的类
 * 
 * </pre>
 * 
 * @author weipeng2k 2015年12月11日 下午2:23:45
 */
@SuppressWarnings({ "rawtypes", "hiding" })
public class GenericsMethod {
	public <E extends Throwable, TZ> TZ m(List list, List<String> strList, List<E> elist,
			List<? extends Number> wildList, List<List<E>> elistlist, List<E[]> array, int i, String s, T<String> e,
			E ee, TTT<E, ? extends Number, String> ttt, TT<E> tt, Z<String> z) throws E, Exception {
		return null;
	}

	static class T<E> {
		E e;
	}

	static class TTT<X, Y, Z> {
		X	t;
		Y	y;
		Z	z;
	}

	@Test
	public void testGetGenericParameterTypes() {
		for (Method m : GenericsMethod.class.getMethods()) {
			// m方法中的参数
			if (m.getName().equals("m")) {
				for (Type type : m.getGenericParameterTypes()) {
					System.out.println("===========================");
					System.out.println("类型=" + type + ", 类=" + type.getClass());
				}
			}
		}
	}

	@Test
	public void getThrowable() {
		for (Method m : GenericsMethod.class.getMethods()) {
			// m方法中的参数
			if (m.getName().equals("m")) {
				Type[] types = m.getGenericExceptionTypes();
				for (Type type : types) {
					System.out.println("类型=" + type + ", 类=" + type.getClass());
				}
			}
		}
	}

	static class Z<Y> {

	}

	@Test
	public void getActualTypeArguments() {
		for (Method m : GenericsMethod.class.getMethods()) {
			// m方法中的参数
			if (m.getName().equals("m")) {
				for (Type type : m.getGenericParameterTypes()) {
					System.out.println("===========================");
					System.out.println("类型=" + type + ", 类=" + type.getClass());
					// 带有<>的类型
					if (type instanceof ParameterizedType) {
						ParameterizedType pt = (ParameterizedType) type;
						for (Type t : pt.getActualTypeArguments()) {
							System.out.println("参数化类型=" + t + ", 类=" + t.getClass());
						}
						System.out.println("声明参数类型的类型rawType=" + pt.getRawType());
						System.out.println("声明参数类型的类型ownerType=" + pt.getOwnerType());
					}
				}
			}
		}
	}
}
