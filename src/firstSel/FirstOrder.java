package firstSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstOrder {
	
	public static String randomStr() {
		String str="";
		for(int i=0;i<5;i++) {
			str+=(char)((int)(Math.random()*26 + 65));
		}
		return str;
	}
	public static int randomNo() {
		int num = (int)(Math.random()*3 + 1);
		return num;
		
	}
	public static String randomZip() {
		String empty="";
		for(int i=0;i<5;i++) {
			empty+=(int)(Math.random()*9 + 1);
		}
		return empty;
	}
	
	public static String randomQuantity() {
		String empty="";
		int quantity=(int)(Math.random()*100 + 1);
		return empty+quantity;
	}
	
	public static String randomVisa() {
		String empty="4";
		for(int i=0;i<15;i++) {
			empty+=(int)(Math.random()*10);
		}
		return empty;
	}
	public static String randomMaster() {
		String empty="5";
		for(int i=0;i<15;i++) {
			empty+=(int)(Math.random()*10);
		}
		return empty;
	}
	public static String randomAmex() {
		String empty="3";
		for(int i=0;i<14;i++) {
			empty+=(int)(Math.random()*10);
		}
		return empty;
	}

	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver", "/Users/furkanozturk/Documents/SeleniumFiles/Drivers/chromedriver");
		
	WebDriver driver = new ChromeDriver();
	driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester");
	driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]")).sendKeys("test");
	driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]")).sendKeys(randomQuantity());
	driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).sendKeys("John" +randomStr()+ "Doe");
	driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")).sendKeys("8607 Westwood Center Dr");
	driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]")).sendKeys("Vienna");
	driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]")).sendKeys("Virginia");
	driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]")).sendKeys(randomZip());
	
	WebElement visa = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]"));
	WebElement master = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]"));
	WebElement amex = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_2\"]"));
	
	if(randomNo()==1) {visa.click();}
	else if(randomNo()==2) {master.click();}
	else {amex.click();}
	
	WebElement cardNo = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"));
	
	if(randomNo()==1) {cardNo.sendKeys(randomVisa());}
	else if(randomNo()==2) {cardNo.sendKeys(randomMaster());}
	else {cardNo.sendKeys(randomAmex());}
	
	
	driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).sendKeys("01/21");
	driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();
	
	if(driver.getPageSource().contains("New order has been successfully added")) {
		System.out.println("TEST PASSED");
	}
	else System.out.println("TEST FAILED");
	
	
	
		
		
		
		
		
		
		
		

	}

}
