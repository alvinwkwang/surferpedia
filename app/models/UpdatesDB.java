package models;

import java.util.Collections;
import java.util.List;


/**
 * A repository that stores update information.
 * @author Alvin Wang
 *
 */
public class UpdatesDB {
  
  
  /**
   * Add an update log.
   * @param surferUpdate Update information.
   */
  public static void addUpdate(Updates surferUpdate) {
    Updates update = surferUpdate;
    update.save();
  }
  
  /**
   * Retrieves a List of updates.
   * @return list of updates.
   */
  public static List<Updates> getUpdates() {
    List<Updates> updates = Updates.find().findList();
    Collections.reverse(updates);
    return updates;
  }
}
