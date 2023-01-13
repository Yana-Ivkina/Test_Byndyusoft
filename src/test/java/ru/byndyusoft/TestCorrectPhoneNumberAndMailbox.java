package ru.byndyusoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static ru.byndyusoft.Browser.getDriver;
import static org.junit.Assert.assertEquals;

public class TestCorrectPhoneNumberAndMailbox {

    private WebDriver driver;

    @Before
    public void startUp() {
        this.driver = getDriver(BrowserName.Chrome);
    }

    @Test
    public void checkMailInOrderPresentationButton() {
        driver.get("https://www.google.com");
        PageObjects element = new PageObjects(driver);
        element.writeWorldInSearchGoogle("Byndyusoft");
        element.clickOnFirstLinks();
        element.scrollToYellowButton();
        element.clickOnYellowButton();
        String actualMail = element.getNameMailboxInButtonOrderPresentation();
        assertEquals(actualMail, "sales@byndyusoft.com");
    }

    @After
    public void teardown() {
        driver.close();
    }
}
