package com.pinterest.testing.pages;

import com.codeborne.selenide.SelenideElement;
import com.pinterest.testing.elements.BaseElement;

public class ElementHelper extends BaseElement {

    public ElementHelper(SelenideElement element) {
        super(element);
    }
    public static SelenideElement byXpathPublic(String xpath) {
        return byXpath(xpath);
    }
}
