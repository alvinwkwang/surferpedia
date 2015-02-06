package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import play.db.ebean.Model;

/**
 * A model for a Surfer.
 * @author Alvin Wang
 *
 */
@Entity
public class Surfer extends Model {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  /** The surfer's name. */
  private String name;
  /** The surfer's home-town. */
  private String home;
  /** The surfer's country of origin. */
  private String country;
  /** The surfer's awards. */
  private String awards;
  /** Image URL for carousel. */
  private String carouselURL;
  /** Image URL for biography. */
  private String bioURL;
  /** The surfer's biography. */
  @Column(columnDefinition = "TEXT")
  private String bio;
  /** The surfer's slug field. */
  private String slug;
  /** The surfer's type. */
  private String type;
  /** The surfer's footstyle. */
  private String footstyle;
  
  /** One Surfer to many Updates. **/
  @OneToMany(mappedBy = "surfer")
  private List<Updates> updates = new ArrayList<>();
  
  /**
   * The EBean ORM finder method for database queries.
   * 
   * @return The finder method for Surfers.
   */
  public static Finder<Long, Surfer> find() {
    return new Finder<Long, Surfer>(Long.class, Surfer.class);
  }
  
  /**
   * Return a list of updates.
   * @return list of updates.
   */
  public List<Updates> getUpdates() {
    return this.updates;
  }

  /**
   * Add an update to a surfer.
   * @param update update.
   */
  public void addUpdate(Updates update) {
    this.updates.add(update);
  }
  
  /**
   * Constructs a new Surfer.
   * @param name The surfer's name.
   * @param home The surfer's home-town.
   * @param country The surfer's country of origin.
   * @param awards The surfer's awards.
   * @param carouselURL Image URL for carousel.
   * @param bioURL Image URL for biography.
   * @param bio The surfer's biography.
   * @param slug The surfer's slug field.
   * @param type The surfer's type.
   * @param footstyle THe surfer's footstyle.
   */
  public Surfer(String name, String home, String country, String awards, String carouselURL, String bioURL, 
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
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return the home
   */
  public String getHome() {
    return home;
  }
  /**
   * @param home the home to set
   */
  public void setHome(String home) {
    this.home = home;
  }
  /**
   * @return the awards
   */
  public String getAwards() {
    return awards;
  }
  /**
   * @param awards the awards to set
   */
  public void setAwards(String awards) {
    this.awards = awards;
  }
  /**
   * @return the carouselURL
   */
  public String getCarouselURL() {
    return carouselURL;
  }
  /**
   * @param carouselURL the carouselURL to set
   */
  public void setCarouselURL(String carouselURL) {
    this.carouselURL = carouselURL;
  }
  /**
   * @return the bioURL
   */
  public String getBioURL() {
    return bioURL;
  }
  /**
   * @param bioURL the bioURL to set
   */
  public void setBioURL(String bioURL) {
    this.bioURL = bioURL;
  }
  /**
   * @return the bio
   */
  public String getBio() {
    return bio;
  }
  /**
   * @param bio the bio to set
   */
  public void setBio(String bio) {
    this.bio = bio;
  }
  /**
   * @return the slug
   */
  public String getSlug() {
    return slug;
  }
  /**
   * @param slug the slug to set
   */
  public void setSlug(String slug) {
    this.slug = slug;
  }
  /**
   * @return the type
   */
  public String getType() {
    return type;
  }
  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the footstyle
   */
  public String getFootstyle() {
    return footstyle;
  }

  /**
   * @param footstyle the footstyle to set
   */
  public void setFootstyle(String footstyle) {
    this.footstyle = footstyle;
  }

  /**
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }

}
