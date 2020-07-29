package com.qa.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common_Elements {
	public static WebDriver obj;

	@SuppressWarnings("static-access")
	public Common_Elements(WebDriver obj) {
		this.obj = obj;
	}

	/*
	 * GetText--To get text of the attribute from specific element following are
	 * the Attributes Xpath ID Class_Name Name TagName
	 */
	public String Gettext_Xpath(String value) throws InterruptedException {

		String value1 = obj.findElement(By.xpath(value)).getText();
		System.out.println(value1);

		return value1;

	}

	public String Gettext_ID(String value) throws InterruptedException {

		String value1 = obj.findElement(By.id(value)).getText();
		System.out.println(value1);
		return value1;

	}

	public String Gettext_ClassName(String value) throws InterruptedException {

		String value1 = obj.findElement(By.className(value)).getText();
		System.out.println(value1);
		return value1;

	}

	public String Gettext_Name(String value) throws InterruptedException {

		String value1 = obj.findElement(By.name(value)).getText();
		System.out.println(value1);
		return value1;

	}

	public String Gettext_Tagname(String value) throws InterruptedException {

		String value1 = obj.findElement(By.tagName(value)).getText();
		System.out.println(value1);
		return value1;

	}

	public String Gettext_PartialLink(String value) throws InterruptedException {

		String value1 = obj.findElement(By.partialLinkText(value)).getText();
		System.out.println(value1);
		return value1;

	}

	/*
	 * Click--To Click on the attribute on specific element following are the
	 * Attributes Xpath ID Class_Name Name TagName PartialLink
	 */
	public void Click_Xpath(String value) throws InterruptedException {

		obj.findElement(By.xpath(value)).click();

	}

	public void Click_ID(String value) throws InterruptedException {

		obj.findElement(By.id(value)).click();

	}

	public void Click_ClassName(String value) throws InterruptedException {

		obj.findElement(By.className(value)).click();

	}

	public void Click_Name(String value) throws InterruptedException {

		obj.findElement(By.name(value)).click();

	}

	public void Click_Tagname(String value) throws InterruptedException {

		obj.findElement(By.tagName(value)).click();

	}

	public void Click_PartialLink(String value) throws InterruptedException {

		obj.findElement(By.partialLinkText(value)).click();

	}
	/*
	 * Relative_Xpath - Relative xpath for the click in appium and webpages
	 * following are the Attributes Xpath ID Class_Name Name TagName PartialLink
	 */

	public void Relative_Text_Xpath_Click(String value) {
		obj.findElement(By.xpath("//*[@text ="+value+"]")).click();
	}

	public void Relative_Index_Xpath_Click(String value) {
		obj.findElement(By.xpath("//*[@index ="+value+"]")).click();
	}

	public void Relative_ID_Xpath_Click(String value) {
		obj.findElement(By.xpath("//*[@id ="+value+"]")).click();
	}
	public String Relative_Text_Xpath_Gettext(String value) {
		String Rel_Textvalue=obj.findElement(By.xpath("//*[@text="+value+"]")).getText();
		return Rel_Textvalue;
		}

	public String  Relative_Index_Xpath_Gettext(String value) {
		String Rel_Indexvalue =obj.findElement(By.xpath("//*[@index =" + value + "]")).getText();
		return Rel_Indexvalue;
		}

	public String  Relative_ID_Xpath_Gettext(String value) {
		String Rel_value=obj.findElement(By.xpath("//*[@id ="+value+"]")).getText();
	return Rel_value;
	}

	/*
	 * Loginpage_Relative_Xpath-- This code will handle single page navigation
	 * Xpath ID Class_Name Name TagName PartialLink
	 */
	public void Loginpage_Relative_Text_Xpath(String RelativeText_usr, String RelativeText_pw, String User_value,
			String Pswd_value, String RealtiveTextSubmit) throws Exception {
		obj.findElement(By.xpath("//*[@text=" + RelativeText_usr + "]")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@text=" + RelativeText_usr + "]")).clear();
		obj.findElement(By.xpath("//*[@text=" + RelativeText_usr + "]")).sendKeys(User_value);
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@text=" + RelativeText_pw + "]")).clear();
		obj.findElement(By.xpath("//*[@text=" + RelativeText_pw + "]")).sendKeys(Pswd_value);
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@text=" + RealtiveTextSubmit + "]")).click();
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("logged in successfully--following are the login details \n User->" + User_value
				+ "--Password-->" + Pswd_value);
	}

	public void Loginpage_Relative_Index_Xpath(String RelativeIndex_usr, String RelativeIndex_pw, String User_value,
			String Pswd_value, String RelativeIndex_Submit) throws InterruptedException {
		obj.findElement(By.xpath("//*[@index =" + RelativeIndex_usr + "]")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@index =" + RelativeIndex_usr + "]")).clear();
		obj.findElement(By.xpath(RelativeIndex_usr)).sendKeys(User_value);// User
																			// name
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@index =" + RelativeIndex_pw + "]")).clear();
		obj.findElement(By.xpath("//*[@index =" + RelativeIndex_pw + "]")).sendKeys(Pswd_value);// password

		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@index =" + RelativeIndex_Submit + "]")).click();// login
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("logged in successfully--following are the login details \n User->" + User_value
				+ "\n--Password-->" + Pswd_value);
	}

	public void Loginapge_Relative_ID_Xpath(String RelativeID_usr, String RelativeID_pw, String User_value,
			String Pswd_value, String RelativeIDSubmit) throws Exception {
		obj.findElement(By.xpath("//*[@id =" + RelativeID_usr + "]")).click();
		Thread.sleep(2000);

		obj.findElement(By.xpath("//*[@id =" + RelativeID_usr + "]")).sendKeys(User_value);// user
																							// name
		Thread.sleep(2000);

		obj.findElement(By.xpath("//*[@id =" + RelativeID_pw + "]")).sendKeys(Pswd_value);// password
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@id =" + RelativeIDSubmit + "]")).click();// login
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("logged in successfully--following are the login details \n User->" + User_value
				+ "\n--Password-->" + Pswd_value);
	}

	/*
	 * SendKeys--To pass value from keyword into the form Xpath ID Class_Name
	 * Name TagName PartialLink
	 */
	public void Sendkeys_Xpath(String value, String passtext) throws InterruptedException {

		obj.findElement(By.xpath(value)).sendKeys(passtext);

	}

	public void Sendkeys_ID(String value, String passtext) throws InterruptedException {

		obj.findElement(By.id(value)).sendKeys(passtext);

	}

	public void Sendkeys_ClassName(String value, String passtext) throws InterruptedException {

		obj.findElement(By.className(value)).sendKeys(passtext);

	}

	public void Sendkeys_Name(String value, String passtext) throws InterruptedException {

		obj.findElement(By.name(value)).sendKeys(passtext);
	}

	public void Sendkeys_Tagname(String value, String passtext) throws InterruptedException {

		obj.findElement(By.tagName(value)).sendKeys(passtext);
	}

	public void Sendkeys_PartialLink(String value, String passtext) throws InterruptedException {

		obj.findElement(By.partialLinkText(value)).sendKeys(passtext);

	}

	/*
	 * Table Count---To get the table count in the Web page
	 */
	public int Table_count(String Xpathvalue, String tagvalue) {
		WebElement Tabtabledata2 = obj.findElement(By.xpath(Xpathvalue));
		List<WebElement> Tablist = Tabtabledata2.findElements(By.tagName(tagvalue));
		int Tablesize_value = Tablist.size();
		return Tablesize_value;
	}
	/*
	 * Get Tab Size value
	 */
	public int Tab_count(String Xpathvalue, String tagvalue) {
		WebElement Tabcount = obj.findElement(By.xpath(Xpathvalue));
		List<WebElement> Tablist = Tabcount.findElements(By.tagName(tagvalue));
		int Tabsize_value = Tablist.size();
		return Tabsize_value;
	}

	/*
	 * Dropdown_List count
	 */
	public int Dropdown_ListCount(String Xpathvalue, String tagvalue) {
		WebElement dropdownlist = obj.findElement(By.xpath(Xpathvalue));
		List<WebElement> droplist = dropdownlist.findElements(By.tagName(tagvalue));
		int Tablesize_value = droplist.size();
		return Tablesize_value;
	}

	/*
	 * To check the Element in the page whether it is accessible or not
	 */
	public Boolean Displayed_Element(String Xpathvalue) {
		boolean searchIconPresence = obj.findElement(By.xpath(Xpathvalue)).isDisplayed();
		return searchIconPresence;

	}

	public Boolean Enabled_Element(String Xpathvalue) {
		boolean searchIconPresence = obj.findElement(By.xpath(Xpathvalue)).isEnabled();
		return searchIconPresence;

	}

	public Boolean Selected_Element(String Xpathvalue) {
		boolean searchIconPresence = obj.findElement(By.xpath(Xpathvalue)).isSelected();
		return searchIconPresence;

	}

	/*
	 * Loginpage --with all the attribute values to automate Login page with
	 * single page interaction This code will handle single page navigation
	 * Xpath ID Class_Name Name TagName PartialLink
	 */
	public void Login_Page_Xpath(String Xpath_usr, String Xpath_pw, String User_value, String Pswd_value, String Xpath_Submit)
			throws Exception {
		Thread.sleep(2000);

		obj.findElement(By.xpath(Xpath_usr)).sendKeys(User_value);// User name
		Thread.sleep(2000);

		obj.findElement(By.xpath(Xpath_pw)).sendKeys(Pswd_value);// password
		Thread.sleep(2000);
		obj.findElement(By.xpath(Xpath_Submit)).click();// login
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("logged in successfully--following are the login details \n User->" + User_value
				+ "\n--Password-->" + Pswd_value);
	}

	public void Login_Page_Classname(String ClassName_usr, String ClassName_pw, String User_value, String Pswd_value,
			String Xpath_Submit) throws Exception {
		Thread.sleep(2000);

		obj.findElement(By.xpath(ClassName_usr)).sendKeys(User_value);// user
																		// name
		Thread.sleep(2000);

		obj.findElement(By.xpath(ClassName_pw)).sendKeys(Pswd_value);// password

		Thread.sleep(2000);
		obj.findElement(By.xpath(Xpath_Submit)).click();// login
		obj.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		System.out.println("logged in successfully--following are the login details \n User->" + User_value
				+ "\n--Password-->" + Pswd_value);
	}

	public void Login_Page_Name(String Name_usr, String Name_pw, String User_value, String Pswd_value, String Xpath_Submit)
			throws Exception {
		Thread.sleep(2000);

		obj.findElement(By.xpath(Name_usr)).sendKeys(User_value);// User name
		Thread.sleep(2000);

		obj.findElement(By.xpath(Name_pw)).sendKeys(Pswd_value);// password
		Thread.sleep(2000);
		obj.findElement(By.xpath(Xpath_Submit)).click();// login
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("logged in successfully--following are the login details \n User->" + User_value
				+ "\n--Password-->" + Pswd_value);
	}

	public void Login_Page_ID(String ID_usr, String ID_pw, String User_value, String Pswd_value, String Xpath_Submit)
			throws Exception {
		Thread.sleep(2000);

		obj.findElement(By.xpath(ID_usr)).sendKeys(User_value);// User name
		Thread.sleep(2000);
		obj.findElement(By.xpath(ID_pw)).sendKeys(Pswd_value);// password
		Thread.sleep(2000);
		obj.findElement(By.xpath(Xpath_Submit)).click();// login
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("logged in successfully--following are the login details \n User->" + User_value
				+ "\n--Password-->" + Pswd_value);
	}

	/*
	 * Move to the Element on Specify to the Xpath provided
	 */
	public void MovetoElement(String value) {
		WebElement startdt = obj.findElement(By.xpath(value));
		Actions actions = new Actions(obj);
		actions.moveToElement(startdt).perform();
		startdt.click();
	}

	/*
	 * Select drop down two different ways Visible text and Index values
	 */
	public void Select_dropdown_VisiableText(String Xpath_value, String VisibleText) {
		obj.findElement(By.xpath(Xpath_value)).click();
		WebElement wb = obj.findElement(By.xpath(Xpath_value));
		Actions mouse = new Actions(obj);
		mouse.moveToElement(wb).perform();
		Select sel = new Select(wb);
		sel.selectByVisibleText(VisibleText.trim());
	}

	public void Select_dropdown_Byindex(String Xpath_value, int indexvalue) {
		obj.findElement(By.xpath(Xpath_value)).click();
		WebElement wb = obj.findElement(By.xpath(Xpath_value));
		Actions mouse = new Actions(obj);
		mouse.moveToElement(wb).perform();
		Select sel = new Select(wb);
		sel.selectByIndex(indexvalue);
	}

	/*
	 * De_Select dropdown two different ways Visiable text and Index values
	 */
	public void DeSelect_dropdown_VisiableText(String Xpath_value, String VisibleText) {
		obj.findElement(By.xpath(Xpath_value)).click();
		WebElement wb = obj.findElement(By.xpath(Xpath_value));
		Actions mouse = new Actions(obj);
		mouse.moveToElement(wb).perform();
		Select sel = new Select(wb);
		sel.deselectByVisibleText(VisibleText);
	}

	public void DeSelect_dropdown_Byindex(String Xpath_value, int indexvalue) {
		obj.findElement(By.xpath(Xpath_value)).click();
		WebElement wb = obj.findElement(By.xpath(Xpath_value));
		Actions mouse = new Actions(obj);
		mouse.moveToElement(wb).perform();
		Select sel = new Select(wb);
		sel.deselectByIndex(indexvalue);
	}

	/*
	 * pageNavigation Count value return
	 */
	public int PageNavigation_Count(String Xpath_value, String tagvalue) {
		WebElement pagenavigationdt = obj.findElement(By.xpath(Xpath_value));
		List<WebElement> pagedt = pagenavigationdt.findElements(By.tagName(tagvalue));
		int pagecount = pagedt.size();

		System.out.println("pagecount value---" + pagecount);
		return pagecount;
	}

	/*
	 * Two level Navigation of the Login page
	 */
	public void Two_leveled_Login_Page_Xpath(String xpath_usr, String xpath_pw, String next,String Xpath_Submit,String User_value,String Pswd_value) throws Exception {
		Thread.sleep(2000);

		obj.findElement(By.xpath(xpath_usr)).sendKeys(User_value);// user name
		Thread.sleep(2000);
		obj.findElement(By.xpath(next)).click();// next click
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.findElement(By.xpath(xpath_pw)).sendKeys(Pswd_value);// password
		Thread.sleep(2000);
		obj.findElement(By.xpath(Xpath_Submit)).click();// final submit
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("logged in successfully--following are the login details \n User->" + User_value
				+ "\n--Password-->" + Pswd_value);
	}
	public void Two_leveled_Login_Page_ID(String ID_usr, String ID_pw, String User_value, String next,String Pswd_value,
			String Xpath_Submit) throws Exception {
		Thread.sleep(2000);

		obj.findElement(By.xpath(ID_usr)).sendKeys(User_value);// user name
		Thread.sleep(2000);
		obj.findElement(By.xpath(next)).click();// next click
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.findElement(By.xpath(ID_pw)).sendKeys(Pswd_value);// password
		Thread.sleep(2000);
		obj.findElement(By.xpath(Xpath_Submit)).click();// final submit
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("logged in successfully--following are the login details \n User->" + User_value
				+ "\n--Password-->" + Pswd_value);
	}
	public void Two_leveled_Login_Page_Name(String Name_usr, String Name_pw, String User_value, String next,String Pswd_value,
			String Xpath_Submit) throws Exception {
		Thread.sleep(2000);

		obj.findElement(By.xpath(Name_usr)).sendKeys(User_value);// user name
		Thread.sleep(2000);
		obj.findElement(By.xpath(next)).click();// next click
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.findElement(By.xpath(Name_pw)).sendKeys(Pswd_value);// password
		Thread.sleep(2000);
		obj.findElement(By.xpath(Xpath_Submit)).click();// final submit
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("logged in successfully--following are the login details \n User->" + User_value
				+ "\n--Password-->" + Pswd_value);
	}
	public void Two_leveled_Login_Page_Classname(String Classname_usr, String classname_pw, String User_value, String next,String Pswd_value,
			String Xpath_Submit) throws Exception {
		Thread.sleep(2000);

		obj.findElement(By.xpath(Classname_usr)).sendKeys(User_value);// user name
		Thread.sleep(2000);
		obj.findElement(By.xpath(next)).click();// next click
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.findElement(By.xpath(classname_pw)).sendKeys(Pswd_value);// password
		Thread.sleep(2000);
		obj.findElement(By.xpath(Xpath_Submit)).click();// final submit
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("logged in successfully--following are the login details \n User->" + User_value
				+ "\n--Password-->" + Pswd_value);
	}
	/*
	 * Scroll up/Down in the Webpage
	 */
	public void Scrollup() {
		JavascriptExecutor js1 = ((JavascriptExecutor) obj);
		js1.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

	public void ScrollDown() {
		JavascriptExecutor js1 = ((JavascriptExecutor) obj);
		js1.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
//Tab click 
	public void Tab_Click(String value) {

		WebElement tabclick = obj.findElement(By.xpath(value));
		Actions tab = new Actions(obj);
		tab.moveToElement(tabclick).click().perform();

	}
//Dropdown size value
	public int Dropdown_Sizevalue(String value) {
		Select se = new Select(obj.findElement(By.xpath(value)));

		List<WebElement> l = se.getOptions();
		int Sublist_Val = l.size();
		return Sublist_Val;
	}
/*
 * Mobile capabilities values of the Configuration setup
 */
	public void Mobile_DesiredCapabilities(String DeviceName, String mobileID, String platform, String mobile_version,
			String App_package, String App_Activity, String URL_IP) throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", DeviceName);
		capabilities.setCapability("udid", mobileID); // Give Device ID

		capabilities.setCapability("platformName", platform);
		capabilities.setCapability("platformVersion", mobile_version);
		capabilities.setCapability("noReset", true);

		capabilities.setCapability("appPackage", App_package);// package from
																
		capabilities.setCapability("appActivity", App_Activity);// Activity name
																

		// Create RemoteWebDriver instance and connect to the Appium server
		obj = new RemoteWebDriver(new URL(URL_IP), capabilities);

		Thread.sleep(5000);

	}
//Chrome Driver browser
	public void Chromedriver_Instance(String chromeBrowser_path, String URL) {
		String data = System.getProperty("os.name");
			if(data.contains("Windows"))
		{
		System.setProperty("webdriver.chrome.driver",chromeBrowser_path +"chromedriver.exe");
		obj = new ChromeDriver();
		obj.get(URL);
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.manage().window().maximize();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", chromeBrowser_path + "chromedriver");
			obj = new ChromeDriver();
			obj.get(URL);
			obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			obj.manage().window().maximize();
		}

	}
//Fire fox browser
	public void Firefox_Instance(String FirefoxBrowser_path, String URL) {
		String data = System.getProperty("os.name");
		if(data.contains("Windows"))
		{
		System.setProperty("webdriver.gecko.driver", FirefoxBrowser_path + "geckodriver.exe");
		obj = new FirefoxDriver();
		obj.get(URL);
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.manage().window().maximize();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", FirefoxBrowser_path + "geckodriver");
			obj = new FirefoxDriver();
			obj.get(URL);
			obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			obj.manage().window().maximize();
		}
	}
//Fire fox browser
	public void Firefox_Instance_Marionette(String Marionettepath, String URL) {
		String data = System.getProperty("os.name");
		if(data.contains("Windows"))
		{
		System.setProperty("webdriver.firefox.marionette", Marionettepath + "geckodriver.exe");
		obj = new FirefoxDriver();
		obj.get(URL);
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.manage().window().maximize();
		}
		else
		{
			System.setProperty("webdriver.firefox.marionette", Marionettepath + "geckodriver");
			obj = new FirefoxDriver();
			obj.get(URL);
			obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			obj.manage().window().maximize();
			
		}
	}
//IE Browser
	public void IE_Instance(String IEBrowser_path, String URL) {
		String data = System.getProperty("os.name");
		if(data.contains("Windows"))
		{
		System.setProperty("webdriver.ie.driver", IEBrowser_path + "IEDriverServer.exe");
		obj = new InternetExplorerDriver();
		obj.get(URL);
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.manage().window().maximize();
	}
	else
	{
		System.setProperty("webdriver.ie.driver", IEBrowser_path + "IEDriverServer");
		obj = new InternetExplorerDriver();
		obj.get(URL);
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.manage().window().maximize();
	}
		
	}
//Ms_Edge browser selection
	public void MS_Edge_Instance(String MS_EdgeBrowser_path, String URL) {
		String data = System.getProperty("os.name");
		if(data.contains("Windows"))
		{
		System.setProperty("webdriver.edge.driver", MS_EdgeBrowser_path + "MicrosoftWebDriver.exe");
		obj = new EdgeDriver();
		obj.get(URL);
		obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj.manage().window().maximize();
		}
		else
		{
			System.setProperty("webdriver.edge.driver", MS_EdgeBrowser_path + "MicrosoftWebDriver");
			obj = new EdgeDriver();
			obj.get(URL);
			obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			obj.manage().window().maximize();
			
		}
	}
	/*
	 * x,y co-ordiante values in the page
	 */
	public void page_Coordinates(int x_value,int y_value)
	{
		JavascriptExecutor js = (JavascriptExecutor) obj;
        js.executeScript("javascript:window.scrollBy("+x_value+","+y_value+")");
	}
	public void chrome_Headless(String Headless_brower,String URL)
	{		
		String data = System.getProperty("os.name");
		if(data.contains("Windows"))
		{
		System.setProperty("webdriver.chrome.driver",Headless_brower+"chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		WebDriver obj = new ChromeDriver(options);
		obj = new ChromeDriver();
	   obj.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj.manage().window().maximize();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver",Headless_brower+"chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");
			WebDriver obj = new ChromeDriver(options);
			obj = new ChromeDriver();
		   obj.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			obj.manage().window().maximize();
		}
	}
	public void Click_Tabkey(String value)
	{
	WebElement ele =obj.findElement(By.xpath(value));
	ele.sendKeys(Keys.TAB);
}
public String Owner_Details()
	
	{
		
	String Owner_Info="-----  Owner of the Selenium Reusable shortcut Jar ------- \n------- Sreeram.Gangala --------------\n---------- QA -----------";
		System.out.println(Owner_Info);
		return Owner_Info;
	}
	public  WebElement WebElement_Elementinvoke_Xpath(String xpathvalue1,String xpathvalue2)
	
	{
		WebElement menuList = obj.findElement(By.xpath(
				xpathvalue1));

		WebElement pagecount = menuList
				.findElement(By.xpath(xpathvalue2));
		return pagecount;
	}
public  WebElement WebElement_Elementinvoke_ID(String IDvalue1,String IDvalue2)
	
	{
		WebElement menuList = obj.findElement(By.xpath(
				IDvalue1));

		WebElement pagecount = menuList
				.findElement(By.xpath(IDvalue2));
		return pagecount;
	}
public  WebElement WebElement_Elementinvoke_NAME(String namevalue1,String namevalue2)

{
	WebElement menuList = obj.findElement(By.xpath(namevalue1));

	WebElement pagecount = menuList
			.findElement(By.xpath(namevalue2));
	return pagecount;
}
public  WebElement WebElement_Elementinvoke_classname(String classnamevalue1,String classnamevalue2)

{
	WebElement menuList = obj.findElement(By.xpath(
			classnamevalue1));

	WebElement pagecount = menuList
			.findElement(By.xpath(classnamevalue2));
	return pagecount;
}
	public void Screenshot(WebDriver obj,String fileWithPath) throws Exception{
                Thread.sleep(5000);
       		 // Take screenshot and store as a file format             
		 File src=((TakesScreenshot)obj).getScreenshotAs(OutputType.FILE);           
		try {
		// now copy the  screenshot to desired location using copyFile method
		 
		FileUtils.copyFile(src, new File("scr/Screenshot/"+System.currentTimeMillis()+".png"));                           
		} catch (IOException e)
		 
		{
		  System.out.println(e.getMessage()); 
		 }
		  }
public boolean JS_pageloadcheck(WebDriver obj,int timeinSeconds) throws InterruptedException
{
	 {
		try {

			long t1 = System.currentTimeMillis();
			WebDriverWait wait = new WebDriverWait(obj, 20);
			JavascriptExecutor js = (JavascriptExecutor) obj;

			// wait for jQuery to load
			ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					try {


						return (Boolean) js.executeScript("return jQuery.active==0");
					} catch (Exception e) {
						return true;
					}
				}
			};

			// wait for Javascript to load
			ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
						return (js.executeScript("return document.readyState").toString().equals("complete"));
				}
			};

			final String javaScriptToLoadAngular = "var injector = window.angular.element('body').injector();"
					+ "var $http = injector.get('$http');" + "return ($http.pendingRequests.length === 0)";
			// wait for angular load
			ExpectedCondition<Boolean> angular = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					//long t3=System.currentTimeMillis();
					//System.out.println("time load"+(t3-t1));

						return ((JavascriptExecutor) driver).executeScript(javaScriptToLoadAngular).equals(true);
				}
			};

			long t2 = System.currentTimeMillis();
