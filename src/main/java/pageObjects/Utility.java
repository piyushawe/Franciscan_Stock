package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	public void captureScreenshot(WebDriver dr, String str, String r, Collection<String> sc) throws IOException
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
	public void verifySave(WebDriver dr,String school, String page,Collection<String> sc)throws IOException
	{
		ArrayList<String> list= new ArrayList<String>();
		Date date= new Date();
		int size= sc.toString().length();
		String scenario= sc.toString().substring(2,size-1);
		String msg;
		try {
			Assert.assertFalse(dr.getPageSource().contains("Server Error"));
		}
		catch(Exception e)
		{
			System.out.println("Server Error on page");
			list.add(date.toString());
			list.add(scenario);
			list.add(page);
			list.add("Save: Server Error");
			prepareErrorLog(list,school);
		}
		dr.switchTo().defaultContent();
		try {
			dr.findElement(By.id("defaultSpeechbubbleHeader"));
		}
		catch(Exception e)
		{
			list.add(date.toString());
			list.add(scenario);
			list.add(page);
			list.add("Save: Message Did Not Appear ");
			prepareErrorLog(list,school);
		}
		msg = dr.findElement(By.id("defaultSpeechbubbleHeader")).getText();
		if(!msg.contains("successfully"))
		{
			list.add(date.toString());
			list.add(scenario);
			list.add(page);
			list.add("Save:"+msg);
			prepareErrorLog(list,school);
		}
	}

	public void verifyView(WebDriver dr,String school, String page,Collection<String> sc )throws IOException
	{
		ArrayList<String>list= new ArrayList<String>();
		Date date= new Date();
		int size= sc.toString().length();
		String scenario= sc.toString().substring(2,size-1);
		String msg;
		try {
			Assert.assertFalse(dr.getPageSource().contains("Server Error"));
		}
		catch(Exception e)
		{
			System.out.println("Server Error on page");
			list.add(date.toString());
			list.add(scenario);
			list.add(page);
			list.add("Modify: Server Error on page");
			prepareErrorLog(list,school);
		}
		dr.switchTo().defaultContent();
		try {
			dr.findElement(By.id("defaultSpeechbubbleHeader"));
		}
		catch(Exception e)
		{
			list.add(date.toString());
			list.add(scenario);
			list.add(page);
			list.add("Modify: Message Did Not Appear");
			prepareErrorLog(list,school);
		}
		msg = dr.findElement(By.id("defaultSpeechbubbleHeader")).getText();
		if(msg.contains("Error")||msg.contains("error"))
		{
			list.add(date.toString());
			list.add(scenario);
			list.add(page);
			list.add("Modify:"+ msg);
			prepareErrorLog(list,school);
		}
	}

	public void prepareErrorLog(ArrayList<String>lst, String school )throws IOException
	{
		ArrayList<String>list= new ArrayList<String>(Arrays.asList("Date","Scenario", "Page","Error Message"));
		File file = new File("D:/TestReports/" + school + "/Stock/ErrorLog.xls");
		File pdir= file.getParentFile();
		FileInputStream fis;
		HSSFWorkbook wb;
		if(!file.exists()) {
			System.out.println("File Does Not Exist");
			if (pdir != null)
				pdir.mkdirs();
			file.createNewFile();
			fis= new FileInputStream(file);
			wb= new HSSFWorkbook();
			System.out.println("New File Created");
		}else {
			fis = new FileInputStream(file);
			wb = new HSSFWorkbook(fis);
		}
		Sheet sheet = wb.getSheet("error log");
		System.out.println(sheet);
		if(sheet==null)
			sheet = wb.createSheet("error log");
		Row row;
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getFirstRowNum());
		int rowcount= sheet.getPhysicalNumberOfRows()-sheet.getFirstRowNum();
		System.out.println("rowcount: "+rowcount);
		System.out.println(sheet.getPhysicalNumberOfRows());
		int i=0;
		if(rowcount==0){
			row= sheet.createRow(rowcount);
			for(String ls:list){
				Cell cell= row.createCell(i);
				cell.setCellValue(ls);
				i++;
			}
		}
		FileOutputStream fout= new FileOutputStream(file);
		wb.write(fout);
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getFirstRowNum());
		rowcount= sheet.getLastRowNum()-sheet.getFirstRowNum();
		row = sheet.createRow(rowcount+1);
		i=0;
		for (String ls:lst)
		{
			Cell cell= row.createCell(i);
			cell.setCellValue(ls);
			i++;
		}
		FileOutputStream fout1= new FileOutputStream(file);
		wb.write(fout1);
	}
}
