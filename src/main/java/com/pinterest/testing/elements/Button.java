package com.pinterest.testing.elements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Button extends BaseElement {

    public Button(SelenideElement element) {
        super(element);
    }

    public void click(String elementName) {
        logger.info("Нажатие на кнопку: {}", elementName);
        base.click();
    }

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static Button byXpathCreate(String xpath) {
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byPhraseInXpathCreate(String phrase) {
        String xpath = ".//div[text()='" + phrase + "']";
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byButtonPhraseInXpathCreate(String phrase) {
        String xpath = "//button[.//div[text()='" + phrase + "']]";
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byButtonTypeCreate(String phrase) {
        String xpath = "//button[@type='" + phrase + "']";
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byTextContainCreate(String phrase) {
        String xpath = "//*[contains(text(), '" + phrase + "')]";
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byIdAndHrefCreate(String phrase1, String phrase2) {
        String xpath = "//a[@data-test-id='" + phrase1 + "' and @href='" + phrase2 + "']" ;
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byIdAndLabelCreate(String phrase1, String phrase2) {
        String xpath = "//div[@data-test-id=\"" + phrase1 + "\"]//a[@aria-label=\"" + phrase2 + "\"]" ;
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byAriaLabelCreate(String phrase) {
        String xpath = "//button[@aria-label='" + phrase + "']\n";
        return new Button(BaseElement.byXpath(xpath));
    }
    public static Button byButtonIdCreate(String phrase) {
        String xpath = "//button[@data-test-id='" + phrase + "']\n";
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byIdCreate(String phrase) {
        String xpath = "//*[@id='" + phrase + "']";
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byRoleCreate(String phrase) {
        String xpath = "(//div[@role='" + phrase + "'])[1]//a\n";
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byGridIdCreate(String phrase) {
        String xpath = "//div[@data-grid-item-idx='" + phrase + "']//img";
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byHTitleCreate(String phrase) {
        String xpath = "//h2[@title='" + phrase + "']";
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byRoleContainsCreate(String phrase1, String phrase2) {
        String xpath = "(//div[@role=\"" + phrase1 + "\" and contains(@class, \"" + phrase2 + "\")])[1]" ;
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byDivIdCreate(String phrase) {
        String xpath = "//div[@data-test-id='" + phrase + "']";
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button bySpanTextCreate(String phrase) {
        String xpath = "//span[text()='" + phrase + "']";
        return new Button(BaseElement.byXpath(xpath));
    }

    public static Button byIdAndContainsCreate(String phrase1, String phrase2) {
        String xpath = "//div[@data-test-id=\"" + phrase1 + "\"]//span[contains(text(), \"" + phrase2 + "\")]" ;
        return new Button(BaseElement.byXpath(xpath));}
}