//20000
			if ((t2 - t1) <= timeinSeconds) {
				return wait.until(jQueryLoad) && wait.until(jsLoad) && wait.until(angular);}
			else
				System.out.println("not loaded");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}
public static void QA_mail_status(String TO, String CC, String MailSubject, String MessageBody) throws InterruptedException {

	System.setProperty("webdriver.chrome.driver", "src//chromedriver.exe");

	obj = new ChromeDriver();

	obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	obj.get("https://www.gmail.co.in");
	Thread.sleep(2000);
	// filling user feild and clicking next
	obj.findElement(By.name("identifier")).sendKeys("dcrstatus@gmail.com");
	obj.findElement(By.id("identifierNext")).click();
	Thread.sleep(2000);
	// filling pwd feild and clicking signin
	obj.findElement(By.name("password")).sendKeys("vassar@123");
	obj.findElement(By.id("passwordNext")).click();
	Thread.sleep(2000);
	try{
		
	
	// COMPOSE CLICK
	WebElement composeButton = obj.findElement(By.cssSelector("[gh='cm']"));
	composeButton.click();
	// passing of email
	obj.findElement(By.name("to")).sendKeys(TO);// TOADRESS
	Thread.sleep(2000);
	obj.findElement(By.xpath("//span[text()='Cc']")).click();
	Thread.sleep(5000);
	obj.findElement(By.xpath("//TEXTAREA[contains(@name, \"cc\")]")).sendKeys(CC);
	Thread.sleep(2000);
	obj.findElement(By.name("subjectbox")).sendKeys(MailSubject);// subject
	
    
	Thread.sleep(2000);
	obj.findElement(By.xpath("//DIV[contains(@aria-label,\"Message Body\")]")).sendKeys(MessageBody);
	Thread.sleep(3000);
	 //click Send button
	  obj.findElement(By.xpath("//div[text()='Send']")).click();
	Thread.sleep(4000);
			@SuppressWarnings("unused")
	String m = obj.findElement(By.xpath("//*[@role='alert']/div/div[2]")).getText();
	// System.out.println(m);
	// Do Logout
	obj.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]")).click();
	Thread.sleep(2000);
	obj.findElement(By.linkText("Sign out")).click();
	Thread.sleep(2000);
	System.out.println("----------Email send successfully-------");
	}
	catch(Exception e)
	{
		System.out.println("----- Error in the mail Sending ----");
	}
	 //Close site
	obj.close();

}

