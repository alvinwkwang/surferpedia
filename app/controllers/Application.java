package controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.avaje.ebean.Page;
import models.Surfer;
import models.SurferDB;
import models.UpdatesDB;
import models.Updates;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.Countries;
import views.formdata.FootstyleTypes;
import views.formdata.LoginFormData;
import views.formdata.SearchFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.Index;
import views.html.Login;
import views.html.ManageSurfer;
import views.html.ShowSurfer;
import views.html.ShowUpdates;
import views.html.SearchResults;
import views.html.SurfMap;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * 
   * @return The resulting home page.
   */
  public static Result index() {
    SearchFormData searchData = new SearchFormData();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(searchData);
    return ok(Index.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), searchFormData,
        SurferTypes.getTypes(), Countries.getCountries()));
  }

  /**
   * Create a new surfer page.
   * 
   * @return The New Surfer page.
   */
  @Security.Authenticated(Secured.class)
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
    List<String> footstyles = FootstyleTypes.getFootstyle();
    SearchFormData searchData = new SearchFormData();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(searchData);
    return ok(ManageSurfer.render("New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
        formData, surferTypeMap, false, footstyles, searchFormData, SurferTypes.getTypes(), Countries.getCountries()));
  }

  /**
   * Manage surfer's page.
   * 
   * @param slug Slug of surfer.
   * @return The surfer page.
   */
  @Security.Authenticated(Secured.class)
  public static Result manageSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypeMap = SurferTypes.getTypes(data.type);
    List<String> footstyles = FootstyleTypes.getFootstyle();
    SearchFormData searchData = new SearchFormData();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(searchData);
    return ok(ManageSurfer.render("New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
        formData, surferTypeMap, true, footstyles, searchFormData, SurferTypes.getTypes(), Countries.getCountries()));
  }

  /**
   * Displays the surfer's page.
   * 
   * @param slug The slug.
   * @return The surfer's page.
   */
  public static Result getSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    SearchFormData searchData = new SearchFormData();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(searchData);
    return ok(ShowSurfer.render("Show", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, searchFormData,
        SurferTypes.getTypes(), Countries.getCountries()));
  }
  
  /**
   * Displays a random surfer's page.
   * 
   * @return The random surfer's page.
   */
  public static Result getRandomSurfer() {
    SurferFormData data = new SurferFormData(SurferDB.randomSurfer());
    return redirect(routes.Application.getSurfer(data.slug));
  }

  /**
   * Processes the form submitted form the Manage Surfer page.
   * 
   * @return The ManageSurfer Page.
   */
  @Security.Authenticated(Secured.class)
  public static Result postSurfer() {
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    List<String> footstyles = FootstyleTypes.getFootstyle();
    SearchFormData searchData = new SearchFormData();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(searchData);
    
    if (formData.hasErrors()) {
      Map<String, Boolean> surferTypeMap = SurferTypes.getTypes();
      return badRequest(ManageSurfer.render("New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
          formData, surferTypeMap, false, footstyles, searchFormData, SurferTypes.getTypes(),
          Countries.getCountries()));
    }
    else {
      SurferFormData data = formData.get();
      Date date = new Date();
      Updates update = new Updates();
      if (SurferDB.isRepeatSlug(data.slug)) {
        update = new Updates(date.toString(), "Edit", data.name);
      }
      else {
        update = new Updates(date.toString(), "Create", data.name);
      }
      UpdatesDB.addUpdate(update);
      SurferDB.addSurfer(data);
      return ok(ShowSurfer.render("Show", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, 
          searchFormData, SurferTypes.getTypes(), Countries.getCountries()));
    }
  }

  /**
   * Removes surfer from repository.
   * 
   * @param slug The slug.
   * @return The Index page.
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteSurfer(String slug) {
    SearchFormData searchData = new SearchFormData();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(searchData);
    Surfer surfer = SurferDB.getSurfer(slug);
    Date date = new Date();
    Updates update = new Updates(date.toString(), "Delete", surfer.getName());
    UpdatesDB.addUpdate(update);
    SurferDB.deleteSurfer(slug);
    return ok(Index.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), searchFormData, 
        SurferTypes.getTypes(), Countries.getCountries()));
  }
  
  /**
   * Displays the updates page.
   * @return the update page.
   */
  @Security.Authenticated(Secured.class)
  public static Result showUpdates() {
    SearchFormData searchData = new SearchFormData();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(searchData);
    return ok(ShowUpdates.render("Updates", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        UpdatesDB.getUpdates(), searchFormData, SurferTypes.getTypes(), Countries.getCountries()));
  }

  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    SearchFormData searchData = new SearchFormData();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(searchData);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, 
        searchFormData, SurferTypes.getTypes(), Countries.getCountries()));
  }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postLogin() {
    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();
    SearchFormData searchData = new SearchFormData();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(searchData);
    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData,
          searchFormData, SurferTypes.getTypes(), Countries.getCountries()));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
  
  /**
   * Displays the search results page.
   * @param page page.
   * @return the results page.
   */
  public static Result showResults(int page) {
    Form<SearchFormData> formData = Form.form(SearchFormData.class).bindFromRequest();
    SearchFormData data = formData.get();
    Page<Surfer> results = SurferDB.searchDB(data.key, data.searchType, data.country, page);
    return ok(SearchResults.render("Results", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        SurferTypes.getTypes(), Countries.getCountries(), results, formData, data.key, data.searchType, data.country));
  }
  
  /**
   * Display a page of search results.
   * @param key key
   * @param surferType surfer type
   * @param country country
   * @param page page
   * @return the results page.
   */
  public static Result pageResults(String key, String surferType, String country, int page) {
    Form<SearchFormData> formData = Form.form(SearchFormData.class).bindFromRequest();
    SearchFormData data = formData.get();
    Page<Surfer> results = SurferDB.searchDB(data.key, data.searchType, data.country, page - 1);
    return ok(SearchResults.render("Results", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        SurferTypes.getTypes(), Countries.getCountries(), results, formData, key, surferType, country));
  }
  
  /**
   * Returns the Map page.
   * 
   * @return The resulting map page.
   */
  public static Result showMap() {
    SearchFormData searchData = new SearchFormData();
    Form<SearchFormData> searchFormData = Form.form(SearchFormData.class).fill(searchData);
    return ok(SurfMap.render("Map", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), searchFormData,
        SurferTypes.getTypes(), Countries.getCountries()));
  }
}
