package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;
import com.pinterest.testing.elements.FileInput;

/**
 * Класс страницы создания нового пина в Pinterest.
 * Предоставляет методы для взаимодействия со всеми элементами
 * формы создания пина: загрузка изображения, ввод названия,
 * публикация пина и проверка результата.
 */
public class PinCreationPage extends BasePage {

    /**
     * Конструктор страницы создания пина.
     * Инициализирует страницу, находя корневой элемент по data-test-id.
     */
    public PinCreationPage() {super(byDataTestId("pin-creation"));}

    private final FileInput imageUploadInput = FileInput.byFileInputTypeCreate("file");
    private final Input titleInput = Input.byIdCreate("storyboard-selector-title");
    private final Button publishButton = Button.byButtonPhraseInXpathCreate("Опубликовать");
    private final Button viewPublishedPinButton = Button.byTextContainCreate("Ваш пин опубликован");

    /**
     * Загружает изображение для пина.
     * @param imagePath Путь к изображению в classpath
     */
    public void uploadImage(String imagePath) {
        imageUploadInput.upload(imagePath);
    }

    /**
     * Устанавливает название пина.
     * @param title Текст названия пина
     */
    public void setTitle(String title) {
        titleInput.setValue("Название", title);
    }

    /**
     * Нажимает кнопку публикации пина.
     */
    public void publish() {
        publishButton.click("Опубликовать");
    }

    /**
     * Проверяет успешность публикации пина.
     * @return true если появилось сообщение об успешной публикации,
     * false в противном случае
     */
    public boolean isPublished(){
        return(viewPublishedPinButton.isDisplayed("Ваш пин опубликован"));
    }

    /**
     * Переходит к просмотру опубликованного пина.
     */
    public void goToPublishedPin() {
        viewPublishedPinButton.click("Ваш пин опубликован");
    }
}