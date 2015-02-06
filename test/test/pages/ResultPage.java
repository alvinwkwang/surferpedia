package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).

import static org.fest.assertions.Assertions.assertThat;

/**
 * Behaves as Search Results page.  
 * @author Philip Johnson
 */
public class ResultPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public ResultPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia: Results");
  }
  
  /**
   * click link to surfer's profile.
   */
  public void goToProfile() {
    find("#searchsurfer").click();
  }
  
}
