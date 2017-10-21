package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class aboutPage {

    //BUG: Dan Roths image is too large (6.9MB) and causes slow page load times...

    WebDriver driver;

    public By aboutLink = By.cssSelector("#navbar-collapse > ul > li:nth-child(2) > a");
    public By managingDirectorDescription = By.cssSelector("#team > div > div > div:nth-child(1) > div > div.row > div > p");
    public String managingDirectorDescriptionText = "Dan is an established leader with over 20 years of experience in software development leadership. Dan has a passion for creating software that solves an organization's toughest problems.";
    public By managingDirectorName = By.cssSelector("#team > div > div > div:nth-child(1) > div > div.row > div > h3");
    public String managingDirectorNameText = "Daniel Roth";

    public aboutPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(aboutLink).click();
    }
}
