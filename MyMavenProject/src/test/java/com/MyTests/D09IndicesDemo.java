package com.MyTests;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class D09IndicesDemo {
	@Test(dataProvider = "dp")
	public void test(Integer n, String s) {
		System.out.println(n + " - " + s);
	}

	@DataProvider (indices = {1, 2, 4})
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { 1, "a" },
			new Object[] { 2, "b" },
			new Object[] { 3, "c" },
			new Object[] { 4, "d" },
			new Object[] { 5, "e" },
		};
	}
}
