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
	'Navigate to Create New User Page'
	WebUI.callTestCase(findTestCase('CommonActions/NavigateUsers'), [:], FailureHandling.STOP_ON_FAILURE)
	TestObject newuser= CustomKeywords. 'common.util.gowrikeywords.getTestObject'("xpath", "//h1[text()='New User']")
	WebUI.verifyElementPresent(newuser, 10)
	'Create User with all mandatory fields'
	WebUI.callTestCase(findTestCase('CommonActions/CreateUsers'), [('firstname') : 'demo', ('lastname') : 'User1',
		('email') : 'demoUser1@gmail.com', ('phonenumber') : '9888098880', ('address') : '8th Main,19th Cross,Vijayanagara',
		 ('state') : 'Karnataka', ('zipcode') : '560027'], FailureHandling.STOP_ON_FAILURE)
	TestObject userstatus= CustomKeywords. 'common.util.gowrikeywords.getTestObject'("xpath", "//p[@id='notice']")
	WebUI.verifyElementText(userstatus, "User was successfully created.")
	'Modify User with all manadatory fields'
	WebUI.callTestCase(findTestCase('CommonActions/ModifyUsers'), [('firstname') : 'Newdemo', ('lastname') : 'NewUser1',
		('email') : 'NewdemoUser1@gmail.com', ('phonenumber') : '9888098889', ('address') : 'New 8th Main,19th Cross,Vijayanagara',
		 ('state') : 'Karnataka', ('zipcode') : '584128'], FailureHandling.STOP_ON_FAILURE)
	TestObject usereditstatus= CustomKeywords. 'common.util.gowrikeywords.getTestObject'("xpath", "//p[@id='notice']")
	WebUI.verifyElementText(usereditstatus, "User was successfully updated.")
	'Delete the User permenately'
	WebUI.callTestCase(findTestCase('CommonActions/DeleteUsers'), [:], FailureHandling.STOP_ON_FAILURE)
	TestObject userdeletestatus= CustomKeywords. 'common.util.gowrikeywords.getTestObject'("xpath", "//p[@id='notice']")
	WebUI.verifyElementText(userdeletestatus, "User was successfully destroyed.")
}catch(Exception e){
	assert false
}finally {
	'Logout from Application'
	WebUI.callTestCase(findTestCase('CommonActions/SignOut'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)
}