public void Verify_URL_StatusCode(String Propertyfile_Path_withdata_Listpass_as_CapURL) throws Exception {
	 File file;
	int linecount = 0;
	
	String[] projectID;

		file = new File(Propertyfile_Path_withdata_Listpass_as_CapURL);

		if (file.exists()) {

			FileReader fr = new FileReader(file);

			@SuppressWarnings("resource")
			LineNumberReader lnr = new LineNumberReader(fr);

			

			while (lnr.readLine() != null) {
				linecount++;

			}

			System.out.println("Total number of lines : " + linecount);
			
		} else {
			System.out.println("File does not exists!");
		}
		int count=linecount;
	
	System.out.println("Count value--"+count);
	Properties p = new Properties();
	FileReader reader = new FileReader(Propertyfile_Path_withdata_Listpass_as_CapURL);
	p.load(reader);
	
	for (int i = 1; i <= count; i++) {
		//System.out.println(p.getProperty("URL" + i + ""));
		{

		projectID = p.getProperty("URL"+i+"").split("//");
	
		
			System.out.println(projectID[1]);
			try {
				URL url = new URL(p.getProperty("URL"+i+""));
				HttpURLConnection http = (HttpURLConnection) url.openConnection();
				int statusCode = http.getResponseCode();

				System.out.println(statusCode);

				if (statusCode == 200) {
					System.out.println("------Site is working fine-----");
					
				}
				else
				{
					System.out.println("------Site is not responding -----");
					
				}

			} catch (Exception e) {
				System.out.println("------Site is not responding -----");
				
			}
		}
       
	}
	}


