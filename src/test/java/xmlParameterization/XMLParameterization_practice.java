package xmlParameterization;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class XMLParameterization_practice 
{
	@Test
	public void demoTest(XmlTest xml)
	{
		System.out.println("In demoTest");
		System.out.println(xml.getParameter("url"));
		System.out.println(xml.getParameter("username"));
		System.out.println(xml.getParameter("password"));
	}
}
