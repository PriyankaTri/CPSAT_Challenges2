package com.cpsat.qa.core.test;


import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cpsat.qa.core.AbstractTest;
import com.cpsat.qa.steps.NSEIndiaSteps;

public class NSEIndiaTest4 extends AbstractTest {
	
	
	public NSEIndiaTest4() {
		super();
	}
	
	@BeforeTest
	public void initURL() {
		initialization();
		driver.get(prop.getProperty("nsc_url"));
	}
	
	@Test(priority=1)
	public void getValue1() throws Exception{
		
		String companyname1 = NSEIndiaSteps.readData(0,0).getStringCellValue();
		NSEIndiaSteps.keyword().sendKeys(companyname1);
		Thread.sleep(2000);
		NSEIndiaSteps.keyword().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String facevalue = nscsteps.faceValue().getText();
		String high52 = nscsteps.weekHigh52().getText();
		String low52 = nscsteps.weekLow52().getText();
		
		System.out.println("Face Value For Bajaj Finserv is:" + facevalue);
		System.out.println("52 Week High Value Bajaj Finserv is:" +high52);
		System.out.println("52 Week Low Value Bajaj Finserv is:" +low52);
		//driver.navigate().back();
		Thread.sleep(2000);
		agiletestingsteps.takeScreenShot();	
	}
	
	@Test(priority=2)
	public void getValue2() throws Exception{
		
		String companyname2 = NSEIndiaSteps.readData(1,0).getStringCellValue();
		NSEIndiaSteps.keyword().clear();
		NSEIndiaSteps.keyword().sendKeys(companyname2);
		Thread.sleep(2000);
		NSEIndiaSteps.keyword().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String facevalue = nscsteps.faceValue().getText();
		String high52 = nscsteps.weekHigh52().getText();
		String low52 = nscsteps.weekLow52().getText();
		
		System.out.println("Face Value For Hindustan Unilever is:" + facevalue);
		System.out.println("52 Week High Value Hindustan Unilever is:" +high52);
		System.out.println("52 Week Low Value Hindustan Unilever is:" +low52);
		Thread.sleep(2000);
		agiletestingsteps.takeScreenShot();	
		//Thread.sleep(2000);
	
	}
	
	@Test(priority=3)
	public void getValue3() throws Exception{
		
		String companyname3 = NSEIndiaSteps.readData(2,0).getStringCellValue();
		NSEIndiaSteps.keyword().clear();
		NSEIndiaSteps.keyword().sendKeys(companyname3);
		Thread.sleep(2000);
		NSEIndiaSteps.keyword().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String facevalue = nscsteps.faceValue().getText();
		String high52 = nscsteps.weekHigh52().getText();
		String low52 = nscsteps.weekLow52().getText();
		
		System.out.println("Face Value For Mahindra Ltd is:" + facevalue);
		System.out.println("52 Week High Value Mahindra Ltd is:" +high52);
		System.out.println("52 Week Low Value Mahindra Ltd is:" +low52);
		Thread.sleep(2000);
		agiletestingsteps.takeScreenShot();
		
	}
	
	@Test(priority=4)
	public void getValue4() throws Exception{
		
		String companyname4 = NSEIndiaSteps.readData(3,0).getStringCellValue();
		NSEIndiaSteps.keyword().clear();
		NSEIndiaSteps.keyword().sendKeys(companyname4);
		Thread.sleep(2000);
		NSEIndiaSteps.keyword().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String facevalue = nscsteps.faceValue().getText();
		String high52 = nscsteps.weekHigh52().getText();
		String low52 = nscsteps.weekLow52().getText();
		
		System.out.println("Face Value For GAIL is:" + facevalue);
		System.out.println("52 Week High Value GAIL is:" +high52);
		System.out.println("52 Week Low Value GAIL is:" +low52);
		Thread.sleep(2000);
		agiletestingsteps.takeScreenShot();	
		
	}
	

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
