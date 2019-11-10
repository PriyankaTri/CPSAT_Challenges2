package com.cpsat.qa.core;

import org.junit.Before;
import com.cpsat.qa.base.TestBase;
import com.cpsat.qa.steps.AgileTestingAllianceSteps;
import com.cpsat.qa.steps.NSEIndiaSteps;
import com.cpsat.qa.steps.ShopperStopSteps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractTest extends TestBase{
	
	public AgileTestingAllianceSteps agiletestingsteps =  new AgileTestingAllianceSteps();
	
	public NSEIndiaSteps nscsteps = new NSEIndiaSteps();
	public TestBase testbase = new NSEIndiaSteps();
	public ShopperStopSteps shopperstopsteps = new ShopperStopSteps();
	
	
	
	public AbstractTest() {
		super();
	}
	
	
	
/*	@Before()
	public void setup() {
		agiletestingsteps = new AgileTestingAllianceSteps();
		nscsteps = new NSEIndiaSteps();
		testbase = new TestBase();
		shopperstopsteps = new ShopperStopSteps();
	}*/

}
