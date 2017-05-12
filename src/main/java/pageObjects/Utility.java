package pageObjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	void captureScreenshot(WebDriver dr, String str, String r, Collection<String> sc) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File f= ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File("D:/stock_screenshots/"+str+"/"+r+"/"+r+sc+timeStamp+".png"));
	}
	void selectDate(WebDriver dr,WebElement date,String mm, String yy,String dd ) throws InterruptedException
	{
		 date.click();
	  	 Thread.sleep(1000);
	  	 new Select(dr.findElement(By.className("datepick-new-month"))).selectByVisibleText(mm);
	     Thread.sleep(1000);
	     new Select(dr.findElement(By.className("datepick-new-year"))).selectByVisibleText(yy);
	  	 Thread.sleep(1000);
	  	 WebElement myw=dr.findElement(By.className("datepick"));
	  		List<WebElement> cells=myw.findElements(By.tagName("td"));
	  		 for(WebElement cell: cells) {
	  		  if (cell.getText().equals(dd)){  
	  		   cell.click();
	  			break; 
	    } 
	    }Thread.sleep(1000);
	}
}
