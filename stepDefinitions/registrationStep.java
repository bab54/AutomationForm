package stepDefinitions;

import PageObject.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class registrationStep {
    public RegistrationPage registrationPage;
    public static WebDriver driver;
    @Given("i navigate to the website")
    public void iNavigateToTheWebsite() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
      //  driver.get("https://blueskycitadel.com/automation-form/");
        driver.manage().window().maximize();
        registrationPage = new RegistrationPage(driver);
        registrationPage.OpenUrl();
        //test
    }

    @And("i enter my first name {string}")
    public void iEnterMyFirstName(String firstName) {
      //  driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_0\"]")).sendKeys(firstName);
            registrationPage.EnterFirstName(firstName);
    }

    @And("i enter my last name {string}")
    public void iEnterMyLastName(String lastName) {
       // driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_0-last\"]")).sendKeys(lastName);
        registrationPage.EnterLastName(lastName);

    }

    @And("i enter my email Address {string}")
    public void iEnterMyEmailAddress(String email) {
        registrationPage.EnterEmail(email);

       // driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_1\"]")).sendKeys(email);
    }
    @And("i enter my height {string}")
    public void iEnterMyHeight(String height) {
        driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_6\"]")).sendKeys(height);


    }

    @And("i select that i am a vegan")
    public void iSelectThatIAmAVegan() {
        Select dropDown = new Select( driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_7\"]")));
        //dropDown = driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_7\"]"));
        dropDown.selectByValue("No");
    }

    @And("i enter which state city and country i am in {string}")
    public void iEnterWhichStateCityAndCountryIAmIn(String city) {
        driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_8\"]")).sendKeys(city);
    }

    @And("i select how long i have been searching for a job")
    public void iSelectHowLongIHaveBeenSearchingForAJob() {
        Select dropDowN = new Select(driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_9\"]")));
        dropDowN.selectByValue("1 year- 2 years");
    }

    @And("i enter a describtion of my favoriite hobbies and interest {string}")
    public void iEnterADescribtionOfMyFavoriiteHobbiesAndInterest(String hobbies) {
        driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_10\"]")).sendKeys(hobbies);
    }

    @And("i select my choice course")
    public void iSelectMyChoiceCourse() {
        driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_11\"]/li[3]/label")).click();
       
    }


    @And("i click on cookie")
    public void iClickOnCookie() {
      //  driver.findElement(By.xpath(driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_12_2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"cn-accept-cookie\"]")).click();
    }
    @And("i choose my career progression")
    public void iChooseMyCareerProgression() {

        driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_12_2\"]")).click();

    }

    @And("i select what days work best for me")
    public void iSelectWhatDaysWorkBestForMe() {
        driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_17\"]/li[1]/label")).click();
    }

    @And("i select what time works best")
    public void iSelectWhatTimeWorksBest() {
        driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_14\"]/li[1]/label")).click();
    }

    @And("i select my favorite music")
    public void iSelectMyFavoriteMusic() {
        driver.findElement(By.xpath("//*[@id=\"wpforms-2082-field_15\"]/li[1]/label")).click();


    }

    @When("i click on submit button")
    public void iClickOnSubmitButton() {
        driver.findElement(By.xpath("//*[@id=\"wpforms-submit-2082\"]")).click();
    }





    @Then("i should be registered with message {string}")
    public void iShouldBeRegisteredWithMessage(String validationMessage) {
        Assert.assertEquals(validationMessage,driver.findElement(By.xpath("//*[@id=\"wpforms-confirmation-2082\"]/p")).getText());
    }
}
