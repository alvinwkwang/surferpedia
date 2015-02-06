package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Surfer;
import models.SurferDB;

/**
 * Java backing class for Surfer's form data.
 * 
 * @author Alvin Wang
 * 
 */
public class SurferFormData {
  /** The surfer's name. */
  public String name = "";
  /** The surfer's home-town. */
  public String home = "";
  /** The surfer's country of origin. */
  public String country = "";
  /** The surfer's awards. */
  public String awards = "";
  /** Image URL for carousel. */
  public String carouselURL = "";
  /** Image URL for biography. */
  public String bioURL = "";
  /** The surfer's biography. */
  public String bio = "";
  /** The surfer's slug field. */
  public String slug = "";
  /** The surfer's type. */
  public String type = "";
  /** The surfer's footystyle. */
  public String footstyle = "";
  /** If surfer page is editing. */
  public boolean isEditing = false;

  /**
   * Empty arg constructor.
   */
  public SurferFormData() {

  }

  /**
   * Constructor that creates a SurferFormData of an existing surfer.
   * 
   * @param surfer An existing surfer.
   */
  public SurferFormData(Surfer surfer) {
    this.name = surfer.getName();
    this.home = surfer.getHome();
    this.country = surfer.getCountry();
    this.awards = surfer.getAwards();
    this.carouselURL = surfer.getCarouselURL();
    this.bioURL = surfer.getBioURL();
    this.bio = surfer.getBio();
    this.slug = surfer.getSlug();
    this.type = surfer.getType();
    this.footstyle = surfer.getFootstyle();
    this.isEditing = true;
  }

  /**
   * Create a new SurferFormData object manually.
   * 
   * @param name The surfer's name.
   * @param home THe surfer's home town.
   * @param country The surfer's country of origin.
   * @param awards The surfer's awards.
   * @param carouselURL The surfer's carousel URL.
   * @param bioURL THe surfer's bio URL.
   * @param bio THe surfer's bio.
   * @param slug The surfer's slug.
   * @param type The surfer's type.
   * @param footstyle THe surfer's footstyle.
   */
  public SurferFormData(String name, String home, String country, String awards, String carouselURL, String bioURL, 
      String bio, String slug, String type, String footstyle) {
    this.name = name;
    this.home = home;
    this.country = country;
    this.awards = awards;
    this.carouselURL = carouselURL;
    this.bioURL = bioURL;
    this.bio = bio;
    this.slug = slug;
    this.type = type;
    this.footstyle = footstyle;
  }

  /**
   * Checks all form fields are valid.
   * 
   * @return null if valid, a list of ValidationErrors if invalid.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is required."));
    }

    if (home == null || home.length() == 0) {
      errors.add(new ValidationError("home", "Home is required."));
    }
    
    if (country == null || country.length() == 0) {
      errors.add(new ValidationError("country", "Country is required."));
    }

    if (carouselURL == null || carouselURL.length() == 0) {
      errors.add(new ValidationError("carouselURL", "Carousel URL is required."));
    }

    if (bioURL == null || bioURL.length() == 0) {
      errors.add(new ValidationError("bioURL", "Bio URL is required."));
    }

    if (bio == null || bio.length() == 0) {
      errors.add(new ValidationError("bio", "Bio is required."));
    }

    if (slug == null || slug.length() == 0) {
      errors.add(new ValidationError("slug", "Slug is required."));
    }

    if (SurferDB.isRepeatSlug(slug) && !isEditing) {
      errors.add(new ValidationError("slug", "Slug '" + slug + "' already exists."));
    }
    
    if (!SurferDB.isAlphaNumeric(slug)) {
      errors.add(new ValidationError("slug", "Slug must be only letters and digits."));
    }
    
    if (!SurferTypes.isType(type)) {
      errors.add(new ValidationError("type", "Type is required."));
    }
    
    if (footstyle == null || footstyle.length() == 0) {
      errors.add(new ValidationError("footstyle", "Footstyle is required."));
    }

    return errors.isEmpty() ? null : errors;
  }

}
