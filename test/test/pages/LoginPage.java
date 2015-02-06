package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import play.Play;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).

import static org.fest.assertions.Assertions.assertThat;

/**
 * Behaves as Login page.  
 * @author Philip Johnson
 */
public class LoginPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public LoginPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia: Login");
  }
    
  /**
   * Set the form to the passed values, then submit it.
   */
  public void login() {
    String adminEmail = Play.application().configuration().getString("surferpedia.admin.email");
    String adminPassword = Play.application().configuration().getString("surferpedia.admin.password");

    // Fill the input field with id "email" with the passed name string.
    fill("#email").with(adminEmail);
    // Fill the input field with id "password" with the passed pass string.
    fill("#password").with(adminPassword);
    
    // Submit the form whose id is "submit"
    submit("#loginsubmit");
  } 
  
  /**
   * Invalid login. Form is not filled.
   */
  public void invalidLogin() {
    // Submit the form whose id is "submit"
    submit("#loginsubmit");
  }
}
