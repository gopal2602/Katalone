package common.util

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.WebDriver;
import com.kms.katalon.core.webui.driver.DriverFactory
import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.testobject.ConditionType

public class gowrikeywords {

	/**
	 * SwitchTo alert
	 */
	@Keyword
	public static void switchToAlert() {
		WebDriver oBrowser = DriverFactory.getWebDriver();
		oBrowser.switchTo().alert().accept();
	}

	/**
	 * Click on Element
	 */
	public static void gowriClick(TestObject to) {
		WebElement element;
		try {
			element = WebUiCommonHelper.findWebElement(findTestObject(to),10)
			WebUI.executeJavaScript('arguments[0].click()', element)
		}catch(Exception e) {
			String message = "Fail to click on Object : " + to.toString() + "\n"
			String testElement = "Test Element : " +  element.toString() + "\n\n"
			String stacktrace = "Stack Trace : " + e.toString() + "\n\n"
			KeywordUtil.markFailedAndStop(message + testElement + stacktrace)
		}
	}

	/**
	 * Get TestObject  
	 * @return TestObject
	 */
	public static TestObject getTestObject(String selectorType, String selectorValue) {
		try {
			TestObject to = new TestObject()
			to.addProperty(selectorType, ConditionType.EQUALS, selectorValue)
			return to
		}catch(Exception e) {
			String stacktrace = "Stack Trace : " + e.toString() + "\n\n"
			KeywordUtil.markFailedAndStop(stacktrace)
		}
	}
}
