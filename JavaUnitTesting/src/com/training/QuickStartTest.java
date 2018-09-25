package com.training;

import static org.junit.Assert.*;

import org.junit.*;

public class QuickStartTest {

	QuickStart obj;
	@Before
	public void init(){
		obj=new QuickStart();
	}
	
	@Test
	public void testGetMessage() {
		//fail("Not yet implemented");
		//QuickStart obj=new QuickStart();
		String expected="HELLO";
		String actual=obj.getMessage();
		assertEquals("Get Message return should be Upper case String",expected, actual);
	}

	@Test
	public void testCalculateDiscountCond1(){
		double amount=1000.0;
		double expected=0.10;
		double actual=obj.calculateDiscount(amount);
		assertEquals("Discount should be 0.10 when amount<5000",expected, actual,2);
	}
	
	@Test
	public void testCalculateDiscountCond2(){
		double amount=6000.0;
		double expected=0.15;
		double actual=obj.calculateDiscount(amount);
		assertEquals("Discount should be 0.15 when amount>5000",expected, actual,2);
	}
	
	@Test
	public void testCalculateDiscountCond3(){
		Double amount=5000.0;
		Double expected=0.10;
		Double actual=obj.calculateDiscount(amount);
		assertEquals("Discount should be 0.10 when amount=5000",expected, actual);
	}
	
	@Test(expected=Exception.class)
	public void testCalculateDiscountCond4(){
		Double amount=-5000.0;
		obj.calculateDiscount(amount);
		//assertEquals("Discount should be 0.10 when amount=5000",expected, actual);
	}
	
	@Test
	public void testCalculateDiscountCond5(){
		Double amount=-5000.0;
		try{
			obj.calculateDiscount(amount);
			fail("Failed Test- Exception Should be thrown");
		}catch(IllegalArgumentException e){
			assertEquals(e.getMessage(),"Amount should be positive");
		}
		//assertEquals("Discount should be 0.10 when amount=5000",expected, actual);
	}
	
}
