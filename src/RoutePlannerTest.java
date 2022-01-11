package src;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class RoutePlannerTest {

  private RoutePlanner rpValid;

  /**
   * @throws java.lang.Exception
   * 
   * Intialises a valid instance of the RoutePlanner class 
   * with parameters in the expected valid domains
   */
  @Before
  public void setUp() throws Exception {
    rpValid = new RoutePlanner(-20.0, 50.0, 12, 15, -30.0, 60.0, null, null);
  }

  /**
   * @throws java.lang.Exception
   * 
   * Removes the valid RoutePlanner instance 
   */
  @After
  public void tearDown() throws Exception {
    rpValid = null;
  }

  /**
   * Confirm that the valid RoutePlanner instance returns the 
   * correct startLatitude when getStartLatitude() is called, ie 50
   */
  @Test
  public void getStartLatitude_ValidRoutePlanner() {
    assertEquals(50.0, rpValid.getStartLatitude(), 0.0001);
  }

  /**
   * Confirm that the valid RoutePlanner instance returns the 
   * correct leaveMinute when getLeaveMinute() is called, ie 15
   */
  @Test
  public void getLeaveMinute_ValidRoutePlanner() {
    assertEquals(new Integer(15), rpValid.getLeaveMinute());
  }

  /**
   * Confirm that the valid RoutePlanner instance returns the 
   * correct arriveHour when getArriveHour() is called, ie null
   */
  @Test
  public void getArriveHour_ValidRoutePlanner() {
    assertNull(rpValid.getArriveHour());
  }

  /**
   * Creating an instance of RoutePlanner with an invalid 
   * combination of time parameters ie all non-null. IllegalArgumentException should be thrown
   */
  @Test(expected = IllegalArgumentException.class)
  public void RoutePlanner_InvalidTimes() {
      RoutePlanner rp = new RoutePlanner(-20.0, 50.0, 12, 15, -30.0, 60.0, 1, 0);
  }

  /**
   * Creating an instance of RoutePlanner with all null time parameters
   * The constructor should change the leave time to the current time
   * While the arrive times should remain as null
   */
  @Test
  public void RoutePlanner_NoTimeEqualCurrentTime() {

      RoutePlanner rp = new RoutePlanner(-20.0, 50.0, null, null, -30.0, 60.0, null, null);

      //Getting the current 24 hour time as Integers
      Date date = new Date();  
      Calendar calendar = Calendar.getInstance();
      Integer currentHour = calendar.get(Calendar.HOUR_OF_DAY);
      Integer currentMinute = calendar.get(Calendar.MINUTE);

      //Confirm that the current time is equal to the leave time
      assertEquals(currentHour, rp.getLeaveHour());
      assertEquals(currentMinute, rp.getLeaveMinute());

      //Confirm that the arrive time is still null
      assertNull(rp.getArriveHour());
      assertNull(rp.getArriveMinute());
  }
}
