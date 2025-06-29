package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;
import com.pinterest.testing.elements.FileInput;
import static com.codeborne.selenide.Selenide.$x;


public class PinCreationPage extends BasePage {

    public PinCreationPage() {super($x("//div[contains(@data-test-id,'pin-creation')]")); }

    private final FileInput imageUploadInput =
            new FileInput(ElementHelper.byXpathPublic("//input[@type='file']"));
    public void uploadImage(String imagePath) {
        imageUploadInput.upload(imagePath);
    }
    private final Input titleInput =
            new Input(ElementHelper.byXpathPublic("//*[@id=\"storyboard-selector-title\"]"));
    public void setTitle(String title) {
        titleInput.setValue(title);
    }
    private final Button publishButton =
            new Button(ElementHelper.byXpathPublic("//button[.//div[text()='Опубликовать']]"));
    public void publish() {
        publishButton.click();
    }
    private final Button viewPublishedPinButton =
            new Button(ElementHelper.byXpathPublic("//*[contains(text(), 'Ваш пин опубликован')]"));
    public void goToPublishedPin() {
        viewPublishedPinButton.click();
        com.codeborne.selenide.Selenide.sleep(3000);
    }

}
