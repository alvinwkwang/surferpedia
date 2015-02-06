package views.formdata;

import java.util.Arrays;
import java.util.List;

/**
 * Represents surfer's footstyle.
 * @author Alvin Wang
 *
 */
public class FootstyleTypes {
  
  /** The surfer's footstyle. */
  public String footstyle = "";
  
  /**
   * Provide a list of footstyles for use in form display.
   * @return A list of footsyles.
   */
  public static List<String> getFootstyle() {
    String[] footstyle = {"Regular", "Goofy"};
    return Arrays.asList(footstyle);
  }
}
