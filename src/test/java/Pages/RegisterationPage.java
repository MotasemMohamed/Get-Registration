package Pages;

import base.PageBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterationPage extends PageBase {

    public RegisterationPage(WebDriver Loginddriver) throws ClassNotFoundException {
        super(Loginddriver);
    }
    WebDriverWait wait = new WebDriverWait(driver, WAIT);
    Faker fakerdata= new Faker();
    String FakeFirstName = String.valueOf(fakerdata.name().firstName());
    String FakeLastName = String.valueOf(fakerdata.name().lastName());
    String FakerPhone = fakerdata.number().digits(10);
    int FakerCountryCode = fakerdata.random().nextInt(252) + 1;
    int Coursecode = fakerdata.random().nextInt(6) + 1;
    int Monthcode = fakerdata.random().nextInt(11) ;
    int SocialMediacode = fakerdata.random().nextInt(6);
    String Username = fakerdata.name().username();
    String EmailData = fakerdata.internet().emailAddress(Username);
  String PasswordData = fakerdata.internet().password(6, 7, true, true)
            .concat(fakerdata.regexify("[A-Z]")).concat(fakerdata.regexify("[a-z]"));
    public void Filldata() throws InterruptedException {
        WebElement FirstName=driver.findElement(By.id("firstname"));
        String FinalFakeFirstName= FakeFirstName.substring(0,1).toUpperCase()+ FakeFirstName.substring(1);
        WebElement LastName=driver.findElement(By.id("last_name"));
        String FinalFakeLastName= FakeLastName.substring(0,1).toUpperCase()+ FakeLastName.substring(1);
        Boolean F= Boolean.valueOf(FakeFirstName.substring(0,1));
        Boolean L= Boolean.valueOf(FakeLastName.substring(0,1));

            if (F=L)
            {
            String FakeFirstName = String.valueOf(fakerdata.name().firstName());
            String FakeLastName = String.valueOf(fakerdata.name().lastName());
            String FinalFakeFirstName2= FakeFirstName.substring(0,1).toUpperCase()+ FakeFirstName.substring(1);
            String FinalFakeLastName2= FakeLastName.substring(0,1).toUpperCase()+ FakeLastName.substring(1);
            Boolean F2= Boolean.valueOf(FakeFirstName.substring(0,1));
            Boolean L2= Boolean.valueOf(FakeLastName.substring(0,1));
                FinalFakeFirstName=FinalFakeFirstName2;
                FinalFakeLastName=FinalFakeLastName2;
            }

            SendData(FirstName, FinalFakeFirstName);
            SendData(LastName, FinalFakeLastName);
            WebElement Phone=driver.findElement(By.id("phone"));
            WebElement Country=driver.findElement(By.xpath("//*[@class='btn dropdown-toggle bs-placeholder btn-light']"));
            clickButton(Country);
        WebElement Countrydropdownlist=driver.findElement(By.id("bs-select-1-"+FakerCountryCode));
        clickButton(Countrydropdownlist);
        SendData(Phone, FakerPhone);
        WebElement Email=driver.findElement(By.id("email"));
        SendData(Email, EmailData);
        WebElement Password=driver.findElement(By.id("password"));
        SendData(Password, PasswordData);
        WebElement Submit=driver.findElement(By.id("submitBTN"));
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        scrollDownPagebbydimention(250);
       // scrollDownPageUntleFound(driver.findElement(By.cssSelector("div.signup_button")));
       //scrollDownToBottom();
        waitForVisibility(Submit);
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));   //This line is used to select captch
        Thread.sleep(1000);
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border"))).click();
       // driver.switchTo().frame(4);
       // waitelementToBeInvisible(driver.findElement(By.cssSelector("div.rc-imageselect-payload")));
       // waitelementToBeClickable(driver.findElement(By.cssSelector("div.signup_button")));
        clickButton2(Submit);
        // Thread.sleep(2000);
        //new WebDriverWait(driver, 55).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'c-') and starts-with(@src, 'https://www.google.com/recaptcha/api2/bframe?hl=en&v=iZWPJyR27lB0cR4hL_xOX0GC&k=6LdX3JoUAAAAAFCG5tm0MFJaCF3LKxUN4pVusJIF')]")));
        //new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border")));
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.book-canceled"))));
       //Assert.assertEquals(driver.findElement(By.cssSelector("div.book-canceled")).getText(),"تم إلغاء موعدك");
    }

    public void Filldata2()
    {
        WebElement FirstName=driver.findElement(By.id("nf-field-17"));
        String FinalFakeFirstName= FakeFirstName.substring(0,1).toUpperCase()+ FakeFirstName.substring(1);
        WebElement LastName=driver.findElement(By.id("nf-field-18"));
        String FinalFakeLastName= FakeLastName.substring(0,1).toUpperCase()+ FakeLastName.substring(1);
        //Boolean F= Boolean.valueOf(FakeFirstName.substring(0,1));
        //Boolean L= Boolean.valueOf(FakeLastName.substring(0,1));
        Boolean F= Boolean.valueOf(FakeFirstName);
        Boolean L= Boolean.valueOf(FakeLastName);
        if (F=L)
        {
            String FakeFirstName = String.valueOf(fakerdata.name().firstName());
            String FakeLastName = String.valueOf(fakerdata.name().lastName());
            String FinalFakeFirstName2= FakeFirstName.substring(0,1).toUpperCase()+ FakeFirstName.substring(1);
            String FinalFakeLastName2= FakeLastName.substring(0,1).toUpperCase()+ FakeLastName.substring(1);
            Boolean F2= Boolean.valueOf(FakeFirstName.substring(0,1));
            Boolean L2= Boolean.valueOf(FakeLastName.substring(0,1));
            FinalFakeFirstName=FinalFakeFirstName2;
            FinalFakeLastName=FinalFakeLastName2;
        }
        SendData(FirstName, FinalFakeFirstName);
        SendData(LastName, FinalFakeLastName);
        WebElement Email=driver.findElement(By.id("nf-field-19"));
        SendData(Email, EmailData);
        WebElement Phone=driver.findElement(By.id("nf-field-20"));
        SendData(Phone, FakerPhone);
        clickButton(driver.findElement(By.id("nf-field-22"))); //Coursedropdownlist
        clickButton(driver.findElement(By.xpath("(//select[@id=\"nf-field-22\"]/option )["+Coursecode+"]")));  //Coursedropdownlistdata
        Select Monthdropdownlist= new Select(driver.findElement(By.id("nf-field-24")));
        Monthdropdownlist.selectByIndex(Monthcode);
        scrollDownPageUntleFound(driver.findElement(By.id("nf-label-field-23")));
        clickButton(driver.findElement(By.id("nf-label-class-field-23-"+SocialMediacode)));
        WebElement RegisterBtn=driver.findElement(By.id("nf-field-15"));
        scrollDownPageUntleFound(RegisterBtn);
        clickButton(RegisterBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Processing']")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//input[@value='Processing']"))));
        Assert.assertEquals("Training Registration Form", driver.findElement(By.xpath("(//div/h2)[2]")).getText());
    }
}