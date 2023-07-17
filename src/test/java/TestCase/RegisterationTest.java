package TestCase;

import Pages.RegisterationPage;
import base.TestBase;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;

@Feature("Register new user")
public class RegisterationTest extends TestBase {


    @Test(description = "Add new user")
    public void Dispatsh() throws InterruptedException, ClassNotFoundException {
        RegisterationPage object= new RegisterationPage(driver);
        object.Filldata2();
        }
}