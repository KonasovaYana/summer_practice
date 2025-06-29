package com.pinterest.testing.pages;
import com.codeborne.selenide.Condition;
import com.pinterest.testing.elements.Button;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {
    public HomePage() {
        super($x("//div[contains(@data-test-id, 'header')]"));
    }
    private final Button openPinCreationButton = new Button(ElementHelper.byXpathPublic("//*[@id=\"VerticalNavContent\"]/div/div/div[1]/div[4]/div/div/div/a"));
    public void openPinCreation() {
        openPinCreationButton.click();
    }
}
