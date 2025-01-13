package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import constants.FrameworkConstants;
import driver.DriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utils.PropertyUtils;
import utils.TestDataLoader;

public class Hooks {
	
	public static WebDriver driver ;
	
	@BeforeAll
	public static void beforeHooks() {
		
	Properties properties = 	PropertyUtils.propertyUtils(FrameworkConstants.CONFIG_FILE_PATH);
		
	FrameworkConstants.BROWSER =  properties.getProperty("browser");	
	
	FrameworkConstants.ENVIRONMENT =  properties.getProperty("environment");	

	
	driver	= DriverFactory.initDriver(FrameworkConstants.BROWSER);
	
	
	driver.get(TestDataLoader.getInstance().getAppURL());

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	}
	
	
	@AfterAll
	public static void afterHooks() {
		driver.quit();
	}
	
	
	
	
	
	

}
