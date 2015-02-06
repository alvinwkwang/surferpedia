package test;

import org.junit.Test;
import play.test.TestBrowser;
import play.libs.F.Callback;
import test.pages.IndexPage;
import test.pages.LoginPage;
import test.pages.MapPage;
import test.pages.NewSurferPage;
import test.pages.ResultPage;
import test.pages.SurferPage;
import test.pages.UpdatesPage;
import static play.test.Helpers.FIREFOX;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.testServer;
import static play.test.Helpers.running;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Integration tests running on an instance of the application.
 */
public class IntegrationTest {
  /** The port number for the integration test. */
  private static final int PORT = 3333;

  /**
   * Check to see that the main page can be displayed.
   */
  @Test
  public void testBasicRetrieval() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:" + PORT);
        assertThat(browser.pageSource()).contains("Surferpedia");
      }
    });
  }
  
  /**
   * Check to see that the admin can successfully login and logout.
   */
  @Test
  public void testLogin() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        assertThat(indexPage.isLoggedIn()).isTrue();
        indexPage.logout();
        assertThat(indexPage.isLoggedIn()).isFalse();
      }
    });
  }
  
  /**
   * Check for invalid login credentials.
   */
  @Test
  public void testInvalidLogin() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.invalidLogin();
        assertThat(browser.pageSource()).contains("Login credentials not valid.");
        //login link should still be visible and should still be at login page.
        assertThat(indexPage.isLoggedIn()).isFalse();
        loginPage.isAt();
      }
    });
  }
  
  /**
   * Check to see that the search results page is accessible.
   */
  @Test
  public void testSearch() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.search();
        ResultPage resultPage = new ResultPage(browser.getDriver(), PORT);
        resultPage.isAt();
      }
    });
  }
  
  /**
   * Tests search results with only keyword entered as criteria.
   * Will test 3 different keywords.
   */
  @Test
  public void testSearchKeyOnly() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchKey("CJ");
        ResultPage resultPageOne = new ResultPage(browser.getDriver(), PORT);
        resultPageOne.isAt();
        assertThat(browser.pageSource()).contains("CJ Hobgood");
        assertThat(browser.pageSource()).doesNotContain("John Florence");
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchKey("jo");
        ResultPage resultPageTwo = new ResultPage(browser.getDriver(), PORT);
        resultPageTwo.isAt();
        assertThat(browser.pageSource()).contains("Joel Parkinson");
        assertThat(browser.pageSource()).contains("Johanne Defay");
        assertThat(browser.pageSource()).contains("John Florence");
        assertThat(browser.pageSource()).doesNotContain("CJ Hobgood");
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchKey("z");
        ResultPage resultPageThree = new ResultPage(browser.getDriver(), PORT);
        resultPageThree.isAt();
        assertThat(browser.pageSource()).contains("Adriano De Souza");
        assertThat(browser.pageSource()).contains("Daize Shayne");
        assertThat(browser.pageSource()).contains("Ezekiel Lau");
        assertThat(browser.pageSource()).contains("Kelia Moniz");
        assertThat(browser.pageSource()).doesNotContain("John Florence");
        assertThat(browser.pageSource()).doesNotContain("CJ Hobgood");
      }
    });
  }
  
  /**
   * Tests search results with Type entered as criteria.
   * Will test for all three types.
   */
  @Test
  public void testSearchTypeOnly() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchType("Female");
        ResultPage resultPageFemale = new ResultPage(browser.getDriver(), PORT);
        resultPageFemale.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | Female | All Countries |");
        assertThat(browser.pageSource()).contains("Bianca Buitendag");
        assertThat(browser.pageSource()).contains("Megan Abubo");
        assertThat(browser.pageSource()).contains("Paige Hareb");
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchType("Male");
        ResultPage resultPageMale = new ResultPage(browser.getDriver(), PORT);
        resultPageMale.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | Male | All Countries |");
        assertThat(browser.pageSource()).contains("Kelly Slater");
        assertThat(browser.pageSource()).contains("Rabbit Kekai");
        assertThat(browser.pageSource()).contains("Sunny Garcia");
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchType("Grom");
        ResultPage resultPageGrom = new ResultPage(browser.getDriver(), PORT);
        resultPageGrom.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | Grom | All Countries |");
        assertThat(browser.pageSource()).contains("Kyuss King");
        assertThat(browser.pageSource()).contains("Nomme Mignot");
        assertThat(browser.pageSource()).contains("Reika Noro");
      }
    });
  }
  
  /**
   * Tests search results with Country entered as criteria.
   * Will test 3 countries.
   */
  @Test
  public void testSearchCountryOnly() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchCountry("United States");
        ResultPage resultPageUS = new ResultPage(browser.getDriver(), PORT);
        resultPageUS.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | All Types | United States |");
        assertThat(browser.pageSource()).contains("CJ Hobgood");
        assertThat(browser.pageSource()).contains("Clarissa Moore");
        assertThat(browser.pageSource()).contains("Jake Marshall");
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchCountry("France");
        ResultPage resultPageFR = new ResultPage(browser.getDriver(), PORT);
        resultPageFR.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | All Types | France |");
        assertThat(browser.pageSource()).contains("Elliot Ivarra");
        assertThat(browser.pageSource()).contains("Jeremy Flores");
        assertThat(browser.pageSource()).contains("Johanne Defay");
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchCountry("Australia");
        ResultPage resultPageAUS = new ResultPage(browser.getDriver(), PORT);
        resultPageAUS.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | All Types | Australia |");
        assertThat(browser.pageSource()).contains("Joel Parkinson");
        assertThat(browser.pageSource()).contains("Serena Brooke");
        assertThat(browser.pageSource()).contains("Tyler Wright");
      }
    });
  }
  
  /**
   * Tests search results with Country and Type selected.
   * Will test 3 combinations.
   */
  @Test
  public void testSearchTypeAndCountry() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchTypeAndCountry("Male", "United States");
        ResultPage resultPageOne = new ResultPage(browser.getDriver(), PORT);
        resultPageOne.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | Male | United States |");
        assertThat(browser.pageSource()).contains("CJ Hobgood");
        assertThat(browser.pageSource()).contains("Eddie Aikau");
        assertThat(browser.pageSource()).contains("Ezekiel Lau");
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchTypeAndCountry("Female", "Australia");
        ResultPage resultPageTwo = new ResultPage(browser.getDriver(), PORT);
        resultPageTwo.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | Female | Australia |");
        assertThat(browser.pageSource()).contains("Nikki Van Dijk");
        assertThat(browser.pageSource()).contains("Serena Brooke");
        assertThat(browser.pageSource()).contains("Tyler Wright");
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchTypeAndCountry("Grom", "France");
        ResultPage resultPageThree = new ResultPage(browser.getDriver(), PORT);
        resultPageThree.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | Grom | France |");
        assertThat(browser.pageSource()).contains("Elliot Ivarra");
        assertThat(browser.pageSource()).contains("Johanne Defay");
        assertThat(browser.pageSource()).contains("Nomme Mignot");
      }
    });
  }
  
  /**
   * Tests search results with all 3 criteria filled.
   * Will test 3 combinations.
   */
  @Test
  public void testSearchAllCriteria() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchAll("cj", "Male", "United States");
        ResultPage resultPageOne = new ResultPage(browser.getDriver(), PORT);
        resultPageOne.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | 'cj' | Male | United States |");
        assertThat(browser.pageSource()).contains("CJ Hobgood");
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchAll("tyler", "Female", "Australia");
        ResultPage resultPageTwo = new ResultPage(browser.getDriver(), PORT);
        resultPageTwo.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | 'tyler' | Female | Australia |");
        assertThat(browser.pageSource()).contains("Tyler Wright");
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchAll("ka", "Grom", "United States");
        ResultPage resultPageThree = new ResultPage(browser.getDriver(), PORT);
        resultPageThree.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | 'ka' | Grom | United States |");
        assertThat(browser.pageSource()).contains("Kalani David");
        assertThat(browser.pageSource()).contains("Kaulana Apo");
      }
    });
  }
  
  /**
   * Tests search results links to surfer profile.
   * Will test 3 times.
   */
  @Test
  public void testSearchToProfile() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchAll("cj", "Male", "United States");
        ResultPage resultPageOne = new ResultPage(browser.getDriver(), PORT);
        resultPageOne.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | 'cj' | Male | United States |");
        assertThat(browser.pageSource()).contains("CJ Hobgood");
        resultPageOne.goToProfile();
        //System.out.println(browser.pageSource());
        SurferPage surferPageOne = new SurferPage(browser.getDriver(), PORT);
        surferPageOne.isAt();
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchAll("tyler", "Female", "Australia");
        ResultPage resultPageTwo = new ResultPage(browser.getDriver(), PORT);
        resultPageTwo.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | 'tyler' | Female | Australia |");
        assertThat(browser.pageSource()).contains("Tyler Wright");
        resultPageTwo.goToProfile();
        SurferPage surferPageTwo = new SurferPage(browser.getDriver(), PORT);
        surferPageTwo.isAt();
        
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.searchAll("kalani", "Grom", "United States");
        ResultPage resultPageThree = new ResultPage(browser.getDriver(), PORT);
        resultPageThree.isAt();
        assertThat(browser.pageSource()).contains("Search Results for  | 'kalani' | Grom | United States |");
        assertThat(browser.pageSource()).contains("Kalani David");
        resultPageThree.goToProfile();
        SurferPage surferPageThree = new SurferPage(browser.getDriver(), PORT);
        surferPageThree.isAt();
      }
    });
  }
  
  /**
   * Check to see the updates page is accessible.
   * Logs in, go to updates page, logout.
   */
  @Test
  public void testUpdates() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        //Login.
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        assertThat(indexPage.isLoggedIn()).isTrue();
        indexPage.isAt();
        
        //go to updates.
        indexPage.goToUpdates();
        UpdatesPage updatesPage = new UpdatesPage(browser.getDriver(), PORT);
        updatesPage.isAt();
      }
    });
  }
  
  /**
   * Checks the random surfer button.
   */
  @Test
  public void testRandom() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToRandom();
        SurferPage surferPage = new SurferPage(browser.getDriver(), PORT);
        surferPage.isAt();
      }
    });
  }
  
  /**
   * Checks to see if the Map page is accessible.
   */
  @Test
  public void testMap() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToMap();
        MapPage mapPage = new MapPage(browser.getDriver(), PORT);
        mapPage.isAt();
      }
    });
  }
  
  /**
   * Checks to see if you can make a new surfer.
   */
  @Test
  public void testNewSurfer() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        assertThat(indexPage.isLoggedIn()).isTrue();
        indexPage.isAt();
        indexPage.goToNewSurfer();
        NewSurferPage newSurferPage = new NewSurferPage(browser.getDriver(), PORT);
        newSurferPage.isAt();
        newSurferPage.makeSurfer("Test 1", "Home", "USA", "test awards", "Regular", 
            "https://drupal.org/files/test-all-the-things.jpg", "https://drupal.org/files/test-all-the-things.jpg",
            "Test bio", "testslug", "Female");
        SurferPage surferPage = new SurferPage(browser.getDriver(), PORT);
        surferPage.isAt();
        assertThat(browser.pageSource()).contains("Test 1");
      }
    });
  }
  
  /**
   * Checks to see if you can edit a surfer.
   */
  @Test
  public void testEditSurfer() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        assertThat(indexPage.isLoggedIn()).isTrue();
        indexPage.isAt();
        indexPage.goToNewSurfer();
        NewSurferPage newSurferPage = new NewSurferPage(browser.getDriver(), PORT);
        newSurferPage.isAt();
        newSurferPage.makeSurfer("Test 1", "Home", "USA", "test awards", "Regular", 
            "https://drupal.org/files/test-all-the-things.jpg", "https://drupal.org/files/test-all-the-things.jpg",
            "Test bio", "testslug", "Female");
        SurferPage surferPage = new SurferPage(browser.getDriver(), PORT);
        surferPage.isAt();
        surferPage.editSurfer();
        assertThat(browser.pageSource()).contains("edit here");
      }
    });
  }
  
  /**
   * Checks to see if you can delete a surfer.
   */
  @Test
  public void testDeleteSurfer() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), FIREFOX, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.login();
        assertThat(indexPage.isLoggedIn()).isTrue();
        indexPage.isAt();
        indexPage.goToNewSurfer();
        NewSurferPage newSurferPage = new NewSurferPage(browser.getDriver(), PORT);
        newSurferPage.isAt();
        newSurferPage.makeSurfer("Test 1", "Home", "USA", "test awards", "Regular", 
            "https://drupal.org/files/test-all-the-things.jpg", "https://drupal.org/files/test-all-the-things.jpg",
            "Test bio", "testslug", "Female");
        SurferPage surferPage = new SurferPage(browser.getDriver(), PORT);
        surferPage.isAt();
        surferPage.deleteSurfer();
        indexPage.isAt();
        browser.goTo("http://localhost:3333/surfer/testslug/");
        assertThat(browser.pageSource()).contains("Action not found");
      }
    });
  }
}
