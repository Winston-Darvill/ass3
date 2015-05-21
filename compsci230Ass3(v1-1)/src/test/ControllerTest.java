package test;

import static org.junit.Assert.*;

import java.security.PublicKey;

import main.Controller;
import main.ControlDeviceType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.builders.NullBuilder;

public class ControllerTest {

	Controller myApp;
	
	@Before
	public void setUp() throws Exception {
		myApp = new Controller();
	}

	@After
	public void tearDown() throws Exception {
	}

	
//--- This section tests adding valid devices to list of controlled devices ---	
	
	@Test
	public void testAddFirstValidDeviceSucceeds() {
		assertTrue("Add device should succeed", myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1111", 0, 100, 20, 50));
		assertTrue("Device id=1111 should be in list", myApp.isDeviceInList("1111"));
		assertEquals("There should be 1 device in list of controlled devices", myApp.getNumDevices(), 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSameID(){
		try{
			myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1111", 0, 100, 20, 50);
			myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1111", 0, 100, 20, 50);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException();
			
		}
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullID(){
		try{
			myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, null, 0, 100, 20, 50);
		}catch(NullPointerException e){
			throw new NullPointerException();
			
		}
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOperatingMin(){
		int min = -1;
		try{
		myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1111", min, 100, 20, 50);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException();
		}	
	}
	
	@Test
	public void testFullList(){
		assertFalse(myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1111", 0, 100, 20, 50));
		assertFalse(myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1112", 0, 100, 20, 50));
		assertFalse(myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1113", 0, 100, 20, 50));
		assertFalse(myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1114", 0, 100, 20, 50));
		assertFalse(myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1115", 0, 100, 20, 50));
		assertFalse(myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1116", 0, 100, 20, 50));
		assertFalse(myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1117", 0, 100, 20, 50));
		
	}
	


}
