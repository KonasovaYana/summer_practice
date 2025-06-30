package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;
import com.pinterest.testing.elements.FileInput;
import static com.codeborne.selenide.Selenide.$x;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class PinCreationPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(PinCreationPage.class);
    public PinCreationPage() {super($x("//div[contains(@data-test-id,'pin-creation')]")); }

    private final FileInput imageUploadInput = FileInput.createByXpath("//input[@type='file']");
    public void uploadImage(String imagePath) {
        logger.info("Загрузка изображения: {}", imagePath);
        imageUploadInput.upload(imagePath);
    }
    private final Input titleInput = Input.createByXpath("//*[@id=\"storyboard-selector-title\"]");
    public void setTitle(String title) {
        logger.info("Установка заголовка пина: {}", title);
        titleInput.setValue(title);
    }
    private final Button publishButton = Button.createByXpath("//button[.//div[text()='Опубликовать']]");
    public void publish() {
        logger.info("Публикация пина");
        publishButton.click();
    }
    private final Button viewPublishedPinButton = Button.createByXpath("//*[contains(text(), 'Ваш пин опубликован')]");
    public void goToPublishedPin() {
        logger.info("Переход к опубликованному пину");
        viewPublishedPinButton.click();
        com.codeborne.selenide.Selenide.sleep(3000);
    }

}
