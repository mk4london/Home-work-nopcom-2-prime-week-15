package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase
{
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod (alwaysRun = true)
    public void setUp()
    {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test (groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToRegisterPage()
    {
        homePage.clickOnRegisterLink();
        String expectedMessage = "Register";
        String actualMessage = registerPage.getWelcomeText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test (groups = {"smoke","regression"})
    public void verifyUserShouldNotRegisterWithInvalidData()
    {
        homePage.clickOnRegisterLink();
        registerPage.clickOnGender();
        registerPage.clickOnRegisterButton();
        String expectedMessage = "First name is required.";
        String actualMessage = registerPage.getErrorMessage();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test (groups = {"regression"})
    public void verifyUserShouldRegisterSuccessfully()
    {
        homePage.clickOnRegisterLink();
        registerPage.clickOnGender();
        registerPage.enterFirstName("Michel");
        registerPage.enterLastName("Richmond");
        registerPage.selectDateOfBirth("13","5","1990");
        registerPage.enterEmail("test@gmail.com");
        registerPage.enterPassword("Abcd123");
        registerPage.enterConfirmPassword("Abcd123");
        registerPage.clickOnRegisterButton();
        String expectedMessage = "Your registration completed";
        String actualMessage = registerPage.getRegisterMessage();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}