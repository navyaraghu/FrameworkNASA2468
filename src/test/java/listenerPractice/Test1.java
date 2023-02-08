package listenerPractice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseClassPractice;

@Listeners(genericLibraries.ListenerImplementationPractice.class)
public class Test1 extends BaseClassPractice
{
@Test
public void test() {
	System.out.println("test");
}
}
