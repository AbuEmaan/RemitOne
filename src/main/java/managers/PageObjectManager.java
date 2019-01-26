package managers;
 
import org.openqa.selenium.WebDriver;

import PageObjects.ARM.AddAgentTellerPage;
import PageObjects.ARM.AddCollectionPointPage;
import PageObjects.ARM.AddDeliveryBankPage;
import PageObjects.ARM.AddDestinationCountryPage;
import PageObjects.ARM.AddProcessingBankPage;
import PageObjects.ARM.AddRemitterPage;
import PageObjects.ARM.AddSourceCountryPage;
import PageObjects.ARM.HomePage;
import PageObjects.ARM.LoginPage;
import PageObjects.ARM.PreferencesPage;
import PageObjects.ARM.SetDestinationConversionRate;
import PageObjects.ARM.SetSourceCoversionRatesPage;
import PageObjects.ARM.AddAgentPage;
import PageObjects.ARM.ORM.QuickRegistrationPage;
import PageObjects.ARM.ORM.ProfilePage;
import PageObjects.ARM.ORM.AddBeneficiaryPage;




 
 
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
	
	private AddRemitterPage addRemitterPage;
	private ProfilePage profilePage;
	private AddBeneficiaryPage addBeneficiaryPage;
	

	public PageObjectManager(WebDriver driver) {
 
		this.driver = driver;
 
	}
 
	
 
	public HomePage getHomePage(){
 
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
 
	}
	
	public LoginPage getLoginPage(){
		 
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
 
	}
	
	public PreferencesPage getPreferencesPage(){
		 
		return (preferencesPage == null) ? preferencesPage = new PreferencesPage(driver) : preferencesPage;
 
	}
	
	public AddSourceCountryPage getAddSourceCountryPage(){
		 
		return (addSourceCountryPage == null) ? addSourceCountryPage = new AddSourceCountryPage(driver) : addSourceCountryPage;
 
	}
	
	public AddDestinationCountryPage getAddDestinationCountryPage(){
		 
		return (addDestinationCountryPage == null) ? addDestinationCountryPage = new AddDestinationCountryPage(driver) : addDestinationCountryPage;
 
	}
	
	
	public SetSourceCoversionRatesPage getSetSourceConversionRatesPage(){
		 
		return (setSourceCoversionRatesPage == null) ? setSourceCoversionRatesPage = new SetSourceCoversionRatesPage(driver) : setSourceCoversionRatesPage;
 
	}
	
	
	public SetDestinationConversionRate getSetDestinationConversionRatesPage(){
		 
		return (setDestinationConversionRate == null) ? setDestinationConversionRate = new SetDestinationConversionRate(driver) : setDestinationConversionRate;
 
	}
	
	
	
	
	public AddDeliveryBankPage getAddDeliveryBankPage(){
		 
		return (addDeliveryBankPage == null) ? addDeliveryBankPage = new AddDeliveryBankPage(driver) : addDeliveryBankPage;
 
	}
	
	public AddCollectionPointPage getAddCollectionPointPage(){
		 
		return (addCollectionPointPage == null) ? addCollectionPointPage = new AddCollectionPointPage(driver) : addCollectionPointPage;
 
	}
	
	public AddProcessingBankPage getAddProcessingBankPage(){
		 
		return (addProcessingBankPage == null) ? addProcessingBankPage = new AddProcessingBankPage(driver) : addProcessingBankPage;
 
	}
	
	public AddAgentTellerPage getaddAgentTellerPage(){
		 
		return (addAgentTellerPage == null) ? addAgentTellerPage = new AddAgentTellerPage(driver) : addAgentTellerPage;
 
	}
	
	public QuickRegistrationPage getQuickRegistrationPage(){
		 
		return (quickRegistrationPage == null) ? quickRegistrationPage = new QuickRegistrationPage(driver) : quickRegistrationPage;
 
	}
	
	public AddAgentPage getAddAgentPage(){
		 
		return (addAgentPage == null) ? addAgentPage = new AddAgentPage(driver) : addAgentPage;
 
	}
	
	
	public AddRemitterPage getAddRemitterPage(){
		 
		return (addRemitterPage == null) ? addRemitterPage = new AddRemitterPage(driver) : addRemitterPage;
 
	}
	
	
	public ProfilePage getProfilePage(){
		 
		return (profilePage == null) ? profilePage = new ProfilePage(driver) : profilePage;
 
	}
	
	
	public AddBeneficiaryPage getAddBeneficiaryPage(){
		 
		return (addBeneficiaryPage == null) ? addBeneficiaryPage = new AddBeneficiaryPage(driver) : addBeneficiaryPage;
 
	}
	
	
	
	
	

}