package com.pinterest.testing.elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codeborne.selenide.SelenideElement;

/**
 * Класс для работы с элементами ввода файлов (file input).
 * Наследует функциональность BaseElement и предоставляет методы
 * для загрузки файлов и поиска элементов ввода по различным атрибутам.
 */
public class FileInput extends BaseElement {

    /**
     * Логгер для записи сообщений о действиях с элементом
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Конструктор для создания экземпляра элемента ввода файла.
     * @param element Selenide элемент, представляющий поле ввода файла
     */
    public FileInput(SelenideElement element) {
        super(element);
    }

    /**
     * Загружает файл из classpath в элемент ввода.
     * Логирует имя загружаемого файла.
     * @param pathInClasspath Путь к файлу в classpath
     */
    public void upload(String pathInClasspath) {
        logger.info("Загрузка изображения: {}", pathInClasspath);
        getElement().uploadFromClasspath(pathInClasspath);
    }

    /**
     * Создает элемент ввода файла по типу input.
     * @param phrase Тип input элемента (обычно "file")
     * @return новый экземпляр FileInput
     */
    public static FileInput byFileInputTypeCreate(String phrase) {
        String xpath = String.format("//input[@type='%s']", phrase);
        return new FileInput(BaseElement.byXpath(xpath));
    }
}