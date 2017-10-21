package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {

    WebDriver driver;

    public By logo = By.cssSelector("#header > div > h1 > a > img");
    public By homeLink = By.cssSelector("#navbar-collapse > ul > li.active.nav-item > a");
    public By aboutLink = By.cssSelector("#navbar-collapse > ul > li:nth-child(2) > a");
    public By introHeader = By.cssSelector("#who > div > h2");
    public String introText = "Who We Are";
    public By skilledTeamHeader = By.cssSelector("#who > div > div > div:nth-child(1) > div > h3");
    public String skilledTeamHeaderText = "Skilled Team";
    public By skilledTeamElement = By.cssSelector("#who > div > div > div:nth-child(1) > div > div.desc > p");
    public String skilledTeamText = "We partner with health systems to make their digital experiences relevant, intuitive, and actionable.";
    public By flexibleApproachTitle = By.cssSelector("#who > div > div > div.item.col-md-3.col-sm-6.col-xs-12.sm-break > div > h3");
    public String flexibleApproachTitleText = "Flexible Approach";
    public By flexibleApproachDescription = By.cssSelector("#who > div > div > div.item.col-md-3.col-sm-6.col-xs-12.sm-break > div > div.desc > p");
    public String flexibleApproachDescriptionText = "We understand the unique challenges that healthcare organizations face. Our team brings the skills necessary to work in this challenging environment and combines them with an unrivaled agility and flexibility. The result is healthcare technology done right.";
    public By partnerTitle = By.cssSelector("#who > div > div > div:nth-child(3) > div > h3");
    public String partnerTitleText = "We Are Your Partner";
    public By partnerDescription = By.cssSelector("#who > div > div > div:nth-child(3) > div > div.desc > p");
    public String partnerDescriptionText = "Our collaboration doesn’t end once we cross the finish line. We continue to stand by our work long after delivery. You are more than a client, you are a partner.";
    public By fastTitle = By.cssSelector("#who > div > div > div:nth-child(4) > div > h3");
    public String fastTitleText = "Fast and Direct";
    public By fastDescription = By.cssSelector("#who > div > div > div:nth-child(4) > div > div.desc > p");
    public String fastDescriptionText = "No jargon or run around from us. Our team is efficient and straightforward in delivering the best possible experience in the most direct way possible.";
    public String LinkedInLink = "https://www.linkedin.com/company/pluralstack";

    public homePage(WebDriver driver) {
        this.driver = driver;
    }
}
