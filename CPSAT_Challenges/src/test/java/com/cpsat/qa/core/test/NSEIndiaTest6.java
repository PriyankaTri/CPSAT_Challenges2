package com.cpsat.qa.core.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cpsat.qa.core.AbstractTest;

import edu.emory.mathcs.backport.java.util.Collections;



public class NSEIndiaTest6 extends AbstractTest {

	public NSEIndiaTest6() {
		super();
	}
	
	@BeforeTest
	public void initURL() {
		initialization();
		driver.get(prop.getProperty("nsc_url1"));
	}
	
	@Test
	public void writeTableDataGainer() throws Exception {
		nscsteps.clickTopGainerLooser();
		int rowCount = nscsteps.tableRow().size();
		int colCount = nscsteps.tableColumn().size();

		XSSFWorkbook wkb = new XSSFWorkbook();       
		XSSFSheet sheet1 = wkb.createSheet("TopGainer"); 
		
		XSSFRow excelRow;
		for(int i=1;i<=rowCount;i++) {
			excelRow = sheet1.createRow(i-1); 
			for(int j=1;j<=colCount;j++) {
						         
					excelRow.createCell(j-1).setCellValue(nscsteps.tabledata(i,j));  
				
				}
						
		}
		File src = new File("./NSEData.xlsx");
		FileOutputStream fos = new FileOutputStream(src);
		wkb.write(fos);
		wkb.close();
		}
	
	@Test
	public void writeTableDataLoser() throws Exception {
		nscsteps.clickTopGainerLooser();
		Thread.sleep(3000);
		nscsteps.clickLoser();
		int rowCount = nscsteps.tableRow1().size();
		int colCount = nscsteps.tableColumn1().size();

		XSSFWorkbook wkb = new XSSFWorkbook();       
		XSSFSheet sheet1 = wkb.createSheet("TopLoser"); 
		
		XSSFRow excelRow;
		for(int i=1;i<=rowCount;i++) {
			excelRow = sheet1.createRow(i-1); 
			for(int j=1;j<=colCount;j++) {
						         
					excelRow.createCell(j-1).setCellValue(nscsteps.tabledata1(i,j));  
				
				}
						
		}
		File src = new File("./Book1.xlsx");
		FileOutputStream fos = new FileOutputStream(src);
		wkb.write(fos);
		wkb.close();
		}
	
	@Test
	public void checkGainerPercentage() {
		nscsteps.clickTopGainerLooser();
		List<String> gainerList = new ArrayList<String>();
		int count = nscsteps.tableRow().size();
		for(int i=2;i<count;i++) {
			gainerList.add(nscsteps.tabledata(i, 3));
		}
		System.out.println(gainerList);
		gainerList.stream().sorted().collect(Collectors.toList()).equals(gainerList);
	}
	
	@Test
	public void checkLosersPercentage() {
		nscsteps.clickTopGainerLooser();
		nscsteps.clickLoser();
		List<String> loserList = new ArrayList<String>();
		int count = nscsteps.tableRow1().size();
		for(int i=2;i<count;i++) {
			loserList.add(nscsteps.tabledata1(i, 3));
		}
		System.out.println(loserList);
		loserList.stream().sorted().collect(Collectors.toList()).equals(loserList);
	}
	
	@Test
	public void assertDateAndTime(){
		
		nscsteps.clickTopGainerLooser();
		nscsteps.dateTime().substring(6, 27);
		DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
		Date date = new Date();
		String systemDateTime= dateFormat.format(date);
		String dataDateTime = nscsteps.dateTime().toString().substring(6, 27);
		System.out.println(dataDateTime);
		System.out.println(systemDateTime);
		System.out.println("Comparing " + dataDateTime + " and " + systemDateTime + " : " + dataDateTime.equals(systemDateTime));
		Assert.assertFalse(dataDateTime.equals(systemDateTime));
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	}
	