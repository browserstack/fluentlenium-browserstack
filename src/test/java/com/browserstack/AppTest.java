package com.browserstack;

import java.net.URL;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.fluentlenium.adapter.FluentTest;
import static org.fest.assertions.Assertions.assertThat;

public class AppTest extends FluentTest {
  public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
  public static final String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
  public static final String HUB_URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@hub.browserstack.com/wd/hub";

  @Test
  public void title_of_bing_should_contain_search_query_name() {
    goTo("http://www.bing.com");
    fill("#sb_form_q").with("FluentLenium");
    submit("#sb_form_go");
    assertThat(title()).contains("FluentLenium");
  }

  @Override
  public WebDriver getDefaultDriver() {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("os", "OS X");
    caps.setCapability("os_version", "El Capitan");
    caps.setCapability("browser", "firefox");
    caps.setCapability("browser_version", "44");
    caps.setCapability("build", "Sample FluentLenium Tests");
    caps.setCapability("browserstack.debug", "true");

    URL hubURL = null;
    try {
      hubURL = new URL(HUB_URL);
    } catch(Exception e) {
      System.out.println("Please provide proper crendentials. Error " + e);
    }

    return new RemoteWebDriver(hubURL, caps);
  }
}
