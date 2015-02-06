package views.formdata;

/**
* Backing class for Search data.
* @author Alvin Wang
*
*/
public class SearchFormData {

  /** Search Name. */
  public String key = "";
  /** Search Type. */
  public String searchType = "";
  /** Search Country. */
  public String country = "";
  
  /** Blank constructor. */
  public SearchFormData() {
  }
  
  /**
* Constructor for SearchFormData.
* @param key keyword
* @param searchType surfer type.
* @param country country.
*/
  public SearchFormData(String key, String searchType, String country) {
    this.key = key;
    this.searchType = searchType;
    this.country = country;
  }
}