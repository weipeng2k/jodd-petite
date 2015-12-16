package com.murdock.tools.petite.generics;

import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

import org.junit.Test;

/**
 * <pre>
 * 类型参数
 * 获取的类型如果为TypeVariable，则可以通过getBounds来获取类型数组
 * 一个泛型类型可能在定义的时候继承自多个地方
 * <E extends Closeable & Map<E, String> & Serializable>，这里就有
 * Closeable，Class类型
 * Map<E, String>, ParameterizedType
 * Serializable，Class类型
 * 
 * </pre>
 * 
 * @author weipeng2k 2015年12月12日 下午4:31:51
 */
public class TypeVariableTest {

	<E extends Closeable & Map<E, String> & Serializable> E m() {
		return null;
	}

	@Test
	public void test() {
		for (Method method : TypeVariableTest.class.getDeclaredMethods()) {
			if (method.getName().equals("m")) {
				TypeVariable<?> tv = (TypeVariable<?>) method.getGenericReturnType();
				for (Type type : tv.getBounds()) {
					System.out.println("Bound类型=" + type + ", 类=" + type.getClass());
				}
			}
		}
	}

}
