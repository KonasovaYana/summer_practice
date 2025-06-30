package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;

import static com.codeborne.selenide.Selenide.$x;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    public HomePage() {
        super($x("//div[contains(@data-test-id, 'header')]"));
    }
    private final Button openPinCreationButton = Button.createByXpath("//a[@data-test-id=\"create-tab\" and @href=\"/pin-creation-tool/\"]");
    public void openPinCreation() {
        logger.info("Открытие страницы создания пина");
        openPinCreationButton.click();
    }
    private final Button openAccountPageButton = Button.createByXpath("//a[@aria-label=\"Профиль\" and @href=\"/sellithu/\"]");
    public void openAccountPage() {
        logger.info("Открытие страницы ваших сохраненных идей");
        openAccountPageButton.click();
    }
}
