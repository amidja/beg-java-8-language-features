// GenericsRuntmeClassTest.java
package com.jdojo.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericsRuntmeClassTest {
	public static void main(String[] args) {
		Wrapper<String> a = new Wrapper<String>("Hello");
		Wrapper<Integer> b = new Wrapper<Integer>(123);
		Class aClass = a.getClass();
		Class bClass = b.getClass();
		System.out.println("Class for a: " + aClass.getName());
		System.out.println("Class for b: " + bClass.getName());
		System.out.println("aClass == bClass: " + (aClass == bClass));

		Wrapper<?> unknownWrapper = new Wrapper<String>("Bob");
		String str = String.valueOf(unknownWrapper.get());

		WrapperUtil.printDetails(unknownWrapper);

		int[] myarray = (int[]) Array.newInstance(Integer.TYPE, 10);

		for (int index = 0; index < myarray.length; index++) {
			myarray[index] = index;
		}


		System.out.println("myArray: "  + Arrays.toString(myarray));

		//Heap Pollution
		Wrapper unknownIntWrapper = new Wrapper<Integer>(123);
		Wrapper<String> strWrapper = unknownIntWrapper;
		try{
			String value = strWrapper.get(); //will throw ClassCastException
		}catch (ClassCastException ex){
			System.out.println(ex);
		}

	}
}
