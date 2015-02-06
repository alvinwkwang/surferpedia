package views.formdata;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents legal Countries. List of countries based from http://www.projectvisa.com/fullcountrylist.asp and
 * http://www.state.gov/misc/list/
 * 
 * @author Alvin Wang
 * 
 */
public class Countries {

  private static String[] countries = {"United States", "Afghanistan", "Albania", "Algeria", "American Samoa",
    "Andorra", "Anguilla", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria",
    "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda",
    "Bhutan", "Bolivia", "Bosnia-Herzegovina", "Botswanna", "Bouvet Island", "Brazil", "Brunei", "Bulgaria",
    "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
    "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocoas (Keeling) Islands", "Colombia",
    "Comoros", "Congo (Democratic Republic)", "Congo (Republic)", "Cook Islands", "Costa Rica", "Cote d'lvoire",
    "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
    "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands",
    "Faroe Islands", "Fiji", "Finland", "France", "French Guinea", "French Polynesia", "Gabon", "Gambia", "Georgia",
    "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea",
    "Guinea-Bissau", "Guyana", "Haiti", "Holy See", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
    "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya",
    "Kiribati", "Korea (North)", "Korea (South)", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho",
    "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi",
    "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte",
    "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco", "Mozambique",
    "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand",
    "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman",
    "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn Islands",
    "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russia", "Rwanda", "Saint Helena",
    "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon", "Saint Vincent and Grenadines", "Samoa",
    "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone",
    "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia", "Spain",
    "Sri Lanka", "Sudan", "Suriname", "Svalbard", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan",
    "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago",
    "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine",
    "United Arab Emirates", "United Kingdom", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam",
    "Virgin Islands", "Wallis and Futuna", "Yemen", "Zambia", "Zimbabwe"};

  /**
   * Returns a newly initialized Map of countries.
   * 
   * @return The surfer type map.
   */
  public static Map<String, Boolean> getCountries() {
    Map<String, Boolean> countryMap = new LinkedHashMap<>();
    for (String country : countries) {
      countryMap.put(country, false);
    }
    return countryMap;
  }

  /**
   * Returns a Map of countries with the passed country set to true. Assumes country is a legal country.
   * 
   * @param country a country
   * @return The country map.
   */
  public static Map<String, Boolean> getCountries(String country) {
    Map<String, Boolean> countryMap = Countries.getCountries();
    if (isCountry(country)) {
      countryMap.put(country, true);
    }
    return countryMap;
  }

  /**
   * Returns true if country is a valid country.
   * 
   * @param country potential country
   * @return true if valid country, false otherwise.
   */
  public static boolean isCountry(String country) {
    return Countries.getCountries().keySet().contains(country);
  }
}
