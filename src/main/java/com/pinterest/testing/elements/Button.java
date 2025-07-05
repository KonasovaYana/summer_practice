package com.pinterest.testing.elements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс для работы с кнопками на веб-странице.
 * Наследует функциональность BaseElement и предоставляет дополнительные методы
 * для поиска и взаимодействия с различными типами кнопок.
 */
public class Button extends BaseElement {

    /**
     * Логгер для записи сообщений
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Конструктор для создания экземпляра кнопки на основе Selenide элемента.
     * @param element Selenide элемент, представляющий кнопку
     */
    public Button(SelenideElement element) {
        super(element);
    }

    /**
     * Выполняет клик по кнопке с логированием действия.
     * @param elementName Название кнопки для логирования
     */
    public void click(String elementName) {
        logger.info("Нажатие на кнопку: {}", elementName);
        base.click();
    }

    /**
     * Создает кнопку, найденную по XPath выражению.
     * @param xpath XPath выражение для поиска кнопки
     * @return новый экземпляр Button
     */
    public static Button byXpathCreate(String xpath) {
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по тексту в XPath.
     * @param phrase Текст для поиска в XPath
     * @return новый экземпляр Button
     */
    public static Button byPhraseInXpathCreate(String phrase) {
        String xpath = String.format(".//div[text()='%s']", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по тексту внутри элемента button.
     * @param phrase Текст для поиска внутри кнопки
     * @return новый экземпляр Button
     */
    public static Button byButtonPhraseInXpathCreate(String phrase) {
        String xpath = String.format("//button[.//div[text()='%s']]", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по типу button.
     * @param phrase Тип кнопки (например, "submit")
     * @return новый экземпляр Button
     */
    public static Button byButtonTypeCreate(String phrase) {
        String xpath = String.format("//button[@type='%s']", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по частичному совпадению текста.
     * @param phrase Часть текста для поиска
     * @return новый экземпляр Button
     */
    public static Button byTextContainCreate(String phrase) {
        String xpath = String.format("//*[contains(text(), '%s')]", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по ID и ссылке.
     * @param phrase1 ID элемента
     * @param phrase2 Ссылка элемента
     * @return новый экземпляр Button
     */
    public static Button byIdAndHrefCreate(String phrase1, String phrase2) {
        String xpath = String.format("//a[@data-test-id='%s' and @href='%s']", phrase1, phrase2);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по ID и метке.
     * @param phrase1 ID элемента
     * @param phrase2 Метка элемента (aria-label)
     * @return новый экземпляр Button
     */
    public static Button byIdAndLabelCreate(String phrase1, String phrase2) {
        String xpath = String.format("//div[@data-test-id=\"%s\"]//a[@aria-label=\"%s\"]", phrase1, phrase2);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по метке (aria-label).
     * @param phrase Метка кнопки
     * @return новый экземпляр Button
     */
    public static Button byAriaLabelCreate(String phrase) {
        String xpath = String.format("//button[@aria-label='%s']", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по ID кнопки.
     * @param phrase ID кнопки
     * @return новый экземпляр Button
     */
    public static Button byButtonIdCreate(String phrase) {
        String xpath = String.format("//button[@data-test-id='%s']", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по ID элемента.
     * @param phrase ID элемента
     * @return новый экземпляр Button
     */
    public static Button byIdCreate(String phrase) {
        String xpath = String.format("//*[@id='%s']", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по роли элемента.
     * @param phrase Роль элемента
     * @return новый экземпляр Button
     */
    public static Button byRoleCreate(String phrase) {
        String xpath = String.format("(//div[@role='%s'])[1]//a", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по ID элемента grid.
     * @param phrase ID элемента grid
     * @return новый экземпляр Button
     */
    public static Button byGridIdCreate(String phrase) {
        String xpath = String.format("//div[@data-grid-item-idx='%s']//img", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по заголовку h2.
     * @param phrase Заголовок элемента
     * @return новый экземпляр Button
     */
    public static Button byHTitleCreate(String phrase) {
        String xpath = String.format("//h2[@title='%s']", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по роли и классу элемента.
     * @param phrase1 Роль элемента
     * @param phrase2 Класс элемента
     * @return новый экземпляр Button
     */
    public static Button byRoleContainsCreate(String phrase1, String phrase2) {
        String xpath = String.format("(//div[@role=\"%s\" and contains(@class, \"%s\")])[1]", phrase1, phrase2);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по ID div элемента.
     * @param phrase ID div элемента
     * @return новый экземпляр Button
     */
    public static Button byDivIdCreate(String phrase) {
        String xpath = String.format("//div[@data-test-id='%s']", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по тексту span элемента.
     * @param phrase Текст span элемента
     * @return новый экземпляр Button
     */
    public static Button bySpanTextCreate(String phrase) {
        String xpath = String.format("//span[text()='%s']", phrase);
        return new Button(BaseElement.byXpath(xpath));
    }

    /**
     * Создает кнопку по ID и частичному совпадению текста.
     * @param phrase1 ID элемента
     * @param phrase2 Часть текста для поиска
     * @return новый экземпляр Button
     */
    public static Button byIdAndContainsCreate(String phrase1, String phrase2) {
        String xpath = String.format("//div[@data-test-id=\"%s\"]//span[contains(text(), \"%s\")]", phrase1, phrase2);
        return new Button(BaseElement.byXpath(xpath));
    }
}