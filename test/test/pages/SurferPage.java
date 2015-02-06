package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fest.assertions.Assertions.assertThat;


/**
 * Behaves as Surfer page.  
 * @author Philip Johnson
 */
public class SurferPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public SurferPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia: Show");
  }
  

 /**
  * Edits surfer.
  */
 public void editSurfer() {
   find("#edit").click();
   assertThat(getUrl().contains("edit"));
   fill("#home").with("edit here");
   submit("#surfersubmit");
 }
 
/**
 * Deletes surfer.
 */
 public void deleteSurfer() {
   find("#deletesurfer").click();
   find("#modaldelete").click();
 }
  
}
