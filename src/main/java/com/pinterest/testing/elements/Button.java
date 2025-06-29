package com.pinterest.testing.elements;

import com.codeborne.selenide.SelenideElement;

public class Button extends BaseElement {
    public Button(SelenideElement element) {
        super(element);
    }

    public void click() {
        base.click();
    }

    public void clickIfVisible() {
        if (base.isDisplayed()) base.click();
    }
}
