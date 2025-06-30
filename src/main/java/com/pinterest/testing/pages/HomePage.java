package com.pinterest.testing.pages;
import com.codeborne.selenide.Condition;
import com.pinterest.testing.elements.Button;

import static com.codeborne.selenide.Selenide.$x;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    public HomePage() {
        super($x("//div[contains(@data-test-id, 'header')]"));
    }
    private final Button openPinCreationButton = new Button(ElementHelper.byXpathPublic("//*[@id=\"VerticalNavContent\"]/div/div/div[1]/div[4]/div/div/div/a"));
    public void openPinCreation() {
        logger.info("Открытие страницы создания пина");
        openPinCreationButton.click();
    }
}
