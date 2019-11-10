package com.cpsat.qa.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cpsat.qa.base.TestBase;
import com.cpsat.qa.web.locators.NSEIndiaPO;
import com.cpsat.qa.web.locators.ShopperStopPO;

import io.qameta.allure.Step;

public class ShopperStopSteps extends TestBase {
	
	@Step("This method will give the banner_slider")
	public List<WebElement> getBanner() {
		return driver.findElements(By.xpath(ShopperStopPO.banners));
	}

	/*@Step("This method will return the banner_slider count")
	public static int getBannerCount() {
		return driver.findElements(By.xpath(ShopperStopPO.banners)).size();
	}*/
	
	@Step("This method will click on AllStores option")
	public void clickAllStores(){
		driver.findElement(By.xpath(ShopperStopPO.appstores)).click();
	}
	
	@Step("This method will return all cities name")
	public List<WebElement> getCities(){
		WebElement ddlist = driver.findElement(By.xpath(ShopperStopPO.city_dropdown));
		Select s = new Select(ddlist);
		List<WebElement> alloptions = s.getOptions();
		return alloptions;
	}
	
	@Step("Click on Men section")
	public void mouseHoverMenSection() {
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.xpath(ShopperStopPO.men_menu));
		actions.moveToElement(target).perform();
	}
	
	@Step("Click on Men fragrance section")
	public void mouseHoverMenFragrance() {
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.xpath(ShopperStopPO.menFragrance));
		actions.moveToElement(target).perform();
	}
	
	@Step("Fetching the Accessories")
	public List<WebElement> fetchAccessories() {
		return driver.findElements(By.xpath(ShopperStopPO.accesoriesDetails));
	}
	
	@Step("Close Privacy policy")
	public void closeCookiesPolicy() {
		driver.findElement(By.xpath(ShopperStopPO.cookiesPolicy)).click();
	}
			
}
