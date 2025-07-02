package com.pinterest.testing.elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codeborne.selenide.SelenideElement;

public class FileInput extends BaseElement {

    public FileInput(SelenideElement element) {
        super(element);
    }

    public void upload(String pathInClasspath) {
        logger.info("Загрузка изображения: {}", pathInClasspath);
        getElement().uploadFromClasspath(pathInClasspath);
    }

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static FileInput byFileInputTypeCreate(String phrase) {
        String xpath = "//input[@type='" + phrase + "']";
        return new FileInput(BaseElement.byXpath(xpath));
    }

    public static FileInput byXpathCreate(String xpath) {
        return new FileInput(BaseElement.byXpath(xpath));
    }
}