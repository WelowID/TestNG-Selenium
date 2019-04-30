package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends LoginBasePage {

    //*********Constructor*********
    public ProjectPage(WebDriver driver) { super(driver); }

    //*********WebElements*********
    private By flashNoticeBy = By.id("flash_notice");

    //*********PageMethods*********
    public ProjectPage verifyCreatedProjectNotice(String noticeMessage) {
        assertEquals(flashNoticeBy, noticeMessage);
        return this;
    }
}
