package globalMastersPageObject;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
import pageObjects.Utility;

public class DefineSmsTemplate {
  WebDriver dr;
  String pg="DefineSmsTemplate";
  Utility u= new Utility();

  @FindBy(id="ContentPlaceHolder1_ddlSMSType")WebElement smstype;
  @FindBy(id="ContentPlaceHolder1_txtsms_TextBox")WebElement sms;
  @FindBy(id="ContentPlaceHolder1_Chkenable")WebElement isenable;
  @FindBy(id="ContentPlaceHolder1_BtnControls1_btnSave")WebElement save;
  @FindBy(id="ContentPlaceHolder1_BtnControls1_btnView")WebElement view;

  public DefineSmsTemplate(WebDriver d)
  {
	  this.dr=d;
	  PageFactory.initElements(d, this); 
  }
  public void openDefineSmsTemplate()
  {
      WebElement menu= dr.findElement(By.xpath("//img[@src='/Images/layout/Global-Masters.png']"));
 	  Actions builder= new Actions(dr);
	  builder.moveToElement(menu).build().perform();
	  dr.findElement(By.linkText("Define SMS Template")).click();
	  dr.switchTo().frame(dr.findElement(By.xpath("//iframe[@src='/SchoolCommonDetails/DefineSMSTemplate.aspx']")));
  }
  public void verifyPage(String schl,Collection<String>sc) throws IOException, InterruptedException
  {
	  dr.findElement(By.xpath("//div[@class='content']")).click();
	  Thread.sleep(1000);
	  u.captureScreenshot(dr,schl,pg,sc);
  }
  public void selectSmsType()
  {
      new Select(smstype).selectByIndex(1);
  }
  public void enterSms(String s)
  {
      sms.sendKeys(s);
  }
  public void selectIsEnable()
  {
      isenable.click();
  }
  public void clickSave(String school, Collection<String> sc)throws IOException
  {
      save.click();
      u.verifySave(dr, school, pg, sc);
  }
  public void clickView(String school, Collection<String> sc)throws IOException
  {
      view.click();
      WebElement table= dr.findElement(By.id("example"));
      List<WebElement> cells= table.findElements(By.tagName("td"));
      if (cells.size()>1) {
          for (WebElement cell : cells) {
              cell.findElement(By.xpath("//input[starts-with(@id,'ContentPlaceHolder1_rptSMSDefine')]")).click();
              break;
          }
          dr.findElement(By.id("ContentPlaceHolder1_BtnControls1_btnModify")).click();
          dr.findElement(By.id("popup_ok")).click();
      }else
          System.out.println("No record Found");
      u.verifyView(dr,school, pg, sc);
  }
}
