package com.runner.scheduler;

import org.testng.TestNG;

import com.qa.dialers.testfiles.DialerModeTest;

public class DialerModeRunner {

	static TestNG testNg;

	public static void main(String[] args) {
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] { DialerModeTest.class });
		testNg.run();
	}

}
