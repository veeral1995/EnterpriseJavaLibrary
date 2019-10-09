package com.library.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.library.controller.servlet.login.*;
import com.library.controller.servlet.register.*;
import com.library.controller.servlet.search.*;
import com.library.controller.servlet.rent.*;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({})
public class AllControllerTests {
	
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.library.controllers");
		//$JUnit-BEGIN$
		suite.addTestSuite(LoginControllerTest.class);
		suite.addTestSuite(RentControllerTest.class);
		suite.addTestSuite(SearchControllerTest.class);
		suite.addTestSuite(RegisterControllerTest.class);
		//$JUnit-END$
		
		return suite;
	}

}
