package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated,
// the no-arg versions of the methods used here are not deprecated. (as of May, 2013).
import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
* Behaves as New Surfer page.
* @author Philip Johnson
*/
public class NewSurferPage extends FluentPage {
  private String url;
  
  /**
* Create the IndexPage.
* @param webDriver The driver.
* @param port The port.
*/
  public NewSurferPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia: New");
  }
  
  /**
* Create surfer.
* @param name surfer name
* @param home surfer home
* @param country surfer country
* @param awards surfer awards
* @param footstyle surfer footstyle
* @param carouselURL surfer carousel url
* @param bioURL surfer bio url
* @param bio surfer bio
* @param slug surfer slug
* @param type surfer type
*/
  public void makeSurfer(String name, String home, String country, String awards, String footstyle, String carouselURL,
      String bioURL, String bio, String slug, String type) {
    fill("#name").with(name);
    fill("#home").with(home);
    fill("#country").with(country);
    fill("#awards").with(awards);
    find("input", withId(footstyle)).click();
    fill("#carouselURL").with(carouselURL);
    fill("#bioURL").with(bioURL);
    fill("#bio").with(bio);
    fill("#slug").with(slug);
    find("select", withId("type")).find("option", withId(type)).click();
    submit("#surfersubmit");
  }
}