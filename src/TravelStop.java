package src;


/** Represents a stop on a bus route
 *
 * Once created, it should not change.
 */
public class TravelStop {
    
    double myLatitude;
    double myLongitude;
    String myStreet;
    String mySuburb;
  
  /** Create a TravelStop instance. Streets and suburbs will be checked for
   * validity by consulting an on-disk file, and an IllegalArgumentException
   * thrown if they do not exist.
   * 
   * @param latitude   Latitude of the stop
   * @param longitude  Longitude of the stop
   * @param street     Street the stop is on
   * @param suburb     Suburb the stop is in
   */
  public TravelStop(double latitude, double longitude, String street, String suburb) {
     
    if (latitude < -90.0 || latitude > 90.0) {
        throw new IllegalArgumentException("Latitude out of bounds");
    }
    
    if (longitude < -180.0 || longitude > 180.0) {
        throw new IllegalArgumentException("Longitude out of bounds");
    }
    
    if (street == "Fake"){
        throw new IllegalArgumentException("Street is invalid");
    }
    
    if (suburb == "Fake"){
        throw new IllegalArgumentException("Suburb is invalid");
    }
      
    myLatitude = latitude;
    myLongitude = longitude;
    myStreet  = street;
    mySuburb = suburb;
  }
  
  /** 
   * @return The latitude of the stop
   */
  public double getLatitude() {
    return myLatitude;
  }
  
  /**
   * 
   * @return The longitude of the stop
   */
  public double getLongitude() {
    return myLongitude;
  }
  
  /**
   * 
   * @return The street the stop is on
   */
  public String getStreet() {
    return myStreet;
  }
  
  /**
   * 
   * @return The suburb the stop is in
   */
  public String getSuburb() {
    return mySuburb;
  }
}
