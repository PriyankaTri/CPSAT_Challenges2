package com.cpsat.qa.steps;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.cpsat.qa.base.TestBase;
import com.cpsat.qa.web.locators.AgileTestingAlliancePO;
import io.qameta.allure.Step;

public class AgileTestingAllianceSteps extends TestBase {

	@Step("This method will click on the Certifications")
	public void clickCertifications() {
		driver.findElement(By.xpath(AgileTestingAlliancePO.certifications)).click();
		}
	
	@Step("This methos will give the image")
	public List<WebElement> allImages() {
		return driver.findElements(By.xpath(AgileTestingAlliancePO.images));
		
	}
	
	@Step("This method will return the images count")
	public int imagesCount() {
		int count = driver.findElements(By.xpath(AgileTestingAlliancePO.images)).size();
        return count;
	}
	
	/*@Step("This method will take the screenshot")
	public void takeScreenShot() throws IOException {
		
		//Take Screenshot and store as a file format
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//now copy the screenshot to desired location using copyfile
		
		FileUtils.copyFile(src, new File("C:\\Users\\Lenovo\\CPSAT_Challenges_2\\ScreenshotFolder"));
		
	}*/
	
	public void takeScreenShot() throws IOException, InterruptedException
	{
	    File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    File dest= new File(".//Screenshots//"+timestamp()+".png");
	    FileUtils.copyFile(scr, dest);
	}

	public String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	@Step("This method will give CP_CCT image")
	public WebElement cpCCT() {
		WebElement cp_cct = driver.findElement(By.xpath(AgileTestingAlliancePO.cp_cct));
		return cp_cct;
	}
	
	
}
