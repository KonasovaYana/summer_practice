package com.pinterest.testing.elements;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Базовый класс для работы с элементами веб-страницы.
 * Предоставляет общие методы для проверки видимости элементов и работы с xpath.
 */
public class BaseElement {

    /**
     * Проверяет, отображается ли элемент на странице в течение заданного времени.
     * @param phrase Текстовая фраза, которая логируется для отладки
     * @return true если элемент отображается, false если элемент не стал видимым в течение таймаута
     */
    public boolean isDisplayed(String phrase) {
        logger.info("Проверям появление фразы: {}", phrase);
        try {
            base.shouldBe(Condition.visible, Duration.ofSeconds(8));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Логгер для записи сообщений
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Базовый элемент Selenide, с которым работает данный класс
     */
    protected final SelenideElement base;

    /**
     * Конструктор базового элемента.
     * @param element Selenide элемент, который будет использоваться как базовый
     */
    protected BaseElement(SelenideElement element) {
        this.base = element;
    }

    /**
     * Возвращает базовый Selenide элемент.
     * @return базовый элемент
     */
    protected SelenideElement getElement() {return base;}

    /**
     * Находит элемент по xpath выражению.
     * @param xpath xpath выражение для поиска элемента
     * @return найденный Selenide элемент
     */
    protected static SelenideElement byXpath(String xpath) {
        return $x(xpath);
    }

}