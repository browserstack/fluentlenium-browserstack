package com.browserstack;

import java.net.URL;
import java.lang.String;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.seleniumhq.selenium.fluent.FluentWebDriver;

public class App  {
  public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
  public static final String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
  public static final String HUB_URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@hub.browserstack.com/wd/hub";

  public static void main( String[] args ) throws Exception {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("os", "OS X");
    caps.setCapability("os_version", "El Capitan");
    caps.setCapability("browser", "firefox");
    caps.setCapability("browser_version", "44");
    caps.setCapability("build", "Sample FluentLenium Tests");
    caps.setCapability("browserstack.debug", "true");

    WebDriver driver = new RemoteWebDriver(new URL(HUB_URL), caps);
    FluentWebDriver fwd = new FluentWebDriver(driver);

    driver.get("http://google.com");
    fwd.input(By.name("q")).sendKeys("BrowserStack").submit();
    System.out.println(driver.getTitle());

    driver.quit();
  }
}
