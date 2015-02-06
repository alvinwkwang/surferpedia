package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated,
// the no-arg versions of the methods used here are not deprecated. (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fest.assertions.Assertions.assertThat;

/**
* Behaves as index page.
* @author Philip Johnson
*/
public class IndexPage extends FluentPage {
  private String url;
  
  /**
* Create the IndexPage.
* @param webDriver The driver.
* @param port The port.
*/
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia: Home");
  }
  
  /**
* click login link.
*/
  public void goToLogin() {
    //find("#navbutton").click();
    find("#login").click();
  }
  
  /**
* click logout link.
*/
  public void logout() {
    //find("#navbutton").click();
    find("#logout").click();
  }
  
  /**
* click on search button. no criteria.
*/
  public void search() {
    //find("#navbutton").click();
    find("#searchdropdown").click();
    find("#search").click();
  }
  
  /**
* click on random button.
*/
  public void goToRandom() {
    //find("#navbutton").click();
    find("#searchdropdown").click();
    find("#random").click();
  }
  /**
* click updates link.
*/
  public void goToUpdates() {
    //find("#navbutton").click();
    find("#updates").click();
  }
  
  /**
* click updates link.
*/
  public void goToNewSurfer() {
    //find("#navbutton").click();
    find("#newsurfer").click();
  }
  
  /**
* click map link.
*/
  public void goToMap() {
    //find("#navbutton").click();
    find("#map").click();
  }
  
  /**
* check if admin is logged in.
* @return true if logged in, false otherwise.
*/
  public boolean isLoggedIn() {
    return !find("#logout").isEmpty();
  }
  
  /**
* Performs search with only key filled in.
* @param key key to be searched.
*/
  public void searchKey(String key) {
    //find("#navbutton").click();
    find("#searchdropdown").click();
    fill("#key").with(key);
    find("#search").click();
  }
  
  /**
* Performs search with only Type selected.
* @param type type to be selected.
*/
  public void searchType(String type) {
    //find("#navbutton").click();
    find("#searchdropdown").click();
    find("select", withId("searchType")).find("option", withId(type)).click();
    find("#search").click();
  }
  
  /**
* Performs search with only country selected.
* @param country country to be selected.
*/
  public void searchCountry(String country) {
    //find("#navbutton").click();
    find("#searchdropdown").click();
    find("select", withId("country")).find("option", withId(country)).click();
    find("#search").click();
  }
  
  /**
* Performs search with type and country.
* @param type type to be selected.
* @param country country to be selected.
*/
  public void searchTypeAndCountry(String type, String country) {
    //find("#navbutton").click();
    find("#searchdropdown").click();
    find("select", withId("searchType")).find("option", withId(type)).click();
    find("select", withId("country")).find("option", withId(country)).click();
    find("#search").click();
  }
  
  /**
* Performs search with all three criteria(keyword, type, and country).
* @param key keyword to be searched.
* @param type type to be selected.
* @param country country to be selected.
*/
  public void searchAll(String key, String type, String country) {
    //find("#navbutton").click();
    find("#searchdropdown").click();
    fill("#key").with(key);
    find("select", withId("searchType")).find("option", withId(type)).click();
    find("select", withId("country")).find("option", withId(country)).click();
    find("#search").click();
  }
  //find("select", withId("gpa")).find("option", withId(gpa)).click();
}