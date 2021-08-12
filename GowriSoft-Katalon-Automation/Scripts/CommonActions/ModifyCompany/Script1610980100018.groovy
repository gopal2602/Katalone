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
WebUI.clearText(findTestObject('Object Repository/Companies/txtcompanyname'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Companies/txtcompanyname'), companyname, FailureHandling.STOP_ON_FAILURE)
WebUI.clearText(findTestObject('Object Repository/Companies/txtcompanyemail'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Companies/txtcompanyemail'), companyemail, FailureHandling.STOP_ON_FAILURE)
WebUI.clearText(findTestObject('Object Repository/Companies/txtcompanyphonenumber'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Companies/txtcompanyphonenumber'), companyphone, FailureHandling.STOP_ON_FAILURE)
WebUI.clearText(findTestObject('Object Repository/Companies/txtcompanyaddress'), FailureHandling.STOP_ON_FAILURE)
WebUI.setText(findTestObject('Object Repository/Companies/txtcompanyaddress'), companyaddress, FailureHandling.STOP_ON_FAILURE)
WebUI.submit(findTestObject('Object Repository/Companies/btnupdatecompany'), FailureHandling.STOP_ON_FAILURE)