package managers;
 
import org.openqa.selenium.WebDriver;

import Pages.AddAgentPage;
import Pages.AddAgentTellerPage;
import Pages.AddBeneficiaryPage;
import Pages.AddCollectionPointPage;
import Pages.AddDeliveryBankBranchPage;
import Pages.AddDeliveryBankPage;
import Pages.AddDestinationCountryPage;
import Pages.AddMemberBeneficiaryPage;
import Pages.AddProcessingBankPage;
import Pages.AddRemitterPage;
import Pages.AddSourceCountryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PreferencesPage;
import Pages.ProfilePage;
import Pages.QuickRegistrationPage;
import Pages.SendMoneyProcessPage;
import Pages.SetDestinationConversionRate;
import Pages.SetSourceCoversionRatesPage;
import TestContext.TestContext;


public class PageObjectManager {
 
	private WebDriver driver;
 
	private HomePage homePage;
 
	private LoginPage loginPage;
	
	private PreferencesPage preferencesPage;
	
	private AddSourceCountryPage addSourceCountryPage;
	
	private AddDestinationCountryPage addDestinationCountryPage;
	
	private SetSourceCoversionRatesPage setSourceCoversionRatesPage;
	
	private SetDestinationConversionRate setDestinationConversionRate;
	
	private AddDeliveryBankPage addDeliveryBankPage;
	
	private AddCollectionPointPage addCollectionPointPage;
	
	private AddProcessingBankPage addProcessingBankPage;
	
	private AddAgentTellerPage addAgentTellerPage;
	
	private QuickRegistrationPage quickRegistrationPage;
 
	private AddAgentPage addAgentPage;
	
	private SendMoneyProcessPage sendMoneyProcessPage;
	
	private AddDeliveryBankBranchPage addDeliveryBankBranchPage;
	
	private AddRemitterPage addRemitterPage;
	private ProfilePage profilePage;
	private AddBeneficiaryPage addBeneficiaryPage;
	
	private AddMemberBeneficiaryPage addMemberBeneficiaryPage;
	

	public PageObjectManager(WebDriver driver) {
 
		this.driver = driver;
 
	}
 
	
 
	public HomePage getHomePage(TestContext testContext){
 
		return (homePage == null) ? homePage = new HomePage(driver,testContext) : homePage;
 
	}
	
	public LoginPage getLoginPage(TestContext testContext){
		 
		return (loginPage == null) ? loginPage = new LoginPage(driver,testContext) : loginPage;
 
	}
	
	public PreferencesPage getPreferencesPage(TestContext testContext){
		 
		return (preferencesPage == null) ? preferencesPage = new PreferencesPage(driver,testContext) : preferencesPage;
 
	}
	
	public AddSourceCountryPage getAddSourceCountryPage(TestContext testContext){
		 
		return (addSourceCountryPage == null) ? addSourceCountryPage = new AddSourceCountryPage(driver,testContext) : addSourceCountryPage;
 
	}
	
	public AddDestinationCountryPage getAddDestinationCountryPage(TestContext testContext){
		 
		return (addDestinationCountryPage == null) ? addDestinationCountryPage = new AddDestinationCountryPage(driver,testContext) : addDestinationCountryPage;
 
	}
	
	
	public SetSourceCoversionRatesPage getSetSourceConversionRatesPage(TestContext testContext){
		 
		return (setSourceCoversionRatesPage == null) ? setSourceCoversionRatesPage = new SetSourceCoversionRatesPage(driver,testContext) : setSourceCoversionRatesPage;
 
	}
	
	
	public SetDestinationConversionRate getSetDestinationConversionRatesPage(TestContext testContext){
		 
		return (setDestinationConversionRate == null) ? setDestinationConversionRate = new SetDestinationConversionRate(driver,testContext) : setDestinationConversionRate;
 
	}
	
	
	
	
	public AddDeliveryBankPage getAddDeliveryBankPage(TestContext testContext){
		 
		return (addDeliveryBankPage == null) ? addDeliveryBankPage = new AddDeliveryBankPage(driver,testContext) : addDeliveryBankPage;
 
	}
	
	public AddCollectionPointPage getAddCollectionPointPage(TestContext testContext){
		 
		return (addCollectionPointPage == null) ? addCollectionPointPage = new AddCollectionPointPage(driver,testContext) : addCollectionPointPage;
 
	}
	
	public AddProcessingBankPage getAddProcessingBankPage(TestContext testContext){
		 
		return (addProcessingBankPage == null) ? addProcessingBankPage = new AddProcessingBankPage(driver,testContext) : addProcessingBankPage;
 
	}
	
	public AddAgentTellerPage getaddAgentTellerPage(TestContext testContext){
		 
		return (addAgentTellerPage == null) ? addAgentTellerPage = new AddAgentTellerPage(driver,testContext) : addAgentTellerPage;
 
	}
	
	public QuickRegistrationPage getQuickRegistrationPage(TestContext testContext){
		 
		return (quickRegistrationPage == null) ? quickRegistrationPage = new QuickRegistrationPage(driver,testContext) : quickRegistrationPage;
 
	}
	
	public AddAgentPage getAddAgentPage(TestContext testContext){
		 
		return (addAgentPage == null) ? addAgentPage = new AddAgentPage(driver,testContext) : addAgentPage;
 
	}
	
	
	public AddRemitterPage getAddRemitterPage(TestContext testContext){
		 
		return (addRemitterPage == null) ? addRemitterPage = new AddRemitterPage(driver,testContext) : addRemitterPage;
 
	}
	
	public AddMemberBeneficiaryPage getAddMemberBeneficiaryPage(TestContext testContext){
		 
		return (addMemberBeneficiaryPage == null) ? addMemberBeneficiaryPage = new AddMemberBeneficiaryPage(driver,testContext) : addMemberBeneficiaryPage;
 
	}
	
	
	public ProfilePage getProfilePage(TestContext testContext){
		 
		return (profilePage == null) ? profilePage = new ProfilePage(driver,testContext) : profilePage;
 
	}
	
	
	public AddBeneficiaryPage getAddBeneficiaryPage(TestContext testContext){
		 
		return (addBeneficiaryPage == null) ? addBeneficiaryPage = new AddBeneficiaryPage(driver,testContext) : addBeneficiaryPage;
 
	}
	
	public SendMoneyProcessPage getSendMoneyProcessPage(TestContext testContext){
		 
		return (sendMoneyProcessPage == null) ? sendMoneyProcessPage = new SendMoneyProcessPage(driver,testContext) : sendMoneyProcessPage;
 
	}
	
	
	public AddDeliveryBankBranchPage getAddDeliveryBankBranchPage(TestContext testContext){
		 
		return (addDeliveryBankBranchPage == null) ? addDeliveryBankBranchPage = new AddDeliveryBankBranchPage(driver,testContext) : addDeliveryBankBranchPage;
 
	}
	

	
	

}