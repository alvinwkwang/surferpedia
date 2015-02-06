package views.formdata;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents legal surfer types.
 * @author Alvin Wang
 *
 */
public class SurferTypes {

  private static String[] types = {"Male", "Female", "Grom"};
  
  /**
   * Returns a newly initialized Map of surfer types.
   * @return The surfer type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new LinkedHashMap<>();
    for (String type : types) {
      typeMap.put(type,  false);
    }
    return typeMap;
  }
  
  /**
   * Returns a Map of surfer types with the passed surferType set to true.
   * Assumes surferType is a legal type.
   * @param type The telephone type.
   * @return The surfer type map.
   */
  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> typeMap = SurferTypes.getTypes();
    if (isType(type)) {
      typeMap.put(type, true);
    }
    return typeMap;
  }
  
  /**
   * Returns true if surferType is a valid surfer type.
   * @param type potential surfer type.
   * @return true if valid surfer type, false otherwise.
   */
  public static boolean isType(String type) {
    return SurferTypes.getTypes().keySet().contains(type);
  }
}
