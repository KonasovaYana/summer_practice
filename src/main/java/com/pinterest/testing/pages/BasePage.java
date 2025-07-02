package com.pinterest.testing.pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    public BasePage(SelenideElement baseType) {
        this.baseType = baseType;
    }

    protected final SelenideElement baseType;

    protected static SelenideElement byDataTestId(String partialId) {
        String xpath = String.format("//div[contains(@data-test-id, '%s')]", partialId);
        return $x(xpath);
    }

}
