package src;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TravelStopTest {

  private TravelStop tsValid;

  /**
   * @throws java.lang.Exception
   * 
   * Intialises a valid instance of the TravelStop class 
   * with parameters in the expected valid domains
   */
  @Before
  public void setUp() throws Exception {
      tsValid = new TravelStop(-20.0,50.0,"Stirling Hwy","Crawley");
  }

  /**
   * @throws java.lang.Exception
   * 
   * Removes the valid TravelStop instance 
   */
  @After
  public void tearDown() throws Exception {
      tsValid = null;
  }
  
  /**
   * Confirm that the valid TravelStop instance returns the 
   * correct latitude when getLatitude() is called, ie -20
   */
  @Test
  public void getLatitude_ValidTravelStop() {
    assertEquals(-20.0, tsValid.getLatitude(), 0.0001);
  }

  /**
   * Confirm that the valid TravelStop instance returns the 
   * correct longitude when getLongitude() is called, ie 50
   */
  @Test
  public void getLongitude_ValidTravelStop() {
    assertEquals(50.0, tsValid.getLongitude(), 0.0001);
  }

  /**
   * Confirm that the valid TravelStop instance returns the 
   * correct street name when getStreet() is called, ie Stirling Hwy
   */
  @Test
  public void getStreet_ValidTravelStop() {
    assertEquals("Stirling Hwy", tsValid.getStreet());
  }

  /**
   * Confirm that the valid TravelStop instance returns the 
   * correct suburb name when getSuburb() is called, ie Crawley
   */
  @Test
  public void getSuburb_ValidTravelStop() {
    assertEquals("Crawley", tsValid.getSuburb());
  }

  /**
   * Creating an instance of TravelStop with an invalid 
   * latitude parameter ie >90. IllegalArgumentException should be thrown
   */
  @Test(expected = IllegalArgumentException.class)
  public void TravelStop_InvalidLatitude() {
      TravelStop ts = new TravelStop(100.0,50.0,"Stirling Hwy","Crawley");
  }
  
  /**
   * Creating an instance of TravelStop with an invalid 
   * longitude parameter ie <-180. IllegalArgumentException should be thrown
   */
  @Test(expected = IllegalArgumentException.class)
  public void TravelStop_InvalidLongitude() {
      TravelStop ts = new TravelStop(10.0,-1000.0,"Stirling Hwy","Crawley");
  }
  
  /**
   * Creating an instance of TravelStop with an invalid 
   * street parameter ie Fake. IllegalArgumentException should be thrown
   */
  @Test(expected = IllegalArgumentException.class)
  public void TravelStop_InvalidStreet() {
      TravelStop ts = new TravelStop(10.0,50.0,"Fake","Crawley");
  }
  
  /**
   * Creating an instance of TravelStop with an invalid 
   * suburb parameter ie Fake. IllegalArgumentException should be thrown
   */
  @Test(expected = IllegalArgumentException.class)
  public void TravelStop_InvalidSuburb() {
      TravelStop ts = new TravelStop(10.0,50.0,"Stirling Hwy","Fake");
  }
}