public void Close_Browser() {
	obj.close();
}
public void Quite_ALL_Browsers() {
	obj.quit();
}


public static void Sending_Mail_WithAttachentfile(String from_UserID,String from_Userpswd,String to,String cc,String bcc,String Subject,String message,String AttachmentFile_Path) throws Exception {

	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "578");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "465");
	props.setProperty("mail.smtp.ssl.enable", "true");

	// This will handle the complete authentication
	Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() 
               {
                    return new PasswordAuthentication(from_UserID, from_Userpswd);
                }
            });
 
    try {
 
        Message msg = new MimeMessage(session);
        Multipart multipart = new MimeMultipart();
        msg.setFrom(new InternetAddress(from_UserID));
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
       //below code only requires if your want cc email address
        msg.setRecipients(Message.RecipientType.CC,
                InternetAddress.parse(cc));
        //below code only requires if your want bcc email address
        msg.setRecipients(Message.RecipientType.BCC,
                InternetAddress.parse(bcc));
        msg.setSubject(Subject);
        msg.setText(message);
 
        System.out.println("Sending");
        
        MimeBodyPart attachPart = new MimeBodyPart();
        
        try {
            attachPart.attachFile(AttachmentFile_Path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        multipart.addBodyPart(attachPart);
   
// sets the multi-part as e-mail's content

      msg.setContent(multipart);
      MimeBodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setContent(message, "text/html");

      // creates multi-part
     
      multipart.addBodyPart(messageBodyPart);

        Transport.send(msg);
 
        System.out.println("Email Sending Successfully");
 
    } catch (MessagingException e) {
    	
        e.printStackTrace();
    }
}
}



