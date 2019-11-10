package com.cpsat.qa.core.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cpsat.qa.core.AbstractTest;

public class NSEIndiaTest2 extends AbstractTest {

	public NSEIndiaTest2() {
		super();
	}
	
	@BeforeTest
	public void initURL() {
		initialization();
		driver.get(prop.getProperty("nsc_url"));
	}
	
	@Test
	public void getNumbers() {
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<3;i++) {
			int num = Integer.parseInt(nscsteps.marketWatchNumbers().get(i).getText());
			System.out.println("Market Watch Numbers are " + num );
			list.add(num);		
			
	}
		System.out.println("Minimum number is" + nscsteps.findMin(list));
				
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}

