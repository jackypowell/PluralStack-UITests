package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import pages.*;


public class PluralStackUITests {

    static WebDriver driver;
    static homePage homePage;

    @BeforeAll
    public static void Setup() {
        //TODO: make driver and url configurable
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://pluralstack.io/");
        homePage = new homePage(driver);
    }

    @AfterAll
    public static void Teardown() {
        driver.close();
    }

    @BeforeEach
    public void GotoHomePage() {
        driver.get("http://pluralstack.io/");
    }

    @Test
    public void VerifyLogoIsDisplayed() {
        assertTrue(driver.findElement(homePage.logo).isDisplayed());
    }

    @Test
    public void VerifyHomeLinkIsDisplayed() {
        assertTrue(driver.findElement(homePage.homeLink).isDisplayed());
    }

    @Test
    public void VerifyAboutLinkIsDisplayed() {
        assertTrue(driver.findElement(homePage.aboutLink).isDisplayed());
    }

    @Test
    public void VerifyIntoText() {
        assertTrue(driver.findElement(homePage.introHeader).getText().equals(homePage.introText));
    }

    @Test
    public void VerifySkilledTeamHeaderText() {
        assertTrue(driver.findElement(homePage.skilledTeamHeader).getText().equals(homePage.skilledTeamHeaderText));
    }

    @Test
    public void VerifySkilledTeamText() {
        assertTrue(driver.findElement(homePage.skilledTeamElement).getText().equals(homePage.skilledTeamText));
    }

    @Test
    public void ApproachTitleText() {
        assertTrue(driver.findElement(homePage.flexibleApproachTitle).getText().equals(homePage.flexibleApproachTitleText));
    }

    @Test
    public void VerifyFlexibleApproachDescription() {
        assertTrue(driver.findElement(homePage.flexibleApproachDescription).getText().equals(homePage.flexibleApproachDescriptionText));
    }

    @Test
    public void VerifyPartnerTitleText() {
        assertTrue(driver.findElement(homePage.partnerTitle).getText().equals(homePage.partnerTitleText));
    }

    @Test
    public void VerifyPartnerDescription() {
        assertTrue(driver.findElement(homePage.partnerDescription).getText().equals(homePage.partnerDescriptionText));
    }

    @Test
    public void VerifyFastTitleText() {
        assertTrue(driver.findElement(homePage.fastTitle).getText().equals(homePage.fastTitleText));
    }

    @Test
    public void VerifyFastDescriptionText() {
        assertTrue(driver.findElement(homePage.fastDescription).getText().equals(homePage.fastDescriptionText));
    }

    @Test
    public void VerifyManagingDirectorName() {
        aboutPage aboutPage = new aboutPage(driver);
        assertTrue(driver.findElement(aboutPage.managingDirectorName).getText().equals(aboutPage.managingDirectorNameText));
    }

    @Test
    public void VerifyManagingDirectorDescription() {
        aboutPage aboutPage = new aboutPage(driver);
        assertTrue(driver.findElement(aboutPage.managingDirectorDescription).getText().equals(aboutPage.managingDirectorDescriptionText));
    }

    @Test
    public void VerifyStatusCodeForLinks() throws IOException {

        //TODO: remove duplicate links from the list
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement element : links) {

            String link = element.getAttribute("href");

            //ignore mailto and tel links
            if (link.contains(("http"))) {
                //hack to ignore the LinkedIn status 999 issue
                if(!link.equals(homePage.LinkedInLink)) {
                    System.out.println(link + " : StatusCode: " + GetHTTPResponseStatusCode(link));
                    assertEquals(200, GetHTTPResponseStatusCode(link));
                }
                else{ assertEquals(homePage.LinkedInLink, link); }
            }
        }
    }

    private int GetHTTPResponseStatusCode(String url) throws IOException {
        HttpURLConnection http = (HttpURLConnection) new URL(url).openConnection();
        return http.getResponseCode();
    }
}