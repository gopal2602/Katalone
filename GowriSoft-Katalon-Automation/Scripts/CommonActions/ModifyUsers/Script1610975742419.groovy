import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.click(findTestObject('Object Repository/Common/lnkedit'), FailureHandling.STOP_ON_FAILURE)
WebUI.clearText(findTestObject('Object Repository/Users/txtfirstname'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Users/txtfirstname'), firstname, FailureHandling.STOP_ON_FAILURE)
WebUI.clearText(findTestObject('Object Repository/Users/txtlastname'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Users/txtlastname'), lastname, FailureHandling.STOP_ON_FAILURE)
WebUI.clearText(findTestObject('Object Repository/Users/txtuseremail'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Users/txtuseremail'), email, FailureHandling.STOP_ON_FAILURE)
WebUI.clearText(findTestObject('Object Repository/Users/txtuserphone'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Users/txtuserphone'), phonenumber, FailureHandling.STOP_ON_FAILURE)
WebUI.clearText(findTestObject('Object Repository/Users/txtuseraddress'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Users/txtuseraddress'), address, FailureHandling.STOP_ON_FAILURE)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Users/selectuserstate'), state, true, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Users/selectuserstate'), state, true, 10, FailureHandling.STOP_ON_FAILURE)
WebUI.clearText(findTestObject('Object Repository/Users/txtuserzipcode'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Users/txtuserzipcode'), zipcode, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Common/btnupdateuser'), FailureHandling.STOP_ON_FAILURE)