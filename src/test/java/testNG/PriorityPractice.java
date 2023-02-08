package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityPractice
{
	@Test
	public void test0() {
		Reporter.log("test 0", true);
	}
	@Test(priority=-1)
	public void test1() {
		Reporter.log("test 1", true);
	}
	@Test(priority=2)
	public void test2() {
		Reporter.log("test 2", true);
	}
	@Test(priority=-2)
	public void test3() {
		Reporter.log("test 3", true);
	}
	@Test(priority=1)
	public void test4() {
		Reporter.log("test 4", true);
	}

}
