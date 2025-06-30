package com.pinterest.testing.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BaseElement {
    protected final SelenideElement base;
    protected BaseElement(SelenideElement element) {
        this.base = element;
    }
    public boolean isDisplayed() {
        return base.isDisplayed();
    }
    protected static SelenideElement byXpath(String xpath) {
        return $x(xpath);
    }
    protected SelenideElement getElement() {return base;}
}
