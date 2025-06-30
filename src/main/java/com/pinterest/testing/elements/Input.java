package com.pinterest.testing.elements;

import com.codeborne.selenide.SelenideElement;

public class Input extends BaseElement {

    public static Input createByXpath(String xpath) {
        return new Input(BaseElement.byXpath(xpath));
    }

    public Input(SelenideElement element) {
        super(element);
    }

    public void setValue(String value) {
        getElement().setValue(value);
    }

    public String getValue() {
        return getElement().getValue();
    }

    public void clear() {
        getElement().clear();
    }

}

