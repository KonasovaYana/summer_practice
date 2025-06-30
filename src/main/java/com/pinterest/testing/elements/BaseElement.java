package com.pinterest.testing.elements;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;

public class BaseElement {
    protected final SelenideElement base;
    protected BaseElement(SelenideElement element) {
        this.base = element;
    }
    public boolean isDisplayed() {
        try {
            base.shouldBe(Condition.visible, Duration.ofSeconds(4));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    protected static SelenideElement byXpath(String xpath) {
        return $x(xpath);
    }
    protected SelenideElement getElement() {return base;}
}
