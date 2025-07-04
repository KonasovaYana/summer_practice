package com.pinterest.testing.pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Абстрактный базовый класс для всех страниц приложения.
 * Предоставляет общую функциональность для работы с элементами страниц
 * и методы для поиска элементов по стандартным атрибутам.
 * Класс предназначен для наследования конкретными классами страниц.
 */
public abstract class BasePage {

    /**
     * Конструктор базовой страницы.
     * @param baseType Корневой элемент страницы, относительно которого
     * будут искаться другие элементы
     */
    public BasePage(SelenideElement baseType) {
        this.baseType = baseType;
    }

    /**
     * Корневой элемент страницы, используемый для поиска других элементов.
     * Доступен для использования в классах-наследниках.
     */
    protected final SelenideElement baseType;

    /**
     * Находит элемент по частичному совпадению data-test-id атрибута.
     * @param partialId Часть значения атрибута data-test-id для поиска
     * @return Найденный Selenide элемент
     */
    protected static SelenideElement byDataTestId(String partialId) {
        String xpath = String.format("//div[contains(@data-test-id, '%s')]", partialId);
        return $x(xpath);
    }

}
