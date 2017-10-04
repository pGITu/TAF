package com.TAF.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox extends Browser{	
	private WebDriver driver = null;
	private DesiredCapabilities capabilities = null;
	
	Firefox() {
		this.setFirefoxProperty();
		this.capabilities = DesiredCapabilities.firefox();
		this.capabilities.setCapability("acceptInsecureCerts", true);
	}
	
	Firefox(DesiredCapabilities capabilities) {
		this.setFirefoxProperty();
		this.capabilities = capabilities;
		this.capabilities.setCapability("acceptInsecureCerts", true);
	}

	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		try {
			driver = new FirefoxDriver(this.capabilities);
		}
		catch (Exception e) {
			System.err.println("Driver not found");
		}
		return driver;
	}
	
	private void setFirefoxProperty() {
		super.setSystemProperty("webdriver.gecko.driver", "geckodriver.exe");
	}
}
