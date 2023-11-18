package selenium_practice2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Assignment {
	static WebDriver driver;
	@BeforeMethod
	public void Init (){

		// Defined ChromeDriver Path
		System.setProperty("WebDriver.Chrome.driver", "D:\\Selenium\\chromedriver117.exe");
		driver = new ChromeDriver();
		//invoke URL
		driver.get(" https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
		//Maximize Page
		driver.manage().window().maximize();
	}
		//==============================================================================
	@Test
public void tableValidate() throws InterruptedException {
	
		//Click on TableData button
		driver.findElement(By.xpath("//summary[text()='Table Data']")).click();		
		
		//clear old data 
		driver.findElement(By.id("jsondata")).clear();	
		
		//find element of input box  
		WebElement inputTextBox = driver.findElement(By.id("jsondata")) ;
      
		// Insert data into table
		inputTextBox.sendKeys("[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]");
		//click on refresh Button
		driver.findElement(By.xpath("//button[@id='refreshtable']")).click();
 
	}
			public void testInsertAndVerifyData() {
	        // Insert Data
	        WebElement inputField = driver.findElement(By.id("jsondata"));
	        inputField.sendKeys("[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
	        		+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
	        		+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]");

	        // Perform actions to insert data and update the table

	        // Retrieve Table Data
	        WebElement tableCell = driver.findElement(By.xpath("//table[@id='dtable']/tbody/tr"));
	        
	        
	        
	        String tableData = tableCell.getText();

	        // Assertions
	        String insertedData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
	        		+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
	        		+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";
	        Assert.assertEquals(tableData, insertedData, "Inserted data is not matching table data");
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
}


