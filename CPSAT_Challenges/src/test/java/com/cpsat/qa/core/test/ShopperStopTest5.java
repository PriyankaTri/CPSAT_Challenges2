package com.cpsat.qa.core.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cpsat.qa.core.AbstractTest;



public class ShopperStopTest5 extends AbstractTest {

	public ShopperStopTest5() {
		super();
	}
	
	@BeforeTest
	public void initURL() {
		initialization();
		driver.get(prop.getProperty("shopperstop_url"));
		
	}
	
	@Test(priority=1)
	public void clickBanners() {
		int c = shopperstopsteps.getBanner().size();
		
		System.out.println(c);
		for(int i=0;i<c;i++) {
			shopperstopsteps.getBanner().get(i).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void getMenAccessories() throws Exception {
		shopperstopsteps.closeCookiesPolicy();
		shopperstopsteps.mouseHoverMenSection();
		Thread.sleep(3000);
		shopperstopsteps.mouseHoverMenFragrance();
		Thread.sleep(2000);
		List<WebElement> list= shopperstopsteps.fetchAccessories();
		List<String> accessories = new ArrayList<String>();
		int size = list.size();
		for(int i=0;i<size;i++) {
		accessories.add( shopperstopsteps.fetchAccessories().get(i).getText());
		}
		System.out.println(accessories);
	}
	
	@Test
	public List<String> getAllCities() {
		shopperstopsteps.clickAllStores();
		List<String> list = new ArrayList<String>();
		List<WebElement> allcitiesname = shopperstopsteps.getCities();
		int count= allcitiesname.size();
		
		for(int i=0;i<count;i++) {
			System.out.println(allcitiesname.get(i).getText());
			list.add(allcitiesname.get(i).getText());
		}
		return list;
	}
	
	@Test
	public void assertCities() throws Exception {
		List<String> cities = getAllCities();
		int count= cities.size();
		
		for(int i=0;i<count;i++) {
			Assert.assertEquals(cities.get(0), "Agra");
			Assert.assertEquals(cities.get(5), "Bhopal");
			Assert.assertEquals(cities.get(28), "Mysore");
		}
		
	}
	
	@Test
	public void printTitle() {
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("StoreFinder | Shoppers Stop"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}