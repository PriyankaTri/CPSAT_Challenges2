package com.cpsat.qa.core.test;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.cpsat.qa.core.AbstractTest;

public class AgileTestingAllianceTest1 extends AbstractTest {

	public AgileTestingAllianceTest1() {
		super();
	}
	
	@Before
	public void initURL() {
		initialization();
		driver.get(prop.getProperty("agiletestingalliance_url"));
	}
	
	@Test
	public void countImages() {
		agiletestingsteps.clickCertifications();
		int count = agiletestingsteps.imagesCount();
		System.out.println(count);
		//return count;
		
	}
	
	@Test
	public void getURL() {
		agiletestingsteps.clickCertifications();
		int count = agiletestingsteps.imagesCount();
		for(int i=0;i<count;i++) {
			String url = agiletestingsteps.allImages().get(i).getAttribute("href");
			System.out.println(url);
		}
	}
	
	@Test
	public void checkLink() {
		SoftAssert softAssert = new SoftAssert();
		agiletestingsteps.clickCertifications();
		
	       String url = "";
	       HttpURLConnection huc = null;
	       int respCode = 200;
	      List<WebElement> links =  agiletestingsteps.allImages();
	       Iterator<WebElement> it = links.iterator();
	       while(it.hasNext()){
	           url = it.next().getAttribute("href");
	           System.out.println(url);
	           if(url == null || url.isEmpty()){
	System.out.println("URL is either not configured for anchor tag or it is empty");
	               continue;
	           }
	           
	           try {
	               huc = (HttpURLConnection)(new URL(url).openConnection());
	               huc.setRequestMethod("HEAD");
	               huc.connect();
	               respCode = huc.getResponseCode();
	               if(respCode >= 400){
	                   System.out.println(url+" is a broken link");
	               }
	               else{
	                   System.out.println(url+" is a valid link");
	                   
	               }
	           } catch (MalformedURLException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	           } catch (IOException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	           }
	       }
	       softAssert.assertAll();
	   }
	
	@Test
	public void screenShot() throws Exception {
		agiletestingsteps.clickCertifications();
		agiletestingsteps.takeScreenShot();
	}
	
	@Test
	public void hoverCPCCT() throws Exception {
		agiletestingsteps.clickCertifications();
		Thread.sleep(5000);
		Actions ac = new Actions(driver);
		ac.moveToElement(agiletestingsteps.cpCCT()).perform();
		Thread.sleep(5000);
		agiletestingsteps.takeScreenShot();
	}
	
	
	@After
	public void tearDown() {
		driver.close();
	}
}
