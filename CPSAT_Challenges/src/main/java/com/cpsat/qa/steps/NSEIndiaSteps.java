package com.cpsat.qa.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cpsat.qa.base.TestBase;
import com.cpsat.qa.web.locators.NSEIndiaPO;

import io.qameta.allure.Step;

public class NSEIndiaSteps extends TestBase {
	
	@Step("This method will return list of Market Watch number")
	public List<WebElement> marketWatchNumbers() {
		return driver.findElements(By.xpath(NSEIndiaPO.market_arrow));
		
	}
	
	
	@Step("This method will return the minimum value")
	public Integer findMin(List<Integer> list) 
    { 
  
        // check list is empty or not 
        if (list == null || list.size() == 0) { 
            return Integer.MAX_VALUE; 
        } 
  
        // create a new list to avoid modification  
        // in the original list 
        List<Integer> sortedlist = new ArrayList<Integer>(list); 
  
        // sort list in natural order 
        Collections.sort(sortedlist); 
  
        // first element in the sorted list 
        // would be minimum 
        return sortedlist.get(0); 
    } 
	
	@Step("This method will give the keyword")
	public static WebElement keyword() {
		return driver.findElement(By.xpath(NSEIndiaPO.keyword));
	}
	
	@Step("This method will assert the page")
	public static String assertMessage() {
		return driver.findElement(By.xpath(NSEIndiaPO.assert_companyname)).getText();
	}
	
	@Step("This method will return face value element")
	public WebElement faceValue() {
		return driver.findElement(By.xpath(NSEIndiaPO.face_value));
	}
	
	@Step("This method will return 52week high element")
	public WebElement weekHigh52() {
		return driver.findElement(By.xpath(NSEIndiaPO.high_52week));
	}
	
	@Step("This method will return face value element")
	public WebElement weekLow52() {
		return driver.findElement(By.xpath(NSEIndiaPO.low_52week));
	}
	
	@Step("Read data from excel file")
	public static XSSFCell readData(int x,int y) throws Exception {

		File src = new File("./Assignment_Challenge.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheetAt(0);
		return ws.getRow(x).getCell(y);
	}
	
	public FileOutputStream fileLoading() {

		try {
			File src = new File("./Assignment_Challenge.xlsx");
			FileOutputStream fos = new FileOutputStream(src);
			return fos;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	@Step("Return workbook")
	public XSSFWorkbook returnWorkbook() throws Exception {
		
		XSSFWorkbook wkb = new XSSFWorkbook();
		return wkb;
		
	}
	
	
	public void writingAndClosingTheSheet(FileOutputStream k){
		
	
		try {
			
			returnWorkbook().write(k);
			k.close();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Step("Write data to excel file")
	public XSSFSheet creatSheet(String sheetName) throws Exception {

		/*File src = new File("./NSEData.xlsx");
		FileOutputStream fos = new FileOutputStream(src);*/
		
		//XSSFWorkbook wkb = new XSSFWorkbook();  
		return returnWorkbook().createSheet(sheetName);
		//XSSFSheet sheet1 = wkb.createSheet("DataStorage"); 
		//return sheet1;
	}
	
	@Step("This method will return the table row")
	public List<WebElement> tableRow() {
		List<WebElement> rows = driver.findElements(By.xpath(NSEIndiaPO.table_row));
		return rows;
	}
	
	@Step("This method will return the table row")
	public List<WebElement> tableColumn() {
		List<WebElement> column = driver.findElements(By.xpath(NSEIndiaPO.table_column));
		return column;
	}
	
	@Step("This method will get the gainer table data")
	public String tabledata(int i, int j) {
		if(i==1)
		return driver.findElement(By.xpath("//table[@id='topGainers']//tbody//tr["+i+"]//th["+j+"]")).getText();
		
		else {
			return driver.findElement(By.xpath("//table[@id='topGainers']//tbody//tr["+i+"]//td["+j+"]")).getText();
		}
		
	}
	
	@Step("This method will return the table row")
	public List<WebElement> tableRow1() {
		List<WebElement> rows = driver.findElements(By.xpath(NSEIndiaPO.table_row1));
		return rows;
	}
	
	@Step("This method will return the table row")
	public List<WebElement> tableColumn1() {
		List<WebElement> column = driver.findElements(By.xpath(NSEIndiaPO.table_column1));
		return column;
	}
	
	@Step("This method will get the gainer table data")
	public String tabledata1(int i, int j) {
		if(i==1)
		return driver.findElement(By.xpath("//table[@id='topLosers']//tbody//tr["+i+"]//th["+j+"]")).getText();
		
		else {
			return driver.findElement(By.xpath("//table[@id='topLosers']//tbody//tr["+i+"]//td["+j+"]")).getText();
		}
		
	}
	
	@Step("This method will click on the Top ten gainer/looser tab")
	public void clickTopGainerLooser() {
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.xpath(NSEIndiaPO.live_market));
		actions.moveToElement(target).perform();
		driver.findElement(By.xpath(NSEIndiaPO.top_10)).click();
	}
	
	@Step("This method will click the Loser table")
	public void clickLoser() {
		driver.findElement(By.xpath(NSEIndiaPO.loser)).click();
	}
	
	@Step("This method will return the date and time")
	public String dateTime() {
		return driver.findElement(By.xpath(NSEIndiaPO.datetime)).getText();
	}
	/*@Step("This method will click on enter")
	public Actions enterKeyboard(String s) {
		Actions ac = new Actions(driver);
		 return ac.click(this.keyword()).sendKeys(s);
	}
*/
}
