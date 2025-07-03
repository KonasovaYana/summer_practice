package com.pinterest.testing.elements;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseElement {

    public boolean isDisplayed(String phrase) {
        logger.info("Проверям появление фразы: {}", phrase);
        try {
            base.shouldBe(Condition.visible, Duration.ofSeconds(8));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final SelenideElement base;

    protected BaseElement(SelenideElement element) {
        this.base = element;
    }

    protected SelenideElement getElement() {return base;}

    protected static SelenideElement byXpath(String xpath) {
        return $x(xpath);
    }

}