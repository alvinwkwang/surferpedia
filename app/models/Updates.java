package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

/**
 * A model for updates.
 * @author Alvin Wang
 *
 */
@Entity
public class Updates extends Model {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  private String date;
  private String action;
  private String name;
  
  /** Many Updates to One UserInfo. **/
  @ManyToOne
  private UserInfo userInfo;
  
  /** Many updates to One Surfer. **/
  @ManyToOne
  private Surfer surfer;
  
  /**
   * Default constructor.
   */
  public Updates() {
    
  }
  
  /**
   * The EBean ORM finder method for database queries.
   * 
   * @return The finder method for Updates.
   */
  public static Finder<Long, Updates> find() {
    return new Finder<Long, Updates>(Long.class, Updates.class);
  }
  
  /**
   * Constructor for updates.
   * @param date The date.
   * @param action The action done.
   * @param name The surfers name.
   */
  public Updates(String date, String action, String name) {
    this.date = date;
    this.action = action;
    this.name = name;
  }
  /**
   * @return the date
   */
  public String getDate() {
    return date;
  }
  /**
   * @param date the date to set
   */
  public void setDate(String date) {
    this.date = date;
  }
  /**
   * @return the action
   */
  public String getAction() {
    return action;
  }
  /**
   * @param action the action to set
   */
  public void setAction(String action) {
    this.action = action;
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
