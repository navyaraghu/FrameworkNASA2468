package testNG;

import org.testng.annotations.Test;

public class EnableAnnotationPractice 
{
	
	@Test(invocationCount=3)
	public void demo1() {
		System.out.println("demo1");
	}
	@Test(invocationCount=2, priority=1)
	public void demo2() {
		System.out.println("demo2");
	}
	@Test(enabled=false)
	public void demo3() {
		System.out.println("demo3");
	}
	@Test(invocationCount=2)
	public void demo4() {
		System.out.println("demo4");
	}

}
