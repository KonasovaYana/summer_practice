package com.pinterest.testing.elements;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Input extends BaseElement {

    public Input(SelenideElement element) {
        super(element);
    }

    public void setValue(String fieldName, String value) {
        logger.info("Заполнение поля '{}': {}", fieldName, value);
        getElement().setValue(value);
    }

    public void pressEnter() {
        getElement().pressEnter();
    }

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static Input byXpathCreate(String xpath) {return new Input(BaseElement.byXpath(xpath));}

    public static Input byInputNameCreate(String phrase) {
        String xpath = "//input[@name='" + phrase + "']";
        return new Input(BaseElement.byXpath(xpath));
    }

    public static Input byIdCreate(String phrase) {
        String xpath = "//*[@id='" + phrase + "']";
        return new Input(BaseElement.byXpath(xpath));
    }

    public static Input byAriaLabelCreate(String phrase) {
        String xpath = "//input[@aria-label='" + phrase + "']\n";
        return new Input(BaseElement.byXpath(xpath));
    }

    public static Input byInputIdCreate(String phrase) {
        String xpath = "//input[@id='" + phrase + "']";
        return new Input(BaseElement.byXpath(xpath));
    }

    public static Input byDivAriaCreate(String phrase) {
        String xpath = "//div[@aria-label='" + phrase + "']";
        return new Input(BaseElement.byXpath(xpath));}

    public static Input byIdAndContentCreate(String phrase1, String phrase2) {
        String xpath = "//div[@id=\"" + phrase1 + "\"]//div[@contenteditable=\"" + phrase2 + "\"]" ;
        return new Input(BaseElement.byXpath(xpath));
    }
}