package com.cpsat.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cpsat.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	
	
	public TestBase()  {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\CPSAT_Challenges\\src\\main\\java\\com\\cpsat\\qa\\config\\cpsat_challenges.properties");
			//FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "//CPSAT_Challenges_2//src//main//java//com//cpsat//qa//config//cpsat_challenges.properties");
			prop.load(ip);
			
		}catch(Exception e) {
			
		}
	}
	
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		//String browernameFir = prop.getProperty("browser");
		System.out.println(browsername);
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");		
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver" , "drivers/geckodriver.exe");
			driver = new FirefoxDriver();   
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);	

}
}
