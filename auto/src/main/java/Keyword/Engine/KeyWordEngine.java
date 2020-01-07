package Keyword.Engine;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.*;

import Base.Base;

public class KeyWordEngine {

	public WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	public static Workbook book;
	public static Sheet sheet;

	public Base base;
	public WebElement element;

	public final String SCENARIO_SHEET_PATH = "C:\\Selenium setup\\Workspace\\auto\\src\\main\\java\\Scenarios\\Scenarios.xlsx";

	public void startExecution(String sheetName) {

		String result = "Pass";

		FileInputStream file = null;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet output_sheet = workbook.createSheet("Output");

		try {
			file = new FileInputStream(SCENARIO_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {

			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		base = new Base();
		int k = 0; // k is for the column

		// output sheet creation

		Row header = output_sheet.createRow(0);
		Cell col1 = header.createCell(k);
		col1.setCellValue("TestID");
		Cell col2 = header.createCell(k + 1);
		col2.setCellValue("Test Step");
		Cell col3 = header.createCell(k + 2);
		col3.setCellValue("Result");
		Cell col4 = header.createCell(k + 3);
		col4.setCellValue("Exception");

		Boolean notEmpty = false;
		Actions mouse;

		System.out.println("last row count" + sheet.getLastRowNum());

		// Looping through the sheet

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			Row row = output_sheet.createRow(i + 1);
			try {
				String testID = sheet.getRow(i + 1).getCell(k).toString().trim();
				if (testID != null && testID != "")
					notEmpty = true;
				Cell cell = row.createCell(k);
				cell.setCellValue(testID);
				String teststep = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
				Cell cell1 = row.createCell(k + 1);
				cell1.setCellValue(teststep);

				// String locator = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
				String locatorType = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
				String locatorValue = sheet.getRow(i + 1).getCell(k + 3).toString().trim();
				String Action = sheet.getRow(i + 1).getCell(k + 4).toString().trim();
				String value = sheet.getRow(i + 1).getCell(k + 5).toString().trim();
				String expType = sheet.getRow(i + 1).getCell(k + 6).toString().trim();
				String expValue = sheet.getRow(i + 1).getCell(k + 7).toString().trim();

				// String expectedValue = null;

				if (!locatorType.equals("NA")) {

					mouse = new Actions(driver);

					switch (locatorType) {
					case "id":
						element = driver.findElement(By.id(locatorValue));
						if (Action.equalsIgnoreCase("sendkeys")) {
							Thread.sleep(500);
							element.clear();
							element.sendKeys(value);
						} else if (Action.equalsIgnoreCase("click")) {
							// js.executeScript("arguments[0].scrollIntoView(true);", element);
							element.click();
						} else if (Action.equalsIgnoreCase("isDisplayed")) {
							element.isDisplayed();
						} else if (Action.equalsIgnoreCase("getText")) {
							String elementText = element.getText();
							System.out.println("text from element : " + elementText);
						} else if (Action.equalsIgnoreCase("Select")) {
							element.click();
							mouse.moveToElement(element).perform();
							Select sel = new Select(element);
							sel.selectByVisibleText(value.trim());
						} else if (Action.equalsIgnoreCase("wait"))
							wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
						  else if (Action.equalsIgnoreCase("compare Text")) {
							compareText(element, expValue);
						  } else if (Action.equalsIgnoreCase("compare WebElement text")) {
							  compareElementText(element,expType,expValue);
							  
						  }	else if (Action.equalsIgnoreCase("compare WebElement value")) {
							  compareElementValue(element,expType,expValue);
						  }
						  
						
						  
						locatorType = null;
						break;

					case "name":
						element = driver.findElement(By.name(locatorValue));
						if (Action.equalsIgnoreCase("sendkeys")) {
							element.clear();
							element.sendKeys(value);
						} else if (Action.equalsIgnoreCase("click")) {
							// js.executeScript("arguments[0].scrollIntoView(true);", element);
							element.click();
						} else if (Action.equalsIgnoreCase("isDisplayed")) {
							element.isDisplayed();
						} else if (Action.equalsIgnoreCase("getText")) {
							String elementText = element.getText();
							System.out.println("text from element : " + elementText);
						} else if (Action.equalsIgnoreCase("Select")) {
							element.click();
							mouse.moveToElement(element).perform();
							Select sel = new Select(element);
							sel.selectByVisibleText(value.trim());
						} else if (Action.equalsIgnoreCase("wait"))
							wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
						else if (Action.equalsIgnoreCase("compare Text")) {
							compareText(element, expValue);
						  } else if (Action.equalsIgnoreCase("compare WebElement text")) {
							  compareElementText(element,expType,expValue);
							  
						  }	else if (Action.equalsIgnoreCase("compare WebElement value")) {
							  compareElementValue(element,expType,expValue);
						  }
						locatorType = null;
						break;

					case "xpath":
						element = driver.findElement(By.xpath(locatorValue));
						System.out.print("Inside the xpath case");
						if (Action.equalsIgnoreCase("sendkeys")) {
							Thread.sleep(200);
							element.click();
							element.sendKeys(value);
						} else if (Action.equalsIgnoreCase("click")) {
							Thread.sleep(200);
							element.click();
						} else if (Action.equalsIgnoreCase("isDisplayed")) {
							element.isDisplayed();
						} else if (Action.equalsIgnoreCase("getText")) {
							Thread.sleep(200);
							String elementText = element.getText();
							System.out.println("text from element : " + elementText);
						} else if (Action.equalsIgnoreCase("Select")) {
							Thread.sleep(500);
							element.click();
							mouse.moveToElement(element).perform();
							Select sel = new Select(element);
							sel.selectByVisibleText(value.trim());
						} else if (Action.equalsIgnoreCase("compareText")) {
							Thread.sleep(500);
							if (!(value.equalsIgnoreCase(element.getText()))) {
								throw new MyException("Values mismatch");
							}
						}else if (Action.equalsIgnoreCase("compare Text")) {
							compareText(element, expValue);
						  } else if (Action.equalsIgnoreCase("compare WebElement text")) {
							  compareElementText(element,expType,expValue);
							  
						  }	else if (Action.equalsIgnoreCase("compare WebElement value")) {
							  compareElementValue(element,expType,expValue);
						  }
						locatorType = null;
						break;

					case "cssSelector":
						element = driver.findElement(By.cssSelector(locatorValue));
						if (Action.equalsIgnoreCase("sendkeys")) {
							element.clear();
							element.sendKeys(value);
						} else if (Action.equalsIgnoreCase("click")) {
							// js.executeScript("arguments[0].scrollIntoView(true);", element);
							element.click();
						} else if (Action.equalsIgnoreCase("isDisplayed")) {
							element.isDisplayed();
						} else if (Action.equalsIgnoreCase("getText")) {
							String elementText = element.getText();
							System.out.println("text from element : " + elementText);
						} else if (Action.equalsIgnoreCase("Select")) {
							element.click();
							mouse.moveToElement(element).perform();
							Select sel = new Select(element);
							sel.selectByVisibleText(value.trim());
						} else if (Action.equalsIgnoreCase("wait"))
							wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
						else if (Action.equalsIgnoreCase("compare Text")) {
							compareText(element, expValue);
						  } else if (Action.equalsIgnoreCase("compare WebElement text")) {
							  compareElementText(element,expType,expValue);
							  
						  }	else if (Action.equalsIgnoreCase("compare WebElement value")) {
							  compareElementValue(element,expType,expValue);
						  }
						locatorType = null;
						break;

					case "className":
						element = driver.findElement(By.className(locatorValue));
						if (Action.equalsIgnoreCase("sendkeys")) {
							element.clear();
							element.sendKeys(value);
						} else if (Action.equalsIgnoreCase("click")) {
							// js.executeScript("arguments[0].scrollIntoView(true);", element);
							Thread.sleep(300);
							element.click();
						} else if (Action.equalsIgnoreCase("isDisplayed")) {
							element.isDisplayed();
						} else if (Action.equalsIgnoreCase("getText")) {
							String elementText = element.getText();
							System.out.println("text from element : " + elementText);
						} else if (Action.equalsIgnoreCase("Select")) {
							Thread.sleep(500);
							Select dropdown = new Select(element);
							dropdown.selectByVisibleText(value);
						} else if (Action.equalsIgnoreCase("wait"))
							wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
						else if (Action.equalsIgnoreCase("compare Text")) {
							compareText(element, expValue);
						  } else if (Action.equalsIgnoreCase("compare WebElement text")) {
							  compareElementText(element,expType,expValue);
							  
						  }	else if (Action.equalsIgnoreCase("compare WebElement value")) {
							  compareElementValue(element,expType,expValue);
						  }
						locatorType = null;
						break;

					case "linkText":
						element = driver.findElement(By.linkText(locatorValue));
						element.click();
						locatorType = null;
						break;

					case "partialLinkText":
						element = driver.findElement(By.partialLinkText(locatorValue));
						element.click();
						locatorType = null;
						break;

					default:
						break;

					}
				}

				else {
					switch (Action) {
					case "open browser":
						prop = base.init_properties();
						if (value.isEmpty() || value.equals("NA")) {
							driver = base.init_driver(prop.getProperty("browser"));
							System.out.print("open browser" + value);
						} else {
							System.out.print("open browser" + value);
							driver = base.init_driver(value);
						}
						break;

					case "enter url":
						if (value.isEmpty() || value.equals("NA")) {
							driver.get(prop.getProperty("url"));
						} else {
							driver.get(value);
						}
						break;

					case "quit":
						driver.quit();
						break;

					default:
						break;
					}

					wait = new WebDriverWait(driver, 30);

				}

				Cell res = row.createCell(k + 2);
				res.setCellValue("PASS");

			} catch (Exception e) {
				e.printStackTrace();
				if (notEmpty == true) {
					Cell fail = row.createCell(k + 2);
					fail.setCellValue("FAIL");

					Cell excep = row.createCell(k + 3);
					excep.setCellValue(e.getMessage());
				}
			}

		}
		try {
			FileOutputStream out = new FileOutputStream(
					new File("C:\\Selenium setup\\Workspace\\auto\\target\\output.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Output generated successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	//compares plain text
	public void compareText(WebElement element, String val) throws MyException {
		if (!(element.getText().equalsIgnoreCase(val))) {
			throw new MyException("text does not match");
		}
	}

	
	
	
	//compares text in a webElement
	public void compareElementText(WebElement element, String type, String val) throws MyException {
		if (type.equalsIgnoreCase("WebElement with ID")) {
			WebElement element2 = driver.findElement(By.id(val));
			if (!(element.getText().equalsIgnoreCase(element2.getText()))) {
				throw new MyException("Text does not match");
			}
		}

		else if (type.equalsIgnoreCase("WebElement with xpath")) {
			WebElement element2 = driver.findElement(By.xpath(val));
			if (!(element.getText().equalsIgnoreCase(element2.getText()))) {
				throw new MyException("Text does not match");
			}
		}

		else if (type.equalsIgnoreCase("WebElement with cssSelector")) {
			WebElement element2 = driver.findElement(By.cssSelector(val));
			if (!(element.getText().equalsIgnoreCase(element2.getText()))) {
				throw new MyException("Text does not match");
			}
		}

		else if (type.equalsIgnoreCase("WebElement with name")) {
			WebElement element2 = driver.findElement(By.name(val));
			if (!(element.getText().equalsIgnoreCase(element2.getText()))) {
				throw new MyException("Text does not match");
			}
		}

		else if (type.equalsIgnoreCase("WebElement with className")) {
			WebElement element2 = driver.findElement(By.className(val));
			if (!(element.getText().equalsIgnoreCase(element2.getText()))) {
				throw new MyException("Text does not match");
			}
		}

		else if (type.equalsIgnoreCase("WebElement with linkText")) {
			WebElement element2 = driver.findElement(By.linkText(val));
			if (!(element.getText().equalsIgnoreCase(element2.getText()))) {
				throw new MyException("Text does not match");
			}
		}

		else if (type.equalsIgnoreCase("WebElement with partialLinkText")) {
			WebElement element2 = driver.findElement(By.partialLinkText(val));
			if (!(element.getText().equalsIgnoreCase(element2.getText()))) {
				throw new MyException("Text does not match");
			}
		}
	}
	
	public void compareElementValue(WebElement element, String type, String val) throws MyException {
		if (type.equalsIgnoreCase("WebElement with ID")) {
			WebElement element2 = driver.findElement(By.id(val));
			if (!(Integer.parseInt(element.getText())==(Integer.parseInt(element2.getText())))) {
				throw new MyException("Value doesn't match");
			}
		}
		
		else if (type.equalsIgnoreCase("WebElement with xpath")) {
			WebElement element2 = driver.findElement(By.xpath(val));
			if (!(Integer.parseInt(element.getText())==(Integer.parseInt(element2.getText())))) {
				throw new MyException("Value doesn't match");
			}
		}
		
		else if (type.equalsIgnoreCase("WebElement with cssSelector")) {
			WebElement element2 = driver.findElement(By.cssSelector(val));
			if (!(Integer.parseInt(element.getText())==(Integer.parseInt(element2.getText())))) {
				throw new MyException("Value doesn't match");
			}
		}
		
		else if (type.equalsIgnoreCase("WebElement with name")) {
			WebElement element2 = driver.findElement(By.name(val));
			if (!(Integer.parseInt(element.getText())==(Integer.parseInt(element2.getText())))) {
				throw new MyException("Value doesn't match");
			}
		}
		
		else if (type.equalsIgnoreCase("WebElement with className")) {
			WebElement element2 = driver.findElement(By.className(val));
			if (!(Integer.parseInt(element.getText())==(Integer.parseInt(element2.getText())))) {
				throw new MyException("Value doesn't match");
			}
		}
		
		else if (type.equalsIgnoreCase("WebElement with linkText")) {
			WebElement element2 = driver.findElement(By.linkText(val));
			if (!(Integer.parseInt(element.getText())==(Integer.parseInt(element2.getText())))) {
				throw new MyException("Value doesn't match");
			}
		}
		
		else if (type.equalsIgnoreCase("WebElement with partialLinkText")) {
			WebElement element2 = driver.findElement(By.partialLinkText(val));
			if (!(Integer.parseInt(element.getText())==(Integer.parseInt(element2.getText())))) {
				throw new MyException("Value doesn't match");
			}
		}
		
	}
}
