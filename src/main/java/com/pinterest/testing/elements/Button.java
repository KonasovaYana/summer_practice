package com.pinterest.testing.elements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;

public class Button extends BaseElement {

    public static Button createByXpath(String xpath) {
        return new Button(BaseElement.byXpath(xpath));
    }
    public Button(SelenideElement element) {
        super(element);
    }

    public boolean has(WebElementCondition condition) {
        return base.has(condition);
    }
    public void click() {
        base.click();
    }
}

