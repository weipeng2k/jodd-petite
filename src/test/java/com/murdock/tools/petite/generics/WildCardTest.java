package com.murdock.tools.petite.generics;

import java.io.Closeable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

/**
 * <pre>
 * 通配符，一般是带有?这种符号的泛型类型
 * 有上界和下届之分
 * 比如：
 * <? super String>，代表这个?是String的超类，下界是String，上界是Object
 * <? extends Closeable>，代表这个?是Closeable的子类，下界没有，上界是Closeable
 * <?> 这个类似<? extends Object>，这个?的下界没有，上界是Object
 * 
 * </pre>
 * 
 * @author weipeng2k 2015年12月14日 下午6:31:44
 */
public class WildCardTest {

	// 下界
	void m(List<? super String> list) {
	}

	// 上界
	void m1(List<? extends Closeable> list) {

	}

	void m2(List<?> list) {

	}

	void m3(List<? extends Number> list) {

	}

	@Test
	public void test() {
		new WildCardTest().m3(new ArrayList<Integer>());
		new WildCardTest().m3(new List<Number>() {

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator<Number> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean add(Number e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends Number> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(int index, Collection<? extends Number> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Number get(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Number set(int index, Number element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void add(int index, Number element) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Number remove(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int indexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int lastIndexOf(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public ListIterator<Number> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ListIterator<Number> listIterator(int index) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Number> subList(int fromIndex, int toIndex) {
				// TODO Auto-generated method stub
				return null;
			}});
	}

	@Test
	public void testM() {
		for (Method method : WildCardTest.class.getDeclaredMethods()) {
			if (method.getName().equals("m")) {
				WildcardType wct = (WildcardType) ((ParameterizedType) method.getGenericParameterTypes()[0])
						.getActualTypeArguments()[0];
				for (Type type : wct.getUpperBounds()) {
					System.out.println("UpperBounds类型=" + type + ", 类=" + type.getClass());
				}
				for (Type type : wct.getLowerBounds()) {
					System.out.println("LowerBounds类型=" + type + ", 类=" + type.getClass());
				}
			}
		}
	}

	@Test
	public void testM1() {
		for (Method method : WildCardTest.class.getDeclaredMethods()) {
			if (method.getName().equals("m1")) {
				WildcardType wct = (WildcardType) ((ParameterizedType) method.getGenericParameterTypes()[0])
						.getActualTypeArguments()[0];
				for (Type type : wct.getUpperBounds()) {
					System.out.println("UpperBounds类型=" + type + ", 类=" + type.getClass());
				}
				for (Type type : wct.getLowerBounds()) {
					System.out.println("LowerBounds类型=" + type + ", 类=" + type.getClass());
				}
			}
		}
	}

	@Test
	public void testM2() {
		for (Method method : WildCardTest.class.getDeclaredMethods()) {
			if (method.getName().equals("m2")) {
				WildcardType wct = (WildcardType) ((ParameterizedType) method.getGenericParameterTypes()[0])
						.getActualTypeArguments()[0];
				for (Type type : wct.getUpperBounds()) {
					System.out.println("UpperBounds类型=" + type + ", 类=" + type.getClass());
				}
				for (Type type : wct.getLowerBounds()) {
					System.out.println("LowerBounds类型=" + type + ", 类=" + type.getClass());
				}
			}
		}
	}

}
