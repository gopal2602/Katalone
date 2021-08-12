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

def baseURL = GlobalVariable.baseURL
def loginusername = GlobalVariable.LoginEmail
def loginpassword = GlobalVariable.LoginPassword
try{
	'Launch the Browser'
	WebUI.openBrowser('', FailureHandling.STOP_ON_FAILURE)
	'Navigate into the Application URL'
	WebUI.callTestCase(findTestCase('CommonActions/NavigateURL'), [('baseURL') : baseURL], FailureHandling.STOP_ON_FAILURE)
	WebUI.verifyElementAttributeValue(findTestObject('Object Repository/LoginLogout/txtloginemail'), 'id', 'student_email', 10)
	'Login into the Application '
	WebUI.callTestCase(findTestCase('CommonActions/SignIn'), [('loginemail') : loginusername, ('password') : loginpassword ], FailureHandling.STOP_ON_FAILURE)
	TestObject homepage= CustomKeywords. 'common.util.gowrikeywords.getTestObject'("xpath", "//h1[text()='Welcome To ']")
	WebUI.verifyElementPresent(homepage, 10)
	'Navigate to Create New Company Page'
	WebUI.callTestCase(findTestCase('CommonActions/NavigateCompanies'), [:], FailureHandling.STOP_ON_FAILURE)
	'Create Company with all mandatory fields'
	WebUI.callTestCase(findTestCase('CommonActions/CreateCompany'), [('companyname') : 'demoCompany', ('companyemail') : 'demoCompany@gmail.com',
		('companyphone') : '9777097770', ('companyaddress') : '10th Main,12th Cross Hampinagar'], FailureHandling.STOP_ON_FAILURE)
	TestObject userstatus= CustomKeywords. 'common.util.gowrikeywords.getTestObject'("xpath", "//p[@id='notice']")
	WebUI.verifyElementText(userstatus, "Company was successfully created.")
	'Modify company with all mandatory fields'
	WebUI.callTestCase(findTestCase('CommonActions/ModifyCompany'), [('companyname') : 'NewdemoCompany', ('companyemail') : 'NewdemoCompany@gmail.com',
		('companyphone') : '9777097779', ('companyaddress') : 'New 10th Main,12th Cross Hampinagar'], FailureHandling.STOP_ON_FAILURE)
	TestObject usereditstatus= CustomKeywords. 'common.util.gowrikeywords.getTestObject'("xpath", "//p[@id='notice']")
	WebUI.verifyElementText(usereditstatus, "Company was successfully updated.")
	'Delete the Company permenately'
	WebUI.callTestCase(findTestCase('CommonActions/DeleteCompany'), [:], FailureHandling.STOP_ON_FAILURE)
	TestObject userdeletestatus= CustomKeywords. 'common.util.gowrikeywords.getTestObject'("xpath", "//p[@id='notice']")
	WebUI.verifyElementText(userdeletestatus, "Company was successfully destroyed.")
}catch(Exception e){
	assert false
}finally {
	'Logout from Application'
	WebUI.callTestCase(findTestCase('CommonActions/SignOut'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)
}