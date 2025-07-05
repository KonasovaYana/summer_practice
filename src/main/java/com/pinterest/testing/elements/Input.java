package com.pinterest.testing.elements;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс для работы с элементами ввода (input fields) на веб-страницах.
 * Наследует функциональность BaseElement и предоставляет методы
 * для взаимодействия с различными типами полей ввода.
 */
public class Input extends BaseElement {

    /**
     * Конструктор для создания экземпляра элемента ввода.
     * @param element Selenide элемент, представляющий поле ввода
     */
    public Input(SelenideElement element) {
        super(element);
    }

    public void click(String elementName) {
        logger.info("Нажатие на поле: {}", elementName);
        base.click();
    }
    /**
     * Устанавливает значение в поле ввода с логированием действия.
     * @param fieldName Название поля для логирования
     * @param value Значение, которое нужно установить в поле
     */
    public void setValue(String fieldName, String value) {
        logger.info("Заполнение поля '{}': {}", fieldName, value);
        getElement().setValue(value);
    }

    /**
     * Имитирует нажатие клавиши Enter в поле ввода.
     */
    public void pressEnter() {
        getElement().pressEnter();
    }

    /**
     * Логгер для записи сообщений о действиях с полем ввода
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Создает элемент ввода по атрибуту name.
     * @param phrase Значение атрибута name
     * @return новый экземпляр Input
     */
    public static Input byInputNameCreate(String phrase) {
        String xpath = "//input[@name='" + phrase + "']";
        return new Input(BaseElement.byXpath(xpath));
    }

    /**
     * Создает элемент ввода по ID элемента.
     * @param phrase ID элемента
     * @return новый экземпляр Input
     */
    public static Input byIdCreate(String phrase) {
        String xpath = "//*[@id='" + phrase + "']";
        return new Input(BaseElement.byXpath(xpath));
    }

    /**
     * Создает элемент ввода по атрибуту aria-label.
     * @param phrase Значение атрибута aria-label
     * @return новый экземпляр Input
     */
    public static Input byAriaLabelCreate(String phrase) {
        String xpath = "//input[@aria-label='" + phrase + "']\n";
        return new Input(BaseElement.byXpath(xpath));
    }

    /**
     * Создает элемент ввода по ID input элемента.
     * @param phrase ID input элемента
     * @return новый экземпляр Input
     */
    public static Input byInputIdCreate(String phrase) {
        String xpath = "//input[@id='" + phrase + "']";
        return new Input(BaseElement.byXpath(xpath));
    }

    /**
     * Создает элемент ввода по атрибуту aria-label div элемента.
     * @param phrase Значение атрибута aria-label
     * @return новый экземпляр Input
     */
    public static Input byDivAriaCreate(String phrase) {
        String xpath = "//div[@aria-label='" + phrase + "']";
        return new Input(BaseElement.byXpath(xpath));}

    /**
     * Создает элемент ввода по ID и атрибуту contenteditable.
     * @param phrase1 ID родительского элемента
     * @param phrase2 Значение атрибута contenteditable
     * @return новый экземпляр Input
     */
    public static Input byIdAndContentCreate(String phrase1, String phrase2) {
        String xpath = "//div[@id=\"" + phrase1 + "\"]//div[@contenteditable=\"" + phrase2 + "\"]" ;
        return new Input(BaseElement.byXpath(xpath));
    }
}