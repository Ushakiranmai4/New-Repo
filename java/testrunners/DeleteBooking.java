package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles/flightbooking.feature",glue="stepdefinitions",dryRun=false,plugin= {"com.cucumber.listener.ExtentCucumberFormatter:Reports/DeleteBookingResult.html"})

public class DeleteBooking extends AbstractTestNGCucumberTests 
{

}
