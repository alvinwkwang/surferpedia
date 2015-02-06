package models;

import java.util.Collections;
import java.util.List;
import com.avaje.ebean.Page;
import views.formdata.SurferFormData;

/**
 * A simple in-memory repository for Surfers.
 * 
 * @author Alvin Wang
 * 
 */
public class SurferDB {

  private static final int CAROUSEL_SIZE = 3;
  private static final int SEARCH_SIZE = 15;


  /**
   * Add a surfer to the surfers list.
   * 
   * @param formData Surfer data.
   */
  public static void addSurfer(SurferFormData formData) {
    if (!isRepeatSlug(formData.slug)) {
      Surfer surfer =
          new Surfer(formData.name, formData.home, formData.country, formData.awards, formData.carouselURL,
              formData.bioURL, formData.bio, formData.slug, formData.type, formData.footstyle);
      surfer.save();  
    }
    else {
      Surfer surfer = getSurfer(formData.slug);
      surfer.setName(formData.name);
      surfer.setHome(formData.home);
      surfer.setCountry(formData.country);
      surfer.setAwards(formData.awards);
      surfer.setCarouselURL(formData.carouselURL);
      surfer.setBioURL(formData.bioURL);
      surfer.setBio(formData.bio);
      surfer.setType(formData.type);
      surfer.setFootstyle(formData.footstyle);
      surfer.save();
    }
  }

  /**
   * Returns a list of surfers.
   * 
   * @return list of surfers.
   */
  public static List<Surfer> getSurfers() {
    return Surfer.find().findList();
  }

  /**
   * Returns a surfer associated with the passed slug.
   * 
   * @param slug The slug.
   * @return THe retrieved slug.
   */
  public static Surfer getSurfer(String slug) {
    return Surfer.find().where().eq("slug", slug).findUnique();
  }

  /**
   * Deletes a surfer with the passed in slug.
   * 
   * @param slug The slug.
   */
  public static void deleteSurfer(String slug) {
    Surfer.find().where().eq("slug", slug).findUnique().delete();
  }

  /**
   * Checks if string is only letters and digits.
   * 
   * @param s The slug.
   * @return true if contains only letters and digits, otherwise false.
   */
  public static boolean isAlphaNumeric(String s) {
    String pattern = "^[a-zA-Z0-9]*$";
    return s.matches(pattern);
  }

  /**
   * Checks if slug already exist.
   * 
   * @param slug The slug.
   * @return true if it already exists, otherwise false.
   */
  public static boolean isRepeatSlug(String slug) {
    return Surfer.find().where().eq("slug", slug).findUnique() != null;
  }

  /**
   * Shuffle list of surfers.
   * 
   * @return list of 3 shuffled surfers.
   */
  public static List<Surfer> randomSurfers() {
    List<Surfer> current = getSurfers();
    Collections.shuffle(current);
    return current.subList(0, CAROUSEL_SIZE);
  }
  
  /**
   * Shuffle list of surfers, return the first surfer.
   * 
   * @return random surfer from DB
   */
  public static Surfer randomSurfer() {
    List<Surfer> current = getSurfers();
    Collections.shuffle(current);
    return current.get(0);
  }
  /**
   * Searches the database of surfers for surfers matching some criteria.
   * 4 cases: type and country not selected.
   *          type not selected.
   *          country not selected.
   *          type and country selected.
   * @param key key
   * @param type type
   * @param country country
   * @param page page.
   * @return page of surfers matching criteria.
   */
  public static Page<Surfer> searchDB(String key, String type, String country, int page) {
    if (type.equals("") && country.equals("")) {
      return Surfer.find().where().icontains("name", key).order("name").findPagingList(SEARCH_SIZE).
          setFetchAhead(false).getPage(page);
    }
    else if (type.equals("")) {
      return Surfer.find().where().icontains("name", key).ieq("country", country).order("name").
          findPagingList(SEARCH_SIZE).setFetchAhead(false).getPage(page);
    }
    else if (country.equals("")) {
      return Surfer.find().where().icontains("name", key).ieq("type", type).order("name").
          findPagingList(SEARCH_SIZE).setFetchAhead(false).getPage(page);
    }
    else {
      return Surfer.find().where().icontains("name", key).ieq("type", type).ieq("country", country).order("name").
          findPagingList(SEARCH_SIZE).setFetchAhead(false).getPage(page);
    }
  }

}
