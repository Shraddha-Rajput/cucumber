package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"FeatureFiles"},monochrome = true, glue= {"stepDefinition"},plugin={"pretty", "html:target/Reports.html"})
 

//u can define file path above also if multiple feature files,message in readable give so guve true

public class Runner_Executable 
{

}
