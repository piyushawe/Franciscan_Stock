package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features= {"Feature/PageVerify.feature"}
		,glue= {"stepDef"}
		,monochrome=true
	    ,plugin= {"pretty","html:target/cucumber_html_report",
	    		  "json:target/cucumber.json",
	    	      "junit:target/cucumber.xml"}		
		//,tags= {"@scenario25"}
	)
public class VerifyPageRunner {

}
