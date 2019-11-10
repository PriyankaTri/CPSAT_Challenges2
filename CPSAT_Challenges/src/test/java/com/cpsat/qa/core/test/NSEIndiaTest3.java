package com.cpsat.qa.core.test;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.cpsat.qa.core.AbstractTest;
import com.cpsat.qa.steps.NSEIndiaSteps;




public class NSEIndiaTest3 extends AbstractTest {

	public NSEIndiaTest3() {
		super();
	}
	
	@BeforeTest
	public void initURL() {
		initialization();
		driver.get(prop.getProperty("nsc_url"));
	}
	
	@Test(priority=1)
	public void enterName() throws Exception{
		//NSEIndiaSteps.keyword();
		/*Actions ac = new Actions(driver);
		Thread.sleep(3000);
		ac.click(NSEIndiaSteps.keyword()).sendKeys(prop.getProperty("keyword1"));
		//NSEIndiaSteps.keyword();
*/		
		NSEIndiaSteps.keyword().sendKeys(prop.getProperty("Keyword1").toString());;
		Thread.sleep(3000);
		NSEIndiaSteps.keyword().sendKeys(Keys.ENTER);
		
	}
	
	@Test
	public void takeScreenShot() throws IOException, Exception {
		enterName();
		Assert.assertEquals("Eicher Motors Limited", NSEIndiaSteps.assertMessage());
		Thread.sleep(3000);
		agiletestingsteps.takeScreenShot();
	}
	
	@Test
	public void printValues() throws Exception{
		enterName();
		String facevalue = nscsteps.faceValue().getText();
		String high52 = nscsteps.weekHigh52().getText();
		String low52 = nscsteps.weekLow52().getText();
		
		System.out.println("Face Value is:" + facevalue);
		System.out.println("52 Week High Value is:" +high52);
		System.out.println("52 Week Low Value is:" +low52);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
