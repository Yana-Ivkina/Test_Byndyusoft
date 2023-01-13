package ru.byndyusoft;

import org.openqa.selenium.*;

import java.util.List;

public class PageObjects {

    private final WebDriver driver;

    public PageObjects(WebDriver driver) {
        this.driver = driver;
    }

    private final By fieldSearchGoogle = By.name("q");
    private final By linksOnFirstPageGoogle = By.xpath(".//div[@class='yuRUbf']/a");
    private final By buttonOrderPresentation = By.xpath(".//div[@class='know-more__container']/span");
    private final By fieldNameMailbox = By.xpath(".//a[contains(text(), 'sales@byndyusoft.com')]");

    public void writeWorldInSearchGoogle(String world) {
        WebElement searchString = driver.findElement(fieldSearchGoogle);
        searchString.sendKeys(world);
        searchString.sendKeys(Keys.ENTER);
    }

    public void clickOnFirstLinks() {
        List<WebElement> webElementList = driver.findElements(linksOnFirstPageGoogle);
        webElementList.get(0).click();
    }

    public void scrollToYellowButton() {
        WebElement element = driver.findElement(buttonOrderPresentation);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOnYellowButton() {
        driver.findElement(buttonOrderPresentation).click();
    }

    public String getNameMailboxInButtonOrderPresentation() {
        return driver.findElement(fieldNameMailbox).getText();
    }
}
