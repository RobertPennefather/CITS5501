package src;

import java.util.List;

/** Given a starting location (specified by latitude and longitude), and a
 * destination location (specified in the same way), calculate a list
 * of directions a user can follow for a bus journey from the starting
 * location to the destination.
 * 
 */
public class RoutePlanner {

  double myStartLongitude;
  double myStartLatitude;
  Integer myLeaveHour;
  Integer myLeaveMinute;
  double myDestinationLongitude; 
  double myDestinationLatitude;
  Integer myArriveHour;
  Integer myArriveMinute;

  /**
   * Construct a RoutePlanner object, specifying a starting location (specified
   * by latitude and longitude), and a destination location (specified in the
   * same way).
   * 
   * Optionally, either a desired leaving time (leaveHour and leaveMinute) may
   * be specified, or a desired arrival time (arriveHour and arriveMinute), but
   * not both - if both are specified, an IllegalArgumentException is thrown.
   * Specifying neither is acceptable; in that case, the leaving time is assumed
   * to be the current time. The arguments for leaving or arrival time
   * should be set to null, if not used.
   * 
   * @param startLongitude
   * @param startLatitude
   * @param leaveHour
   * @param leaveMinute
   * @param destinationLongitude
   * @param destinationLatitude
   * @param arriveHour
   * @param arriveMinute
   */
  public RoutePlanner(double startLongitude, double startLatitude, Integer leaveHour, Integer leaveMinute,
      double destinationLongitude, double destinationLatitude, Integer arriveHour, Integer arriveMinute) {

      if (leaveHour != null && arriveHour != null) {
        throw new IllegalArgumentException("Cannot have two times");
      }

    myStartLongitude = startLongitude;
    myStartLatitude = startLatitude;
    myLeaveHour = leaveHour;
    myLeaveMinute = leaveMinute;
    myDestinationLongitude = destinationLongitude; 
    myDestinationLatitude = destinationLatitude;
    myArriveHour = arriveHour;
    myArriveMinute = arriveMinute;
  }

  public double getStartLongitude() {
    return myStartLongitude;
  }
  public double getStartLatitude() {
    return myStartLatitude;
  }
  public Integer getLeaveHour() {
    return myLeaveHour;
  }
  public Integer getLeaveMinute() {
    return myLeaveMinute;
  }
  public double getDestinationLongitude() {
    return myDestinationLongitude;
  }
  public double getDestinationLatitude() {
    return myDestinationLatitude;
  }
  public Integer getArriveHour() {
    return myArriveHour;
  }
  public Integer getArriveMinute() {
    return myArriveMinute;
  }
  
  /** Return a list of directions for the user to follow.
   * The return value is a list of TravelStop objects, which
   * will be displayed visually to the user by other classes.
   * 
   * For the description argument, an empty array of Strings should
   * be passed; an IllegalArgumentException is thrown if such an array
   * is not passed.
   * 
   * After the method is called, the method will have populated
   * this array with one String, which consists of a textual
   * description of the route to take, including walking to and from
   * or between stops.
   * 
   * If a route cannot be planned for some reason, an IllegalStateException
   * is thrown, with an explanatory message.
   * 
   */
  public List<TravelStop> getDirections(String description[]) {
      TravelStop ts = new TravelStop(0.0,0.0,"","");
    return null;
  }
  
  
  
}
