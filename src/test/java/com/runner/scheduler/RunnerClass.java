package com.runner.scheduler;

import org.testng.TestNG;
import org.testng.annotations.Listeners;

import com.qa.allurelistener.TestAllureListener;
import com.qa.dialers.testfiles.SchedulerTest;

@Listeners({TestAllureListener.class})
public class RunnerClass {
	
	static TestNG testNg;

	public static void main(String[] args) {
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] { SchedulerTest.class });
		testNg.run();
	}

}
